package de.slimou.mysql.purchase;

import de.slimou.mysql.customer.Customer;
import de.slimou.mysql.customer.CustomerRepository;
import de.slimou.mysql.product.Product;
import de.slimou.mysql.product.ProductRepository;
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
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    public PurchasePopulate(PurchaseRepository purchaseRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer c1 = new Customer();
        c1.setFirstname("Max");
        c1.setLastname("Muster");
        this.customerRepository.save(c1);

        Product p1 = new Product("Milch", 1.78);
        this.productRepository.save(p1);

        Purchase pu1 = new Purchase();
        pu1.setTransaction_date(LocalDate.now());
        pu1.setCustomer(c1);
        pu1.setProduct(p1);
        this.purchaseRepository.save(pu1);

        Customer c2 = this.customerRepository.findById(288L);
        Product p2 = this.productRepository.findById(112L);
        Purchase pu2 = new Purchase(LocalDate.now(), c2, p2);
        this.purchaseRepository.save(pu2);


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
        log.info("SEARCHING PURCHASE WITH METADATA");

        Purchase pu3 = this.purchaseRepository.findById(293L);
        log.info("PURCHASE: {}", pu3.getId());
        log.info("PRODUCT: {}", pu3.getProduct().getName());
        log.info("CUSTOMER: {}", pu3.getCustomer().getLastname());

        log.info("PRODUCT: {}", pu3.getProduct());
        log.info("CUSTOMER: {}", pu3.getCustomer());

        log.info("--------------------------------");
        for (Purchase p : this.purchaseRepository.findAll()) {
            log.info("PURCHASE: {}", p.getId());
            log.info("PURCHASE: {}", p.getCustomer().getLastname());
            log.info("PURCHASE: {}", p.getProduct().getName());
        }


        log.info("--------------------------------");
        log.info("PURCHASE with ID 60");
        Purchase p1 = this.purchaseRepository.findById(293L);
        log.info("date: {}", p1.getTransaction_date());
        log.info("forname: {}", p1.getCustomer().getFirstname());
        log.info("lasname: {}", p1.getCustomer().getLastname());
        log.info("product: {}", p1.getProduct().getName());
        log.info("price: {}", p1.getProduct().getPrice());

    }
}
