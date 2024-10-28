package org.glofox.service.impl;

import org.glofox.model.Booking;
import org.glofox.model.Class;
import org.glofox.model.User;
import org.glofox.repository.BookingRepository;
import org.glofox.repository.ClassRepository;
import org.glofox.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BookingServiceImplTest {
    @InjectMocks
    private BookingServiceImpl bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private ClassRepository classRepository;

    @Mock
    private UserRepository userRepository;

    private Booking booking;
    private Class classObj;
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        classObj = new Class(1L, "Yoga Class", new Date(), new Date(), 20);
        user = new User(1L, "John Doe", "1234567890");
        booking = new Booking(1L, user.getId(), classObj.getClassId(), user.getName(), new Date());
    }

    @Test
    public void createBooking_ShouldReturnBooking_WhenValid() {
        when(classRepository.findClassById(booking.getClassId())).thenReturn(classObj);
        when(userRepository.findUserById(booking.getUserId())).thenReturn(user);

        Booking createdBooking = bookingService.createBooking(booking);

        assertNotNull(createdBooking);
        assertEquals(booking.getBookingId(), createdBooking.getBookingId());
        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    public void getBookingById_ShouldReturnBooking_WhenExists() {
        when(bookingRepository.findBookingById(1L)).thenReturn(booking);

        Booking foundBooking = bookingService.getBookingById(1L);

        assertNotNull(foundBooking);
        assertEquals(booking.getBookingId(), foundBooking.getBookingId());
        verify(bookingRepository, times(1)).findBookingById(1L);
    }

    @Test
    public void getAllBookings_ShouldReturnListOfBookings() {
        when(bookingRepository.findAll()).thenReturn(List.of(booking)); // Ensure this is a valid method

        List<Booking> bookings = bookingService.getAllBookings();

        assertNotNull(bookings);
        assertEquals(1, bookings.size());
        verify(bookingRepository, times(1)).findAll();
    }

    @Test
    public void getBookingByUserId_ShouldReturnListOfBookings() {
        when(bookingRepository.findBookingByUserId(user.getId())).thenReturn(List.of(booking)); // Ensure this is a valid method

        List<Booking> bookingsByUser = bookingService.getBookingByUserId(user.getId());

        assertNotNull(bookingsByUser);
        assertEquals(1, bookingsByUser.size());
        verify(bookingRepository, times(1)).findBookingByUserId(user.getId());
    }
}
