package br.com.mmartini.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.mmartini.model.Nave;
import br.com.mmartini.model.Planeta;
import br.com.mmartini.model.PlanoVoo;

@ManagedBean(name = "appService")
@ApplicationScoped
public class AppService {

	private List<PlanoVoo> planos = new ArrayList<PlanoVoo>();
	private static List<Nave> naves = new ArrayList<Nave>();
	private static List<Planeta> planetas = new ArrayList<Planeta>();

	static {
		Nave n1 = new Nave(1, "Nave 1", "Modelo 1", 6);
		Nave n2 = new Nave(2, "Nave 2", "Modelo 2", 6);
		Nave n3 = new Nave(3, "Nave 3", "Modelo 3", 6);

		naves.add(n1);
		naves.add(n2);
		naves.add(n3);

		Planeta p1 = new Planeta(1, "Mercurio", 100, "arido", "deserto",
				new Long(3000));
		Planeta p2 = new Planeta(2, "Venus", 100, "arido", "deserto", new Long(
				5000));
		Planeta p3 = new Planeta(3, "Terra", 100, "Tropical", "temperado",
				new Long(7000000));

		planetas.add(p1);
		planetas.add(p2);
		planetas.add(p3);

	}

	public List<PlanoVoo> getPlanos() {
		return planos;
	}

	public void setPlanos(List<PlanoVoo> planos) {
		this.planos = planos;
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

}
