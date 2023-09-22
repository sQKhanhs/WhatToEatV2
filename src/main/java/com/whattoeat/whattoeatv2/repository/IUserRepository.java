package com.whattoeat.whattoeatv2.repository;

import com.whattoeat.whattoeatv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

}
