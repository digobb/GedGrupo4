package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Template
 *
 */
@Entity

public class Template implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "TemplateId")
	@SequenceGenerator(name = "TemplateId", allocationSize = 1, initialValue = 1)	
	private Integer id;
	
	@Length(min = 2, max = 100, message = "A descrição deve conter entre {min} e {max} caracteres.")
	@Column(length = 100, nullable = false)	
	private String descricao;
	
	@Column(length = 100, nullable = false)	
	private String texto;

	private static final long serialVersionUID = 1L;

	public Template() {
		super(); 
}
	

	public Template(Integer id) {
		super();
		this.id = id;
	}


	public Template(Integer id,
			@Length(min = 2, max = 100, message = "A descrição deve conter entre {min} e {max} caracteres.") String descricao,
			String texto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.texto = texto;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Template other = (Template) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Template [id=" + id + ", descricao=" + descricao + ", texto=" + texto + "]";
	}
	
}