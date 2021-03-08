package de.slimou.mysqlnorm.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(value = 1)
public class PersonPopulate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PersonPopulate.class);
    private PersonRepository personRepository;
    private PersonService personService;

    public PersonPopulate(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.personRepository.deleteAll();
        this.personRepository.save(new Person("Mimi", "Illmi", LocalDate.of(1976,3,6)));
        this.personRepository.save(new Person("Salim", "Oussayfi", LocalDate.of(1980,4,26)));

        List<Person> personListByName = this.personService.findByName("Mimi", "Illmi");
        log.info("Personen {}", personListByName.size());
        for(Person person:personListByName){
            log.info("Person {} {}", person.getFirstname(), person.getLastname() );
        }

        List<Person> personListByNameAndBirthday = this.personService.findByNameAndBirthday("Mimi", "Illmi", LocalDate.of(1976,3,6));

        personListByNameAndBirthday.addAll(this.personService.findByNameAndBirthday("Salim", "Oussayfi", LocalDate.of(1980,4,26)));

        log.info("Personen nach Name und Geburtsdatum {}", personListByNameAndBirthday.size());
    }
}
