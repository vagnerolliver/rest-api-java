package com.programinwithvagner.rest.RestApp.controller;

import com.programinwithvagner.rest.RestApp.model.User;
import com.programinwithvagner.rest.RestApp.service.UserServiceImp;

import com.programinwithvagner.rest.RestApp.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);


    @Autowired
    UserServiceImp userService; //Service which will do all data retrieval/manipulation work

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {

        List<User> users = userService.findAllUsers();

        if (users.isEmpty()) {

            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        
        logger.info("Fetching User with id {}", id);

        User user = userService.findById(id);

        if (user ==  null) {

            return new ResponseEntity(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
