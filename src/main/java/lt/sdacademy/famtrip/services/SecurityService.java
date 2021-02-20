package lt.sdacademy.famtrip.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lt.sdacademy.famtrip.configs.JwtAuthFilter;
import lt.sdacademy.famtrip.converters.UserConverter;
import lt.sdacademy.famtrip.models.dto.User;
import lt.sdacademy.famtrip.models.entities.UserEntity;
import lt.sdacademy.famtrip.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class SecurityService implements UserDetailsService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public SecurityService(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User \"%s\" not found", email));
        }

        return user;
    }

    public User signUp(User user) {
        UserEntity userEntity = userConverter.convertToEntity(user);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userConverter.convert(userRepository.save(userEntity));
    }

    public String generateToken(Long id, String email) {
        return Jwts.builder()
            .setClaims(new HashMap<>())
            .setId(id.toString())
            .setSubject(email)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + JwtAuthFilter.VALIDITY))
            .signWith(SignatureAlgorithm.HS512, JwtAuthFilter.SECRET)
            .compact();
    }
}
