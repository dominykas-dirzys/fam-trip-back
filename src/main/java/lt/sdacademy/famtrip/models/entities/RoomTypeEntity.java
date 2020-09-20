package lt.sdacademy.famtrip.models.entities;

import lt.sdacademy.famtrip.models.Title;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "room_type")
public class RoomTypeEntity extends AbstractEntity {

    @Column(name = "title", length = 50, unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Title title;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
