package com.domain;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;

public class RequisicaoStatus  implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private String id;
    
    private int codigo;
    private String mensagem;
    private String data;
    private int quantidade;
    private String hashTotal;

    public RequisicaoStatus(String id, int codigo, String mensagem, String data, int quantidade, String hashTotal) {
        this.id = id;
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.data = data;
        this.quantidade = quantidade;
        this.hashTotal = hashTotal;
    }

    public RequisicaoStatus() {
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getHashTotal() {
		return hashTotal;
	}

	public void setHashTotal(String hashTotal) {
		this.hashTotal = hashTotal;
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
		RequisicaoStatus other = (RequisicaoStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "RequisicaoStatus [codigo=" + codigo + ", data=" + data + ", hashTotal=" + hashTotal + ", id=" + id
                + ", mensagem=" + mensagem + ", quantidade=" + quantidade + "]";
    }
}
