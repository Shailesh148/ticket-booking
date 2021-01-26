package com.ticketbooking.repository;

import com.ticketbooking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface BookingRepository  extends JpaRepository<BookingEntity, Integer> {

    List<BookingEntity> findByUserId(int userId);
}
