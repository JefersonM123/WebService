package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
