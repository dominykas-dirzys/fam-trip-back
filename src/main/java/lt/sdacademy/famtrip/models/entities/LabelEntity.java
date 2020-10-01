package lt.sdacademy.famtrip.models.entities;

import lt.sdacademy.famtrip.models.HotelLabel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "label")
public class LabelEntity extends AbstractEntity {

    @Column(name = "title", length = 50, nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private HotelLabel title;

    public HotelLabel getTitle() {
        return title;
    }

    public void setTitle(HotelLabel title) {
        this.title = title;
    }
}