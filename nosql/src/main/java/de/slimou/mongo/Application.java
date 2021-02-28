package de.slimou.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	private FilmMongoRepository filmMongoRepository;

	@Override
	public void run(String... args) throws Exception {
		this.filmMongoRepository.save(new Film("Test", 2021));
	}
}
