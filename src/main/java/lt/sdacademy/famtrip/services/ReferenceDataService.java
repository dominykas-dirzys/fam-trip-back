package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.CuisineType;
import lt.sdacademy.famtrip.models.HotelLabel;
import lt.sdacademy.famtrip.models.RecommendedTo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReferenceDataService {
    public ReferenceDataService() {
    }

    public Map<String, List<Enum>> getReferenceData() {
        Map<String, List<Enum>> referenceData = new HashMap<>();
        referenceData.put("recommendedTos", Arrays.asList(RecommendedTo.values()));
        referenceData.put("cuisineTypes", Arrays.asList(CuisineType.values()));
        referenceData.put("hotelLabels", Arrays.asList(HotelLabel.values()));
        return referenceData;
    }
}
