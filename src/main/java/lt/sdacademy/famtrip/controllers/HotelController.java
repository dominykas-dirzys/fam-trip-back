package lt.sdacademy.famtrip.controllers;

import lt.sdacademy.famtrip.models.dto.Hotel;
import lt.sdacademy.famtrip.services.HotelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
//    TODO

    @GetMapping("{id}")
//    TODO

    @PostMapping
//    TODO
    public Hotel save(@RequestBody @Valid Hotel hotel) {
        return hotelService.save(hotel);
    }

    @DeleteMapping
//    TODO
}
