package de.slimou.mysqlnorm.Anschrift;

import de.slimou.mysqlnorm.Meldeanschrift.Meldeanschrift;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "anschrift")
public class Anschrift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "housenumber")
    private String housenumber;

    @Column(name = "zipcode")
    private Integer zipcode;

    @Column(name = "location")
    private String location;

    @OneToOne(mappedBy = "anschrift", fetch = LAZY, targetEntity = Meldeanschrift.class)
    private Meldeanschrift meldeanschrift;

    public Anschrift(String street, String housenumber, Integer zipcode, String location) {
        this.street = street;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.location = location;
    }

    public Anschrift() {
    }

    @Override
    public String toString() {
        return "Anschrift{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", housenumber='" + housenumber + '\'' +
                ", zipcode=" + zipcode +
                ", location='" + location + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Meldeanschrift getMeldeanschrift() {
        return meldeanschrift;
    }

    public void setMeldeanschrift(Meldeanschrift meldeanschrift) {
        this.meldeanschrift = meldeanschrift;
    }
}
