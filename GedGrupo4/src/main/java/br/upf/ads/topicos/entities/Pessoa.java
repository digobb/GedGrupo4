package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.upf.ads.topicos.constraints.StringOptionsValid;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity

public class Pessoa implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "PessoaId")
	@SequenceGenerator(name = "PessoaId",sequenceName = "PessoaId", allocationSize = 1)	
	private Integer id;
	
	@NotBlank(message = "O nome deve ser informado!")
	@Length(min = 2, max = 60, message = "O nome deve ter entre {min} e {max} caracteres.")
	@Basic(optional=false)
	private String nome;
	
	@NotBlank(message = "O Email  deve ser informado!")
	@Column(nullable = true,unique = true)
	@Basic(optional=false)
	@Email(message = "Email inválido")
	private String email;
	
	@NotBlank(message = "A senha  deve ser informada!")
	@Length(min = 6, max = 50, message = "A senha deve ter entre {min} e {max} caracteres.")	
	private String senha;
	
	@NotBlank(message = "O Documento  deve ser informado!")
	@Length(min = 2, max = 80, message = "O Documento deve ter entre {min} e {max} caracteres.")
	@Basic(optional = false)	
	@Column(nullable = false,unique = true)
	private String documento;
	
	@NotBlank(message = "O Tipo do Documento  deve ser informado!")
	@Length(min = 2, max = 60, message = "O tipo do  Documento deve ter entre {min} e {max} caracteres.")
	@Basic(optional = false)
	@StringOptionsValid(opcoes = {"RG", "CPF", "Outro"}, message = "Tipo de documento inválido.")
	private String tipoDocumento;
	
	@NotBlank(message = "A Nacionalidade  deve ser informada!")
	@Length(min = 2, max = 60, message = "A Nacionalidade deve ter entre {min} e {max} caracteres.")
	@Basic(optional = false)
	@StringOptionsValid(opcoes = {"Brasileira", "Outra"}, message = "Nacionalidade inválida.")
	private String nacionalidade;
	
	@Length(max = 15, message = "O Telefone deve ter no máximo {max} dígitos.")
	@Basic(optional=false)
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
