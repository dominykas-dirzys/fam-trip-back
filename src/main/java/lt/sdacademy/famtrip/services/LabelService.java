package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.LabelEntity;
import lt.sdacademy.famtrip.repositories.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {

    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<LabelEntity> getLabels() {
        return labelRepository.findAll();
    }

    public LabelEntity save(LabelEntity labelEntity) {
        return labelRepository.save(labelEntity);
    }

    public void delete(LabelEntity labelEntity) {
        labelRepository.delete(labelEntity);
    }

    public LabelEntity getLabelByTitle(String title) {
        return labelRepository.findOneByTitle(title);
    }
}
