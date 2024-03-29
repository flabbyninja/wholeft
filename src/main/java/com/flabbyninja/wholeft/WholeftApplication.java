package com.flabbyninja.wholeft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WholeftApplication {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(WholeftApplication.class, args);
    }

    @Bean
    public CommandLineRunner validate(UserRepository repository) {
        return (args) ->
                log.info("CommandLineRunner stub");
    }
}
