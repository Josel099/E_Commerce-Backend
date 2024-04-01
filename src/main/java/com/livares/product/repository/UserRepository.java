package com.livares.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livares.product.model.User;

import jakarta.persistence.Id;

public interface UserRepository extends JpaRepository<User,Integer> {

}
