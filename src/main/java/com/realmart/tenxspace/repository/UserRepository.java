package com.realmart.tenxspace.repository;

import com.realmart.tenxspace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);


    Optional<User> findOneByEmailAndPassword(String email, String encodedPswrd);




}
