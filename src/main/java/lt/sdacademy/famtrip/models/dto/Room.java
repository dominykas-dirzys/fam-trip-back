package lt.sdacademy.famtrip.models.dto;

import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.RoomType;
import lt.sdacademy.famtrip.models.Size;

public class Room {

    private Long id;
    private String type;
    private RoomType roomType;
    private Size size;
    private RoomCondition roomCondition;
    private String remarks;

    public Room() {
    }

    public Room(Long id, String type, RoomType roomType, Size size, RoomCondition roomCondition, String remarks) {
        this.id = id;
        this.type = type;
        this.roomType = roomType;
        this.size = size;
        this.roomCondition = roomCondition;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
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