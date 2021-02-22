package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.entities.CountryEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CountryRepository extends Repository<CountryEntity, Long> {
    List<CountryEntity> findAll();

    List<CountryEntity> findAllByTitle(String title);

    CountryEntity save(CountryEntity country);

    void deleteById(Long id);

    CountryEntity findById(Long id);
}
