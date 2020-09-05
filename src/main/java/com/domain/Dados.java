package com.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dados  implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String versao;
    
    private RequisicaoStatus requisicaoStatus;

    @OneToMany(targetEntity = Agenda.class, mappedBy = "agenda")
    private List<Agenda> agenda;

    public Dados(String versao, RequisicaoStatus requisicaoStatus, List<Agenda> agenda) {
        this.versao = versao;
        this.requisicaoStatus = requisicaoStatus;
        this.agenda = agenda;
    }

    public Dados() {
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
		Dados other = (Dados) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Dados [agenda=" + agenda + ", requisicaoStatus=" + requisicaoStatus + ", versao=" + versao + "]";
    }
}
