package com.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

public class Dados  implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    private String versao;

    @OneToMany(targetEntity = RequisicaoStatus.class, mappedBy = "requisicaoStatus")
    private List<RequisicaoStatus> requisicaoStatus;

    @OneToMany(targetEntity = Agenda.class, mappedBy = "agenda")
    private List<Agenda> agenda;

    public Dados(String versao, List<RequisicaoStatus> requisicaoStatus, List<Agenda> agenda) {
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

	public List<RequisicaoStatus> getRequisicaoStatus() {
		return requisicaoStatus;
	}

	public void setRequisicaoStatus(List<RequisicaoStatus> requisicaoStatus) {
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
