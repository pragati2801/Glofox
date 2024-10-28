package org.glofox.controller;

import org.glofox.model.Booking;
import org.glofox.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


public class BookingControllerTest {
    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingService bookingService;

    private Booking booking;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        booking = Booking.builder()
                .bookingId(1L)
                .userId(1L)
                .classId(1L)
                .memberName("User1")
                .date(new Date())
                .build();
    }

    @Test
    public void getBooking_ShouldReturnBooking_WhenExists() {
        when(bookingService.getBookingById(anyLong())).thenReturn(booking);

        ResponseEntity<Booking> response = bookingController.getBooking(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(booking, response.getBody());
        verify(bookingService, times(1)).getBookingById(1L);
    }


    @Test
    public void createBooking_ShouldReturnBooking_WhenValid() {
        when(bookingService.createBooking(any(Booking.class))).thenReturn(booking);

        ResponseEntity<Booking> response = bookingController.createBooking(booking);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(booking, response.getBody());
        verify(bookingService, times(1)).createBooking(booking);
    }

    @Test
    public void getAllBookings_ShouldReturnListOfBookings() {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);
        when(bookingService.getAllBookings()).thenReturn(bookings);

        ResponseEntity<List<Booking>> response = bookingController.getAllBookings();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals(bookings, response.getBody());
        verify(bookingService, times(1)).getAllBookings();
    }
    @Test
    public void getBookingsByUserId_ShouldReturnListOfBookings() {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);
        when(bookingService.getBookingByUserId(anyLong())).thenReturn(bookings);

        ResponseEntity<List<Booking>> response = bookingController.getBookingsByUserId(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals(bookings, response.getBody());
        verify(bookingService, times(1)).getBookingByUserId(1L);
    }


}
