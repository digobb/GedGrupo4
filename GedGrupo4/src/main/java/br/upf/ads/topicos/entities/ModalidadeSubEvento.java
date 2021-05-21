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
	private static final long serialVersionUID = 1L;

	public ModalidadeSubEvento() {
		super();
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

}