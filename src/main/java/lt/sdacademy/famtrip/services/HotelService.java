package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelEntity> getHotels() {
        return hotelRepository.findAll();
    }

    public HotelEntity save(HotelEntity hotelEntity) {
        return hotelRepository.save(hotelEntity);
    }

    public void delete(HotelEntity hotelEntity) {
        hotelRepository.delete(hotelEntity);
    }

    public HotelEntity getHotelByName(String name) {
        return hotelRepository.findOneByName(name);
    }

    public List<HotelEntity> getHotelsByNameContains(String name) {
        return hotelRepository.findAllByNameContains(name);
    }

    public List<HotelEntity> getHotelsByCityTitle(String city) {
        return hotelRepository.findAllByCityTitle(city);
    }

    public List<HotelEntity> getHotelsByOfficialRating(HotelRating officialRating) {
        return hotelRepository.findAllByOfficialRating(officialRating);
    }

    public List<HotelEntity> getHotelsByInspectionScore(Integer inspectionScore) {
        return hotelRepository.findAllByInspectionScore(inspectionScore);
    }

    public List<HotelEntity> getHotelsByFoodQuality(FoodQuality foodQuality) {
        return hotelRepository.findAllByFoodQuality(foodQuality);
    }

    public List<HotelEntity> getHotelsByTerritorySize(Size territorySize) {
        return hotelRepository.findAllByTerritorySize(territorySize);
    }

    public List<HotelEntity> getHotelsByWaterSlides(boolean waterSlides) {
        return hotelRepository.findAllByWaterSlides(waterSlides);
    }

    public List<HotelEntity> getHotelsBySpa(boolean spa) {
        return hotelRepository.findAllBySpa(spa);
    }

    public List<HotelEntity> getHotelsByDistanceToBeach(Integer distanceToBeach) {
        return hotelRepository.findAllByDistanceToBeach(distanceToBeach);
    }

    public List<HotelEntity> getHotelsByDistanceFromAirport(Double distanceFromAirport) {
        return hotelRepository.findAllByDistanceFromAirport(distanceFromAirport);
    }

    public List<HotelEntity> getHotelsByAuthor(BigInteger authorId) {
        return hotelRepository.findAllByAuthor(authorId);
    }

    public List<HotelEntity> getHotelsByCountryTitle(String country) {
        return hotelRepository.findAllByCountryTitle(country);
    }

    public List<HotelEntity> getHotelsByRecommendedTosTitle(String recommendedTo) {
        return hotelRepository.findAllByRecommendedTosTitle(recommendedTo);
    }

    public List<HotelEntity> getHotelsByUserId(Long id) {
        return hotelRepository.findAllByUserId(id);
    }

    public List<HotelEntity> getHotelsByLabelsTitle(String title) {
        return hotelRepository.findAllByLabelsTitle(title);
    }

    public List<HotelEntity> getHotelsByCuisineTypesTitle(String title) {
        return hotelRepository.findAllByCuisineTypesTitle(title);
    }

    public List<HotelEntity> getHotelsByRoomsTypeId(Long id) {
        return hotelRepository.findAllByRoomsTypeId(id);
    }

    public List<HotelEntity> getHotelsByRoomsType(String type) {
        return hotelRepository.findAllByRoomsType(type);
    }

    public List<HotelEntity> getHotelsByRoomsSize(Size roomSize) {
        return hotelRepository.findAllByRoomsSize(roomSize);
    }

    public List<HotelEntity> getHotelsByRoomsRoomCondition(RoomCondition roomCondition) {
        return hotelRepository.findAllByRoomsRoomCondition(roomCondition);
    }
}
