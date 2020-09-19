package lt.sdacademy.university.repositories;

import lt.sdacademy.university.models.entities.StudyProgramEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StudyProgramRepository extends Repository<StudyProgramEntity, Long> {
    List<StudyProgramEntity> findAll();

    StudyProgramEntity findOneByTitle(String title);

    StudyProgramEntity save(StudyProgramEntity studyProgramEntity);

    @Query("from StudyProgramEntity sp join sp.modules m where m.title=:title")
    List<StudyProgramEntity> findAllByModuleTitle(String title);
}
