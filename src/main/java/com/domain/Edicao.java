package com.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Edicao implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    private int id;
    
    private String descricao;
    private int ano;
    private int mes;
    
    @OneToMany(targetEntity = Evento.class, mappedBy = "evento")
    private List<Evento> evento;

    public Edicao() {
    }

    public Edicao(int id, String descricao, int ano, int mes, List<Evento> evento) {
        this.id = id;
        this.descricao = descricao;
        this.ano = ano;
        this.mes = mes;
        this.evento = evento;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Edicao other = (Edicao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Edicao [ano=" + ano + ", descricao=" + descricao + ", evento=" + evento + ", id=" + id + ", mes=" + mes
                + "]";
    }
}
