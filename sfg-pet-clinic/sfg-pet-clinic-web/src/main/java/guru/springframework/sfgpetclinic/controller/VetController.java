package guru.springframework.sfgpetclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import guru.springframework.sfgpetclinic.services.VetService;

@Controller
public class VetController {

    private VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        super();
        this.vetService = vetService;
    }

    @GetMapping({ "/vets", "/vets/index", "vets/index.html" })
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        /* Returns the path and name of the desired view file */
        return "/vets/index";
    }
}
