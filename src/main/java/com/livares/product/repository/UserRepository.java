package com.livares.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livares.product.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


	Optional<User> findByUsername(String username);

}
