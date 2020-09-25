package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.CityEntity;
import lt.sdacademy.famtrip.models.entities.CountryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @Test
    void getCities() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        CityEntity city = new CityEntity();
        city.setTitle("TestCity");
        city.setCountry(country);
        cityService.save(city);

        List<CityEntity> result = cityService.getCities();

        assertEquals(1, result.size());
        assertEquals("TestCity", result.get(0).getTitle());
    }

    @Test
    void getCitiesByTitle() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        CityEntity city = new CityEntity();
        city.setTitle("TestCity");
        city.setCountry(country);
        cityService.save(city);

        List<CityEntity> result = cityService.getCitiesByTitle("TestCity");

        assertEquals(1, result.size());
        assertEquals("TestCity", result.get(0).getTitle());
    }

    @Test
    void getCitiesByCountryTitle() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        CityEntity city = new CityEntity();
        city.setTitle("TestCity");
        city.setCountry(country);
        cityService.save(city);

        List<CityEntity> result = cityService.getCitiesByCountryTitle("TestNation");

        assertEquals(1, result.size());
        assertEquals("TestCity", result.get(0).getTitle());
    }

    @Test
    void save() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        CityEntity city = new CityEntity();
        city.setTitle("TestCity");
        city.setCountry(country);
        cityService.save(city);

        assertNotNull(city.getId());
        assertEquals("TestCity", city.getTitle());
        assertEquals("TestNation", city.getCountry().getTitle());
    }

    @Test
    void delete() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        CityEntity city = new CityEntity();
        city.setTitle("TestCity");
        city.setCountry(country);
        cityService.save(city);

        List<CityEntity> cities = cityService.getCities();
        int oldSize = cities.size();
        cityService.delete(cities.get(0));
        cities = cityService.getCities();

        assertEquals(oldSize - 1, cities.size());
    }
}