package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.converters.CityConverter;
import lt.sdacademy.famtrip.models.dto.City;
import lt.sdacademy.famtrip.models.entities.CityEntity;
import lt.sdacademy.famtrip.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    public CityService(CityRepository cityRepository, CityConverter cityConverter) {
        this.cityRepository = cityRepository;
        this.cityConverter = cityConverter;
    }

    public List<City> getCities() {
        return cityConverter.convert(cityRepository.findAll());
    }

    public City getCityById(Long id) {
        return cityConverter.convert(cityRepository.findById(id));
    }

    public List<City> getCitiesByTitle(String cityTitle) {
        return cityConverter.convert(cityRepository.findAllByTitle(cityTitle));
    }

    public List<City> getCitiesByCountryTitle(String countryTitle) {
        return cityConverter.convert(cityRepository.findAllByCountryTitle(countryTitle));
    }

    public City save(City city) {
        CityEntity cityEntity = cityConverter.convertToEntity(city);
        cityRepository.save(cityEntity);

        return cityConverter.convert(cityEntity);
    }

    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
