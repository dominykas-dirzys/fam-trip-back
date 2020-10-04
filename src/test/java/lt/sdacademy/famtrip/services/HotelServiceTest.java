package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.CuisineType;
import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelLabel;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RecommendedTo;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.RoomType;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.entities.CityEntity;
import lt.sdacademy.famtrip.models.entities.CountryEntity;
import lt.sdacademy.famtrip.models.entities.CuisineTypeEntity;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.models.entities.LabelEntity;
import lt.sdacademy.famtrip.models.entities.RecommendedToEntity;
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
class HotelServiceTest {

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
    private LabelService labelService;

    @Autowired
    private RecommendedToService recommendedToService;

    @Autowired
    private CuisineTypeService cuisineTypeService;

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

        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);

        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
        cuisineType.setTitle(CuisineType.LOCAL);

        LabelEntity label = new LabelEntity();
        label.setTitle(HotelLabel.ECONOMY);

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

        List<RecommendedToEntity> recommendedTos = new ArrayList<>();
        recommendedTos.add(recommendedTo);
        hotel.setRecommendedTos(recommendedTos);

        List<CuisineTypeEntity> cuisineTypes = new ArrayList<>();
        cuisineTypes.add(cuisineType);
        hotel.setCuisineTypes(cuisineTypes);

        List<LabelEntity> labels = new ArrayList<>();
        labels.add(label);
        hotel.setLabels(labels);

        List<RoomEntity> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);

        hotelService.save(hotel);
        labelService.save(label);
        recommendedToService.save(recommendedTo);
        cuisineTypeService.save(cuisineType);
    }

    @Test
    void getHotels() {
        List<HotelEntity> result = hotelService.getHotels();

        assertEquals(1, result.size());
        assertEquals("Test Hotel", result.get(0).getName());
        assertEquals(HotelRating.FIVE_STAR, result.get(0).getOfficialRating());
    }

    @Test
    void save() {
        assertNotNull(hotelService.getHotels().get(0).getId());
        assertEquals("Test Hotel", hotelService.getHotels().get(0).getName());
    }

    @Test
    void delete() {
        List<HotelEntity> hotels = hotelService.getHotels();
        int oldSize = hotels.size();
        hotelService.delete(hotels.get(0));
        hotels = hotelService.getHotels();

        assertEquals(oldSize - 1, hotels.size());
    }

    @Test
    void getHotelByName() {
        HotelEntity result = hotelService.getHotelByName("Test Hotel");

        assertNotNull(result);
        assertEquals("Test Hotel", result.getName());
    }

    @Test
    void getHotelsByNameContains() {
        List<HotelEntity> result = hotelService.getHotelsByNameContains("Test");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Hotel", result.get(0).getName());
    }

    @Test
    void getHotelsByCityTitle() {
        List<HotelEntity> result = hotelService.getHotelsByCityTitle("TestCity");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("TestCity", result.get(0).getCity().getTitle());
    }

    @Test
    void getHotelsByOfficialRating() {
        List<HotelEntity> result = hotelService.getHotelsByOfficialRating(HotelRating.FIVE_STAR);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(HotelRating.FIVE_STAR, result.get(0).getOfficialRating());
    }

    @Test
    void getHotelsByInspectionScore() {
        List<HotelEntity> result = hotelService.getHotelsByInspectionScore((byte) 10);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals((byte) 10, result.get(0).getInspectionScore());
    }

    @Test
    void getHotelsByFoodQuality() {
        List<HotelEntity> result = hotelService.getHotelsByFoodQuality(FoodQuality.FANTASTIC);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(FoodQuality.FANTASTIC, result.get(0).getFoodQuality());
    }

    @Test
    void getHotelsByTerritorySize() {
        List<HotelEntity> result = hotelService.getHotelsByTerritorySize(Size.LARGE);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(Size.LARGE, result.get(0).getTerritorySize());
    }

    @Test
    void getHotelsByWaterSlides() {
        List<HotelEntity> result = hotelService.getHotelsByWaterSlides(true);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(true, result.get(0).isWaterSlides());
    }

    @Test
    void getHotelsBySpa() {
        List<HotelEntity> result = hotelService.getHotelsBySpa(true);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(true, result.get(0).isSpa());
    }

    @Test
    void getHotelsByDistanceToBeach() {
        List<HotelEntity> result = hotelService.getHotelsByDistanceToBeach(500);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(500, result.get(0).getDistanceToBeach());
    }

    @Test
    void getHotelsByDistanceFromAirport() {
        List<HotelEntity> result = hotelService.getHotelsByDistanceFromAirport(10.0);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(10.0, result.get(0).getDistanceFromAirport());
    }

    @Test
    void getHotelsByAuthorId() {
        List<HotelEntity> result = hotelService.getHotelsByAuthorId(hotelService.getHotels().get(0).getAuthor().getId());

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Hotel", result.get(0).getName());
    }

    @Test
    void getHotelsByCityCountryTitle() {
        List<HotelEntity> result = hotelService.getHotelsByCityCountryTitle("TestNation");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("TestNation", result.get(0).getCity().getCountry().getTitle());
    }


    @Test
    void getHotelsByRecommendedTosTitle() {
        List<HotelEntity> result = hotelService.getHotelsByRecommendedTo(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Hotel", result.get(0).getName());
    }

    @Test
    void getHotelsByLabelsTitle() {
        List<HotelEntity> result = hotelService.getHotelsByLabel(HotelLabel.ECONOMY);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Hotel", result.get(0).getName());
    }

    @Test
    void getHotelsByCuisineTypesTitle() {
        List<HotelEntity> result = hotelService.getHotelsByCuisineType(CuisineType.LOCAL);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Hotel", result.get(0).getName());
    }

    @Test
    void getHotelsByRoomsRoomSize() {
        List<HotelEntity> result = hotelService.getHotelsByRoomsRoomSize(Size.LARGE);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Hotel", result.get(0).getName());
    }

    @Test
    void getHotelsByRoomsRoomCondition() {
        List<HotelEntity> result = hotelService.getHotelsByRoomsRoomCondition(RoomCondition.VERY_GOOD);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Hotel", result.get(0).getName());
    }
}