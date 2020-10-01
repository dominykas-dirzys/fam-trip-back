package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.entities.UserEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<UserEntity, Long> {

    List<UserEntity> findAll();

    UserEntity save(UserEntity userEntity);

    void delete(UserEntity userEntity);

    UserEntity findOneById(Long id);

    UserEntity findByEmail(String email);
}