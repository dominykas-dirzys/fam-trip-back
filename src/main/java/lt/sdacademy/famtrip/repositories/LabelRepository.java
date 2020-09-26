package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.entities.HotelLabelEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LabelRepository extends Repository<HotelLabelEntity, Long> {

    List<HotelLabelEntity> findAll();

    HotelLabelEntity save(HotelLabelEntity hotelLabelEntity);

    void delete(HotelLabelEntity hotelLabelEntity);

    HotelLabelEntity findOneByTitle(String title);
}