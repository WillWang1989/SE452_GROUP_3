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
			// fetch all Products
			log.info("Products found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach((product) -> {
				log.info(product.toString());
				log.info(product.getDept().getName());
			});
			log.info("-------------------------------");
		};
	}
	@Bean
	public CommandLineRunner showCustomer(CustomerRepository repository) {
		return (args) -> {
			// fetch all Customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach((it) -> {
				log.info(it.toString());
			});
			log.info("-------------------------------");
		};
	}

	@Bean
	public CommandLineRunner showOrder(OrderRepository repository) {
		return (args) -> {
			// fetch all Orders
			log.info("Orders found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach((it) -> {
				log.info(it.toString());
				log.info(it.getCustomer().toString());
				log.info("	products within current order");
				log.info("	-----------begin--------------");
				it.getProducts().forEach((p)->{
					log.info("\t"+p.toString());
				});
				log.info("	-----------end-----------------");
			});
			log.info("-------------------------------");
		};
	}

	@Bean
	public CommandLineRunner showShoppingCart(ShoppingCartRepository repository) {
		return (args) -> {
			// fetch all shoppingCarts
			log.info("shoppingCarts found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach((it) -> {
				log.info(it.toString());
				log.info(it.getCustomer().toString());
				log.info("	products within current cart");
				log.info("	-----------begin--------------");
				it.getProducts().forEach((p)->{
					log.info("\t"+p.toString());
				});
				log.info("	-----------end-----------------");
			});
			log.info("-------------------------------");
		};
	}

}
