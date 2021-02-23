package lt.sdacademy.famtrip.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    private Long id;

    @NotEmpty
    private String password;

    @Email
    @NotEmpty
    @Size(max = 255)
    private String email;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
