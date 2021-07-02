package br.upf.ads.topicos.named;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.upf.ads.topicos.entities.Evento;
import br.upf.ads.topicos.entities.TipoEvento;
import br.upf.ads.topicos.jpa.GenericDao;
import br.upf.ads.topicos.jpa.JpaUtil;
import br.upf.ads.topicos.jsf.JsfUtil;
import br.upf.ads.topicos.jsf.TrataException;

@Named
@ViewScoped
public class TipoEventoBean implements Serializable{

	private TipoEvento selecionado; // atributo para vinculo com campos do formulário
	private List<TipoEvento> lista; // atributo para vinculo com o datatable da consulta
	private Boolean editando; // atributo para controlar o painel visível editar ou consultar
	private GenericDao<TipoEvento> dao = new GenericDao<TipoEvento>();
	
	public TipoEventoBean() {
		super();
		setEditando(false);
		carregarLista();
	}
	
	public void incluir() {
		selecionado = new TipoEvento(); // cria novo produto
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
			lista = dao.createQuery("from TipoEvento order by id");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e)); 
		}			
	}
	
	public List<TipoEvento> completeTipoEvento(String query) {
		EntityManager em = JpaUtil.getInstance().getEntityManager();
		 List<TipoEvento> results = em.createQuery(
		 "from TipoEvento where upper(descricao) like "+
		"'"+query.trim().toUpperCase()+"%' "+
		 "order by descricao").getResultList();
		 em.close();
		 return results;
		 }

	public List<TipoEvento> getLista() {
		return lista;
	}


	public void setLista(List<TipoEvento> lista) {
		this.lista = lista;
	}


	public TipoEvento getSelecionado() {
		return selecionado;
	}


	public void setSelecionado(TipoEvento selecionado) {
		this.selecionado = selecionado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	
	
	
	
	
}