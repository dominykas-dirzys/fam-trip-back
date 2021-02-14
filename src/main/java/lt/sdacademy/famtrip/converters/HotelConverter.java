package lt.sdacademy.famtrip.converters;

import lt.sdacademy.famtrip.models.dto.Hotel;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.repositories.HotelRepository;
import org.springframework.stereotype.Component;

@Component
public class HotelConverter {

    private final HotelRepository hotelRepository;

    public HotelConverter(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel convert(HotelEntity hotel) {
        return new Hotel(
                hotel.getId(),
                hotel.getCity(),
                hotel.getName(),
                hotel.getOfficialRating(),
                hotel.getInspectionScore(),
                hotel.getFoodQuality(),
                hotel.getTerritorySize(),
                hotel.isWaterSlides(),
                hotel.isSpa(),
                hotel.getDistanceToBeach(),
                hotel.getDistanceFromAirport(),
                hotel.getRemarks(),
                hotel.getAuthor(),
                hotel.getRooms(),
                hotel.getRecommendedTos(),
                hotel.getLabels(),
                hotel.getCuisineTypes());
    }

    public HotelEntity convertToEntity(Hotel hotel) {
        HotelEntity result;
        if (hotel.getId() == null) {
            result = new HotelEntity();
        } else {
            result = hotelRepository.findById(hotel.getId());
        }

        result.setCity(hotel.getCity());
        result.setName(hotel.getName());
        result.setOfficialRating(hotel.getOfficialRating());
        result.setInspectionScore(hotel.getInspectionScore());
        result.setFoodQuality(hotel.getFoodQuality());
        result.setTerritorySize(hotel.getTerritorySize());
        result.setWaterSlides(hotel.isWaterSlides());
        result.setSpa(hotel.isSpa());
        result.setDistanceToBeach(hotel.getDistanceToBeach());
        result.setDistanceFromAirport(hotel.getDistanceFromAirport());
        result.setRemarks(hotel.getRemarks());
        result.setAuthor(hotel.getAuthor());
        result.setRooms(hotel.getRooms());
        result.setRecommendedTos(hotel.getRecommendedTos());
        result.setLabels(hotel.getLabels());
        result.setCuisineTypes(hotel.getCuisineTypes());

        return result;
    }
}
