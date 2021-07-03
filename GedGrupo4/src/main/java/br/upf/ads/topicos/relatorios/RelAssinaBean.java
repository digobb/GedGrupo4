package br.upf.ads.topicos.relatorios;

import java.io.Serializable;
import java.util.HashMap;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;

import br.upf.ads.topicos.jsf.JsfUtil;

@Named
@ViewScoped
public class RelAssinaBean implements Serializable{
	
	
	public RelAssinaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StreamedContent gerarPDF() {
		try {
			HashMap parameters = new HashMap();
			return RelatorioUtil.gerarStreamRelatorioPDF("WEB-INF/relatorios/Assina/Assina.jasper", parameters,
					"Assina.pdf");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(e.getMessage());
			return null;
		}
	}
}
