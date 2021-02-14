//package lt.sdacademy.famtrip.services;
//
//import lt.sdacademy.famtrip.models.HotelLabel;
//import lt.sdacademy.famtrip.models.HotelRating;
//import lt.sdacademy.famtrip.models.entities.CityEntity;
//import lt.sdacademy.famtrip.models.entities.CountryEntity;
//import lt.sdacademy.famtrip.models.entities.HotelEntity;
//import lt.sdacademy.famtrip.models.entities.LabelEntity;
//import lt.sdacademy.famtrip.models.entities.UserEntity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//@Transactional
//class LabelServiceTest {
//
//    @Autowired
//    private LabelService labelService;
//
//    @Autowired
//    private CountryService countryService;
//
//    @Autowired
//    private CityService cityService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private HotelService hotelService;
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
//
//        UserEntity user = new UserEntity();
//        user.setEmail("user@web.com");
//        user.setPassword("password");
//        userService.save(user);
//
//        HotelEntity hotel = new HotelEntity();
//        hotel.setName("Test Hotel");
//        hotel.setCity(city);
//        hotel.setOfficialRating(HotelRating.FIVE_STAR);
//        hotel.setInspectionScore((byte) 10);
//        hotel.setAuthor(user);
//
//        LabelEntity label = new LabelEntity();
//        label.setTitle(HotelLabel.ECONOMY);
//        List<LabelEntity> labels = new ArrayList<>();
//        labels.add(label);
//        hotel.setLabels(labels);
//        hotelService.save(hotel);
//        labelService.save(label);
//    }
//
//    @Test
//    void getLabels() {
//        List<LabelEntity> result = labelService.getLabels();
//
//        assertEquals(1, result.size());
//        assertEquals(HotelLabel.ECONOMY, result.get(0).getTitle());
//    }
//
//    @Test
//    void save() {
//        LabelEntity label = new LabelEntity();
//        label.setTitle(HotelLabel.ADULTS_ONLY);
//        labelService.save(label);
//
//        assertNotNull(label.getId());
//        assertEquals(HotelLabel.ADULTS_ONLY, label.getTitle());
//    }
//
//    @Test
//    void deleteMustFailBecauseOfFk() {
//        List<LabelEntity> labels = labelService.getLabels();
//        int oldSize = labels.size();
//        labelService.delete(labels.get(0));
//        labels = labelService.getLabels();
//
//        assertEquals(oldSize - 1, labels.size());
//    }
//
//    @Test
//    void getLabelByTitle() {
//        LabelEntity result = labelService.getLabelByTitle(HotelLabel.ECONOMY);
//
//        assertNotNull(result);
//        assertEquals(HotelLabel.ECONOMY, result.getTitle());
//    }
//}
