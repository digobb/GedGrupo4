package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity

public class Pessoa implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "PessoaId")
	@SequenceGenerator(name = "PessoaId", allocationSize = 1, initialValue = 1)	
	private Integer id;
	@NotBlank(message = "O nome deve ser informado!")
	@Length(min = 2, max = 60, message = "O nome deve ter entre {min} e {max} caracteres.")
	@Column(length = 60, nullable = false)	
	private String nome;
	@Column(length = 60, nullable = false)	
	private String email;
	@Column(length = 60, nullable = false)	
	private String senha;
	@Column(length = 60, nullable = false)	
	private String documento;
	@Column(length = 60, nullable = false)	
	private String tipoDocumento;
	@Column(length = 60, nullable = false)	
	private String nacionalidade;
	@Column(length = 20)
	private String telefone;
	

	private static final long serialVersionUID = 1L;

	public Pessoa() {
		super();
	}   
	
	
	
	public Pessoa(Integer id) {
		super();
		this.id = id;
	}



	public Pessoa(Integer id,
			@NotBlank(message = "O nome deve ser informado!") @Length(min = 2, max = 60, message = "O nome deve ter entre {min} e {max} caracteres.") String nome,
			String email, String senha, String documento, String tipoDocumento, String nacionalidade, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", documento="
				+ documento + ", tipoDocumento=" + tipoDocumento + ", nacionalidade=" + nacionalidade + ", telefone="
				+ telefone + "]";
	}
   
}
