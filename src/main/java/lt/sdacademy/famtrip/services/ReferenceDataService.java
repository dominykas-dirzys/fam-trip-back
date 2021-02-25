package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.CuisineType;
import lt.sdacademy.famtrip.models.FoodQuality;
import lt.sdacademy.famtrip.models.HotelLabel;
import lt.sdacademy.famtrip.models.HotelRating;
import lt.sdacademy.famtrip.models.RecommendedTo;
import lt.sdacademy.famtrip.models.RoomCondition;
import lt.sdacademy.famtrip.models.RoomType;
import lt.sdacademy.famtrip.models.Size;
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
        referenceData.put("cuisineTypes", Arrays.asList(CuisineType.values()));
        referenceData.put("foodQualities", Arrays.asList(FoodQuality.values()));
        referenceData.put("hotelLabels", Arrays.asList(HotelLabel.values()));
        referenceData.put("hotelRatings", Arrays.asList(HotelRating.values()));
        referenceData.put("recommendedTos", Arrays.asList(RecommendedTo.values()));
        referenceData.put("roomConditions", Arrays.asList(RoomCondition.values()));
        referenceData.put("roomTypes", Arrays.asList(RoomType.values()));
        referenceData.put("sizes", Arrays.asList(Size.values()));

        return referenceData;
    }
}
