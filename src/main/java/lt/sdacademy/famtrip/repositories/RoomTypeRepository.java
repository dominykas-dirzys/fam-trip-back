package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.Title;
import lt.sdacademy.famtrip.models.entities.RoomTypeEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RoomTypeRepository extends Repository<RoomTypeEntity, Long> {
    List<RoomTypeEntity> findAll();

    List<RoomTypeEntity> findAllByTitle(Title title);

    RoomTypeEntity save(RoomTypeEntity roomType);

    void delete(RoomTypeEntity roomType);
}
