package com.example.demo.Services.UserService;

import com.example.demo.Entities.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id).orElseThrow( () -> new RuntimeException("User with this id not found"));
    }

    @Override
    public User findUserByCpr(Long cpr) {
        return userRepository.findUserByCpr(cpr).orElseThrow( () -> new RuntimeException("User with this cpr not found"));

    }

    @Override
    public Boolean existsByCpr(Long cpr) {
        return userRepository.existsByCpr(cpr);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void editUser(Long id, User user) {
    User myUser = userRepository.findUserById(id).orElseThrow( () -> new RuntimeException("User with this id not found"));
    myUser.setCpr(user.getCpr());
    myUser.setEmail(user.getEmail());
    myUser.setName(user.getName());
    myUser.setPassword(user.getPassword());
    myUser.setRole(user.getRole());
    }

    @Override
    public void deleteUser(Long id) {
     User myUser = userRepository.findUserById(id).orElseThrow( () -> new RuntimeException("User with this id not found"));

        userRepository.delete(myUser);
    }
}
