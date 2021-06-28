package br.upf.ads.topicos.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.upf.ads.topicos.entities.Pessoa;
import br.upf.ads.topicos.jpa.JpaUtil;

@FacesConverter(value = "pessoaConverter")
public class ConverterPessoa implements Converter{
	@Override
	public Pessoa getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				EntityManager em = JpaUtil.getEntityManager();
				Pessoa ret = em.find(Pessoa.class,Integer.parseInt(value));
				em.close();
				return ret;
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de Conversão do Pessoante", "Pessoante  inválido."));
			}
		} else
			return null;
	}
	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Pessoa) object).getId());
		} else
			return null;
	}
}