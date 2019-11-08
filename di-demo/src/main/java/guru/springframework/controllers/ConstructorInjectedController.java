package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import guru.springframework.services.GreetinService;

@Controller
public class ConstructorInjectedController {

    private GreetinService greetinService;

    /*
     * With constructor injection, the Autowired annotation is not necessary but
     * it can be a good idea to use anyway because it makes our intentions more
     * explicit
     */
    @Autowired
    public ConstructorInjectedController(GreetinService greetinService) {
        super();
        this.greetinService = greetinService;
    }

    public String sayHello() {
        return greetinService.sayGreeting();
    }
}
