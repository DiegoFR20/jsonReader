package com.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.domain.Agenda;
import com.repository.AgendaRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private AgendaRepository agendaRepository;

	@Override
	public void run(String... arg0) throws Exception {
		agendaRepository.deleteAll();

		Agenda teste2 = new Agenda("as564d", 1157498, "teste2", "teste2");
		Agenda teste3 = new Agenda("as574d", 1158498, "teste3", "teste3");
		Agenda teste4 = new Agenda("as584d", 1159498, "teste5", "teste4");

		agendaRepository.saveAll(Arrays.asList(teste2, teste3, teste4));
	}
}