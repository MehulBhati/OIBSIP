package com.example.reservation.service;
import com.example.reservation.entity.User;
import com.example.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    public boolean register(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) return false;
        userRepository.save(user); return true;
    }
    public User login(String username, String password) {
        Optional<User> u = userRepository.findByUsername(username);
        return (u.isPresent() && u.get().getPassword().equals(password)) ? u.get() : null;
    }
}
