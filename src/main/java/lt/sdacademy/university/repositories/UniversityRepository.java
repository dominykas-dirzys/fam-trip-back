package lt.sdacademy.university.repositories;

import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.services.UniversityService;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public interface UniversityRepository extends Repository<UniversityEntity, Long> {

    List<UniversityEntity> findAll();

    UniversityEntity save(UniversityEntity universityEntity);

    void delete(UniversityEntity universityEntity);

    List<UniversityEntity> findAllByStudyProgramsTitle(String title);
}
