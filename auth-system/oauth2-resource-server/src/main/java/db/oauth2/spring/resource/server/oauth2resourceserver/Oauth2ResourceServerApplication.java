package db.oauth2.spring.resource.server.oauth2resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.UUID;

@SpringBootApplication
@RestController
@EnableResourceServer
public class Oauth2ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2ResourceServerApplication.class, args);
	}


	@RequestMapping("/")
	public String securedCall() {
		return "success (id: " + UUID.randomUUID().toString().toUpperCase() + ")";
	}
}
