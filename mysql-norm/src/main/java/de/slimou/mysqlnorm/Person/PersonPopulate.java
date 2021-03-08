package de.slimou.mysqlnorm.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class PersonPopulate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PersonPopulate.class);
    private PersonRepository personRepository;

    public PersonPopulate(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.personRepository.save(new Person("Mimi", "Illmi"));
    }
}
