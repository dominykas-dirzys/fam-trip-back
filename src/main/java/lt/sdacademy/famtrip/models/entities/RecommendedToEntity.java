package lt.sdacademy.famtrip.models.entities;

import lt.sdacademy.famtrip.models.RecommendedTo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "recommended_to")
public class RecommendedToEntity extends AbstractEntity {

    @Column(name = "title", length = 50, nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RecommendedTo title;

    public RecommendedTo getTitle() {
        return title;
    }

    public void setTitle(RecommendedTo title) {
        this.title = title;
    }
}