package lt.sdacademy.famtrip.converters;

import lt.sdacademy.famtrip.models.dto.Hotel;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.repositories.CuisineTypeRepository;
import lt.sdacademy.famtrip.repositories.HotelRepository;
import lt.sdacademy.famtrip.repositories.LabelRepository;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class HotelConverter extends AbstractBiConverter<HotelEntity, Hotel> {

    private final HotelRepository hotelRepository;
    private final RoomConverter roomConverter;
    private final UserConverter userConverter;

    public HotelConverter(HotelRepository hotelRepository, RoomConverter roomConverter, UserConverter userConverter) {
        this.hotelRepository = hotelRepository;
        this.roomConverter = roomConverter;
        this.userConverter = userConverter;
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
                userConverter.convert(hotel.getAuthor()),
                roomConverter.convert(hotel.getRooms()),
                hotel.getRecommendedTos(),
                hotel.getLabels(),
                hotel.getCuisineTypes()
        );
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
        result.setAuthor(userConverter.convertToEntity(hotel.getAuthor()));
        result.setRooms(roomConverter.convertToEntity(hotel.getRooms()));
        result.setRecommendedTos(hotel.getRecommendedTos());
        result.setLabels(hotel.getLabels());
        result.setCuisineTypes(hotel.getCuisineTypes());

        return result;
    }
}
