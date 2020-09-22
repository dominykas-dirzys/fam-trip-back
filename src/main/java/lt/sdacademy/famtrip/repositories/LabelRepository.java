package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.entities.LabelEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LabelRepository extends Repository<LabelEntity, Long> {

    List<LabelEntity> findAll();

    LabelEntity save(LabelEntity labelEntity);

    void delete(LabelEntity labelEntity);

    LabelEntity findOneByTitle(String title);
}