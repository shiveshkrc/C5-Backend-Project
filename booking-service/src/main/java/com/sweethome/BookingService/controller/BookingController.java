package com.sweethome.BookingService.controller;


import com.sweethome.BookingService.entities.BookingInfoEntity;
import com.sweethome.BookingService.DTO.BookingDTO;
import com.sweethome.BookingService.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hotel")
public class BookingController {

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    BookingService bookingService;

    @GetMapping (value="/test")
    public ResponseEntity helloApp(){
        return new ResponseEntity("The controller received your request", HttpStatus.OK);
    }

    @PostMapping(value = "/booking" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBooking(@RequestBody BookingDTO bookingDTO){
        BookingInfoEntity bookedRooms = bookingService.saveBookingDetails(bookingDTO);
        System.out.println("Booking created successfully!");
        return new ResponseEntity(bookedRooms, HttpStatus.CREATED);
    }


//    need to code feign code and communication part

}
