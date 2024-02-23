package com.springboot.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

// By default the Scope is Singleton

public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Practice backhand volley";
    }
}
