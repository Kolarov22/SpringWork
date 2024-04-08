package com.wad.mvc.services;


import com.wad.mvc.domain.User;
import com.wad.mvc.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void save(User u) {
        userRepo.save(u);

    }
}
