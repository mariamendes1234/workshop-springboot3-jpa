package com.educandoweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.demo.entities.OrderItem;
import com.educandoweb.demo.entities.User;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	//JPA já faz a implementação!!!
}
