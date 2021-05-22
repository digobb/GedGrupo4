package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: ModalidadeSubEvento
 *
 */
@Entity

public class ModalidadeSubEvento implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ModalidadeSubEventoId")
	@SequenceGenerator(name = "ModalidadeSubEventoId", allocationSize = 1, initialValue = 1)
	private Integer id;
	@ManyToOne(optional = false)
    private SubEvento subEvento; 
	@ManyToOne(optional = false)
    private Modalidade modalidade;
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
		ModalidadeSubEvento other = (ModalidadeSubEvento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ModalidadeSubEvento [id=" + id + ", subEvento=" + subEvento + ", modalidade=" + modalidade
				+ ", template=" + template + "]";
	}

}