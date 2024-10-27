package org.glofox.service;

import org.glofox.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getAllBookings();

    Booking getBookingById(Long bookingId);
    List<Booking> getBookingByUserId(Long userId);
}
