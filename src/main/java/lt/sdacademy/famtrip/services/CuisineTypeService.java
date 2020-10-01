package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.CuisineType;
import lt.sdacademy.famtrip.models.entities.CuisineTypeEntity;
import lt.sdacademy.famtrip.repositories.CuisineTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuisineTypeService {

    private final CuisineTypeRepository cuisineTypeRepository;

    public CuisineTypeService(CuisineTypeRepository cuisineTypeRepository) {
        this.cuisineTypeRepository = cuisineTypeRepository;
    }

    public List<CuisineTypeEntity> getCuisineTypes() {
        return cuisineTypeRepository.findAll();
    }

    public List<CuisineTypeEntity> getCuisineTypesByTitle(CuisineType title) {
        return cuisineTypeRepository.findAllByTitle(title);
    }

    public CuisineTypeEntity save(CuisineTypeEntity cuisineType) {
        return cuisineTypeRepository.save(cuisineType);
    }

    public void delete(CuisineTypeEntity cuisineType) {
        cuisineTypeRepository.delete(cuisineType);
    }
}