package de.slimou.h2.purchase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Order(value = 3)
public class PurchasePopulate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PurchasePopulate.class);
    private PurchaseRepository purchaseRepository;

    public PurchasePopulate(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.purchaseRepository.save(new Purchase(LocalDate.now(), 1L, 1L));

        workWithOrders();
    }

    private void workWithOrders() {
        log.info("-----------ORDER-----------");
        log.info("Orders found with findAll():");
        log.info("-------------------------------");
        for (Purchase purchase : this.purchaseRepository.findAll()) {
            log.info(purchase.toString());
        }
        log.info("--------------------------------");

        Purchase p1 = this.purchaseRepository.findById(7L);

        log.info("Purchase-Date {}", p1.getTransaction_date());

    }
}
