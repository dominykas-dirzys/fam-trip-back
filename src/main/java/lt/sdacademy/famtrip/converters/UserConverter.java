package lt.sdacademy.famtrip.converters;

import lt.sdacademy.famtrip.models.dto.User;
import lt.sdacademy.famtrip.models.entities.UserEntity;
import lt.sdacademy.famtrip.repositories.UserRepository;

public class UserConverter extends AbstractBiConverter<UserEntity, User> {
    private final UserRepository userRepository;

    public UserConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User convert(UserEntity user) {
        return new User(
            user.getId(),
            user.getPassword(),
            user.getEmail()
        );
    }

    public UserEntity convertToEntity(User user) {
        UserEntity result = new UserEntity();

        if (user.getId() != null) {
            result = userRepository.findOneById(user.getId());
        }

        result.setPassword(user.getPassword());
        result.setEmail(user.getEmail());

        return result;
    }
}
