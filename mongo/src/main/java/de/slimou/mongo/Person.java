package de.slimou.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons")
public class Person {

    private String id;
    private String forename;
    private String lastname;

    public Person(String forename, String lastname) {
        this.forename = forename;
        this.lastname = lastname;
    }
}
