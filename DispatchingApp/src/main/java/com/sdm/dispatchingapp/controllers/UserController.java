package com.sdm.dispatchingapp.controllers;

import com.sdm.dispatchingapp.domain.Dispatcher;
import com.sdm.dispatchingapp.repositories.DispatcherRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {
    private final DispatcherRepository dispatcherRepo;

    public UserController(DispatcherRepository dispatcherRepo) {
        this.dispatcherRepo = dispatcherRepo;
    }

    @GetMapping("/")
    public String logIn(){
        return "dispatcher.html";
    }
    @PostMapping("/login")
    public String createDispatcher(@RequestParam String dispatcherUsername, HttpSession session) {
        Dispatcher dispatcher = new Dispatcher(dispatcherUsername);
        dispatcherRepo.save(dispatcher);
        session.setAttribute("dispatcher", dispatcher);
        return "redirect:/reports";
    }

}
