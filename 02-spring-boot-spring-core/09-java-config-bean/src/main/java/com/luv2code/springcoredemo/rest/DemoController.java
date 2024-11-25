package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach1;

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach coach1) {
        this.coach1 = coach1;
    }

    @GetMapping("/daylyworkout")
    public String getDailyWorkout(){
        return coach1.getDailyWorkout();
    }

}
