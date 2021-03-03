package de.slimou.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }
    @Autowired
    private FilmMongoRepository filmMongoRepository;

    @Override
    public void run(String... args) throws Exception {
        this.filmMongoRepository.deleteAll();
        this.filmMongoRepository.save(new Film("Test", 2021));
        this.filmMongoRepository.save(new Film("Das Leben Brians", 1982));
        this.filmMongoRepository.save(new Film("Das Boot", 1964));
        this.filmMongoRepository.save(new Film("Das Boot", 1964));

        Actor dencel = new Actor("Dencel", "Washington");
        Film equalizer = new Film("Equilizar",2015, dencel);


        this.filmMongoRepository.save(equalizer);


    }

}
