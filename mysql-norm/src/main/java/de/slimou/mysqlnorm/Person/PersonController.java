package de.slimou.mysqlnorm.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    private PersonRepository personRepository;
    private PersonService personService;

    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @GetMapping(path = "/personen")
    public String uebersicht(Model model) {
        model.addAttribute("personen", personRepository.findAll());
        return "person/person-list";
    }
}
