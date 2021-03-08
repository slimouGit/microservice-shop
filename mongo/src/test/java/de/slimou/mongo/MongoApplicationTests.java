package de.slimou.mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataMongoTest
public class MongoApplicationTests {

    @Autowired
    private PersonRepository personRepository;


    @Test
    public void personShouldBeSaved(){
        Person person = new Person("Max", "Mustermann");
        this.personRepository.save(person);
        assertThat(person.getId()).isNotNull();
        assertEquals(person.getForename(),"Max");
    }

}
