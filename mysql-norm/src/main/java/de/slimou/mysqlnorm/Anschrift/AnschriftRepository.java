package de.slimou.mysqlnorm.Anschrift;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnschriftRepository extends CrudRepository<Anschrift, Long> {
    @Query("SELECT a FROM Anschrift a WHERE a.location = :location")
        List<Anschrift> findByLocation(@Param("location") String location);
}
