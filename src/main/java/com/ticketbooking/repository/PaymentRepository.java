package com.ticketbooking.repository;

import com.ticketbooking.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends JpaRepository<Payments, Integer> {
}
