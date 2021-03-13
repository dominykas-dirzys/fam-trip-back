package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.converters.HotelConverter;
import lt.sdacademy.famtrip.models.CuisineType;
import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelLabel;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RecommendedTo;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.dto.Hotel;
import lt.sdacademy.famtrip.models.dto.User;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.repositories.HotelRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelConverter hotelConverter;
    private final HotelRepository hotelRepository;

    public HotelService(HotelConverter hotelConverter, HotelRepository hotelRepository) {
        this.hotelConverter = hotelConverter;
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getHotels() {
        return hotelConverter.convert(hotelRepository.findAll());
    }

    public Hotel save(Hotel hotel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        hotel.setAuthor(user);

        HotelEntity hotelEntity = hotelConverter.convertToEntity(hotel);
        hotelRepository.save(hotelEntity);

        return hotelConverter.convert(hotelEntity);
    }

    public void delete(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    public Hotel getHotelByName(String name) {
        return hotelConverter.convert(hotelRepository.findByName(name));
    }

    public List<Hotel> getHotelsByNameContains(String name) {
        return hotelConverter.convert(hotelRepository.findAllByNameContains(name));
    }

    public List<Hotel> getHotelsByCityTitle(String cityTitle) {
        return hotelConverter.convert(hotelRepository.findAllByCityTitle(cityTitle));
    }

    public List<Hotel> getHotelsByOfficialRating(HotelRating officialRating) {
        return hotelConverter.convert(hotelRepository.findAllByOfficialRating(officialRating));
    }

    public List<Hotel> getHotelsByInspectionScore(Byte inspectionScore) {
        return hotelConverter.convert(hotelRepository.findAllByInspectionScore(inspectionScore));
    }

    public List<Hotel> getHotelsByFoodQuality(FoodQuality foodQuality) {
        return hotelConverter.convert(hotelRepository.findAllByFoodQuality(foodQuality));
    }

    public List<Hotel> getHotelsByTerritorySize(Size territorySize) {
        return hotelConverter.convert(hotelRepository.findAllByTerritorySize(territorySize));
    }

    public List<Hotel> getHotelsByWaterSlides(boolean waterSlides) {
        return hotelConverter.convert(hotelRepository.findAllByWaterSlides(waterSlides));
    }

    public List<Hotel> getHotelsBySpa(boolean spa) {
        return hotelConverter.convert(hotelRepository.findAllBySpa(spa));
    }

    public List<Hotel> getHotelsByDistanceToBeach(Integer distanceToBeach) {
        return hotelConverter.convert(hotelRepository.findAllByDistanceToBeach(distanceToBeach));
    }

    public List<Hotel> getHotelsByDistanceFromAirport(Double distanceFromAirport) {
        return hotelConverter.convert(hotelRepository.findAllByDistanceFromAirport(distanceFromAirport));
    }

    public List<Hotel> getHotelsByAuthorId(Long authorId) {
        return hotelConverter.convert(hotelRepository.findAllByAuthorId(authorId));
    }

    public List<Hotel> getHotelsByCityCountryTitle(String title) {
        return hotelConverter.convert(hotelRepository.findAllByCityCountryTitle(title));
    }

    public List<Hotel> getHotelsByRecommendedTo(RecommendedTo recommendedTo) {
        return hotelConverter.convert(hotelRepository.findAllByRecommendedTosContaining(recommendedTo));
    }

    public List<Hotel> getHotelsByLabel(HotelLabel hotelLabel) {
        return hotelConverter.convert(hotelRepository.findAllByLabelsContaining(hotelLabel));
    }

    public List<Hotel> getHotelsByCuisineType(CuisineType cuisineType) {
        return hotelConverter.convert(hotelRepository.findAllByCuisineTypesContaining(cuisineType));
    }

    public List<Hotel> getHotelsByRoomsRoomSize(Size roomSize) {
        return hotelConverter.convert(hotelRepository.findAllByRoomsRoomSize(roomSize));
    }

    public List<Hotel> getHotelsByRoomsRoomCondition(RoomCondition roomCondition) {
        return hotelConverter.convert(hotelRepository.findAllByRoomsRoomCondition(roomCondition));
    }

    public Hotel getHotelById(Long id) {
        return hotelConverter.convert(hotelRepository.findById(id));
    }

}

