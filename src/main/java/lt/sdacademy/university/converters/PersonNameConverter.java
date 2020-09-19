package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.PersonName;
import lt.sdacademy.university.models.entities.PersonEntity;

public class PersonNameConverter extends AbstractConverter<PersonEntity, PersonName> {

    public PersonName convert(PersonEntity person) {
        PersonName result = new PersonName();

        result.setId(person.getId());
        String fullName = person.getName() + " " + person.getSurname();
        result.setFullName(fullName);

        return result;
    }
}
