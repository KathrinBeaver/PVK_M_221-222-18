package ru.mai.testwebproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mai.testwebproject.form.AnimalForm;
import ru.mai.testwebproject.model.Animal;
import ru.mai.testwebproject.service.AnimalService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = { "/animalList" }, method = RequestMethod.GET)
    public String animalList(Model model) {

        model.addAttribute("animals", animalService.getAnimals());

        return "animalList";
    }

    @RequestMapping(value = { "/addAnimal" }, method = RequestMethod.GET)
    public String showAddAnimalPage(Model model) {

        AnimalForm animalForm = new AnimalForm();
        model.addAttribute("animalForm", animalForm);

        return "addAnimal";
    }

    @RequestMapping(value = { "/addAnimal" }, method = RequestMethod.POST)
    public String saveAnimal(Model model,
                             @ModelAttribute("animalForm") AnimalForm animalForm) {

        String firstName = animalForm.getName();
        String lastName = animalForm.getType();

        if (firstName != null && firstName.length() > 0
                && lastName != null && lastName.length() > 0) {
            Animal newAnimal = new Animal(firstName, lastName);
            animalService.addAnimal(newAnimal);

            return "redirect:/animalList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addAnimal";
    }
}
