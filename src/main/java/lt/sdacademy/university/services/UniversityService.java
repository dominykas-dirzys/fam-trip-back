package lt.sdacademy.university.services;

import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<UniversityEntity> getUniversities() {
        return universityRepository.findAll();
    }

    public UniversityEntity save(UniversityEntity universityEntity) {
        return universityRepository.save(universityEntity);
    }

    public void delete(UniversityEntity universityEntity) {
        universityRepository.delete(universityEntity);
    }
}
