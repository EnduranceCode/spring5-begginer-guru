package guru.springframework.sfgpetclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.OwnerService;

@Controller
@RequestMapping(value = "/owners")
public class OwnerController {
    
    private OwnerService ownerService;
    
    @Autowired
    public OwnerController(OwnerService ownerService) {
        super();
        this.ownerService = ownerService;
    }

    @GetMapping(value = { "", "/", "/index", "index.html" })
    public String listOwners(Model model) {
        
        model.addAttribute("owners", ownerService.findAll());
        
        /* Returns the path and name of the desired view file */
        return "/owners/index";
    }
}
