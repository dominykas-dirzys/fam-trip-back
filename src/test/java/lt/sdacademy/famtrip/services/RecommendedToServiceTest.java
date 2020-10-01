package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.RecommendedTo;
import lt.sdacademy.famtrip.models.entities.RecommendedToEntity;
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
class RecommendedToServiceTest {

    @Autowired
    private RecommendedToService recommendedToService;

    @BeforeEach
    void setup() {
        RecommendedToEntity recommendedTo = new RecommendedToEntity();
        recommendedTo.setTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);
        recommendedToService.save(recommendedTo);
    }

    @Test
    void getRecommendedTos() {
        List<RecommendedToEntity> result = recommendedToService.getRecommendedTos();

        assertEquals(1, result.size());
        assertEquals(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN, result.get(0).getTitle());
    }

    @Test
    void save() {
        assertNotNull(recommendedToService.getRecommendedTos().get(0).getId());
        assertEquals(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN, recommendedToService.getRecommendedTos().get(0).getTitle());
    }

    @Test
    void delete() {
        List<RecommendedToEntity> recommendedTos = recommendedToService.getRecommendedTos();
        int oldSize = recommendedTos.size();
        recommendedToService.delete(recommendedTos.get(0));
        recommendedTos = recommendedToService.getRecommendedTos();

        assertEquals(oldSize - 1, recommendedTos.size());
    }

    @Test
    void getRecommendedToByTitle() {
        RecommendedToEntity result = recommendedToService.getRecommendedToByTitle(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN);

        assertNotNull(result);
        assertEquals(RecommendedTo.FAMILIES_WITH_OLDER_CHILDREN, result.getTitle());
    }
}