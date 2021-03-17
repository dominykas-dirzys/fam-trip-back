package lt.sdacademy.famtrip.validators;

import lt.sdacademy.famtrip.models.dto.City;
import lt.sdacademy.famtrip.models.exceptions.ValidationException;
import lt.sdacademy.famtrip.repositories.CityRepository;
import lt.sdacademy.famtrip.repositories.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CityValidator {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public CityValidator(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public void validate(City city) {
        Map<String, String> errors = new HashMap<>();

        validateCountry(city, errors);
        validateTitle(city, errors);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateTitle(City city, Map<String, String> errors) {
        if (city.getId() == null) {
            if (isSameCountry(city)) {
                errors.put("title", "Such city already exists in this country");
            }
        } else if (cityRepository.existsByTitleAndIdNot(city.getTitle(), city.getId())) {
            if (isSameCountry(city)) {
                errors.put("title", "Such city already exists in this country");
            }
        }
    }

    private boolean isSameCountry(City city) {
        return cityRepository.existsByTitleAndCountry_IdIs(city.getTitle(), city.getCountry().getId());

    }

    private void validateCountry(City city, Map<String, String> errors) {
        if (!countryRepository.existsById(city.getCountry().getId())) {
            errors.put("country", "Such country does not exist");
        } else if (!countryRepository.findById(city.getCountry().getId()).getTitle().equals(city.getCountry().getTitle())) {
            errors.put("country", "Changing country title is not allowed");
        }
    }

    public void validateMatches(City city) {
        Map<String, String> errors = new HashMap<>();

        if (!cityRepository.existsByIdAndTitleIsAndCountry_IdIs(city.getId(), city.getTitle(), city.getCountry().getId())) {
            errors.put("city", "Such city does not exist or has changed");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
