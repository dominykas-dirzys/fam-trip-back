package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.HotelLabel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LabelService {

    public LabelService() {
    }

    public List<HotelLabel> getLabels() {
        return Arrays.asList(HotelLabel.values());
    }
}
