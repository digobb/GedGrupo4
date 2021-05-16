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
	
}