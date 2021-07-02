package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "UsuarioId")
	@SequenceGenerator(name = "UsuarioId",sequenceName = "UsuarioId", allocationSize = 1)	
	private Integer id;
	
	@NotBlank(message = "O nome deve ser informado!")
	@Length(max = 60, min = 3, message = "O nome deve ter entre {min} e {max} caracteres!")
	@Column(length = 60, nullable = false)
	private String nome;
	
	@NotBlank(message = "O email deve ser informado!")
	@Email(message = "O email deve ser válido!")
	@Column( nullable = false)
	@Basic(optional = false)
	private String email;
	
	@NotBlank(message = "A senha deve ser informada!")
	@Length(max = 40, min = 6, message = "A senha deve ter entre {min} e {max} caracteres!")
	private String senha;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataInativo;
	
	private static final long serialVersionUID = 1L;
	

	public Usuario(Integer id) {
		super();
		this.id = id;
	}

	public Usuario() {
		super();
	}

	public Usuario(Integer id,
			@NotBlank(message = "O nome deve ser informado!") @Length(max = 60, min = 3, message = "O nome deve ter entre {min} e {max} caracteres!") String nome,
			@NotBlank(message = "O email deve ser informado!") @Email(message = "O email deve ser válido!") String email,
			@NotBlank(message = "A senha deve ser informada!") @Length(max = 40, min = 6, message = "A senha deve ter entre {min} e {max} caracteres!") String senha,
			Date dataInativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataInativo = dataInativo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataInativo() {
		return dataInativo;
	}

	public void setDataInativo(Date dataInativo) {
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", dataInativo="
				+ dataInativo + "]";
	}   
	
	
   
}
