package com.config;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.domain.Dados;
import com.google.gson.Gson;
import com.repository.DadosRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private DadosRepository dadosRepository;

	@Override
	public void run(String... arg0) throws Exception {
		Gson gson = new Gson();

		FileReader reader = new FileReader("src/resources/json/dados.json");

		Dados dadosJson = gson.fromJson(reader, Dados.class);

		dadosRepository.save(dadosJson);
		
		System.out.println("ID: "+ dadosJson.getAgenda().get(0).getId());
		System.out.println("Hash: "+ dadosJson.getAgenda().get(0).getHash());
		System.out.println("Nome: "+ dadosJson.getAgenda().get(0).getNome());
		System.out.println("Esfera: "+ dadosJson.getAgenda().get(0).getEsfera());
	}
}