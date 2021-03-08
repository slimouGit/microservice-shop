package de.slimou.mysqlnorm.Person;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findByName(String forname, String lastname){
        return this.personRepository.findByName(forname, lastname);
    }

    public List<Person> findByNameAndBirthday(String forname, String lastname, LocalDate birthday){
        return this.personRepository.findByNameAndBirthday(forname, lastname, birthday);
    }
}
