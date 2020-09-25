package lt.sdacademy.famtrip.services;

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
class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    void getCountries() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        List<CountryEntity> result = countryService.getCountries();

        assertEquals(1, result.size());
        assertEquals("TestNation", result.get(0).getTitle());
    }

    @Test
    void getCountriesByTitle() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        List<CountryEntity> result = countryService.getCountriesByTitle("TestNation");

        assertEquals(1, result.size());
        assertEquals("TestNation", result.get(0).getTitle());
    }

    @Test
    void save() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        assertNotNull(country.getId());
        assertEquals("TestNation", country.getTitle());
    }

    @Test
    void delete() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        List<CountryEntity> countries = countryService.getCountries();
        int oldSize = countries.size();
        countryService.delete(countries.get(0));
        countries = countryService.getCountries();

        assertEquals(oldSize - 1, countries.size());
    }
}