package com.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Embeddable
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "id")
	private Integer id;

	
	@EmbeddedId
	@Column(name="hash")
	private String hash;

	private String nome;
	private String esfera;

	@OneToMany(targetEntity = Edicao.class, mappedBy = "edicao")
	private List<Edicao> edicao;

	public Agenda() {
	}

	public Agenda(Integer id, String hash, String nome, String esfera, List<Edicao> edicao) {
		this.id = id;
		this.hash = hash;
		this.nome = nome;
		this.esfera = esfera;
		this.edicao = edicao;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", hash=" + hash + ", nome=" + nome + ", esfera=" + esfera + ", edicao=" + edicao
				+ "]";
	}
}