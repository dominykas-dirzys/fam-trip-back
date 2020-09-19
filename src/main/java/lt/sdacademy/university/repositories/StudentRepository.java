package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.StudyType;
import lt.sdacademy.university.models.entities.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends Repository<StudentEntity, Long> {

    List<StudentEntity> findAll();

    @Query("from StudentEntity s where s.person.gender=:gender")
    List<StudentEntity> findAllByPersonGender(Gender gender);

    @Query("from StudentEntity s where s.studyProgram.title=:studyProgram")
    List<StudentEntity> findAllByStudyProgram(String studyProgram);

    @Query("from StudentEntity s where s.studyType=:studyType")
    List<StudentEntity> findAllByStudyType(StudyType studyType);

    @Query("from StudentEntity s join s.studyProgram.modules m where s.studyType=:studyType and m.title=:title")
    List<StudentEntity> findAllByStudyTypeModule(StudyType studyType, String title);
}
