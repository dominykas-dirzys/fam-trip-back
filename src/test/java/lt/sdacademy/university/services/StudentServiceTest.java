package lt.sdacademy.university.services;

import java.util.List;
import javax.transaction.Transactional;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.StudyType;
import lt.sdacademy.university.models.entities.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void getStudents() {
        List<StudentEntity> result = studentService.getStudents();

        assertFalse(result.isEmpty());
        result.forEach(s -> assertNotNull(s.getPerson()));
    }

    @Test
    void getStudentsByGender() {
        List<StudentEntity> result = studentService.getStudentsByGender(Gender.male);

        result.forEach(s -> assertEquals(Gender.male, s.getPerson().getGender()));
    }

    @Test
    void getStudentsByStudyProgram() {
        List<StudentEntity> result = studentService.getStudentsByStudyProgram("Java nuo pagrindų");

        assertFalse(result.isEmpty());
        assertEquals(7, result.size());
    }

    @Test
    void getStudentsByStudyType() {
        List<StudentEntity> result = studentService.getStudentsByStudyType(StudyType.vakarines);

        assertFalse(result.isEmpty());
    }

    @Test
    void getStudentsByStudyTypeModule() {
        List<StudentEntity> result = studentService.getStudentsByStudyTypeModule(StudyType.vakarines, "J2EE");

        assertTrue(result.isEmpty());
    }
}
