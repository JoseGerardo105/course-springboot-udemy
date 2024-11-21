package com.luv2code.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCoolAppController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }
    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }

    // expose a new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: John, Manager: Mary";
    }

    // expose a new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo3(){
        return "Coach: John, Manager: Mary";
    }
}
