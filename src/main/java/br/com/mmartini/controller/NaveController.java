package br.com.mmartini.controller;

import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mmartini.model.Nave;

@ManagedBean
@ViewScoped
public class NaveController {

	private Nave nave;
	private AppService service;
	
	public NaveController(){
		if (this.service == null) {
			this.service = new AppService();
		}
		this.nave = new Nave();
	}
	
	public void incluir(){
		nave.setId(new Random().nextInt());
		this.service.getNaves().add(nave);
		this.nave = new Nave();
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}
	
	
	
	
}
