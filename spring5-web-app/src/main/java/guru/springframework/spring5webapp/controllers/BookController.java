package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;

    /* Constructor used by Spring to AutoWire the BookRepository */
    public BookController(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/books")
    public String getBooks(Model model) {

        /*
         * We add an attribute with a pair key/value (name of the
         * attribute)/(attribute)
         */
        model.addAttribute("books", bookRepository.findAll());

        /* We return a string with the name of the associated view */
        return "books";
    }
}
