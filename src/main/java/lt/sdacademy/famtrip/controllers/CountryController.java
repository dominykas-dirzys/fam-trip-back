package lt.sdacademy.famtrip.controllers;

import lt.sdacademy.famtrip.models.dto.City;
import lt.sdacademy.famtrip.models.dto.Country;
import lt.sdacademy.famtrip.services.CountryService;
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
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("{id}")
    public Country getCountry(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public Country save(@RequestBody @Valid Country country) {
        return countryService.save(country);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        countryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
