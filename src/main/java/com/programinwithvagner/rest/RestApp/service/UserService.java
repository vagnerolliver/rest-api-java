package com.programinwithvagner.rest.RestApp.service;

import com.programinwithvagner.rest.RestApp.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findById(long id);

    void saveUser(User user);

    boolean isUserExist(User user);
}
