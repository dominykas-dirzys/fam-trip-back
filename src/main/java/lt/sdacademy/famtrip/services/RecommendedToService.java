package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.RecommendedTo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RecommendedToService {

    public List<RecommendedTo> getRecommendedTos() {
        return Arrays.asList(RecommendedTo.values());
    }
}
