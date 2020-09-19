package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import javax.transaction.Transactional;

import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void getPeople() {
        List<PersonEntity> result = personService.getPeople();

        assertFalse(result.isEmpty());
    }

    @Test
    void getPeopleByName() {
        List<PersonEntity> result = personService.getPeopleByName("Rutenis");

        assertFalse(result.isEmpty());
        assertEquals("Rutenis", result.get(0).getName());
    }

    @Test
    void getPeopleBySurname() {
        List<PersonEntity> result = personService.getPeopleBySurname("Turcinas");

        assertFalse(result.isEmpty());
        assertEquals("Turcinas", result.get(0).getSurname());
    }

    @Test
    void getPeopleByGender() {
        List<PersonEntity> result = personService.getPeopleByGender(Gender.male);

        assertFalse(result.isEmpty());
        assertEquals(10, result.size());
    }
}
