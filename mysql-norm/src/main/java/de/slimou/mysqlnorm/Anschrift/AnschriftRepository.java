package de.slimou.mysqlnorm.Anschrift;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnschriftRepository extends CrudRepository<Anschrift, Long> {
    @Query("SELECT a FROM Anschrift a WHERE a.location = :location")
        List<Anschrift> findByLocation(@Param("location") String location);
}
