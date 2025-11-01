package br.edu.unichristus.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Documentação da Biblioteca Virtual ",
				version = "1.0",
				description = "API - NP2 da Disciplina TEPW-20252 " +
                         "Contato: giuliedev@gmail.com; margoprr@gmail.com; pollyammelo@gmail.com",

				contact = @Contact(
						name = "Equipe: Giulie Ribeiro; Margarida Pereira; Pollyanna Melo",
						email = "giuliedev@gmail.com",
						url = "https://github.com/giuliedev/biblioteca-virtual")
		)
)
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
