package br.com.mmartini.model;

import java.util.ArrayList;
import java.util.List;

public class PlanoVoo {

	private Nave nave;
	private Planeta planeta;
	private List<Tripulante> tripulantes = new ArrayList<Tripulante>();

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public List<Tripulante> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

}
