package de.slimou.h2.customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long customer_id);

    void deleteById(Long customer_id);

    long count();
}
