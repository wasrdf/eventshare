package br.com.eventshare.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Evento")
public class Evento implements Serializable {
	
	
	private static final long serialVersionUID = -8021581422613646867L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@Column(name = "data_evento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEvento;
	
	private String descricao;
	
	@Column(name = "data_termino_lista_amiga")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTerminoListaAmiga;
	
	private byte[] img;

	public Long getCodigo() {
		return codigo;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getDataTerminoListaAmiga() {
		return dataTerminoListaAmiga;
	}

	public byte[] getImg() {
		return img;
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
		Evento other = (Evento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataTerminoListaAmiga(Date dataTerminoListaAmiga) {
		this.dataTerminoListaAmiga = dataTerminoListaAmiga;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
	
	
	
}
