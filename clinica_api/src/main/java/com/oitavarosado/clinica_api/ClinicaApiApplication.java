package com.oitavarosado.clinica_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class ClinicaApiApplication {

	public static void main(String[] args) {
	    Dotenv dotenv = Dotenv.load();

		SpringApplication.run(ClinicaApiApplication.class, args);
	}

}
