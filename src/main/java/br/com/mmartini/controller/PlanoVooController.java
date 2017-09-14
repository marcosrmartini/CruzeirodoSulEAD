package br.com.mmartini.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.mmartini.model.Nave;
import br.com.mmartini.model.Planeta;
import br.com.mmartini.model.PlanoVoo;
import br.com.mmartini.model.Tripulante;

@ManagedBean(name="planoVooControler")
@ApplicationScoped
public class PlanoVooController {

	private List<PlanoVoo> planos = new ArrayList<PlanoVoo>();
	private PlanoVoo plano = new PlanoVoo();

	
	private String nomeTripulante;
	private String generoTripulante;

	private List<Nave> naves = new ArrayList<Nave>();
	private List<Planeta> planetas = new ArrayList<Planeta>();

	public PlanoVooController() {
		this.init();
	}

	//@PostConstruct
	public void init() {
		Nave n1 = new Nave("Nave 1", "Modelo 1", 6);
		Nave n2 = new Nave("Nave 2", "Modelo 2", 6);
		Nave n3 = new Nave("Nave 3", "Modelo 3", 6);

		this.naves.add(n1);
		this.naves.add(n2);
		this.naves.add(n3);

		Planeta p1 = new Planeta("Mercurio", 100, "arido", "deserto", new Long(
				3000));
		Planeta p2 = new Planeta("Venus", 100, "arido", "deserto", new Long(
				5000));
		Planeta p3 = new Planeta("Terra", 100, "Tropical", "temperado",
				new Long(7000000));

		this.planetas.add(p1);
		this.planetas.add(p2);
		this.planetas.add(p3);

	}

	public void incluirTripulante() {
		if (this.plano.getNave().getPassengers() < this.plano.getTripulantes()
				.size()) {
			Tripulante tripulante = new Tripulante();
			tripulante.setName(this.nomeTripulante);
			tripulante.setGender(this.generoTripulante);
			this.plano.getTripulantes().add(tripulante);
			this.nomeTripulante = null;
			this.generoTripulante = null;
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Numero de tripulantes não pode exceder a quantidade maxima da nave",
					"Numero de tripulantes não pode exceder a quantidade maxima da nave");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void incluirPlano() {
		String planetaAtual = this.plano.getPlaneta().getName();
		String planetaAnterior = this.planos.get(this.planos.size() - 1)
				.getPlaneta().getName();
		if (this.planos.size() > 0) {
			if (planetaAtual.equals(planetaAnterior)) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Planeta anterior com o mesmo destino",
						"Planeta anterior com o mesmo destino");
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

	public String getNomeTripulante() {
		return nomeTripulante;
	}

	public void setNomeTripulante(String nomeTripulante) {
		this.nomeTripulante = nomeTripulante;
	}

	public String getGeneroTripulante() {
		return generoTripulante;
	}

	public void setGeneroTripulante(String generoTripulante) {
		this.generoTripulante = generoTripulante;
	}



	
	
}
