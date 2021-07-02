package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Assina
 *
 */
@Entity

public class Assina implements Serializable {

	
	
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "AssinaId")
	@SequenceGenerator(name = "AssinaId",sequenceName = "AssinaId", allocationSize = 1)
	private Integer id;
	
	@NotBlank(message = "O nome deve ser informado!")
	@Length(min = 1, max = 45, message = "O nome deve ter entre {min} e {max} caracteres.")
	@Basic(optional = false)
	private String nome;
	
	@NotBlank(message = "A função deve ser informada!")
	@Length(min = 1, max = 50, message = "A função deve ter entre {min} e {max} caracteres.")
	@Basic(optional = false)
	private String funcao;
	
	@NotNull(message = "A imagem deve ser informada!")
	@Basic(optional = false)
	@Lob
	private byte[] imagem;
	
	@Temporal(TemporalType.DATE)
	private Date dataInativo;
	
	private static final long serialVersionUID = 1L;
	
	public Assina() {
		super();
	}

	public Assina(Integer id) {
		super();
		this.id = id;
	}

	

	

	

	public Assina(Integer id,
			@NotBlank(message = "O nome deve ser informado!") @Length(min = 1, max = 45, message = "O nome deve ter entre {min} e {max} caracteres.") String nome,
			@NotBlank(message = "A função deve ser informada!") @Length(min = 1, max = 50, message = "A função deve ter entre {min} e {max} caracteres.") String funcao,
			@NotBlank(message = "A imagem deve ser informada!") byte[] imagem, Date dataInativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.imagem = imagem;
		this.dataInativo = dataInativo;
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
		Assina other = (Assina) obj;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Date getDataInativo() {
		return dataInativo;
	}

	public void setDataInativo(Date dataInativo) {
		this.dataInativo = dataInativo;
	}

	@Override
	public String toString() {
		return "Assina [id=" + id + ", nome=" + nome + ", funcao=" + funcao + "]";
	}

	
   
}
