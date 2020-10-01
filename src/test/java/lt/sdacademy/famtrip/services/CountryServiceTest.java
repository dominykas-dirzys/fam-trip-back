package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.CountryEntity;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setup() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);
    }

    @Test
    void getCountries() {
        List<CountryEntity> result = countryService.getCountries();

        assertEquals(1, result.size());
        assertEquals("TestNation", result.get(0).getTitle());
    }

    @Test
    void getCountriesByTitle() {
        List<CountryEntity> result = countryService.getCountriesByTitle("TestNation");

        assertEquals(1, result.size());
        assertEquals("TestNation", result.get(0).getTitle());
    }

    @Test
    void save() {
        assertNotNull(countryService.getCountries().get(0).getId());
        assertEquals("TestNation", countryService.getCountries().get(0).getTitle());
    }

    @Test
    void delete() {
        List<CountryEntity> countries = countryService.getCountries();
        int oldSize = countries.size();
        countryService.delete(countries.get(0));
        countries = countryService.getCountries();

        assertEquals(oldSize - 1, countries.size());
    }
}