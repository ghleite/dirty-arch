package com.ada.service;

import com.ada.model.User;
import com.ada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User User) {
        return repository.save(User);
    }

    @Override
    public User getUserByName(String name) {
        Optional<User> user = repository.findByName(name);
        return user.orElse(null);
    }

    @Override
    public List<User> listAllUsers() {
        return repository.findAll();
    }
}