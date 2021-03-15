package lt.sdacademy.famtrip.controllers;

import lt.sdacademy.famtrip.models.dto.City;
import lt.sdacademy.famtrip.services.CityService;
import lt.sdacademy.famtrip.validators.CityValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;
    private final CityValidator cityValidator;

    public CityController(CityService cityService, CityValidator cityValidator) {
        this.cityService = cityService;
        this.cityValidator = cityValidator;
    }

    @GetMapping
    public List<City> getCities() {
        return cityService.getCities();
    }

    @GetMapping("{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping
    public City save(@RequestBody @Valid City city) {
        cityValidator.validate(city);

        return cityService.save(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
