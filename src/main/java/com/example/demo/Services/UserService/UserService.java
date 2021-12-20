package com.example.demo.Services.UserService;

import com.example.demo.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User findUserById(Long id);

    public User findUserByCpr(Long cpr);

    public Boolean existsByCpr(Long cpr);

    public List<User> findAll();

    public void addUser(User user);

    public void editUser(Long id, User user);

    public void deleteUser(Long id);
}
