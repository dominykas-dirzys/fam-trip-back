package lt.sdacademy.famtrip.models.entities;

import lt.sdacademy.famtrip.models.CuisineType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "cuisine_type")
public class CuisineTypeEntity extends AbstractEntity{

    @Column(name = "title", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private CuisineType title;

    public CuisineType getTitle() {
        return title;
    }

    public void setTitle(CuisineType title) {
        this.title = title;
    }
}
