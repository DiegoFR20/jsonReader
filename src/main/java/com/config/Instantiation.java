package com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.domain.Agenda;
import com.domain.Dados;
import com.domain.Edicao;
import com.domain.Evento;
import com.domain.FatoGerador;
import com.domain.Obrigacao;
import com.domain.Recolhimento;
import com.domain.RequisicaoStatus;
import com.repository.DadosRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private DadosRepository dadosRepository;

	@Override
	public void run(String... arg0) throws Exception {
		dadosRepository.deleteAll();

		RequisicaoStatus requisicaoStatus1 = new RequisicaoStatus(8974, 7894, "mensagem", "data", 987, "hashTotal");
		Recolhimento recolhimento1 = new Recolhimento("regra", "forma", "tipo", "descricao", "url");
		FatoGerador fatoGerador1 = new FatoGerador(932, 2983);

		Obrigacao obrigacao1 = new Obrigacao(987123, "sigla", "nome", "genero", "area", "tipo", "periodicidade",
				"descricao", recolhimento1);

		Evento evento1 = new Evento(546, "data", obrigacao1, fatoGerador1);

		List<Evento> eventoList = new ArrayList<Evento>();
		eventoList.add(evento1);

		Edicao edicao1 = new Edicao(32939, "descricao", 2020, 12, eventoList);

		List<Edicao> edicaoList = new ArrayList<Edicao>();
		edicaoList.add(edicao1);

		Agenda teste2 = new Agenda(1157498, "hash", "nome", "esfera", edicaoList);

		List<Agenda> agendaList = new ArrayList<>();
		agendaList.add(teste2);

		Dados dados1 = new Dados("versao", requisicaoStatus1, agendaList);

		dadosRepository.save(dados1);
	}
}