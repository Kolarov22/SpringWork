package com.wad.mvc.services;


import com.wad.mvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> users = new ArrayList(List.of(
            new User(28L, "Andrei", "andrei@yahoo.com"),
            new User(20L, "John", "john@outlook.com"),
            new User(19L, "Michael", "mike@gmail.com"))
    );
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User u) {
        users.add(u);

    }
}
