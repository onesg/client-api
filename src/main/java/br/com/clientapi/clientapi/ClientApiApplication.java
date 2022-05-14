package br.com.clientapi.clientapi;

import br.com.clientapi.clientapi.model.entity.Client;
import br.com.clientapi.clientapi.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ClientApiApplication {

	/* @Bean Será executado assim que o projeto for startado. */
	@Bean
	public CommandLineRunner run(@Autowired ClientRepository repository){

		/* Método padrão */
		/*
		return args -> {
			Client client = new Client();
			client.setNameClient("Tiago");
			client.setCpfClient("123456789");
			client.setDateRegisterClient(LocalDate.of(2022, 05, 9));
			repository.save(client);
		};
		*/

		/* Método mais atual */
		return args -> {
			Client client = Client.builder().
					nameClient("").
					cpfClient("").
					dateRegisterClient(LocalDate.of(2022, 06, 14)).
					build();
			repository.save(client);
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);
	}

}
