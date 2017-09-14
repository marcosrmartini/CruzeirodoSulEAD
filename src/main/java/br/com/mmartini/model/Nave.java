package br.com.mmartini.model;

public class Nave {

	private String name;
	private String model;
	private Integer passengers;
	
	public Nave(String name, String model, Integer passengers) {
		super();
		this.name = name;
		this.model = model;
		this.passengers = passengers;
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
