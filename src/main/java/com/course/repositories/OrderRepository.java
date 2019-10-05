package com.course.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entities.Order;
import com.course.entities.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByClient(User client);
}
