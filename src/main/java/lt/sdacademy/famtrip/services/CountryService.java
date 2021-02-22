package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.converters.CountryConverter;
import lt.sdacademy.famtrip.models.dto.Country;
import lt.sdacademy.famtrip.models.entities.CountryEntity;
import lt.sdacademy.famtrip.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryConverter countryConverter;

    public CountryService(CountryRepository countryRepository, CountryConverter countryConverter) {
        this.countryRepository = countryRepository;
        this.countryConverter = countryConverter;
    }

    public List<Country> getCountries() {
        return countryConverter.convert(countryRepository.findAll());
    }

    public List<Country> getCountriesByTitle(String countryTitle) {
        return countryConverter.convert(countryRepository.findAllByTitle(countryTitle));
    }

    public Country save(Country country) {
        CountryEntity countryEntity = countryConverter.convertToEntity(country);
        countryRepository.save(countryEntity);

        return countryConverter.convert(countryEntity);
    }

    public void delete(Long id) {
        countryRepository.delete(id);
    }

    public Country getCountryById(Long id) {
        return countryConverter.convert(countryRepository.findById(id));
    }
}
