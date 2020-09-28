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
import lt.sdacademy.famtrip.models.entities.HotelLabelEntity;
import lt.sdacademy.famtrip.models.entities.RecommendedToEntity;
import lt.sdacademy.famtrip.models.entities.RoomEntity;
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

    @Test
    void getHotels() {
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

        HotelLabelEntity hotelLabel = new HotelLabelEntity();
        hotelLabel.setTitle(HotelLabel.ECONOMY);

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
        hotel.getRecommendedTos().add(recommendedTo);
        hotel.getCuisineTypes().add(cuisineType);
        hotel.getHotelLabels().add(hotelLabel);
        List<RoomEntity> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);

        hotelService.save(hotel);

        List<HotelEntity> result = hotelService.getHotels();

        assertEquals(1, result.size());
        assertEquals("Test Hotel", result.get(0).getName());
        assertEquals(HotelRating.FIVE_STAR, result.get(0).getOfficialRating());
    }

//    @Test
//    void save() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        assertNotNull(hotel.getId());
//        assertEquals("Test Hotel", hotel.getName());
//        assertEquals(HotelRating.FIVE_STAR, hotel.getOfficialRating());
//    }
//
//    @Test
//    void delete() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//        List<HotelEntity> hotels = hotelService.getHotels();
//        int oldSize = hotels.size();
//        hotelService.delete(hotels.get(0));
//        hotels = hotelService.getHotels();
//
//        assertEquals(oldSize - 1, hotels.size());
//    }
//
//    @Test
//    void getHotelByName() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        HotelEntity result = hotelService.getHotelByName("Test Hotel");
//
//        assertNotNull(result);
//        assertEquals("Test Hotel", result.getName());
//    }
//
//    @Test
//    void getHotelsByNameContains() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByNameContains("Test");
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//
//    @Test
//    void getHotelsByCityTitle() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByCityTitle("TestCity");
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByOfficialRating() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByOfficialRating(HotelRating.FIVE_STAR);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByInspectionScore() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByInspectionScore((byte) 10);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByFoodQuality() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByFoodQuality(FoodQuality.FANTASTIC);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByTerritorySize() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByTerritorySize(Size.LARGE);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByWaterSlides() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByWaterSlides(true);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsBySpa() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsBySpa(true);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByDistanceToBeach() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByDistanceToBeach(500);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByDistanceFromAirport() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByDistanceFromAirport(10.0);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByAuthorId() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByAuthorId(user.getId());
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByCityCountryTitle() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByCityCountryTitle("TestNation");
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByRecommendedTosTitle() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByRecommendedTos(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByLabelsTitle() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByHotelLabels(HotelLabel.ECONOMY);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByCuisineTypesTitle() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByCuisineTypes(CuisineType.LOCAL);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByRoomsRoomType() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByRoomsType(RoomType.STANDARD_DBL);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByRoomsRoomSize() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByRoomsRoomSize(Size.LARGE);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
//
//    @Test
//    void getHotelsByRoomsRoomCondition() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        RecommendedToEntity recommendedTo = new RecommendedToEntity();
//        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
//
//        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
//        cuisineType.setTitle(CuisineType.LOCAL);
//
//        HotelLabelEntity hotelLabel = new HotelLabelEntity();
//        hotelLabel.setTitle(HotelLabel.ECONOMY);
//
//        RoomEntity room = new RoomEntity();
//        room.setRoomType(RoomType.STANDARD_DBL);
//        room.setRoomSize(Size.LARGE);
//        room.setRoomCondition(RoomCondition.VERY_GOOD);
//        room.setRemarks("Very good room");
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setFoodQuality(FoodQuality.FANTASTIC);
//        hotel.setTerritorySize(Size.LARGE);
//        hotel.setWaterSlides(true);
//        hotel.setSpa(true);
//        hotel.setDistanceToBeach(500);
//        hotel.setDistanceFromAirport(10.0);
//        hotel.setRemarks("Wonderful hotel");
//        hotel.setAuthor(user);
//        hotel.getRecommendedTos().add(recommendedTo);
//        hotel.getCuisineTypes().add(cuisineType);
//        hotel.getHotelLabels().add(hotelLabel);
//        List<RoomEntity> rooms = new ArrayList<>();
//        rooms.add(room);
//        hotel.setRooms(rooms);
//
//        hotelService.save(hotel);
//
//        List<HotelEntity> result = hotelService.getHotelsByRoomsRoomCondition(RoomCondition.VERY_GOOD);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Test Hotel", result.get(0).getName());
//    }
}