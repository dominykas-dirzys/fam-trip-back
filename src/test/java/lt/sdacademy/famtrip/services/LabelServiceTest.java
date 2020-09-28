package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.HotelLabel;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.entities.CityEntity;
import lt.sdacademy.famtrip.models.entities.CountryEntity;
import lt.sdacademy.famtrip.models.entities.HotelEntity;
import lt.sdacademy.famtrip.models.entities.HotelLabelEntity;
import lt.sdacademy.famtrip.models.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@Transactional
class LabelServiceTest {

    @Autowired
    private LabelService labelService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    @Autowired
    private HotelService hotelService;

    @Test
    void getLabels() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        CityEntity city = new CityEntity();
        city.setTitle("TestCity");
        city.setCountry(country);
        cityService.save(city);

        UserEntity user = new UserEntity();
        user.setEmail("user@web.com");
        user.setPassword("password");
        userService.save(user);

        HotelEntity hotel = new HotelEntity();
        hotel.setName("Test Hotel");
        hotel.setCity(city);
        hotel.setOfficialRating(HotelRating.FIVE_STAR);
        hotel.setInspectionScore((byte) 10);
        hotel.setAuthor(user);

        HotelLabelEntity label = new HotelLabelEntity();
        label.setTitle(HotelLabel.ECONOMY);
        List<HotelLabelEntity> labels = new ArrayList<>();
        labels.add(label);
        hotel.setHotelLabels(labels);
        hotelService.save(hotel);

        List<HotelLabelEntity> result = labelService.getLabels();

        assertEquals(1, result.size());
        assertEquals(HotelLabel.ECONOMY, result.get(0).getTitle());
    }

    @Test
    void save() {
        HotelLabelEntity label = new HotelLabelEntity();
        label.setTitle(HotelLabel.ECONOMY);
        labelService.save(label);

        assertNotNull(label.getId());
        assertEquals(HotelLabel.ECONOMY, label.getTitle());
    }

    @Test
    void delete() {
        HotelLabelEntity label = new HotelLabelEntity();
        label.setTitle(HotelLabel.ECONOMY);
        labelService.save(label);

        List<HotelLabelEntity> labels = labelService.getLabels();
        int oldSize = labels.size();
        labelService.delete(labels.get(0));
        labels = labelService.getLabels();

        assertEquals(oldSize - 1, labels.size());
    }

    @Test
    void getLabelByTitle() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        CityEntity city = new CityEntity();
        city.setTitle("TestCity");
        city.setCountry(country);
        cityService.save(city);

        UserEntity user = new UserEntity();
        user.setEmail("user@web.com");
        user.setPassword("password");
        userService.save(user);

        HotelEntity hotel = new HotelEntity();
        hotel.setName("Test Hotel");
        hotel.setCity(city);
        hotel.setOfficialRating(HotelRating.FIVE_STAR);
        hotel.setInspectionScore((byte) 10);
        hotel.setAuthor(user);

        HotelLabelEntity label = new HotelLabelEntity();
        label.setTitle(HotelLabel.ECONOMY);
        List<HotelLabelEntity> labels = new ArrayList<>();
        labels.add(label);
        hotel.setHotelLabels(labels);
        hotelService.save(hotel);

        HotelLabelEntity result = labelService.getLabelByTitle(HotelLabel.ECONOMY);

        assertNotNull(result);
        assertEquals(HotelLabel.ECONOMY, result.getTitle());
    }

    @Test
    void getAllLabelsByTitle() {
        CountryEntity country = new CountryEntity();
        country.setTitle("TestNation");
        countryService.save(country);

        CityEntity city = new CityEntity();
        city.setTitle("TestCity");
        city.setCountry(country);
        cityService.save(city);

        UserEntity user = new UserEntity();
        user.setEmail("user@web.com");
        user.setPassword("password");
        userService.save(user);

        HotelEntity hotel = new HotelEntity();
        hotel.setName("Test Hotel");
        hotel.setCity(city);
        hotel.setOfficialRating(HotelRating.FIVE_STAR);
        hotel.setInspectionScore((byte) 10);
        hotel.setAuthor(user);

        HotelLabelEntity label = new HotelLabelEntity();
        label.setTitle(HotelLabel.ECONOMY);
        List<HotelLabelEntity> labels = new ArrayList<>();
        labels.add(label);
        hotel.setHotelLabels(labels);
        hotelService.save(hotel);

        HotelEntity hotel2 = new HotelEntity();
        hotel2.setName("Test Hotel 2");
        hotel2.setCity(city);
        hotel2.setOfficialRating(HotelRating.FIVE_STAR);
        hotel2.setInspectionScore((byte) 10);
        hotel2.setAuthor(user);

        HotelLabelEntity label3 = new HotelLabelEntity();
        label3.setTitle(HotelLabel.SUPERIOR);

        List<HotelLabelEntity> labels2 = new ArrayList<>();
        labels2.add(label);
        labels2.add(label3);


        hotel2.setHotelLabels(labels2);
        hotelService.save(hotel2);

        List<HotelLabelEntity> result = labelService.getAllLabelsByTitle(HotelLabel.ECONOMY);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(HotelLabel.ECONOMY, result.get(0).getTitle());
        assertEquals(HotelLabel.ECONOMY, result.get(1).getTitle());
    }
}