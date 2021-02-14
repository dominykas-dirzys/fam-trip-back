package lt.sdacademy.famtrip.repositories;

import lt.sdacademy.famtrip.models.CuisineType;
import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelLabel;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RecommendedTo;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.Size;
import lt.sdacademy.famtrip.models.dto.Hotel;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface HotelRepository extends Repository<HotelEntity, Long> {

    List<HotelEntity> findAll();

    HotelEntity save(HotelEntity hotelEntity);

    Hotel save(Hotel hotel);

    void deleteById(Long id);

    HotelEntity findByName(String name);

    HotelEntity findById(Long id);

    List<HotelEntity> findAllByNameContains(String name);

    List<HotelEntity> findAllByCityTitle(String title);

    List<HotelEntity> findAllByOfficialRating(HotelRating officialRating);

    List<HotelEntity> findAllByInspectionScore(Byte inspectionScore);

    List<HotelEntity> findAllByFoodQuality(FoodQuality foodQuality);

    List<HotelEntity> findAllByTerritorySize(Size territorySize);

    List<HotelEntity> findAllByWaterSlides(boolean waterSlides);

    List<HotelEntity> findAllBySpa(boolean spa);

    List<HotelEntity> findAllByDistanceToBeach(Integer distanceToBeach);

    List<HotelEntity> findAllByDistanceFromAirport(Double distanceFromAirport);

    List<HotelEntity> findAllByAuthorId(Long authorId);

    List<HotelEntity> findAllByCityCountryTitle(String title);

    @Query("from HotelEntity h join h.recommendedTos hrt where hrt.title=:recommendedTo")
    List<HotelEntity> findAllByRecommendedTo(RecommendedTo recommendedTo);

    @Query("from HotelEntity h join h.labels hl where hl.title=:hotelLabel")
    List<HotelEntity> findAllByLabel(HotelLabel hotelLabel);

    @Query("from HotelEntity h join h.cuisineTypes hct where hct.title=:cuisineType")
    List<HotelEntity> findAllByCuisineType(CuisineType cuisineType);

    List<HotelEntity> findAllByRoomsRoomSize(Size roomSize);

    List<HotelEntity> findAllByRoomsRoomCondition(RoomCondition roomCondition);
}
