package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.converters.RoomConverter;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.dto.Room;
import lt.sdacademy.famtrip.models.entities.RoomEntity;
import lt.sdacademy.famtrip.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomConverter roomConverter;

    public RoomService(RoomRepository roomRepository, RoomConverter roomConverter) {
        this.roomRepository = roomRepository;
        this.roomConverter = roomConverter;
    }

    public Room getRoomById(Long id) {
        return roomConverter.convert(roomRepository.findById(id));
    }

    public List<Room> getRooms() {
        return roomConverter.convert(roomRepository.findAll());
    }

    public List<Room> getRoomsByRoomSize(Size size) {
        return roomConverter.convert(roomRepository.findAllByRoomSize(size));
    }

    public List<Room> getRoomsByRoomCondition(RoomCondition roomCondition) {
        return roomConverter.convert(roomRepository.findAllByRoomCondition(roomCondition));
    }

    public Room save(Room room) {
        RoomEntity roomEntity = roomConverter.convertToEntity(room);
        roomRepository.save(roomEntity);

        return roomConverter.convert(roomEntity);
    }

    public void delete(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}
