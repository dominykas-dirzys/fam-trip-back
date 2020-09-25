package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.Title;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.repositories.HotelRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

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

    public List<HotelEntity> getHotelsByCityTitle(String cityTitle) {
        return hotelRepository.findAllByCityTitle(cityTitle);
    }

    public List<HotelEntity> getHotelsByOfficialRating(HotelRating officialRating) {
        return hotelRepository.findAllByOfficialRating(officialRating);
    }

    public List<HotelEntity> getHotelsByInspectionScore(Byte inspectionScore) {
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

    public List<HotelEntity> getHotelsByAuthorId(Long authorId) {
        return hotelRepository.findAllByAuthorId(authorId);
    }

    public List<HotelEntity> getHotelsByCityCountryTitle(String title) {
        return hotelRepository.findAllByCityCountryTitle(title);
    }

    public List<HotelEntity> getHotelsByRecommendedTosTitle(String recommendedToTitle) {
        return hotelRepository.findAllByRecommendedTosTitle(recommendedToTitle);
    }

    public List<HotelEntity> getHotelsByLabelsTitle(String title) {
        return hotelRepository.findAllByLabelsTitle(title);
    }

    public List<HotelEntity> getHotelsByCuisineTypesTitle(String title) {
        return hotelRepository.findAllByCuisineTypesTitle(title);
    }

    public List<HotelEntity> getHotelsByRoomsTypeTitle(Title title) {
        return hotelRepository.findAllByRoomsRoomTypeTitle(title);
    }

    public List<HotelEntity> getHotelsByRoomsRoomSize(Size roomSize) {
        return hotelRepository.findAllByRoomsRoomSize(roomSize);
    }

    public List<HotelEntity> getHotelsByRoomsRoomCondition(RoomCondition roomCondition) {
        return hotelRepository.findAllByRoomsRoomCondition(roomCondition);
    }
}
