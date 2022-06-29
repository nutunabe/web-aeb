package ru.albank.trainee.traineemanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.albank.trainee.traineemanager.models.ERole;
import ru.albank.trainee.traineemanager.models.User;
import ru.albank.trainee.traineemanager.repo.UserRepo;

import java.util.Collections;
import java.util.Map;

@Controller

public class RegistrationController {
    @Autowired
    private UserRepo userRepo;


    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

//    @PostMapping("/registration")
//    public String addUser(User user, Map<String, Object> model) {
//        User userFromDb = userRepo.findByUsername(user.getUsername());
//
//        if (userFromDb != null) {
//            model.put("message", "Пользователь уже существует!");
//            return "registration";
//        }
//
//        user.setActive(true);
//        user.setRoles(Collections.singleton(ERole.ROLE_USER));
//        userRepo.save(user);
//
//        return "redirect:/login";
//    }
}
