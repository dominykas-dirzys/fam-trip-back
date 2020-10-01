package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.UserEntity;
import lt.sdacademy.famtrip.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void delete(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findOneById(id);
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}