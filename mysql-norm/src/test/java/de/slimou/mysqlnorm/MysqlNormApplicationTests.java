package de.slimou.mysqlnorm;

import de.slimou.mysqlnorm.Person.Person;
import de.slimou.mysqlnorm.Person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MysqlNormApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void personCouldBeSaved(){
        Person person = new Person("Mimi", "Illmi", LocalDate.of(1976,3,6));
        this.personRepository.save(person);
        assertThat(person.getId()).isNotNull();
        assertEquals(person.getFirstname(),"Mimi");
    }

}
