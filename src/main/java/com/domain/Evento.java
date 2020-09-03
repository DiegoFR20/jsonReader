package com.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

public class Evento  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="@id")
    private int id;
	private String data;
	
	@OneToMany(targetEntity = Obrigacao.class, mappedBy = "obrigacao")
	private List<Obrigacao> obrigacao;

	@OneToMany(targetEntity = FatoGerador.class, mappedBy = "fatoGerador")
    private List<FatoGerador> fatoGerador;

	public Evento(int id, String data, List<Obrigacao> obrigacao, List<FatoGerador> fatoGerador) {
		this.id = id;
		this.data = data;
		this.obrigacao = obrigacao;
		this.fatoGerador = fatoGerador;
	}

	public Evento() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Obrigacao> getObrigacao() {
		return obrigacao;
	}

	public void setObrigacao(List<Obrigacao> obrigacao) {
		this.obrigacao = obrigacao;
	}

	public List<FatoGerador> getFatoGerador() {
		return fatoGerador;
	}

	public void setFatoGerador(List<FatoGerador> fatoGerador) {
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