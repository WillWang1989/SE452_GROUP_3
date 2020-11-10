package edu.depaul.se452.windycityflyers;

import edu.depaul.se452.windycityflyers.model.Logs;
import edu.depaul.se452.windycityflyers.service.StorageService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import edu.depaul.se452.windycityflyers.repository.*;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication
public class WindycityflyersApplication {

	private static final Logger log = LoggerFactory.getLogger(WindycityflyersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WindycityflyersApplication.class, args);
	}

	@Bean
	CommandLineRunner initStorageService(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
	@Bean
	public MappingMongoConverter mongoConverter(MongoDatabaseFactory mongoFactory, MongoMappingContext mongoMappingContext) {
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoFactory);
		MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
		mongoConverter.setMapKeyDotReplacement("__DOT__");
		return mongoConverter;
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
				product.getImgList().forEach((img->{
					log.info(img.toString());
				}));
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
	//@Bean
	public CommandLineRunner saveLogsReview(LogsRepository repository) {
		return (args) -> {
			log.info("begin of writing logs");
			Logs log1 = new Logs();
			log1.setUrl("http://localhost:8081/login");
			log1.setProtocol("HTTP");
			log1.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/85.0.4183.102");
			log1.setHttpMethod("GET");
			HashMap<String,String> cookie = new HashMap();
			cookie.put("SSID","AZfk0LGTJnOxuyTJy");
			cookie.put("APISID","AGNTTaGnMuyHU8CO/AZdgMLmsMjbTCZoY_");
			log1.setCookies(cookie);
			HashMap<String,String> headers = new HashMap<>();
			headers.put("Accept-Encoding","gzip, deflate, br");
			headers.put("Accept-Language","en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7");
			log1.setHeaders(headers);
			log1.setStatusCode("200");
			log1.setRequestDate(LocalDateTime.now());
			repository.save(log1);

			Logs log2 = new Logs();
			log2.setUrl("http://localhost:8081/login");
			log2.setProtocol("HTTPS");
			log2.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/85.0.4183.102");
			log2.setHttpMethod("POST");
			log2.setContentType("application/x-www-form-urlencoded");
			log2.setStatusCode("200");
			log2.setRequestDate(LocalDateTime.now());
			repository.save(log2);
			log.info("end of writing logs");
		};
	}

	//@Bean
	public CommandLineRunner showLogsReview(LogsRepository repository) {
		return (args) -> {
			List<Logs> logs = repository.findAll();
			log.info("logs found with findAll():");
			log.info("-------------------------------");
			for (Logs l : logs) {
				log.info(l.toString());
			}
			log.info("-------------------------------");
		};
	}

	@Bean
	public CommandLineRunner showAdmin(AdminRepository repository) {
		return (args) -> {
			// fetch all Customers
			log.info("List of administrators found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach((it) -> {
				log.info(it.toString());
			});
			log.info("-------------------------------");
		};
	}

	@Bean
	public CommandLineRunner showStore(StoreRepository repository) {
		return (args) -> {
			// fetch all Customers
			log.info("List of Stores found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach((it) -> {
				log.info(it.toString());
				log.info("List of department within store found with findAll():");
				log.info("-------------------------------");
				it.getDeptList().forEach((d)->{
					log.info(d.toString());
				});
				log.info("-------------------------------");
				log.info("List of products within store found with findAll():");
				log.info("-------------------------------");
				it.getProdList().forEach((d)->{
					log.info(d.toString());
				});
				log.info("-------------------------------");
			});
			log.info("-------------------------------");
		};
	}
}
