package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.entities.RoomEntity;
import lt.sdacademy.famtrip.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomEntity getById(Long id) {
        return roomRepository.findById(id);
    }

    public List<RoomEntity> getRooms() {
        return roomRepository.findAll();
    }

    public List<RoomEntity> getRoomsByRoomSize(Size size) {
        return roomRepository.findAllByRoomSize(size);
    }

    public List<RoomEntity> getRoomsByRoomCondition(RoomCondition roomCondition) {
        return roomRepository.findAllByRoomCondition(roomCondition);
    }

    public RoomEntity save(RoomEntity room) {
        return roomRepository.save(room);
    }

    public void delete(RoomEntity room) {
        roomRepository.delete(room);
    }
}
