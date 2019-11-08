package guru.springframework.controllers;

import guru.springframework.services.GreetinService;

public class ConstructorInjectedController {

    private GreetinService greetinService;

    public ConstructorInjectedController(GreetinService greetinService) {
        super();
        this.greetinService = greetinService;
    }

    public String sayHello() {
        return greetinService.sayGreeting();
    }
}
