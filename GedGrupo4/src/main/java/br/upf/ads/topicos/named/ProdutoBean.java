package br.upf.ads.topicos.named;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

import br.upf.ads.topicos.entities.Produto;
import br.upf.ads.topicos.jpa.GenericDao;
import br.upf.ads.topicos.jsf.JsfUtil;
import br.upf.ads.topicos.jsf.TrataException;

@Named
@ViewScoped
public class ProdutoBean implements Serializable{

	private Produto selecionado; // atributo para vinculo com campos do formulário
	private List<Produto> lista; // atributo para vinculo com o datatable da consulta
	private Boolean editando; // atributo para controlar o painel visível editar ou consultar
	private GenericDao<Produto> dao = new GenericDao<Produto>();
	
	public ProdutoBean() {
		super();
		setEditando(false);
		carregarLista(); 
	}
	
	
	// Controle dos arquivos anexados
	private UploadedFile file;
	
	

    
    public StreamedContent getImagem() throws Exception {
		if (selecionado != null && selecionado.getArquivoBytes() != null) {
			InputStream io = new ByteArrayInputStream(selecionado.getArquivoBytes());
			return DefaultStreamedContent.builder().contentType("image/jpeg").stream(() -> io).build();
		} else {
			return getLocalizarImg();
		} 
    }	   
       
    public StreamedContent getLocalizarImg() throws Exception {
    	 FacesContext context = FacesContext.getCurrentInstance();
    	 String caminho = context.getExternalContext().getRealPath("")+"\\resources\\images\\localizar.png";
    	 InputStream is = new BufferedInputStream(new FileInputStream(caminho));
    	 return DefaultStreamedContent.builder()
	               .contentType("image/png")
	               .stream(() -> is)
	               .build();
    }
    
    public StreamedContent getLocalizarTextoImg() {
        try {
            return DefaultStreamedContent.builder()
                    .contentType("image/png")
                    .stream(() -> {
                        try {
                            BufferedImage bufferedImg = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
                            Graphics2D g2 = bufferedImg.createGraphics();
                            g2.drawString("Localizar ao lado", 50, 100);
                            ByteArrayOutputStream os = new ByteArrayOutputStream();
                            ImageIO.write(bufferedImg, "png", os);
                            return new ByteArrayInputStream(os.toByteArray());
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    public void handleFileUpload(FileUploadEvent event) {
    	selecionado.setArquivoBytes(event.getFile().getContent());     
    	
    }


	
	public void incluir() {
		selecionado = new Produto(); // cria novo produto
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
			lista = dao.createQuery("from Produto order by id");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e)); 
		}			
	}	

	public List<Produto> getLista() {
		return lista;
	}


	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}


	public Produto getSelecionado() {
		return selecionado;
	}


	public void setSelecionado(Produto selecionado) {
		this.selecionado = selecionado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}


	
	
	
	
	
}
