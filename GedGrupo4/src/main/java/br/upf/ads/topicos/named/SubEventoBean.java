package br.upf.ads.topicos.named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;

import br.upf.ads.topicos.entities.Assina;
import br.upf.ads.topicos.entities.SubEvento;
import br.upf.ads.topicos.jpa.GenericDao;
import br.upf.ads.topicos.jsf.JsfUtil;
import br.upf.ads.topicos.jsf.TrataException;
import br.upf.ads.topicos.relatorios.RelatorioUtil;

@Named
@ViewScoped
public class SubEventoBean implements Serializable {
	
	private SubEvento selecionado; // atributo para vinculo com campos do formulário
	private List<SubEvento> lista; // atributo para vinculo com o datatable da consulta
	private Boolean editando; // atributo para controlar o painel visível editar ou consultar
	private GenericDao<SubEvento> dao = new GenericDao<SubEvento>();
	private List<Assina> assinantes;
	public SubEventoBean() throws Exception {
		super();
		setEditando(false);
		assinantes = new GenericDao<Assina>().createQuery("from Assina");
		selecionado = new SubEvento();
		carregarLista();
	}
	
	@Named
	@RequestScoped
	public class RelSubEventoBean {
		public StreamedContent gerarPDF() {
			try {
				HashMap parameters = new HashMap();
				return RelatorioUtil.gerarStreamRelatorioPDF("WEB-INF/relatorios/SubEvento/SubEvento.jasper", parameters,
						"SubEvento.pdf");
			} catch (Exception e) {
				e.printStackTrace();
				JsfUtil.addErrorMessage(e.getMessage());
				return null;
			}
		}
	}
	
	public void incluir() {
		selecionado = new SubEvento(); // cria novo produto
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
			lista = dao.createQuery("from SubEvento order by id");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e)); 
		}			
	}	

	public List<SubEvento> getLista() {
		return lista;
	}


	public void setLista(List<SubEvento> lista) {
		this.lista = lista;
	}


	public SubEvento getSelecionado() {
		return selecionado;
	}


	public void setSelecionado(SubEvento selecionado) {
		this.selecionado = selecionado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public List<Assina> getAssinantes() {
		return assinantes;
	}

	public void setAssinantes(List<Assina> assinantes) {
		this.assinantes = assinantes;
	}

}
