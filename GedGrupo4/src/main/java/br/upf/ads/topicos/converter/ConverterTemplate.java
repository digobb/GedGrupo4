package br.upf.ads.topicos.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.upf.ads.topicos.entities.Template;
import br.upf.ads.topicos.jpa.JpaUtil;

@FacesConverter(value = "templateConverter")
public class ConverterTemplate implements Converter {
	@Override
	public Template getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				EntityManager em = JpaUtil.getInstance().getEntityManager();
				Template ret = em.find(Template.class, Integer.parseInt(value));
				em.close();
				return ret;
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de Conversão do Modalidadente", "Modalidadente  inválido."));
			}
		} else
			return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Template) object).getId());
		} else
			return null;
	}
}