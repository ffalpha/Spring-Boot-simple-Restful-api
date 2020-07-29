package restapi.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import restapi.modal.Employee;

@SpringBootApplication
@EnableJpaAuditing

public class ExampleApplication {
	public static void main(String[]args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

}
