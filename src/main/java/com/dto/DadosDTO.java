package com.dto;

import java.io.Serializable;
import java.util.List;

import com.domain.Agenda;
import com.domain.Dados;
import com.domain.RequisicaoStatus;

public class DadosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String versao;
	private RequisicaoStatus requisicaoStatus;
	private List<Agenda> agenda;

	public DadosDTO() {
	}

	public DadosDTO(Dados dados) {
		id = dados.getId();
		versao = dados.getVersao();
		requisicaoStatus = dados.getRequisicaoStatus();
		agenda = dados.getAgenda();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public RequisicaoStatus getRequisicaoStatus() {
		return requisicaoStatus;
	}

	public void setRequisicaoStatus(RequisicaoStatus requisicaoStatus) {
		this.requisicaoStatus = requisicaoStatus;
	}

	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}	
}