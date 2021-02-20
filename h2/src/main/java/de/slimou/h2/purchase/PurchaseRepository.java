package de.slimou.h2.purchase;

import de.slimou.h2.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    Purchase findById(long purchase_id);

    void deleteById(Long purchase_id);

    long count();
}
