package com.dto;

import java.io.Serializable;
import java.util.List;

import com.domain.Agenda;
import com.domain.Edicao;

public class AgendaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String hash;
	private String nome;
	private String esfera;
	private List<Edicao> edicao;

	public AgendaDTO() {
	}

	public AgendaDTO(Agenda agenda) {
		id = agenda.getId();
		hash = agenda.getHash();
		nome = agenda.getNome();
		esfera = agenda.getEsfera();
		edicao = agenda.getEdicao();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEsfera() {
		return esfera;
	}

	public void setEsfera(String esfera) {
		this.esfera = esfera;
	}

	public List<Edicao> getEdicao() {
		return edicao;
	}

	public void setEdicao(List<Edicao> edicao) {
		this.edicao = edicao;
	}
}