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


    @GetMapping("/greeting")
    public String greeting() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();

        String greeting;
        if (hour >= 5 && hour < 12) {
            greeting = "Good Morning";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good Afternoon";
        } else if (hour >= 17 && hour < 21) {
            greeting = "Good Evening";
        } else {
            greeting = "Good Night";
        }

        return greeting + "! Current server time: " + now;
    }
}
