package lt.sdacademy.famtrip.validators;

import lt.sdacademy.famtrip.models.dto.Hotel;
import lt.sdacademy.famtrip.models.exceptions.ValidationException;
import lt.sdacademy.famtrip.repositories.HotelRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HotelValidator {

    private final HotelRepository hotelRepository;

    public HotelValidator(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void validate(Hotel hotel) {
        Map<String, String> errors = new HashMap<>();

        validateName(hotel, errors);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateName(Hotel hotel, Map<String, String> errors) {
        if (hotel.getId() == null) {
            if (hotelRepository.existsByName(hotel.getName())) {
                errors.put("name", "Such hotel name already exists");
            }
        } else if (hotelRepository.existsByNameAndIdNot(hotel.getName(), hotel.getId())) {
            errors.put("name", "Such hotel name already exists");
        }
    }
}
