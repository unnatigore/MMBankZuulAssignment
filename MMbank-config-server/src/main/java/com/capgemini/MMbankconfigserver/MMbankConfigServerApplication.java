package com.capgemini.MMbankconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MMbankConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MMbankConfigServerApplication.class, args);
	}

}

