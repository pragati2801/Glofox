package org.glofox.repository;

import org.glofox.model.Booking;
import org.glofox.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingRepositoryTest {
    private BookingRepository bookingRepository;

    @BeforeEach
    public void setUp() {
        bookingRepository = new BookingRepository();
    }

    @Test
    public void save_ShouldAddBooking_WhenCalled() {
        Booking booking = new Booking(1L, 1L, 1L, "John Doe", new Date());
        bookingRepository.save(booking);

        assertEquals(1, bookingRepository.findAll().size());
        assertEquals(booking, bookingRepository.findAll().get(0));
    }

    @Test
    public void findAll_ShouldReturnAllBookings() {
        Booking booking1 = new Booking(1L, 1L, 1L, "John Doe", new Date());
        Booking booking2 = new Booking(2L, 2L, 1L, "Jane Doe", new Date());

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);

        assertEquals(2, bookingRepository.findAll().size());
    }

    @Test
    public void findBookingById_ShouldReturnBooking_WhenExists() {
        Booking booking = new Booking(1L, 1L, 1L, "John Doe", new Date());
        bookingRepository.save(booking);

        Booking foundBooking = bookingRepository.findBookingById(1L);

        assertEquals(booking, foundBooking);
    }

    @Test
    public void findBookingByUserId_ShouldReturnBookings_WhenExists() {
        Booking booking1 = new Booking(1L, 1L, 1L, "John Doe", new Date());
        Booking booking2 = new Booking(2L, 1L, 1L, "Jane Doe", new Date());
        Booking booking3 = new Booking(3L, 2L, 1L, "Jim Doe", new Date());

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);

        assertEquals(2, bookingRepository.findBookingByUserId(1L).size());
        assertEquals(1, bookingRepository.findBookingByUserId(2L).size());
    }


    public static class UserRepositoryTest {
        private UserRepository userRepository;

        @BeforeEach
        public void setUp() {
            userRepository = new UserRepository();
        }

        @Test
        public void save_ShouldAddUser_WhenCalled() {
            User user = new User(1L, "john.doe", "password");
            userRepository.save(user);

            assertEquals(1, userRepository.findAll().size());
            assertEquals(user, userRepository.findAll().get(0));
        }

        @Test
        public void findAll_ShouldReturnAllUsers() {
            User user1 = new User(1L, "john.doe", "password");
            User user2 = new User(2L, "jane.doe", "password");

            userRepository.save(user1);
            userRepository.save(user2);

            assertEquals(2, userRepository.findAll().size());
        }

        @Test
        public void findUserById_ShouldReturnUser_WhenExists() {
            User user = new User(1L, "john.doe", "password");
            userRepository.save(user);

            User foundUser = userRepository.findUserById(1L);

            assertEquals(user, foundUser);
        }
    }
}
