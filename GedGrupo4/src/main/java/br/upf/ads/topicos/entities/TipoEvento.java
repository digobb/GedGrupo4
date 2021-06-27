package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: TipoEvento
 *
 */
@Entity
public class TipoEvento implements Serializable {
	
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "TipoEventoId")
	@SequenceGenerator(name = "TipoEventoId",sequenceName = "TipoEventoId", allocationSize = 1)	
	private Integer id;
	@NotBlank(message = "A descrição deve ser informada")
	@Length(min = 2, max = 60, message = "O nome deve ter entre {min} e {max} caracteres.")
	@Basic(optional=false)
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public TipoEvento(Integer id,
			@NotBlank(message = "A descrição deve ser informada") @Length(min = 2, max = 60, message = "O nome deve ter entre {min} e {max} caracteres.") String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}


	public TipoEvento(Integer id) {
		super();
		this.id = id;
	}


	public TipoEvento() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		TipoEvento other = (TipoEvento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TipoEvento [id=" + id + ", descricao=" + descricao + "]";
	}
   
}
