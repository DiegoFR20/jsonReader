package com.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recolhimento  implements Serializable{
	private static final long serialVersionUID = 1L;
    
	@Id
	private String id;
	
    private String regra;
    private String forma;
    private String tipo;
    private String descricao;
    private String url;

    public Recolhimento(String regra, String forma, String tipo, String descricao, String url) {
        this.regra = regra;
        this.forma = forma;
        this.tipo = tipo;
        this.descricao = descricao;
        this.url = url;
    }

    public Recolhimento() {
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		Recolhimento other = (Recolhimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recolhimento [id=" + id + ", regra=" + regra + ", forma=" + forma + ", tipo=" + tipo + ", descricao="
				+ descricao + ", url=" + url + "]";
	}
}