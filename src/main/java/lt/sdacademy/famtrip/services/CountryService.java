package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.CountryEntity;
import lt.sdacademy.famtrip.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryEntity> getCountries() {
        return countryRepository.findAll();
    }

    public List<CountryEntity> getCountriesByTitle(String countryTitle) {
        return countryRepository.findAllByTitle(countryTitle);
    }

    public CountryEntity save(CountryEntity country) {
        return countryRepository.save(country);
    }

    public void delete(CountryEntity country) {
        countryRepository.delete(country);
    }

    public CountryEntity getCountryById(Long id) {
        return countryRepository.findById(id);
    }
}
