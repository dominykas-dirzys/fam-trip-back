package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.HotelLabel;
import lt.sdacademy.famtrip.models.entities.LabelEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LabelRepository extends Repository<LabelEntity, Long> {

    List<LabelEntity> findAll();

    LabelEntity save(LabelEntity hotelLabelEntity);

    void delete(LabelEntity hotelLabelEntity);

    LabelEntity findByTitle(HotelLabel label);
}