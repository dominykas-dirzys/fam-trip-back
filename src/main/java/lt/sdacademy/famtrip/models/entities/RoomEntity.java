package lt.sdacademy.famtrip.models.entities;

import lt.sdacademy.famtrip.models.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class RoomEntity extends AbstractEntity {

    @Column(name = "type", length = 50, unique = true)
    private String type;

    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomTypeEntity roomType;

    @Column(name = "size", length = 50)
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name = "room_condition", length = 50)
    @Enumerated(EnumType.STRING)
    private String room_condition;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotelEntity;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RoomTypeEntity getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEntity roomType) {
        this.roomType = roomType;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getRoom_condition() {
        return room_condition;
    }

    public void setRoom_condition(String room_condition) {
        this.room_condition = room_condition;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }
}