package guru.springframework.recipe.controllers;

import guru.springframework.recipe.domain.Category;
import guru.springframework.recipe.domain.UnitOfMeasure;
import guru.springframework.recipe.repositories.CategoryRepository;
import guru.springframework.recipe.repositories.UnitOfMeasureRepository;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    CategoryRepository categoryRepository;
    UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(
            CategoryRepository categoryRepository,
            UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping(value = {"", "/", "/index", "/index.html"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription(
                "Teaspoon");

        System.out.println("Category ID is " + categoryOptional.get().getId());
        System.out.println("Unit of Measure ID is " + unitOfMeasureOptional.get().getId());

        /* Returns the path and name of the related view file */
        return "index";
    }
}
