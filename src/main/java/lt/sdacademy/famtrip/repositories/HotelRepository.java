package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface HotelRepository extends Repository<HotelEntity, Long> {

    List<HotelEntity> findAll();

    HotelEntity save(HotelEntity hotelEntity);

    void delete(HotelEntity hotelEntity);

    HotelEntity findOneByName(String name);

    List<HotelEntity> findAllByNameContains(String name);

    List<HotelEntity> findAllByCityTitle(String title);

    List<HotelEntity> findAllByOfficialRating(HotelRating officialRating);

    List<HotelEntity> findAllByInspectionScore(Integer inspectionScore);

    List<HotelEntity> findAllByFoodQuality(FoodQuality foodQuality);

    List<HotelEntity> findAllByTerritorySize(Size territorySize);

    List<HotelEntity> findAllByWaterSlides(boolean waterSlides);

    List<HotelEntity> findAllBySpa(boolean spa);

    List<HotelEntity> findAllByDistanceToBeach(Integer distanceToBeach);

    List<HotelEntity> findAllByDistanceFromAirport(Double distanceFromAirport);

    List<HotelEntity> findAllByAuthor(Long authorId);

    List<HotelEntity> findAllByCountryTitle(String title);

    List<HotelEntity> findAllByRecommendedTosTitle(String title);

    List<HotelEntity> findAllByLabelsTitle(String title);

    List<HotelEntity> findAllByCuisineTypesTitle(String title);

    List<HotelEntity> findAllByRoomsTypeId(Long id);

    List<HotelEntity> findAllByRoomsType(String type);

    List<HotelEntity> findAllByRoomsSize(Size roomSize);

    List<HotelEntity> findAllByRoomsRoomCondition(RoomCondition roomCondition);
}