package com.promocao.usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class PromocaoUsuarioApplication {

	private static final Logger log = LoggerFactory.getLogger(PromocaoUsuarioApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(PromocaoUsuarioApplication.class, args);
		ConfigurableEnvironment environment = run.getEnvironment();

		log.info("\n\n\t---------------------------------\n\t" +
				":: Cadastro de usuário na porta :: " + environment.getProperty("server.port") + " ::" +
				"\n\t------------------------------------\n\t");
	}
}
