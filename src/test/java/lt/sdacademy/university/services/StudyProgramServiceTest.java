package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import javax.transaction.Transactional;
import lt.sdacademy.university.models.entities.ModuleEntity;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
class StudyProgramServiceTest {

    @Autowired
    private UniversityService universityService;

    @Autowired
    private StudyProgramService studyProgramService;

    @Test
    void getStudyProgramByTitle() {
        UniversityEntity university = new UniversityEntity();
        university.setTitle("Test University");
        university.setCode("TU");
        StudyProgramEntity studyProgram = new StudyProgramEntity();
        studyProgram.setTitle("Test Study Program");
        studyProgram.setUniversity(university);
        ModuleEntity module = new ModuleEntity();
        module.setTitle("Test Module");
        studyProgram.getModules().add(module);
        university.getStudyPrograms().add(studyProgram);
        universityService.save(university);

        StudyProgramEntity result = studyProgramService.getStudyProgramByTitle("Test Study Program");

        assertFalse(result.getModules().isEmpty());
    }

    @Test
    void getStudyProgramByModuleTitle() {
        UniversityEntity university = new UniversityEntity();
        university.setTitle("Test University");
        university.setCode("TU");
        StudyProgramEntity studyProgram = new StudyProgramEntity();
        studyProgram.setTitle("Test Study Program");
        studyProgram.setUniversity(university);
        ModuleEntity module = new ModuleEntity();
        module.setTitle("Test Module");
        studyProgram.getModules().add(module);
        university.getStudyPrograms().add(studyProgram);
        universityService.save(university);

        List<StudyProgramEntity> result = studyProgramService.getStudyProgramByModuleTitle("Test Module");

        assertFalse(result.isEmpty());
    }
}
