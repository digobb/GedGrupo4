package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Participacao
 *
 */
@Entity

public class Participacao implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ParticipacaoId")
	@SequenceGenerator(name = "ParticipacaoId", allocationSize = 1, initialValue = 1)
	private Integer id;

	//Horas participadas do evento
	@Column(nullable = false)
	private Float horasParticipou;
	
	//Upload do arquivo
	@Column(nullable = true)
	private String arquivo;
	@ManyToOne(optional = false)
    private ModalidadeSubEvento modalidadeSubEvento;
	@ManyToOne(optional = false)
    private Pessoa pessoa;
	
	private static final long serialVersionUID = 1L;

	public Participacao() {
		super();
	}
	

	public Participacao(Integer id) {
		super();
		this.id = id;
	}


	public Participacao(Integer id, Float horasParticipou, String arquivo, ModalidadeSubEvento modalidadeSubEvento,
			Pessoa pessoa) {
		super();
		this.id = id;
		this.horasParticipou = horasParticipou;
		this.arquivo = arquivo;
		this.modalidadeSubEvento = modalidadeSubEvento;
		this.pessoa = pessoa;
	}


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

	public static long getSerialversionuid() {
		return serialVersionUID;
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