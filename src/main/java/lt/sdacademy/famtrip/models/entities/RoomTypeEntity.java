package lt.sdacademy.famtrip.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room_type")
public class RoomTypeEntity extends AbstractEntity {

    @Column(name = "title", length = 50, unique = true, nullable = false)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
