package br.com.mmartini.model;

import java.io.Serializable;

import br.com.mmartini.converter.SampleEntity;

public class Nave implements Serializable, SampleEntity {

	private int id;
	private String name;
	private String model;
	private Integer passengers;
	
	public Nave(){}
	
	public Nave(int id, String name, String model, Integer passengers) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.passengers = passengers;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

}
