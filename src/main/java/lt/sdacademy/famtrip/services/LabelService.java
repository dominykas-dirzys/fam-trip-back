package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.HotelLabel;
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

    public LabelEntity save(LabelEntity hotelLabelEntity) {
        return labelRepository.save(hotelLabelEntity);
    }

    public void delete(LabelEntity hotelLabelEntity) {
        labelRepository.delete(hotelLabelEntity);
    }

    public LabelEntity getLabelByTitle(HotelLabel label) {
        return labelRepository.findByTitle(label);
    }

}