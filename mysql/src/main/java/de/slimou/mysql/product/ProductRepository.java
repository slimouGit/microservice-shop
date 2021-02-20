package de.slimou.mysql.product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);

    Product findById(long product_id);

    void deleteById(Long product_id);

    long count();
}
