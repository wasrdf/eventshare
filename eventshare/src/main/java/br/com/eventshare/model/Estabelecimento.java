package br.com.eventshare.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.eventshare.enums.Situacao;

@Entity
@Table(name = "Estabelecimento")
public class Estabelecimento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5086631149516599426L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Endereco endereco;
	private String telefone;
	private String email;
	private Situacao situacao;;
	private Long nivel;
	@Column(name = "cpf_cnpj")
	private String cnpjCpf;
	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	@Column(name = "nome_responsavel")
	private String nomeResponsavel;
	
	
	
	
	public Estabelecimento() {
		this.endereco = new Endereco();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Estabelecimento other = (Estabelecimento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	public Long getCodigo() {
		return codigo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getEmail() {
		return email;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public Long getNivel() {
		return nivel;
	}
	public String getCnpjCpf() {
		return cnpjCpf;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}
	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	
	
	
}
