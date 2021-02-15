package lt.sdacademy.famtrip.controllers;

import lt.sdacademy.famtrip.models.dto.Token;
import lt.sdacademy.famtrip.models.dto.User;
import lt.sdacademy.famtrip.models.entities.UserEntity;
import lt.sdacademy.famtrip.services.SecurityService;
import lt.sdacademy.famtrip.validators.UserValidator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserValidator userValidator;
    private final SecurityService securityService;

    public AuthController(AuthenticationManager authenticationManager, UserValidator userValidator, SecurityService securityService) {
        this.authenticationManager = authenticationManager;
        this.userValidator = userValidator;
        this.securityService = securityService;
    }

    @PostMapping("/login")
    public Token authenticate(@RequestBody User user) {
        UserEntity userEntity = securityService.loadUserByUsername(user.getEmail());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntity, user.getPassword()));

        return new Token(securityService.generateToken(userEntity.getEmail()));
    }

    @PostMapping("/sign-up")
    public User signUp(@RequestBody @Valid User user) {
        userValidator.validate(user);

        return securityService.signUp(user);
    }
}
