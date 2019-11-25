package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    @GetMapping({"/vets", "/vets/index", "vets/index.html"})
    public String listVets() {
        /* Returns the path and name of the desired view file */
        return "/vets/index";
    }
}
