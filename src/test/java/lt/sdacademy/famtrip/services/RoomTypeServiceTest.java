package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.Title;
import lt.sdacademy.famtrip.models.entities.RoomTypeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class RoomTypeServiceTest {

    @Autowired
    private RoomTypeService roomTypeService;

    @Test
    void getRoomTypes() {
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setTitle(Title.STANDARD_DBL);
        roomTypeService.save(roomType);

        List<RoomTypeEntity> result = roomTypeService.getRoomTypes();

        assertEquals(1, result.size());
        assertEquals(Title.STANDARD_DBL, result.get(0).getTitle());
    }

    @Test
    void getRoomTypesByTitle() {
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setTitle(Title.STANDARD_DBL);
        roomTypeService.save(roomType);

        List<RoomTypeEntity> result = roomTypeService.getRoomTypesByTitle(Title.STANDARD_DBL);

        assertEquals(1, result.size());
        assertEquals(Title.STANDARD_DBL, result.get(0).getTitle());
    }

    @Test
    void save() {
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setTitle(Title.STANDARD_DBL);
        roomTypeService.save(roomType);

        assertNotNull(roomType.getId());
        assertEquals(Title.STANDARD_DBL, roomType.getTitle());
    }

    @Test
    void delete() {
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setTitle(Title.STANDARD_DBL);
        roomTypeService.save(roomType);

        List<RoomTypeEntity> roomTypes = roomTypeService.getRoomTypes();
        int oldSize = roomTypes.size();
        roomTypeService.delete(roomTypes.get(0));
        roomTypes = roomTypeService.getRoomTypes();

        assertEquals(oldSize - 1, roomTypes.size());
    }
}