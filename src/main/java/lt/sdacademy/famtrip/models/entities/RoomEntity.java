package lt.sdacademy.famtrip.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "room")
public class RoomEntity extends AbstractEntity {

    @Column(name = "type", length = 50, unique = true)
    private String type;

    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomTypeEntity roomType;

    @Column(name = "size", length = 50)
    @Enumerated(EnumType.STRING)
    private String size;
//    TODO: size enum

    @Column(name = "room_condition", length = 50)
    @Enumerated(EnumType.STRING)
    private String room_condition;
//    TODO: roomCondition enum

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotelEntity;
}
