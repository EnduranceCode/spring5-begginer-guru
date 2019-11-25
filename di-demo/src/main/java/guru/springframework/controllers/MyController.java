package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import guru.services.GreetingService;

@Controller
public class MyController {

    private GreetingService greetingService;

    /*
     * With constructor injection, the Autowired annotation is not necessary but
     * it can be a good idea to use anyway because it makes our intentions more
     * explicit. The string value of the qualifier corresponds to the name of
     * the implementation class in camel case.
     */
    @Autowired
    public MyController(GreetingService greetingService) {
        super();
        this.greetingService = greetingService;
    }

    public String hello() {
        System.out.println("Hello World!");

        return greetingService.sayGreeting();
    }
}
