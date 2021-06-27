package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: SubEvento
 *
 */
@Entity

public class SubEvento implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "SubEventoId")
	@SequenceGenerator(name = "SubEventoId",sequenceName = "SubEventoId", allocationSize = 1)	
	private Integer id;
	
	@NotBlank(message = "O titulo deve ser informado!")
	@Length(min = 1, max = 60, message = "O titulo deve ter entre {min} e {max} caracteres.")
	@Basic(optional = false)
	private String titulo;
	
	//@NotBlank(message = "A descrição deve ser informada!")
	//@Length(min = 1, max = 200, message = "A descrição deve ter entre {min} e {max} caracteres.")
	//@Column(length = 200, nullable = false)
	@Basic(optional = false)
	@Lob
	private String descricao;
	
	@NotNull(message = "A data e hora de inicio deve ser informada!")
	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Future(message = "A data de início deve ser no futuro")
	private Date dataHoraInicio;
	
	@NotNull(message = "A data e hora de termino deve ser informada!")
	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Future(message = "A data de término deve ser no futuro")
	private Date dataHoraTermino;
	
	@NotNull(message = "O total de horas deve ser informado!")
	@DecimalMin(value = "0", inclusive = false, message = "O total de horas deve ser maior que zero")
	private Float totalHoras;
	
	@NotNull(message = "O Evento deve ser informado!")
	@ManyToOne(optional = false)
    private Evento evento; 
	
	@OneToMany(mappedBy = "subEvento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModalidadeSubEvento> modalidadeSubEventos;
	
	@NotNull(message = "O tipo do evento deve ser informado!")
	@ManyToOne(optional = false)
    private TipoEvento tipoEvento;
	
	@NotNull(message = "O campo assina deve ser informado!")
	@ManyToMany//(mappedBy = "subevento")
	@Size(min = 1, message = "Deve ter pelo menos um assinante")
	private List<Assina> assina;

	
	private static final long serialVersionUID = 1L;

	public SubEvento() {
		super();
	}

	public SubEvento(Integer id) {
		super();
		this.id = id;
	}

	

	

	

	

	public SubEvento(Integer id,
			@NotBlank(message = "O titulo deve ser informado!") @Length(min = 1, max = 60, message = "O titulo deve ter entre {min} e {max} caracteres.") String titulo,
			String descricao,
			@NotNull(message = "A data e hora de inicio deve ser informada!") @Future(message = "A data de início deve ser no futuro") Date dataHoraInicio,
			@NotNull(message = "A data e hora de termino deve ser informada!") @Future(message = "A data de término deve ser no futuro") Date dataHoraTermino,
			@NotNull(message = "O total de horas deve ser informado!") @DecimalMin(value = "0", inclusive = false, message = "O total de horas deve ser maior que zero") Float totalHoras,
			@NotNull(message = "O Evento deve ser informado!") Evento evento,
			List<ModalidadeSubEvento> modalidadeSubEventos,
			@NotNull(message = "O tipo do evento deve ser informado!") TipoEvento tipoEvento,
			@NotNull(message = "O campo assina deve ser informado!") @Size(min = 1, message = "Deve ter pelo menos um assinante") List<Assina> assina) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraTermino = dataHoraTermino;
		this.totalHoras = totalHoras;
		this.evento = evento;
		this.modalidadeSubEventos = modalidadeSubEventos;
		this.tipoEvento = tipoEvento;
		this.assina = assina;
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
		SubEvento other = (SubEvento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraTermino() {
		return dataHoraTermino;
	}

	public void setDataHoraTermino(Date dataHoraTermino) {
		this.dataHoraTermino = dataHoraTermino;
	}

	public Float getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Float totalHoras) {
		this.totalHoras = totalHoras;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<ModalidadeSubEvento> getModalidadeSubEventos() {
		return modalidadeSubEventos;
	}

	public void setModalidadeSubEventos(List<ModalidadeSubEvento> modalidadeSubEventos) {
		this.modalidadeSubEventos = modalidadeSubEventos;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public List<Assina> getAssina() {
		return assina;
	}

	public void setAssina(List<Assina> assina) {
		this.assina = assina;
	}

	@Override
	public String toString() {
		return "SubEvento [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dataHoraInicio="
				+ dataHoraInicio + ", dataHoraTermino=" + dataHoraTermino + ", totalHoras=" + totalHoras + ", evento="
				+ evento + ", modalidadeSubEventos=" + modalidadeSubEventos + ", tipoEvento=" + tipoEvento + ", assina="
				+ assina + "]";
	}

	

	
   
}
