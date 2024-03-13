package com.wad.mvc.services;

import com.wad.mvc.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User u);
}
