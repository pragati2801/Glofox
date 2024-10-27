package org.glofox.service.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.glofox.Exception.ClassesNotFoundException;
import org.glofox.Exception.UserNotFoundException;
import org.glofox.model.Booking;
import org.glofox.model.Class;
import org.glofox.model.User;
import org.glofox.repository.BookingRepository;
import org.glofox.repository.ClassRepository;
import org.glofox.repository.UserRepository;
import org.glofox.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class  BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ClassRepository classRepository;
    private final UserRepository userRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, ClassRepository classRepository , UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.classRepository = classRepository;
        this.userRepository = userRepository;
    }

    @Override
    @SneakyThrows
    public Booking createBooking(Booking booking) {
        log.info("Attempting to create booking for userId: {} on date: {}", booking.getUserId(), booking.getDate());

        Class selectedClass = null;
        User selectedUser = null;

        selectedClass = classRepository.findClassById(booking.getClassId());
        selectedUser = userRepository.findUserById(booking.getUserId());
//


        if (Objects.isNull(selectedClass)) {
            throw new ClassesNotFoundException("Class not found for the given date");
        }
        if (Objects.isNull(selectedUser)) {
            throw new UserNotFoundException("User not found for the given date");
        }

        bookingRepository.save(booking);
        log.info("Booking created successfully for userId: {} on date: {}", booking.getUserId(), booking.getDate());
        return booking;
    }

    @Override
    public List<Booking> getAllBookings() {
        log.info("Fetching all bookings");
        return bookingRepository.findAll();
    }
    @Override
    public Booking getBookingById(Long bookingId) {
        log.info("Fetching booking for id : {}" ,bookingId );
        return bookingRepository.findBookingById(bookingId);
    }

    @Override
    public List<Booking> getBookingByUserId(Long userId) {
        log.info("Fetching bookings for userId: {}", userId);
        return bookingRepository.findBookingByUserId(userId);
    }
}
