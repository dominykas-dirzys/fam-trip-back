package lt.sdacademy.famtrip.converters;

import lt.sdacademy.famtrip.models.dto.Hotel;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.repositories.CuisineTypeRepository;
import lt.sdacademy.famtrip.repositories.HotelRepository;
import lt.sdacademy.famtrip.repositories.LabelRepository;
import lt.sdacademy.famtrip.repositories.RecommendedToRepository;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class HotelConverter extends AbstractBiConverter<HotelEntity, Hotel> {

    private final HotelRepository hotelRepository;
    private final RoomConverter roomConverter;
    private final UserConverter userConverter;
    private final RecommendedToRepository recommendedToRepository;
    private final LabelRepository labelRepository;
    private final CuisineTypeRepository cuisineTypeRepository;

    public HotelConverter(HotelRepository hotelRepository, RoomConverter roomConverter, UserConverter userConverter, RecommendedToRepository recommendedToRepository, LabelRepository labelRepository, CuisineTypeRepository cuisineTypeRepository) {
        this.hotelRepository = hotelRepository;
        this.roomConverter = roomConverter;
        this.userConverter = userConverter;
        this.recommendedToRepository = recommendedToRepository;
        this.labelRepository = labelRepository;
        this.cuisineTypeRepository = cuisineTypeRepository;
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
                hotel.getRecommendedTos().stream().map(r -> r.getTitle()).collect(toList()),
                hotel.getLabels().stream().map(l -> l.getTitle()).collect(toList()),
                hotel.getCuisineTypes().stream().map(c -> c.getTitle()).collect(toList()));
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
        result.setRecommendedTos(hotel.getRecommendedTos().stream().map(r -> recommendedToRepository.findByTitle(r)).collect(toList()));
        result.setLabels(hotel.getLabels().stream().map(l -> labelRepository.findByTitle(l)).collect(toList()));
        result.setCuisineTypes(hotel.getCuisineTypes().stream().map(c -> cuisineTypeRepository.findByTitle(c)).collect(toList()));

        return result;
    }
}
