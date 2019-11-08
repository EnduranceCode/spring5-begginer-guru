package guru.springframework.controllers;

import guru.springframework.services.GreetinService;

public class SetterInjectedController {

    private GreetinService greetinService;

    public void setGreetinService(GreetinService greetinService) {
        this.greetinService = greetinService;
    }

    public String sayHello() {
        return greetinService.sayGreeting();
    }
}
