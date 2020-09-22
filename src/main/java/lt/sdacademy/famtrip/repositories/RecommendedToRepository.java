package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.entities.RecommendedToEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RecommendedToRepository extends Repository<RecommendedToEntity, Long> {

    List<RecommendedToEntity> findAll();

    RecommendedToEntity save(RecommendedToEntity recommendedToEntity);

    void delete(RecommendedToEntity recommendedToEntity);

    RecommendedToEntity findOneByTitle(String title);
}