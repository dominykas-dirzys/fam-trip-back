package lt.sdacademy.famtrip.converters;

import lt.sdacademy.famtrip.models.dto.Room;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.models.entities.RoomEntity;
import lt.sdacademy.famtrip.repositories.HotelRepository;
import lt.sdacademy.famtrip.repositories.RoomRepository;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter extends AbstractBiConverter<RoomEntity, Room> {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomConverter(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public Room convert(RoomEntity room) {
        return new Room(
                room.getId(),
                room.getType(),
                room.getRoomType(),
                room.getRoomSize(),
                room.getRoomCondition(),
                room.getRemarks(),
                room.getHotel().getId()
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

        HotelEntity hotelEntity = hotelRepository.findById(room.getHotelId());
        result.setHotel(hotelEntity);

        return result;
    }
}
