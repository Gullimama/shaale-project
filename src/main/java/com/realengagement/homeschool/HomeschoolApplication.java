package com.realengagement.homeschool;

import com.realengagement.homeschool.jpa.repositories.ClassesRepository;
import com.realengagement.homeschool.jpa.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeschoolApplication {

	Logger logger  = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(HomeschoolApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(UsersRepository repository) {
//		return (args) -> {
//			repository.findAll()
//						.forEach(e -> logger.info(e.));
//		};
//	}
}
