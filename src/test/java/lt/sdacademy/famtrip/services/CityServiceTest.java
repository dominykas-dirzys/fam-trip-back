//package lt.sdacademy.famtrip.services;
//
//import lt.sdacademy.famtrip.models.entities.CityEntity;
//import lt.sdacademy.famtrip.models.entities.CountryEntity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//@Transactional
//class CityServiceTest {
//
//    @Autowired
//    private CityService cityService;
//
//    @Autowired
//    private CountryService countryService;
//
//    @BeforeEach
//    void setup() {
//        CountryEntity country = new CountryEntity();
//        country.setTitle("TestNation");
//        countryService.save(country);
//
//        CityEntity city = new CityEntity();
//        city.setTitle("TestCity");
//        city.setCountry(country);
//        cityService.save(city);
//    }
//
//    @Test
//    void getCities() {
//        List<CityEntity> result = cityService.getCities();
//
//        assertEquals(1, result.size());
//        assertEquals("TestCity", result.get(0).getTitle());
//    }
//
//    @Test
//    void getCitiesByTitle() {
//        List<CityEntity> result = cityService.getCitiesByTitle("TestCity");
//
//        assertEquals(1, result.size());
//        assertEquals("TestCity", result.get(0).getTitle());
//    }
//
//    @Test
//    void getCitiesByCountryTitle() {
//        List<CityEntity> result = cityService.getCitiesByCountryTitle("TestNation");
//
//        assertEquals(1, result.size());
//        assertEquals("TestCity", result.get(0).getTitle());
//    }
//
//    @Test
//    void save() {
//        assertNotNull(cityService.getCities().get(0).getId());
//        assertEquals("TestCity", cityService.getCities().get(0).getTitle());
//        assertEquals("TestNation", cityService.getCities().get(0).getCountry().getTitle());
//    }
//
//    @Test
//    void delete() {
//        List<CityEntity> cities = cityService.getCities();
//        int oldSize = cities.size();
//        cityService.delete(cities.get(0));
//        cities = cityService.getCities();
//
//        assertEquals(oldSize - 1, cities.size());
//    }
//}
