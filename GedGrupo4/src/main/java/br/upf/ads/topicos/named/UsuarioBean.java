package br.upf.ads.topicos.named;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.upf.ads.topicos.entities.Usuario;
import br.upf.ads.topicos.jpa.GenericDao;
import br.upf.ads.topicos.jsf.JsfUtil;
import br.upf.ads.topicos.jsf.TrataException;
import br.upf.ads.topicos.jpa.JpaUtil;

@Named
@ViewScoped
public class UsuarioBean implements Serializable{

	private Usuario selecionado; // atributo para vinculo com campos do formulário
	private List<Usuario> lista; // atributo para vinculo com o datatable da consulta
	private Boolean editando; // atributo para controlar o painel visível editar ou consultar
	private GenericDao<Usuario> dao = new GenericDao<Usuario>();
	
	public UsuarioBean() {
		super();
		setEditando(false);
		carregarLista();
	}
	
	public void incluir() {
		selecionado = new Usuario(); // cria novo produto
		setEditando(true);
	}

	public void alterar() {
		setEditando(true);
	}
	
	public void cancelar() {
		carregarLista();
		setSelecionado(null); // para desabilitar os botões alterar e excluir
		setEditando(false);
	}
	
	public void salvar() {
		try {
			setSelecionado( dao.merge(selecionado) );
			JsfUtil.addSuccessMessage("Salvo com sucesso!");
			carregarLista(); // carregar produtos do BD quando salva algo
			setEditando(false);
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e));
		}
	}
	
	public void excluir() {
		try {
			dao.remove(selecionado);
			JsfUtil.addSuccessMessage("Excluído com sucesso!");
			setSelecionado(null); // para desabilitar os botões alterar e excluir
			carregarLista(); // carregar produtos do BD quando salva algo
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e));
		}
	}
	
	
	
	public void carregarLista() {
		try {
			lista = dao.createQuery("from Usuario order by id");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e)); 
		}			
	}
	public List<Usuario> completeUsuario(String query) {
		EntityManager em = JpaUtil.getEntityManager();
		List<Usuario> results = em.createQuery(
				"FROM Usuario WHERE upper(nome) like " + "'" + query.trim().toUpperCase() + "%' " + "ORDER BY nome")
				.getResultList();
		em.close();
		return results;
	}

	public List<Usuario> getLista() {
		return lista;
	}


	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}


	public Usuario getSelecionado() {
		return selecionado;
	}


	public void setSelecionado(Usuario selecionado) {
		this.selecionado = selecionado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	
	
	
	
	
}
