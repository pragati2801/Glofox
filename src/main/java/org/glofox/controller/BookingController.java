package org.glofox.controller;

import lombok.extern.slf4j.Slf4j;
import org.glofox.model.Booking;
import org.glofox.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping()
    public ResponseEntity<Booking> getBooking(@RequestParam("bookingId")  Long bookingId )
    {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));

    }


    @PostMapping()
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking)
    {

        return ResponseEntity.ok(bookingService.createBooking(booking));

    }
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        log.info("Fetching all bookings");
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
    @GetMapping("/user")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@RequestParam("userId") Long userId) {
        List<Booking> bookings = bookingService.getBookingByUserId(userId);
        return ResponseEntity.ok(bookings);
    }
}
