package lt.sdacademy.famtrip.models.entities;

import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.RoomType;
import lt.sdacademy.famtrip.models.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class RoomEntity extends AbstractEntity {

    @Column(name = "type", length = 50, unique = true)
    private String type;

    @Column(name = "room_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(name = "size", length = 50)
    @Enumerated(EnumType.STRING)
    private Size roomSize;

    @Column(name = "room_condition", length = 50)
    @Enumerated(EnumType.STRING)
    private RoomCondition roomCondition;

    @Column(name = "remarks", columnDefinition = "text")
    private String remarks;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Size getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Size roomSize) {
        this.roomSize = roomSize;
    }

    public RoomCondition getRoomCondition() {
        return roomCondition;
    }

    public void setRoomCondition(RoomCondition roomCondition) {
        this.roomCondition = roomCondition;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}