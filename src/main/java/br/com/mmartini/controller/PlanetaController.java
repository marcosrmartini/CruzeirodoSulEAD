package br.com.mmartini.controller;

import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mmartini.model.Planeta;


@ManagedBean
@ViewScoped
public class PlanetaController {

	private Planeta planeta;
	private AppService service;
	
	public PlanetaController(){
		if (this.service == null){
			this.service = new AppService();
		}
		this.planeta = new Planeta();
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}
	
	public void incluir(){
		planeta.setId(new Random().nextInt());
		this.service.getPlanetas().add(planeta);
		this.planeta = new Planeta();
	}
	
}
