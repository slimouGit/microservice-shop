package de.slimou.mysqlnorm.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    /**
     * Person anhand Vor- und Zuname suchen
     * @param firstname
     * @param lastname
     * @return
     */
    @Query("SELECT p FROM Person p WHERE p.firstname = :firstname AND p.lastname = :lastname")
    List<Person> findByName(@Param("firstname") String firstname, @Param("lastname") String lastname);

    @Query("SELECT p FROM Person p WHERE p.firstname = :firstname AND p.lastname = :lastname AND p.birthday = :birthday")
    List<Person> findByNameAndBirthday(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("birthday") LocalDate birthday);

}
