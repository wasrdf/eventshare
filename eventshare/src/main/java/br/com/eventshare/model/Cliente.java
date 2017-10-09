package br.com.eventshare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	
	@Column(name = "nome_cliente")
	private String nomeCliente;
	
	private String telefone;
	
	private String email;
	
	@Column(name = "aceita_sms")
	private Boolean aceitaSMS;
	
	@Column(name = "aceita_email")
	private Boolean aceitaEmail;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAceitaSMS() {
		return aceitaSMS;
	}

	public void setAceitaSMS(Boolean aceitaSMS) {
		this.aceitaSMS = aceitaSMS;
	}

	public Boolean getAceitaEmail() {
		return aceitaEmail;
	}

	public void setAceitaEmail(Boolean aceitaEmail) {
		this.aceitaEmail = aceitaEmail;
	}
	
	
}
