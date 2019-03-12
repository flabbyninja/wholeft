package com.flabbyninja.wholeft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WholeftApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(WholeftApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 1 -> {}", repository.findById(1L));
		logger.info("All users 1 -> {}", repository.findAll());

		logger.info("Inserting -> {}", repository.insert(new User(101L, "MC", "Hammer")));
		logger.info("Update 2 -> {}", repository.update(new User(2L, "Tony", "Hart")));

		repository.deleteById(3L);

		logger.info("All users 2 -> {}", repository.findAll());
	}
}