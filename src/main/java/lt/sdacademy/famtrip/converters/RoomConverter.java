package lt.sdacademy.famtrip.converters;

import lt.sdacademy.famtrip.models.dto.Room;
import lt.sdacademy.famtrip.models.entities.RoomEntity;
import lt.sdacademy.famtrip.repositories.RoomRepository;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter {

    private final RoomRepository roomRepository;

    public RoomConverter(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room convert(RoomEntity room) {
        return new Room(
                room.getId(),
                room.getType(),
                room.getRoomType(),
                room.getRoomSize(),
                room.getRoomCondition(),
                room.getRemarks()
        );
    }

    public RoomEntity convertToEntity(Room room) {
        RoomEntity result;
        if (room.getId() == null) {
            result = new RoomEntity();
        } else {
            result = roomRepository.findById(room.getId());
        }

        result.setType(room.getType());
        result.setRoomType(room.getRoomType());
        result.setRoomSize(room.getSize());
        result.setRoomCondition(room.getRoomCondition());
        result.setRemarks(room.getRemarks());

        return result;
    }
}