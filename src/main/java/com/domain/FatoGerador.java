package com.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class FatoGerador  implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    private int mesReferencia;
    private int anoReferencia;

    public FatoGerador(int mesReferencia, int anoReferencia) {
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
    }

    public FatoGerador() {
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(int mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public int getAnoReferencia() {
		return anoReferencia;
	}

	public void setAnoReferencia(int anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoReferencia;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + mesReferencia;
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
		FatoGerador other = (FatoGerador) obj;
		if (anoReferencia != other.anoReferencia)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mesReferencia != other.mesReferencia)
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "FatoGerador [anoReferencia=" + anoReferencia + ", mesReferencia=" + mesReferencia + "]";
    }
}
