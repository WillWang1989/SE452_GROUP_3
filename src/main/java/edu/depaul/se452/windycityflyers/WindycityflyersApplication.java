package edu.depaul.se452.windycityflyers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import edu.depaul.se452.windycityflyers.repository.*;

import java.util.Optional;


@SpringBootApplication
public class WindycityflyersApplication {

	private static final Logger log = LoggerFactory.getLogger(WindycityflyersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WindycityflyersApplication.class, args);
	}

	@Bean
	public CommandLineRunner showProduct(ProductRepository repository) {
		return (args) -> {
			// fetch all Students
			log.info("Products found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach((product) -> {
				log.info(product.toString());
				log.info(product.getDept().getName());
			});
			log.info("-------------------------------");
		};
	}

}
