package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Participacao
 *
 */
@Entity

public class Participacao implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ParticipacaoId")
	@SequenceGenerator(name = "ParticipacaoId",sequenceName = "ParticipacaoId", allocationSize = 1)
	private Integer id;

	//Horas participadas do evento
	@NotNull(message = "Deve ser informada a quantidade de horas de participação!")
	@DecimalMin(value = "0", inclusive = false, message = "A quantidade de horas informadas deve ser maior que 0!")
	@Column(nullable = false)
	private Float horasParticipou;
	
	
	@Basic(optional = true)
	@Lob
	private String arquivo;
	
	@NotNull(message = "A modalidade sub-evento deve ser informada!")
	@ManyToOne(optional = false)
    private ModalidadeSubEvento modalidadeSubEvento;
	
	@NotNull(message = "A pessoa deve ser informada!")
	@ManyToOne(optional = false)
    private Pessoa pessoa;
	
	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getHorasParticipou() {
		return horasParticipou;
	}

	public void setHorasParticipou(Float horasParticipou) {
		this.horasParticipou = horasParticipou;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public ModalidadeSubEvento getModalidadeSubEvento() {
		return modalidadeSubEvento;
	}

	public void setModalidadeSubEvento(ModalidadeSubEvento modalidadeSubEvento) {
		this.modalidadeSubEvento = modalidadeSubEvento;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Participacao() {
		super();
	}

	public Participacao(Integer id) {
		super();
		this.id = id;
	}

	public Participacao(Integer id,
			@NotNull(message = "Deve ser informada a quantidade de horas de participação!") @DecimalMin(value = "0", inclusive = false, message = "A quantidade de horas informadas deve ser maior que 0!") Float horasParticipou,
			String arquivo,
			@NotNull(message = "A modalidade sub-evento deve ser informada!") ModalidadeSubEvento modalidadeSubEvento,
			@NotNull(message = "A pessoa deve ser informada!") Pessoa pessoa) {
		super();
		this.id = id;
		this.horasParticipou = horasParticipou;
		this.arquivo = arquivo;
		this.modalidadeSubEvento = modalidadeSubEvento;
		this.pessoa = pessoa;
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
		Participacao other = (Participacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Participacao [id=" + id + ", horasParticipou=" + horasParticipou + ", arquivo=" + arquivo
				+ ", modalidadeSubEvento=" + modalidadeSubEvento + ", pessoa=" + pessoa + "]";
	}

	




	

}