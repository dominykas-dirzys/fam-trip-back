package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.LabelEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class LabelServiceTest {

    @Autowired
    private LabelService labelService;

    @Test
    void getLabels() {
        LabelEntity label = new LabelEntity();
        label.setTitle("Economy");
        labelService.save(label);

        List<LabelEntity> result = labelService.getLabels();

        assertEquals(1, result.size());
        assertEquals("Economy", result.get(0).getTitle());
    }

    @Test
    void save() {
        LabelEntity label = new LabelEntity();
        label.setTitle("Economy");
        labelService.save(label);

        assertNotNull(label.getId());
        assertEquals("Economy", label.getTitle());
    }

    @Test
    void delete() {
        LabelEntity label = new LabelEntity();
        label.setTitle("Economy");
        labelService.save(label);

        List<LabelEntity> labels = labelService.getLabels();
        int oldSize = labels.size();
        labelService.delete(labels.get(0));
        labels = labelService.getLabels();

        assertEquals(oldSize - 1, labels.size());
    }

    @Test
    void getLabelByTitle() {
        LabelEntity label = new LabelEntity();
        label.setTitle("Economy");
        labelService.save(label);

        LabelEntity result = labelService.getLabelByTitle("Economy");

        assertNotNull(result);
        assertEquals("Economy", result.getTitle());
    }
}