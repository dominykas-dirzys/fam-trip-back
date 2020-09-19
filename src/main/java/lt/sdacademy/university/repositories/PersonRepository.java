package lt.sdacademy.university.repositories;

import java.util.List;

import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<PersonEntity, Long> {

    @Query("from PersonEntity p")
    List<PersonEntity> findAll();

    List<PersonEntity> findAllByName(String name);

    @Query("from PersonEntity p where p.surname =:surname")
    List<PersonEntity> findAllBySurname(String surname);

    @Query("from PersonEntity p where p.gender =:gender")
    List<PersonEntity> findAllByGender(Gender gender);
}
