package de.slimou.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmMongoRepository 
	extends MongoRepository<Film, String> {
}
