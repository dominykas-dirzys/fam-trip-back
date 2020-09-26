package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.entities.RoomEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RoomRepository extends Repository<RoomEntity, Long> {
    RoomEntity findOneById(Long id);

    List<RoomEntity> findAll();

    List<RoomEntity> findAllByRoomSize(Size size);

    List<RoomEntity> findAllByRoomCondition(RoomCondition roomCondition);

    RoomEntity save(RoomEntity room);

    void delete(RoomEntity room);
}
