package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: ModalidadeSubEvento
 *
 */
@Entity

public class ModalidadeSubEvento implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ModalidadeSubEventoId")
	@SequenceGenerator(name = "ModalidadeSubEventoId",sequenceName = "ModalidadeSubEventoId", allocationSize = 1)
	private Integer id;
	
	@NotNull(message = "o subEvento deve ser informado")
	@ManyToOne(optional = false)
    private SubEvento subEvento; 
	
	@NotNull(message = "A modalidade deve ser informada")
	@ManyToOne(optional = false)
    private Modalidade modalidade;
	
	@NotNull(message = "o template deve ser informado")
	@ManyToOne(optional = false)
    private Template template;
	
	private static final long serialVersionUID = 1L;

	public ModalidadeSubEvento() {
		super();
	}
	
	public ModalidadeSubEvento(Integer id, SubEvento subEvento, Modalidade modalidade, Template template) {
		super();
		this.id = id;
		this.subEvento = subEvento;
		this.modalidade = modalidade;
		this.template = template;
	}
	
	
	public ModalidadeSubEvento(Integer id) {
		super();
		this.id = id;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SubEvento getSubEvento() {
		return subEvento;
	}

	public void setSubEvento(SubEvento subEvento) {
		this.subEvento = subEvento;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, modalidade, subEvento, template);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModalidadeSubEvento other = (ModalidadeSubEvento) obj;
		return Objects.equals(id, other.id) && Objects.equals(modalidade, other.modalidade)
				&& Objects.equals(subEvento, other.subEvento) && Objects.equals(template, other.template);
	}


	@Override
	public String toString() {
		return "ModalidadeSubEvento [id=" + id + ", subEvento=" + subEvento + ", modalidade=" + modalidade
				+ ", template=" + template + "]";
	}

}