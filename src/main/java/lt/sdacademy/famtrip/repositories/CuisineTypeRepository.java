package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.CuisineType;
import lt.sdacademy.famtrip.models.entities.CuisineTypeEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CuisineTypeRepository extends Repository<CuisineTypeEntity, Long> {
    List<CuisineTypeEntity> findAll();

    CuisineTypeEntity findByTitle(CuisineType title);

    List<CuisineTypeEntity> findAllByTitle(CuisineType title);

    CuisineTypeEntity save(CuisineTypeEntity cuisineType);

    void delete(CuisineTypeEntity cuisineType);
}
