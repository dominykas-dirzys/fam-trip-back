package lt.sdacademy.university.services;

import lt.sdacademy.university.models.entities.UniversityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UniversityServiceTest {

    @Autowired
    private UniversityService universityService;

    @Test
    void getUniversities() {
        List<UniversityEntity> result = universityService.getUniversities();

        assertFalse(result.isEmpty());
    }

    @Test
    void save() {
        UniversityEntity university = new UniversityEntity();
        university.setCode("TST");
        university.setTitle("Test University");
        university = universityService.save(university);
        assertNotNull(university.getId());
        assertEquals("TST", university.getCode());
        assertEquals("Test University", university.getTitle());
    }
    @Test
    void delete() {
        List<UniversityEntity> universities = universityService.getUniversities();
        int oldSize = universities.size();
        universityService.delete(universities.get(0));
        universities = universityService.getUniversities();
        assertEquals(oldSize - 1, universities.size());
    }
}