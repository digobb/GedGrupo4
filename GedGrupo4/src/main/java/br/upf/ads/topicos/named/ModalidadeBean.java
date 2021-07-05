package br.upf.ads.topicos.named;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.upf.ads.topicos.entities.Modalidade;
import br.upf.ads.topicos.entities.Pessoa;
import br.upf.ads.topicos.entities.Template;
import br.upf.ads.topicos.jpa.GenericDao;
import br.upf.ads.topicos.jpa.JpaUtil;
import br.upf.ads.topicos.jsf.JsfUtil;
import br.upf.ads.topicos.jsf.TrataException;

@Named
@ViewScoped
public class ModalidadeBean implements Serializable{

	private Modalidade selecionado; // atributo para vinculo com campos do formulário
	private List<Modalidade> lista; // atributo para vinculo com o datatable da consulta
	private Boolean editando; // atributo para controlar o painel visível editar ou consultar
	private GenericDao<Modalidade> dao = new GenericDao<Modalidade>();
	
	public ModalidadeBean() {
		super();
		setEditando(false);
		carregarLista();
	}
	
	public void incluir() {
		selecionado = new Modalidade(); // cria novo produto
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
			lista = dao.createQuery("from Modalidade order by id");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e)); 
		}			
	}
	
	public List<Modalidade> completeModalidade(String query) {
		EntityManager em = JpaUtil.getEntityManager();
		List<Modalidade> results = em.createQuery(
				"FROM Modalidade WHERE upper(descricao) like " + "'" + query.trim().toUpperCase() + "%' " + "ORDER BY descricao")
				.getResultList();
		em.close();
		return results;
	}

	public List<Modalidade> getLista() {
		return lista;
	}


	public void setLista(List<Modalidade> lista) {
		this.lista = lista;
	}


	public Modalidade getSelecionado() {
		return selecionado;
	}


	public void setSelecionado(Modalidade selecionado) {
		this.selecionado = selecionado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	
	
	
	
	
}
