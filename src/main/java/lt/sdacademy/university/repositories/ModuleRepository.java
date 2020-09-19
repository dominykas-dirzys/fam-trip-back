package lt.sdacademy.university.repositories;

import lt.sdacademy.university.models.entities.ModuleEntity;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.List;

public interface ModuleRepository extends Repository<ModuleEntity, Long> {
    List<ModuleEntity> findAll();

    List<ModuleEntity> findAllByTitle(String title);

    List<ModuleEntity> findAllByTitleNot(String title);

    List<ModuleEntity> findAllByTitleIn(Collection<String> titles);

    List<ModuleEntity> findAllByTitleLike(String title);

    List<ModuleEntity> findAllByTitleContains(String title);

    ModuleEntity save(ModuleEntity moduleEntity);
}
