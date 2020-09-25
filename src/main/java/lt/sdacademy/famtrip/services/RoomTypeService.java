package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.Title;
import lt.sdacademy.famtrip.models.entities.RoomTypeEntity;
import lt.sdacademy.famtrip.repositories.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public List<RoomTypeEntity> getRoomTypes() {
        return roomTypeRepository.findAll();
    }

    public List<RoomTypeEntity> getRoomTypesByTitle(Title title) {
        return roomTypeRepository.findAllByTitle(title);
    }

    public RoomTypeEntity save(RoomTypeEntity roomType) {
        return roomTypeRepository.save(roomType);
    }

    public void delete(RoomTypeEntity roomType) {
        roomTypeRepository.delete(roomType);
    }
}
