package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.HotelLabelEntity;
import lt.sdacademy.famtrip.repositories.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {

    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<HotelLabelEntity> getLabels() {
        return labelRepository.findAll();
    }

    public HotelLabelEntity save(HotelLabelEntity hotelLabelEntity) {
        return labelRepository.save(hotelLabelEntity);
    }

    public void delete(HotelLabelEntity hotelLabelEntity) {
        labelRepository.delete(hotelLabelEntity);
    }

    public HotelLabelEntity getLabelByTitle(String title) {
        return labelRepository.findOneByTitle(title);
    }
}
