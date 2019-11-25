package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/owners")
public class OwnerController {

    @GetMapping(value = { "", "/", "/index", "index.html" })
    public String listOwners() {
        /* Returns the path and name of the desired view file */
        return "/owners/index";
    }
}
