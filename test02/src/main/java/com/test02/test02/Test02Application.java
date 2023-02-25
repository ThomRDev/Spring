package com.test02.test02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test02Application {
	private static Logger log = LoggerFactory.getLogger(Test02Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Test02Application.class, args);
		log.warn("algo va fallar");
		log.info("info");

		// por defecto el debug esta oculto
		log.debug("Asdasd");
	}

}
