package lt.sdacademy.university.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.dto.PersonName;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonNameConverterTest {

    private PersonNameConverter personNameConverter;

    @BeforeEach
    void setUp() {
        personNameConverter = new PersonNameConverter();
    }

    @Test
    void convert() {
        PersonEntity person = new PersonEntity();
        person.setId(2L);
        person.setName("Test");
        person.setSurname("Tester");
        String expectedFullName = "Test Tester";

        PersonName result = personNameConverter.convert(person);

        assertEquals(2L, result.getId());
        assertEquals(expectedFullName, result.getFullName());
    }
}
