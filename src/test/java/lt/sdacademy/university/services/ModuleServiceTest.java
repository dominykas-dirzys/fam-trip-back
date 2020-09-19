package lt.sdacademy.university.services;

import lt.sdacademy.university.models.entities.ModuleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Transactional
class ModuleServiceTest {

    @Autowired
    private ModuleService moduleService;

    @Test
    void getModulesByTitleLike() {
        List<ModuleEntity> result = moduleService.getModulesByTitleLike("%Databases%");

        assertFalse(result.isEmpty());

        assertEquals(1, result.size());
        assertEquals("Databases - SQL", result.get(0).getTitle());
    }

    @Test
    void getModulesByTitleContains() {
        List<ModuleEntity> result = moduleService.getModulesByTitleContains("SQL");

        assertFalse(result.isEmpty());


        assertEquals(1, result.size());
        assertEquals("Databases - SQL", result.get(0).getTitle());
    }


    @Test
    void getModules() {
        ModuleEntity module = new ModuleEntity();
        module.setTitle("Test Module");
        moduleService.save(module);
        ModuleEntity module2 = new ModuleEntity();
        module2.setTitle("Test Module Two");
        moduleService.save(module2);

        List<ModuleEntity> result = moduleService.getModules();

        assertFalse(result.isEmpty());

        assertEquals("Test Module", result.get(result.size()-2).getTitle());
        /*List<ModuleEntity> result = moduleService.getModules();

        assertFalse(result.isEmpty());*/
    }

    @Test
    void getModulesByTitle() {
        List<ModuleEntity> result = moduleService.getModulesByTitle("Databases - SQL");

        assertFalse(result.isEmpty());


        assertEquals(1, result.size());
        assertEquals("Databases - SQL", result.get(0).getTitle());
    }

    @Test
    void getModulesByTitleNot() {
        List<ModuleEntity> result = moduleService.getModulesByTitleNot("Databases - SQL");

        assertFalse(result.isEmpty());


        assertEquals(11, result.size());
    }

    @Test
    void getModulesByTitleIn() {
        List<String> titles = new ArrayList<>();
        titles.add("Databases - SQL");
        titles.add("J2EE");
        List<ModuleEntity> result = moduleService.getModulesByTitleIn(titles);

        assertFalse(result.isEmpty());


        assertEquals(2, result.size());
    }
}