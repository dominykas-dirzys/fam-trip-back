package lt.sdacademy.university.services;

import java.util.List;

import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> getPeople() {
        return personRepository.findAll();
    }

    public List<PersonEntity> getPeopleByName(String name) {
        return personRepository.findAllByName(name);
    }

    public List<PersonEntity> getPeopleBySurname(String surname) {
        return personRepository.findAllBySurname(surname);
    }

    public List<PersonEntity> getPeopleByGender(Gender gender) {
        return personRepository.findAllByGender(gender);
    }
}
