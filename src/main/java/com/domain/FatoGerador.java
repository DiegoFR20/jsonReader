package com.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FatoGerador  implements Serializable{
	private static final long serialVersionUID = 1L;

    private Integer mesReferencia;
    private Integer anoReferencia;

    public FatoGerador(Integer mesReferencia, Integer anoReferencia) {
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
    }

    public FatoGerador() {
    }

	public Integer getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Integer mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Integer getAnoReferencia() {
		return anoReferencia;
	}

	public void setAnoReferencia(Integer anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	@Override
    public String toString() {
        return "FatoGerador [anoReferencia=" + anoReferencia + ", mesReferencia=" + mesReferencia + "]";
    }
}
