package com.tbp.mdl.controller;

import com.tbp.mdl.model.moodle.User;
import com.tbp.mdl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getById(@PathVariable Long userId) {
        return userRepository.findOne(userId);
    }

}
