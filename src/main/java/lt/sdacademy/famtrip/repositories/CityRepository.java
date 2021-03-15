package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.entities.CityEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CityRepository extends Repository<CityEntity, Long> {
    boolean existsByTitleAndCountry_IdIs(String title, Long country_id);

    boolean existsByTitleAndIdNot(String title, Long id);

    List<CityEntity> findAll();

    List<CityEntity> findAllByTitle(String title);

    List<CityEntity> findAllByCountryTitle(String title);

    CityEntity findById(Long id);

    CityEntity save(CityEntity city);

    void deleteById(Long id);
}
