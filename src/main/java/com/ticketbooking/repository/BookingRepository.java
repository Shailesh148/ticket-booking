package com.ticketbooking.repository;

import com.ticketbooking.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface BookingRepository  extends JpaRepository<Bookings, Integer> {

    List<Bookings> findByUserId(int userId);
}
