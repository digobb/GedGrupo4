package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Modalidade
 *
 */
@Entity

public class Modalidade implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ModalidadeId")
	@SequenceGenerator(name = "ModalidadeId", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Length(min = 2, max = 100, message = "A descrição deve conter entre {min} e {max} caracteres.")
	@Column(length = 100, nullable = false)
	private String descricao;

	private static final long serialVersionUID = 1L;

	public Modalidade() {
		super();
	}

}