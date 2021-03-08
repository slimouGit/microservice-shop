package de.slimou.mysqlnorm.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    /**
     * Person anhand Vor- und Zuname suchen
     * @param firstname
     * @param lastname
     * @return
     */
    @Query("SELECT p FROM Person p WHERE p.firstname = :firstname AND p.lastname = :lastname")
    List<Person> findByName(@Param("firstname") String firstname, @Param("lastname") String lastname);

    /**
     * Person anhand Vor- und Zuname und Geburtsdatum suchen
     * @param firstname
     * @param lastname
     * @param birthday
     * @return
     */
    @Query("SELECT p FROM Person p WHERE p.firstname = :firstname AND p.lastname = :lastname AND p.birthday = :birthday")
    List<Person> findByNameAndBirthday(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("birthday") LocalDate birthday);

}
