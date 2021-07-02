package br.upf.ads.topicos.named;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

import br.upf.ads.topicos.entities.Assina;
import br.upf.ads.topicos.jpa.GenericDao;
import br.upf.ads.topicos.jpa.JpaUtil;
import br.upf.ads.topicos.jsf.JsfUtil;
import br.upf.ads.topicos.jsf.TrataException;


@Named
@ViewScoped
public class AssinaBean implements Serializable{
	
	private Assina selecionado; // atributo para vinculo com campos do formulário
	private List<Assina> lista; // atributo para vinculo com o datatable da consulta
	private Boolean editando; // atributo para controlar o painel visível editar ou consultar
	private GenericDao<Assina> dao = new GenericDao<Assina>();
	private UploadedFile file;
	
	public AssinaBean() {
		super();
		setEditando(false);
		carregarLista();
	}
	
	public void incluir() {
		selecionado = new Assina(); // cria novo produto
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
			if (file != null) {
				selecionado.setImagem(file.getContent());
			}
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
			lista = dao.createQuery("from Assina order by id");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e)); 
		}			
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		selecionado.setImagem(event.getFile().getContent());
	}

	public StreamedContent getArquivo() throws IOException {
		if (selecionado != null && selecionado.getImagem() != null) {
			InputStream io = new ByteArrayInputStream(selecionado.getImagem());
			return DefaultStreamedContent.builder().contentType("image/jpeg").stream(() -> io).build();
		} else {
			return null;
		}
	}
	
	public void downloadAssinatura(Integer item) throws IOException {
		byte[] b = selecionado.getImagem();
		HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();
		// res.setContentType(selected.getArquivotipo());
		res.setHeader("Content-disposition", "atachment;filename=" + selecionado.getNome()); 
		res.getOutputStream().write(b);
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public UploadedFile getFile() {
		return file;
	}
	
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<Assina> getLista() {
		return lista;
	}


	public void setLista(List<Assina> lista) {
		this.lista = lista;
	}


	public Assina getSelecionado() {
		return selecionado;
	}


	public void setSelecionado(Assina selecionado) {
		this.selecionado = selecionado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}
	
	

}
