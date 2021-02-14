package lt.sdacademy.famtrip.controllers;

import lt.sdacademy.famtrip.models.dto.Hotel;
import lt.sdacademy.famtrip.services.HotelService;
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
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getHotels() {
        return hotelService.getHotels();
    }

    @GetMapping("{id}")
    public Hotel getHotel(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @PostMapping
    public Hotel save(@RequestBody @Valid Hotel hotel) {
        return hotelService.save(hotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hotelService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
