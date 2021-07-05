package br.upf.ads.topicos.named;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.upf.ads.topicos.entities.Modalidade;
import br.upf.ads.topicos.entities.ModalidadeSubEvento;
import br.upf.ads.topicos.entities.Pessoa;
import br.upf.ads.topicos.entities.SubEvento;
import br.upf.ads.topicos.entities.Template;
import br.upf.ads.topicos.jpa.GenericDao;
import br.upf.ads.topicos.jpa.JpaUtil;
import br.upf.ads.topicos.jsf.JsfUtil;
import br.upf.ads.topicos.jsf.TrataException;

@Named
@ViewScoped
public class ModalidadeSubEventoBean implements Serializable{
	
	
	private ModalidadeSubEvento selecionado;
	private List<ModalidadeSubEvento> lista;
	private Boolean editando;
	private GenericDao<ModalidadeSubEvento> dao = new GenericDao<ModalidadeSubEvento>();
	
	public ModalidadeSubEventoBean() {
		super();
		setEditando(false);
		carregarLista();
	}
	
	public void incluir() {
		selecionado = new ModalidadeSubEvento();
		setEditando(true);
	}

	public void alterar() {
		setEditando(true);
	}
	
	public void cancelar() {
		carregarLista();
		setSelecionado(null);
		setEditando(false);
	}
	
	public void salvar() {
		try {
			setSelecionado( dao.merge(selecionado) );
			JsfUtil.addSuccessMessage("Salvo com sucesso!");
			carregarLista();
			setEditando(false);
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e));
		}
	}
	
	public List<ModalidadeSubEvento> getLista() {
		return lista;
	}

	public void setLista(List<ModalidadeSubEvento> lista) {
		this.lista = lista;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public GenericDao<ModalidadeSubEvento> getDao() {
		return dao;
	}

	public void setDao(GenericDao<ModalidadeSubEvento> dao) {
		this.dao = dao;
	}

	public ModalidadeSubEvento getSelecionado() {
		return selecionado;
	}

	public void excluir() {
		try {
			EntityManager em = JpaUtil.getInstance().getEntityManager();
			em.getTransaction().begin();
			Query qry = em.createQuery("DELETE from ModalidadeSubEvento m WHERE m.id = :id");
			qry.setParameter("id", selecionado.getId());
			qry.executeUpdate();
			em.getTransaction().commit();
			JsfUtil.addSuccessMessage("Excluído com sucesso!");
			setSelecionado(null);
			carregarLista();
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e));
		}
	}
	
	public void setSelecionado(ModalidadeSubEvento selecionado) {
		this.selecionado = selecionado;
	}

	public void carregarLista() {
		try {
			lista = dao.createQuery("from ModalidadeSubEvento order by id");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e)); 
		}			
	}
	public List<ModalidadeSubEvento> completeModalidadeSubEvento(String query) {
		EntityManager em = JpaUtil.getEntityManager();
		List<ModalidadeSubEvento> results = em.createQuery(
				"FROM ModalidadeSubEvento  ORDER BY id")
				.getResultList();
		em.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<SubEvento> carregarSubEventos(String query) {
		EntityManager em = JpaUtil.getInstance().getEntityManager();
		List<SubEvento> results = em.createQuery(" from SubEvento where upper(titulo) like " + "'" + query.trim().toUpperCase() + "%'" + " order by id").getResultList();
		em.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<Modalidade> carregarModalidades(String query) {
		EntityManager em = JpaUtil.getInstance().getEntityManager();
		List<Modalidade> results = em.createQuery(" from Modalidade where upper(descricao) like " + "'" + query.trim().toUpperCase() + "%'" + " order by id").getResultList();
		em.close();
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Template> carregarTemplates(String query) {
		EntityManager em = JpaUtil.getInstance().getEntityManager();
		List<Template> results = em.createQuery(" from Template where upper(descricao) like " + "'" + query.trim().toUpperCase() + "%'" + " order by id").getResultList();
		em.close();
		return results;
	}
	
}