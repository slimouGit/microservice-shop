package de.slimou.mysql.customer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class CustomerPopulate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CustomerPopulate.class);
    private CustomerRepository customerRepository;

    public CustomerPopulate(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.customerRepository.save(new Customer("Jack", "Bauer"));
        this.customerRepository.save(new Customer("Chloe", "O'Brian"));
        this.customerRepository.save(new Customer("Kim", "Bauer"));
        this.customerRepository.save(new Customer("David", "Palmer"));
        this.customerRepository.save(new Customer("Michelle", "Dessler"));

        workWithCustomers();
    }

    private void workWithCustomers() {
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Customer customer : this.customerRepository.findAll()) {
            log.info(customer.toString());
        }
        log.info("--------------------------------");

        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        Customer specialCustomer = this.customerRepository.findById(1L);
        if (null != specialCustomer) {
            log.info(specialCustomer.toString());
            log.info("--------------------------------");
        }

        log.info("Total amount of customers:");
        Long amountCustomers = this.customerRepository.count();
        log.info(amountCustomers.toString() + " customers");

        log.info("--------------------------------");
        log.info("Delete domain with id 5:");
        if (null != this.customerRepository.findById(5L)) {
            this.customerRepository.deleteById(5L);
        }

        log.info("--------------------------------");

        log.info("Total amount of customers:");
        log.info(this.customerRepository.count() + " customers");

        log.info("--------------------------------");
        log.info("Delete all customers:");
//        this.customerRepository.deleteAll();

        log.info("--------------------------------");


    }


}
