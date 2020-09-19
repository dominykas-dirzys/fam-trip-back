package lt.sdacademy.university.tasks.fundamentals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lt.sdacademy.university.models.dto.StudyProgram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudyProgramServiceTest {

    private StudyProgramService studyProgramService;

    @BeforeEach
    void setUp() {
        studyProgramService = new StudyProgramService();
    }

    @Test
    public void getStudyProgram() {
        StudyProgram result = studyProgramService.getStudyProgram();

        assertNotNull(result);
    }

    @Test
    public void getStudyProgramWithTitle() {
        StudyProgram result = studyProgramService.getStudyProgramWithTitle("Study Program Title");

        assertNotNull(result);
        assertEquals("Study Program Title", result.getTitle());
    }

    @Test
    public void getStudyProgramWithIdAndTitle() {
        // TODO: complete test
    }

    @Test
    public void getStudyProgramWithModule() {
        StudyProgram result = studyProgramService.getStudyProgramWithModule("Module Title");

        assertNotNull(result);
        assertNotNull(result.getModules());
        assertEquals("Module Title", result.getModules().get(0));
    }

    @Test
    public void getStudyPrograms() {
        String[] studyProgramTitles = new String[]{
            "Study Program A",
            "Study Program B",
            "Study Program C"
        };

        List<StudyProgram> result = studyProgramService.getStudyPrograms(studyProgramTitles);

        assertNotNull(result);
        assertEquals("Study Program A", result.get(0).getTitle());
        assertEquals("Study Program B", result.get(1).getTitle());
        assertEquals("Study Program C", result.get(2).getTitle());
    }

    @Test
    public void getStudyProgramWithModules() {
        // TODO: complete test
    }

    @Test
    public void getLastStudyProgram() {
        // TODO: complete test
    }

    @Test
    public void getLongestModuleTitle() {
        // TODO: complete test
    }
}
