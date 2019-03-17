package com.flabbyninja.wholeft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class WholeftApplication {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(WholeftApplication.class, args);
    }

    @Bean
    public CommandLineRunner validate(UserRepository repository) {
        return (args) -> {
            log.info("User id 1 -> {}", repository.findById(1L));
            log.info("All users 1 -> {}", repository.findAll());

            log.info("Inserting -> {}", repository.save(new User(101L, "MC", "Hammer", 999L, LocalDate.now(), LocalDate.of(2099, Month.DECEMBER, 31))));
            log.info("Update 2 -> {}", repository.save(new User(2L, "Tony", "Hart", 999L, LocalDate.now(), LocalDate.of(2099, Month.DECEMBER, 31))));

            repository.deleteById(3L);

            log.info("All users 2 -> {}", repository.findAll());
        };
    }


//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("User id 1 -> {}", repository.findById(1L));
//		logger.info("All users 1 -> {}", repository.findAll());
//
//		logger.info("Inserting -> {}", repository.insert(new User(101L, "MC", "Hammer", 999, LocalDate.now(), LocalDate.of(2099, Month.DECEMBER, 31))));
//		logger.info("Update 2 -> {}", repository.update(new User(2L, "Tony", "Hart", 999, LocalDate.now(), LocalDate.of(2099, Month.DECEMBER, 31))));
//
//		repository.deleteById(3L);
//
//		logger.info("All users 2 -> {}", repository.findAll());
//	}
}
