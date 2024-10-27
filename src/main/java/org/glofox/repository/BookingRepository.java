package org.glofox.repository;

import org.glofox.model.Booking;

import org.glofox.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookingRepository {
    private final List<Booking> bookings = new ArrayList<>();

    public void save(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> findAll() {
        return bookings;
    }

    public Booking findBookingById(Long bookingId)
    {
        return bookings.stream().filter(x->
                x.getBookingId().equals(bookingId)).findFirst().get();
    }
    public List<Booking> findBookingByUserId(Long userId)
    {
        return bookings.stream()
                .filter(booking -> booking.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
