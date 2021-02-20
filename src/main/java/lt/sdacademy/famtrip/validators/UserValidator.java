package lt.sdacademy.famtrip.validators;

import lt.sdacademy.famtrip.models.dto.User;
import lt.sdacademy.famtrip.models.exceptions.ValidationException;
import lt.sdacademy.famtrip.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserValidator {

    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(User user) {
        Map<String, String> errors = new HashMap<>();

        emailIsUnique(user.getEmail(), errors);

        if (!errors.isEmpty()) throw new ValidationException(errors);
    }

    private void emailIsUnique(String email, Map<String, String> errors) {
        if (userRepository.existsByEmail(email)) {
            errors.put("email", "Such user exits already");
        }
    }
}
