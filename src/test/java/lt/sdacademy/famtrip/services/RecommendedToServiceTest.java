package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.RecommendedToEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class RecommendedToServiceTest {

    @Autowired
    private RecommendedToService recommendedToService;

    @Test
    void getRecommendedTos() {
        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle("Family");
        recommendedToService.save(recommendedTo);

        List<RecommendedToEntity> result = recommendedToService.getRecommendedTos();

        assertEquals(1, result.size());
        assertEquals("Family", result.get(0).getTitle());
    }

    @Test
    void save() {
        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle("Family");
        recommendedToService.save(recommendedTo);

        assertNotNull(recommendedTo.getId());
        assertEquals("Family", recommendedTo.getTitle());
    }

    @Test
    void delete() {
        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle("Family");
        recommendedToService.save(recommendedTo);

        List<RecommendedToEntity> recommendedTos = recommendedToService.getRecommendedTos();
        int oldSize = recommendedTos.size();
        recommendedToService.delete(recommendedTos.get(0));
        recommendedTos = recommendedToService.getRecommendedTos();

        assertEquals(oldSize - 1, recommendedTos.size());
    }

    @Test
    void getRecommendedToByTitle() {
        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle("Family");
        recommendedToService.save(recommendedTo);

        RecommendedToEntity result = recommendedToService.getRecommendedToByTitle("Family");

        assertNotNull(result);
        assertEquals("Family", result.getTitle());
    }
}