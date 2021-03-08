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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
