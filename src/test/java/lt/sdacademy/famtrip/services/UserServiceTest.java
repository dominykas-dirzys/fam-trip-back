package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    void setup() {
        UserEntity user = new UserEntity();
        user.setEmail("user@web.com");
        user.setPassword("password");
        userService.save(user);
    }

    @Test
    void getUsers() {
        List<UserEntity> result = userService.getUsers();

        assertEquals(1, result.size());
        assertEquals("user@web.com", result.get(0).getEmail());
        assertEquals("password", result.get(0).getPassword());
    }

    @Test
    void save() {
        assertNotNull(userService.getUsers().get(0).getId());
        assertEquals("user@web.com", userService.getUsers().get(0).getEmail());
    }

    @Test
    void delete() {
        List<UserEntity> users = userService.getUsers();
        int oldSize = users.size();
        userService.delete(users.get(0));
        users = userService.getUsers();

        assertEquals(oldSize - 1, users.size());
    }

    @Test
    void getUserById() {
        UserEntity user = new UserEntity();
        user.setEmail("user2@web.com");
        user.setPassword("password");
        userService.save(user);

        UserEntity result = userService.getUserById(user.getId());

        assertNotNull(result);
        assertEquals("user2@web.com", result.getEmail());
        assertEquals("password", result.getPassword());
    }

    @Test
    void getUserByEmail() {
        UserEntity user = new UserEntity();
        user.setEmail("user2@web.com");
        user.setPassword("password");
        userService.save(user);

        UserEntity result = userService.getUserByEmail("user2@web.com");

        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals("password", result.getPassword());
    }
}