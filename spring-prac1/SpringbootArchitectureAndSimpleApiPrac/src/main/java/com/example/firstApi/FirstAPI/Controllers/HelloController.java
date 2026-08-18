package com.example.firstApi.FirstAPI.Controllers;

import com.example.firstApi.FirstAPI.Services.HelloServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public HelloController(HelloServices srv) {
        System.out.println("Hello Controller Constructor Called");
        this.srv = srv;
    }

    @Autowired
    HelloServices srv;

    @GetMapping("/")
    public String hello() {
        return "Hello - This is API Building practice";
    }

    @GetMapping("about")
    public String about() {
        return "This is about page";
    }

    @GetMapping("/greet")
    public String greetCall(){
        return  srv.greet();
    }
}
