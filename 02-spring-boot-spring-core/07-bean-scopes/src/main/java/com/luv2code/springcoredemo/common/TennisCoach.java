package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("Constructor from class: " + this.getClass().getSimpleName());
    }

    //init method -> Ejecuta el método después de ser construido el componente (después del constructor)
    @PostConstruct
    public void postConstructComponentMethod(){
        System.out.printf("Do some thing since postConstructComponentMethod()");
    }


    //destroy method --> Ejecuta el método justo antes de ser destruido
    @PreDestroy
    public void preDestroyComponentMethod(){
        System.out.printf("Do some thing since preDestroyComponentMethod()");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
