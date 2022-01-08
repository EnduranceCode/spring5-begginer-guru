package guru.springframework.recipe.controllers;

import guru.springframework.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = {"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model) {
        log.debug("[START] : " + this.getClass().getName() + ".getIndexPage(~)");

        model.addAttribute("recipes", recipeService.getRecipes());

        log.debug("[END] : " + this.getClass().getName() + ".getIndexPage(~)");

        /* Returns the path and name of the related view file */
        return "index";
    }
}
