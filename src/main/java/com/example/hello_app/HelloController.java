package com.example.hello_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "Hello JBDL-79 - "+Thread.currentThread().getName();
    }


}
