package com.example.springsecurity101.repository;

import com.example.springsecurity101.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findUsersByUsername(String username);
}
