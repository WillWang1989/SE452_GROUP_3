package Model;

//import Model.Orders.*;
import Model.Products.*;
import Model.Users.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication

public class WindyCityFlyersRunner {

    private static final Logger log = LoggerFactory.getLogger(WindyCityFlyersRunner.class);

    public static void main(String[] args) {
        SpringApplication.run(WindyCityFlyersRunner.class, args);
    }

    @Bean
    public CommandLineRunner showProduct(ProductRepository repository) {
        return (args) -> {
            // fetch all Students
            log.info("Students found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach((product) -> {
                log.info(product.toString());
            });
            log.info("-------------------------------");
        };
    }
}
