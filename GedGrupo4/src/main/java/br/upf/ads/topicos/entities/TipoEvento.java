package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
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
	@SequenceGenerator(name = "TipoEventoId", allocationSize = 1, initialValue = 1)	
	private Integer id;
	@NotBlank(message = "A descrição deve ser informada")
	@Length(min = 2, max = 60, message = "O nome deve ter entre {min} e {max} caracteres.")
	@Column(length = 60, unique = true)
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
   
}
