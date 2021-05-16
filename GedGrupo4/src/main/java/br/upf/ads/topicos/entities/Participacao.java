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

	private static final long serialVersionUID = 1L;

	public Participacao() {
		super();
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
	

}