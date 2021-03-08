package de.slimou.mysqlnorm.Meldeanschrift;

import de.slimou.mysqlnorm.Anschrift.Anschrift;
import de.slimou.mysqlnorm.Anschrift.AnschriftRepository;
import de.slimou.mysqlnorm.Person.Person;
import de.slimou.mysqlnorm.Person.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(value = 3)
public class MeldeanschriftPopulate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MeldeanschriftPopulate.class);

    private MedleanschriftRepository medleanschriftRepository;

    @Autowired
    private AnschriftRepository anschriftRepository;

     @Autowired
    private PersonRepository personRepository;

    public MeldeanschriftPopulate(MedleanschriftRepository medleanschriftRepository) {
        this.medleanschriftRepository = medleanschriftRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Optional<Person> person = this.personRepository.findById(2l);
        Optional<Anschrift> anschrift = this.anschriftRepository.findById(1l);

        if(person.isPresent() && anschrift.isPresent()){
            Meldeanschrift meldeanschrift = new Meldeanschrift();
            this.medleanschriftRepository.save(meldeanschrift);
        }

    }
}
