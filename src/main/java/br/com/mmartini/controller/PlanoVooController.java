package br.com.mmartini.controller;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.mmartini.model.Nave;
import br.com.mmartini.model.Planeta;
import br.com.mmartini.model.PlanoVoo;
import br.com.mmartini.model.Tripulante;

@ManagedBean(name = "planoVooControler")
@ViewScoped
public class PlanoVooController {

	private PlanoVoo plano = new PlanoVoo();
	private Tripulante tripulante = new Tripulante();
	
	private AppService service;


	public PlanoVooController() {
		this.plano.setNave(new Nave());
		this.plano.setPlaneta(new Planeta());
		this.plano.setTripulantes(new ArrayList<Tripulante>());
		if (this.service == null) {
			this.service = new AppService();
		}
	}


	public void incluirTripulante() {
			if (this.plano.getNave().getPassengers() > this.plano
					.getTripulantes().size()) {
				this.plano.getTripulantes().add(this.tripulante);
				this.tripulante = new Tripulante();
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Numero de tripulantes não pode exceder a quantidade maxima da nave",
						null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
	}

	public void incluirPlano() {
		String planetaAtual = this.plano.getPlaneta().getName();
		String planetaAnterior = "";

				
		if (service.getPlanos().size() > 0) {
			planetaAnterior = service.getPlanos().get(service.getPlanos().size() - 1).getPlaneta().getName();
			if (planetaAtual.equals(planetaAnterior)) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Planeta anterior com o mesmo destino", null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				service.getPlanos().add(this.plano);
				this.plano = new PlanoVoo();
			}
		} else {
			service.getPlanos().add(this.plano);
			this.plano = new PlanoVoo();	
		}
	}

	public PlanoVoo getPlano() {
		return plano;
	}

	public void setPlano(PlanoVoo plano) {
		this.plano = plano;
	}

	public Tripulante getTripulante() {
		return tripulante;
	}

	public void setTripulante(Tripulante tripulante) {
		this.tripulante = tripulante;
	}

}
