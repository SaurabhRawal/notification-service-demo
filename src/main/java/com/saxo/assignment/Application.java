package com.saxo.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.saxo.assignment.client.ClientPortfolio;
import com.saxo.assignment.client.ClientService;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy=true)
public class Application implements CommandLineRunner {

	private ClientService clientService;

	@Autowired
	public Application(ClientService clientService) {
		this.clientService = clientService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args).close();;
	}

	@Override
	public void run(String... strings) throws Exception {
		ClientPortfolio clientPortfolio = ClientPortfolio.builder().clientId(1).clientFirstName("Saurabh").clietLastName("Rawal").build();
		clientService.addPortfolio(clientPortfolio);
		clientService.addPortfolio(clientPortfolio);
	}
}
