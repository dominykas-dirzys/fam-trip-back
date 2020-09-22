package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.entities.RecommendedToEntity;
import lt.sdacademy.famtrip.repositories.RecommendedToRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendedToService {

    private final RecommendedToRepository recommendedToRepository;

    public RecommendedToService(RecommendedToRepository recommendedToRepository) {
        this.recommendedToRepository = recommendedToRepository;
    }

    public List<RecommendedToEntity> getRecommendedTos() {
        return recommendedToRepository.findAll();
    }

    public RecommendedToEntity save(RecommendedToEntity recommendedToEntity) {
        return recommendedToRepository.save(recommendedToEntity);
    }

    public void delete(RecommendedToEntity recommendedToEntity) {
        recommendedToRepository.delete(recommendedToEntity);
    }

    public RecommendedToEntity getRecommendedToByTitle(String title) {
        return recommendedToRepository.findOneByTitle(title);
    }
}