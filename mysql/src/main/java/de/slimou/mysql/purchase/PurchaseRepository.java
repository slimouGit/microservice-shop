package de.slimou.mysql.purchase;

import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    Purchase findById(long purchase_id);

    void deleteById(Long purchase_id);

    long count();
}
