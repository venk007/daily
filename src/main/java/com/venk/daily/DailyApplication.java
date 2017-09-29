package com.venk.daily;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DailyApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DailyApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(DailyApplication.class, args);
		LOGGER.info("Halo Venk！");
	}
}
