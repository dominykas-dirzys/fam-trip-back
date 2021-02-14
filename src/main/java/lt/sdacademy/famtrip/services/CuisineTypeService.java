package lt.sdacademy.famtrip.services;

import lt.sdacademy.famtrip.models.CuisineType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CuisineTypeService {

    public CuisineTypeService() {
    }

    public List<CuisineType> getCuisineTypes() {
        return Arrays.asList(CuisineType.values());
    }
}
