package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach1;
    private Coach coach2;

    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach coach1, @Qualifier("tennisCoach") Coach coach2) {
        this.coach1 = coach1;
        this.coach2 = coach2;
    }

    @GetMapping("/daylyworkout")
    public String getDailyWorkout(){
        return coach1.getDailyWorkout();
    }

    @GetMapping("/compare-coaches")
    public String compareCoaches(){
        return "Comparing that Coach 1 == Coach 2, " +  (coach1 == coach2);
    }
}
