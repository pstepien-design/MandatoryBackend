package com.example.demo.Repositories;

import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findUserById(Long id);

    public Optional<User> findUserByCpr(Long cpr);

    public Boolean existsByCpr(Long cpr);

    public List<User> findAll();
}
