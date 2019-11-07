package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    /* Constructor used by Springto AutoWire the AuthorRepository */
    public AuthorController(AuthorRepository authorRepository) {
        super();
        this.authorRepository = authorRepository;
    }

    @RequestMapping(value = "/authors")
    public String getAuthors(Model model) {

        /*
         * We add an attribute with a pair key/value (name of the
         * attribute)/(attribute)
         */
        model.addAttribute("authors", authorRepository.findAll());

        /* We return a string with the name of the associated view */
        return "authors";
    }
}
