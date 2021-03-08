package de.slimou.mysqlnorm.Meldeanschrift;

import de.slimou.mysqlnorm.Anschrift.Anschrift;
import de.slimou.mysqlnorm.Person.Person;

import javax.persistence.*;

@Entity
@Table(name = "meldeanschrift")
public class Meldeanschrift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "person")
    private Person person;

    @OneToOne
    @JoinColumn(name = "anschrift")
    private Anschrift anschrift;

    public Meldeanschrift(Person person, Anschrift anschrift) {
        this.person = person;
        this.anschrift = anschrift;
    }

    public Meldeanschrift() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Anschrift getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(Anschrift anschrift) {
        this.anschrift = anschrift;
    }
}
