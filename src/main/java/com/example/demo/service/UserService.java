package com.example.demo.service;


;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


    @Service
    public class UserService {
        @Autowired
        private UserRepository userRepository;

        public void addUpdateUser(User user) {
            userRepository.save(user);
        }

        public void removeUserById(long id) {
            userRepository.deleteById(id);
        }

        public User getUserById(long id) {
            User user= null;
            Optional<User> optional = userRepository.findById(id);
            if(optional.isPresent()){
                user = optional.get();}
            return user;
        }

        public List<User> getAllUsers() {
            return userRepository.findAll();
        }
    }