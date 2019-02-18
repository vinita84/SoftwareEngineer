package com.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.application","com.controllers", "com.repository"} )
public class PassengerApp {



    //static PassengerRepository repository;
    public static void main(String[] args) {

        SpringApplication.run(PassengerApp.class, args);

    }
}


/*
import com.model.Passenger;
import com.repository.PassengerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class PassengerApp {
    @Bean
    CommandLineRunner init(PassengerRepository repository) {
        return args -> {
            repository.save(new Passenger("Jane", "Doe", 123, 12, "economy"));
            repository.save(new Passenger("Martin", "Fowler", 124, 11, "economy"));
            repository.save(new Passenger("Roy", "Fielding", 125, 10, "economy"));
        };
    }
}*/
