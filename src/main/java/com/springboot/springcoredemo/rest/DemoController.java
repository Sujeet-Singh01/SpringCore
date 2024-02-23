package com.springboot.springcoredemo.rest;

import com.springboot.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define private fields for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach,
                          @Qualifier("tennisCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = theAnotherCoach;
    }
// If the scope is singleton(default) then theCoach and theAnotherCoach
// will point to the same memory location

    @GetMapping("/check")
    public String check() {
        return "Comparing Coach and AnotherCoach: " + (myCoach == anotherCoach);
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/")
    public String getStr() {
        return "Hello";
    }
}
