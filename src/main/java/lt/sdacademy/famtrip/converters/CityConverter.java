package lt.sdacademy.famtrip.converters;

import lt.sdacademy.famtrip.models.dto.City;
import lt.sdacademy.famtrip.models.entities.CityEntity;
import lt.sdacademy.famtrip.repositories.CityRepository;
import org.springframework.stereotype.Component;

@Component
public class CityConverter extends AbstractBiConverter<CityEntity, City> {

    private final CityRepository cityRepository;
    private final CountryConverter countryConverter;

    public CityConverter(CityRepository cityRepository, CountryConverter countryConverter) {
        this.cityRepository = cityRepository;
        this.countryConverter = countryConverter;
    }

    public City convert(CityEntity city) {
        return new City(
                city.getId(),
                city.getTitle(),
                countryConverter.convert(city.getCountry())
        );
    }

    public CityEntity convertToEntity(City city) {
        CityEntity result;
        if (city.getId() == null) {
            result = new CityEntity();
        } else {
            result = cityRepository.findById(city.getId());
        }

        result.setTitle(city.getTitle());
        result.setCountry(countryConverter.convertToEntity(city.getCountry()));

        return result;
    }
}
