package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Evento
 *
 */
@Entity

public class Evento implements Serializable {

	
	
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "EventoId")
	@SequenceGenerator(name = "EventoId", allocationSize = 1, initialValue = 1)	
	private Integer id;
	@NotBlank(message = "O titulo deve ser informado!")
	@Length(min = 1, max = 60, message = "O titulo deve ter entre {min} e {max} caracteres.")
	@Column(length = 60, nullable = false)
	private String titulo;
	@NotBlank(message = "A descrição deve ser informada!")
	@Length(min = 1, max = 200, message = "A descrição deve ter entre {min} e {max} caracteres.")
	@Column(length = 200, nullable = false)
	private String descricao;
	@NotBlank(message = "A data de inicio deve ser informada!")
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@NotBlank(message = "A data de termino deve ser informada!")
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	@Column(nullable = false)
	private Float totalHoras;
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubEvento> subEventos;
	
	private static final long serialVersionUID = 1L;

	public Evento() {
		super();
	}

	public Evento(Integer id) {
		super();
		this.id = id;
	}

	

	public Evento(Integer id,
			@NotBlank(message = "O titulo deve ser informado!") @Length(min = 1, max = 60, message = "O titulo deve ter entre {min} e {max} caracteres.") String titulo,
			@NotBlank(message = "A descrição deve ser informada!") @Length(min = 1, max = 200, message = "A descrição deve ter entre {min} e {max} caracteres.") String descricao,
			@NotBlank(message = "A data de inicio deve ser informada!") Date dataInicio,
			@NotBlank(message = "A data de termino deve ser informada!") Date dataTermino, Float totalHoras,
			List<SubEvento> subEventos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.totalHoras = totalHoras;
		this.subEventos = subEventos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Float getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Float totalHoras) {
		this.totalHoras = totalHoras;
	}

	public List<SubEvento> getSubEventos() {
		return subEventos;
	}

	public void setSubEventos(List<SubEvento> subEventos) {
		this.subEventos = subEventos;
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dataInicio=" + dataInicio
				+ ", dataTermino=" + dataTermino + ", totalHoras=" + totalHoras + ", subEventos=" + subEventos + "]";
	}
	
   
}
