package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import guru.springframework.services.GreetinService;

@Controller
public class SetterInjectedController {

    private GreetinService greetinService;

    @Autowired
    public void setGreetinService(GreetinService greetinService) {
        this.greetinService = greetinService;
    }

    public String sayHello() {
        return greetinService.sayGreeting();
    }
}
