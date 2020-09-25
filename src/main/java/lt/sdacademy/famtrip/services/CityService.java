package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.CityEntity;
import lt.sdacademy.famtrip.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityEntity> getCities() {
        return cityRepository.findAll();
    }

    public List<CityEntity> getCitiesByTitle(String cityTitle) {
        return cityRepository.findAllByTitle(cityTitle);
    }

    public List<CityEntity> getCitiesByCountryTitle(String countryTitle) {
        return cityRepository.findAllByCountryTitle(countryTitle);
    }

    public CityEntity save(CityEntity city) {
        return cityRepository.save(city);
    }

    public void delete(CityEntity city) {
        cityRepository.delete(city);
    }
}