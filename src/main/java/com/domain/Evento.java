package com.domain;

import java.io.Serializable;

import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Evento  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    private Integer id;
	
	private String data;
	
	@OneToMany(targetEntity = Obrigacao.class, mappedBy = "obrigacao")
	private Obrigacao obrigacao;

	@OneToMany(targetEntity = FatoGerador.class, mappedBy = "fatoGerador")
    private FatoGerador fatoGerador;

	public Evento(Integer id, String data, Obrigacao obrigacao, FatoGerador fatoGerador) {
		this.id = id;
		this.data = data;
		this.obrigacao = obrigacao;
		this.fatoGerador = fatoGerador;
	}

	public Evento() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Obrigacao getObrigacao() {
		return obrigacao;
	}

	public void setObrigacao(Obrigacao obrigacao) {
		this.obrigacao = obrigacao;
	}

	public FatoGerador getFatoGerador() {
		return fatoGerador;
	}

	public void setFatoGerador(FatoGerador fatoGerador) {
		this.fatoGerador = fatoGerador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evento [data=" + data + ", fatoGerador=" + fatoGerador + ", id=" + id + ", obrigacao=" + obrigacao
				+ "]";
	}	
}