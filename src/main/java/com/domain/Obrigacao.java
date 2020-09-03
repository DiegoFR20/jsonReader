package com.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

public class Obrigacao  implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name="@id")
    private String id;
    private String sigla;
    private String nome;
    private String genero;
    private String area;
    private String tipo;
    private String periodicidade;
    private String descricao;

    @OneToMany(targetEntity = Recolhimento.class, mappedBy = "recolhimento")
    private List<Recolhimento> recolhimento;

    public Obrigacao() {
    }

    public Obrigacao(String id, String sigla, String nome, String genero, String area, String tipo,
            String periodicidade, String descricao, List<Recolhimento> recolhimento) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.genero = genero;
        this.area = area;
        this.tipo = tipo;
        this.periodicidade = periodicidade;
        this.descricao = descricao;
        this.recolhimento = recolhimento;
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Recolhimento> getRecolhimento() {
		return recolhimento;
	}

	public void setRecolhimento(List<Recolhimento> recolhimento) {
		this.recolhimento = recolhimento;
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
		Obrigacao other = (Obrigacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Obrigacao [area=" + area + ", descricao=" + descricao + ", genero=" + genero + ", id=" + id + ", nome="
                + nome + ", periodicidade=" + periodicidade + ", recolhimento=" + recolhimento + ", sigla=" + sigla
                + ", tipo=" + tipo + "]";
    }
}
