package br.edu.unichristus.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Documentação",
				version = "1.0",
				description = "Trata-se da Documentação da " +
						"API construída em sala",
				contact = @Contact(
						name = "Adriano Lima",
						email = "adriano.candido@unichristus.edu.br",
						url = "https://unichristus.edu.br")
		)
)
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
