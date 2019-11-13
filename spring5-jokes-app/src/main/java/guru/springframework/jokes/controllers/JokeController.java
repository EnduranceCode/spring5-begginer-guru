package guru.springframework.jokes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import guru.springframework.jokes.services.JokeService;

@Controller
public class JokeController {

    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        super();
        this.jokeService = jokeService;
    }

    @GetMapping(value = { "/", "" })
    public String getJoke(Model model) {
        
        model.addAttribute("joke", jokeService.getJoke());
        
        return null;
    }
}
