package br.com.mmartini.converter;

import java.io.Serializable;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("planetaConverter")
public class PlanetaConverter implements Converter, Serializable {

	private static final long serialVersionUID = -2947463068045924451L;

	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		if (value != null) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {

		if (value != null && !"".equals(value)) {

			SampleEntity entity = (SampleEntity) value;

			// adiciona item como atributo do componente
			this.addAttribute(component, entity);

			int codigo = entity.getId();

			return String.valueOf(codigo);

		}

		return (String) value;
	}

	protected void addAttribute(UIComponent component, SampleEntity o) {
		if (o != null) {
			String key = String.valueOf(o.getId());
			this.getAttributesFrom(component).put(key, o);
		}
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}