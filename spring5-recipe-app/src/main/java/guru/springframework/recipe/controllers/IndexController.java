package guru.springframework.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = { "", "/", "/index", "/index.html" })
    public String getIndexPage() {
        /* Returns the path and name of the related view file */
        return "index";
    }
}
