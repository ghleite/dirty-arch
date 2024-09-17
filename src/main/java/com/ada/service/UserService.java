package com.ada.service;

import com.ada.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserByName(String name);

    List<User> listAllUsers();
}
