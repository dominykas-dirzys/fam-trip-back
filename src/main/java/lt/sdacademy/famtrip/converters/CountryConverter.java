package lt.sdacademy.famtrip.converters;

import lt.sdacademy.famtrip.models.dto.Country;
import lt.sdacademy.famtrip.models.entities.CountryEntity;
import lt.sdacademy.famtrip.repositories.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter extends AbstractBiConverter<CountryEntity, Country> {
    private final CountryRepository countryRepository;

    public CountryConverter(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country convert(CountryEntity country) {
        return new Country(
            country.getId(),
            country.getTitle()
        );
    }

    public CountryEntity convertToEntity(Country country) {
        CountryEntity result;
        if (country.getId() == null) {
            result = new CountryEntity();
        } else {
            result = countryRepository.findById(country.getId());
        }

        result.setTitle(country.getTitle());

        return result;
    }
}
