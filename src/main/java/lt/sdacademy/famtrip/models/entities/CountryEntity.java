package lt.sdacademy.famtrip.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryEntity extends AbstractEntity {

    @Column(name = "title", length = 50, nullable = false, unique = true)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}