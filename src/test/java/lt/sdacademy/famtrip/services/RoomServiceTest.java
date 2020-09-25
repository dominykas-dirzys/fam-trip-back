package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.Title;
import lt.sdacademy.famtrip.models.entities.CityEntity;
import lt.sdacademy.famtrip.models.entities.CountryEntity;
import lt.sdacademy.famtrip.models.entities.CuisineTypeEntity;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.models.entities.LabelEntity;
import lt.sdacademy.famtrip.models.entities.RecommendedToEntity;
import lt.sdacademy.famtrip.models.entities.RoomEntity;
import lt.sdacademy.famtrip.models.entities.RoomTypeEntity;
import lt.sdacademy.famtrip.models.entities.UserEntity;
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

    @Autowired
    private RoomTypeService roomTypeService;

    @Test
    void getRooms() {
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

        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle("Family");

        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
        cuisineType.setTitle("Local");

        LabelEntity label = new LabelEntity();
        label.setTitle("Economy");

        RoomEntity room = new RoomEntity();
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setTitle(Title.STANDARD_DBL);
        roomTypeService.save(roomType);
        room.setRoomType(roomType);
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
        hotel.getRecommendedTos().add(recommendedTo);
        hotel.getCuisineTypes().add(cuisineType);
        hotel.getLabels().add(label);
        List<RoomEntity> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);
        hotelService.save(hotel);

        List<RoomEntity> result = roomService.getRooms();

        assertEquals(1, result.size());
        assertEquals(Title.STANDARD_DBL, result.get(0).getRoomType().getTitle());
        assertEquals("Very good room", result.get(0).getRemarks());
    }

    @Test
    void getRoomsByRoomSize() {
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

        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle("Family");

        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
        cuisineType.setTitle("Local");

        LabelEntity label = new LabelEntity();
        label.setTitle("Economy");

        RoomEntity room = new RoomEntity();
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setTitle(Title.STANDARD_DBL);
        roomTypeService.save(roomType);
        room.setRoomType(roomType);
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
        hotel.getRecommendedTos().add(recommendedTo);
        hotel.getCuisineTypes().add(cuisineType);
        hotel.getLabels().add(label);
        List<RoomEntity> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);
        hotelService.save(hotel);

        List<RoomEntity> result = roomService.getRoomsByRoomSize(Size.LARGE);

        assertEquals(1, result.size());
        assertEquals(Title.STANDARD_DBL, result.get(0).getRoomType().getTitle());
        assertEquals("Very good room", result.get(0).getRemarks());
    }

    @Test
    void getRoomsByRoomCondition() {
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

        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle("Family");

        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
        cuisineType.setTitle("Local");

        LabelEntity label = new LabelEntity();
        label.setTitle("Economy");

        RoomEntity room = new RoomEntity();
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setTitle(Title.STANDARD_DBL);
        roomTypeService.save(roomType);
        room.setRoomType(roomType);
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
        hotel.getRecommendedTos().add(recommendedTo);
        hotel.getCuisineTypes().add(cuisineType);
        hotel.getLabels().add(label);
        List<RoomEntity> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);
        hotelService.save(hotel);

        List<RoomEntity> result = roomService.getRoomsByRoomCondition(RoomCondition.VERY_GOOD);

        assertEquals(1, result.size());
        assertEquals(Title.STANDARD_DBL, result.get(0).getRoomType().getTitle());
        assertEquals("Very good room", result.get(0).getRemarks());
    }

    @Test
    void save() {
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

        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle("Family");

        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
        cuisineType.setTitle("Local");

        LabelEntity label = new LabelEntity();
        label.setTitle("Economy");

        RoomEntity room = new RoomEntity();
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setTitle(Title.STANDARD_DBL);
        roomTypeService.save(roomType);
        room.setRoomType(roomType);
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
        hotel.getRecommendedTos().add(recommendedTo);
        hotel.getCuisineTypes().add(cuisineType);
        hotel.getLabels().add(label);
        List<RoomEntity> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);
        hotelService.save(hotel);

        assertNotNull(room.getId());
        assertEquals(Title.STANDARD_DBL, room.getRoomType().getTitle());
        assertEquals("Very good room", room.getRemarks());
    }

    @Test
    void delete() {
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

        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle("Family");

        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
        cuisineType.setTitle("Local");

        LabelEntity label = new LabelEntity();
        label.setTitle("Economy");

        RoomEntity room = new RoomEntity();
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setTitle(Title.STANDARD_DBL);
        roomTypeService.save(roomType);
        room.setRoomType(roomType);
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
        hotel.getRecommendedTos().add(recommendedTo);
        hotel.getCuisineTypes().add(cuisineType);
        hotel.getLabels().add(label);
        List<RoomEntity> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);
        hotelService.save(hotel);

        List<RoomEntity> foundRooms = roomService.getRooms();
        int oldSize = foundRooms.size();
        roomService.delete(foundRooms.get(0));
        foundRooms = roomService.getRooms();

        assertEquals(oldSize - 1, foundRooms.size());
    }
}