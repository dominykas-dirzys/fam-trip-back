package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.entities.CityEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CityRepository extends Repository<CityEntity, Long> {
    List<CityEntity> findAll();

    List<CityEntity> findAllByTitle(String title);

    List<CityEntity> findAllByCountryTitle(String title);

    CityEntity save(CityEntity city);

    void delete(CityEntity city);
}
