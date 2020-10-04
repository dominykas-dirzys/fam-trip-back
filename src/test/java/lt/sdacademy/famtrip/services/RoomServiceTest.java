package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.RoomType;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.entities.CityEntity;
import lt.sdacademy.famtrip.models.entities.CountryEntity;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.models.entities.RoomEntity;
import lt.sdacademy.famtrip.models.entities.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class RoomServiceTest {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setup() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        CityEntity city = new CityEntity();
        city.setTitle("TestCity");
        city.setCountry(country);
        cityService.save(city);

        UserEntity user = new UserEntity();
        user.setEmail("user@web.com");
        user.setPassword("password");
        userService.save(user);

        RoomEntity room = new RoomEntity();
        room.setRoomType(RoomType.STANDARD_DBL);
        room.setRoomSize(Size.LARGE);
        room.setRoomCondition(RoomCondition.VERY_GOOD);
        room.setRemarks("Very good room");

        HotelEntity hotel = new HotelEntity();
        hotel.setName("Test Hotel");
        hotel.setCity(city);
        hotel.setOfficialRating(HotelRating.FIVE_STAR);
        hotel.setInspectionScore((byte) 10);
        hotel.setFoodQuality(FoodQuality.FANTASTIC);
        hotel.setTerritorySize(Size.LARGE);
        hotel.setWaterSlides(true);
        hotel.setSpa(true);
        hotel.setDistanceToBeach(500);
        hotel.setDistanceFromAirport(10.0);
        hotel.setRemarks("Wonderful hotel");
        hotel.setAuthor(user);

        List<RoomEntity> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);
        hotelService.save(hotel);
        roomService.save(room);
    }

    @Test
    void getRooms() {
        List<RoomEntity> result = roomService.getRooms();

        assertEquals(1, result.size());
        assertEquals(RoomType.STANDARD_DBL, result.get(0).getRoomType());
        assertEquals("Very good room", result.get(0).getRemarks());
    }

    @Test
    void getRoomsByRoomSize() {
        List<RoomEntity> result = roomService.getRoomsByRoomSize(Size.LARGE);

        assertEquals(1, result.size());
        assertEquals(Size.LARGE, result.get(0).getRoomSize());
    }

    @Test
    void getRoomsByRoomCondition() {
        List<RoomEntity> result = roomService.getRoomsByRoomCondition(RoomCondition.VERY_GOOD);

        assertEquals(1, result.size());
        assertEquals(RoomCondition.VERY_GOOD, result.get(0).getRoomCondition());
    }

    @Test
    void save() {
        assertNotNull(roomService.getRooms().get(0).getId());
        assertEquals(RoomType.STANDARD_DBL, roomService.getRooms().get(0).getRoomType());
        assertEquals("Very good room", roomService.getRooms().get(0).getRemarks());
    }

    @Test
    void deleteMustFailBecauseTestIsTransactional() {
        List<RoomEntity> foundRooms = roomService.getRooms();
        int oldSize = foundRooms.size();
        roomService.delete(foundRooms.get(0));
        foundRooms = roomService.getRooms();

        assertEquals(oldSize - 1, foundRooms.size());
    }

    @Test
    void getById() {
        RoomEntity result = roomService.getById(roomService.getRooms().get(0).getId());

        assertNotNull(result);
        assertEquals(RoomType.STANDARD_DBL, result.getRoomType());
    }
}