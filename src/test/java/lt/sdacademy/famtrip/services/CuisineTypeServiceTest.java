package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.CuisineType;
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
class CuisineTypeServiceTest {

    @Autowired
    private CuisineTypeService cuisineTypeService;

    @BeforeEach
    void setup() {
        CuisineTypeEntity cuisineType = new CuisineTypeEntity();
        cuisineType.setTitle(CuisineType.MEXICAN);
        cuisineTypeService.save(cuisineType);
    }

    @Test
    void getCuisineTypes() {
        List<CuisineTypeEntity> result = cuisineTypeService.getCuisineTypes();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(CuisineType.MEXICAN, result.get(0).getTitle());
    }


    @Test
    void getCuisineTypesByTitle() {
        List<CuisineTypeEntity> result = cuisineTypeService.getCuisineTypesByTitle(CuisineType.MEXICAN);

        assertEquals(CuisineType.MEXICAN, result.get(0).getTitle());
    }

    @Test
    void save() {
        assertNotNull(cuisineTypeService.getCuisineTypes().get(0).getId());
        assertEquals(CuisineType.MEXICAN, cuisineTypeService.getCuisineTypes().get(0).getTitle());
    }

    @Test
    void delete() {
        List<CuisineTypeEntity> cuisineTypes = cuisineTypeService.getCuisineTypes();
        int oldSize = cuisineTypes.size();
        cuisineTypeService.delete(cuisineTypes.get(0));
        cuisineTypes = cuisineTypeService.getCuisineTypes();

        assertEquals(oldSize - 1, cuisineTypes.size());
    }
}
