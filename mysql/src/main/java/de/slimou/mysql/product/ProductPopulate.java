package de.slimou.mysql.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class ProductPopulate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ProductPopulate.class);
    private ProductRepository productRepository;

    public ProductPopulate(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.productRepository.save(new Product("Seife", 2.25));

        workWithProducts();
    }

    private void workWithProducts() {

        log.info("-----------PRODUCT-----------");
        log.info("Products found with findAll():");
        log.info("-------------------------------");
        for (Product product : this.productRepository.findAll()) {
            log.info(product.toString());
        }
        log.info("--------------------------------");


    }
}
