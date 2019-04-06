package com.programinwithvagner.rest.RestApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {

    @RequestMapping("/home")
    public String home() {
        return "Hello Word";
    }
}
