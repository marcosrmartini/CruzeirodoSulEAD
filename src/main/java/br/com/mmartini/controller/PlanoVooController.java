package br.com.mmartini.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.mmartini.model.Nave;
import br.com.mmartini.model.Planeta;
import br.com.mmartini.model.PlanoVoo;
import br.com.mmartini.model.Tripulante;

@ManagedBean(name = "planoVooControler")
@ApplicationScoped
public class PlanoVooController {

	private List<PlanoVoo> planos = new ArrayList<PlanoVoo>();
	private PlanoVoo plano = new PlanoVoo();

	private Tripulante tripulante = new Tripulante();

	private List<Nave> naves = new ArrayList<Nave>();
	private List<Planeta> planetas = new ArrayList<Planeta>();

	public PlanoVooController() {
		// this.init();
	}

	@PostConstruct
	public void init() {
		this.plano.setNave(new Nave());
		this.plano.setPlaneta(new Planeta());
		this.plano.setTripulantes(new ArrayList<Tripulante>());
		
		Nave n1 = new Nave(1,"Nave 1", "Modelo 1", 6);
		Nave n2 = new Nave(2,"Nave 2", "Modelo 2", 6);
		Nave n3 = new Nave(3,"Nave 3", "Modelo 3", 6);

		this.naves.add(n1);
		this.naves.add(n2);
		this.naves.add(n3);

		Planeta p1 = new Planeta(1,"Mercurio", 100, "arido", "deserto", new Long(
				3000));
		Planeta p2 = new Planeta(2,"Venus", 100, "arido", "deserto", new Long(
				5000));
		Planeta p3 = new Planeta(3,"Terra", 100, "Tropical", "temperado",
				new Long(7000000));

		this.planetas.add(p1);
		this.planetas.add(p2);
		this.planetas.add(p3);

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
		if (this.planos.size() > 0){ 
			planetaAnterior = this.planos.get(this.planos.size() - 1).getPlaneta().getName();
		} 
				
		if (this.planos.size() > 0) {
			if (planetaAtual.equals(planetaAnterior)) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Planeta anterior com o mesmo destino", null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				this.planos.add(this.plano);
				this.plano = new PlanoVoo();
			}
		}
	}

	public List<PlanoVoo> getPlanos() {
		return planos;
	}

	public void setPlanos(List<PlanoVoo> planos) {
		this.planos = planos;
	}

	public PlanoVoo getPlano() {
		return plano;
	}

	public void setPlano(PlanoVoo plano) {
		this.plano = plano;
	}

	public List<Nave> getNaves() {
		return naves;
	}

	public void setNaves(List<Nave> naves) {
		this.naves = naves;
	}

	public List<Planeta> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<Planeta> planetas) {
		this.planetas = planetas;
	}

	public Tripulante getTripulante() {
		return tripulante;
	}

	public void setTripulante(Tripulante tripulante) {
		this.tripulante = tripulante;
	}

}
