package lt.sdacademy.famtrip.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity {

    @Column(name = "id", length = 50, nullable = false)
    private String id;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user", orphanRemoval = true)
    private List<UserEntity> id = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
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