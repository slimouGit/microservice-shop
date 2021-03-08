package de.slimou.mysqlnorm.Anschrift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(value = 2)
public class AnschriftPopulate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AnschriftPopulate.class);
    private AnschriftRepository anschriftRepository;

    public AnschriftPopulate(AnschriftRepository anschriftRepository) {
        this.anschriftRepository = anschriftRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.anschriftRepository.save(new Anschrift("Antoninusstrasse", "64", 60439, "Frankfurt"));

        List<Anschrift> anschriftList = this.anschriftRepository.findByLocation("Frankfurt");
        log.info("Anschriften {}", anschriftList.size());
        for(Anschrift anschrift:anschriftList){
            log.info(anschrift.getLocation());
        }
    }
}
