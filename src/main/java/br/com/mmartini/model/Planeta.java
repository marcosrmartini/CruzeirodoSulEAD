package br.com.mmartini.model;

import java.io.Serializable;

import br.com.mmartini.converter.SampleEntity;

public class Planeta implements Serializable, SampleEntity {

	private int id;
	private String name;
	private Integer diameter;
	private String climate;
	private String terrain;
	private Long population;
	
	public Planeta(){}

	public Planeta(int id, String name, Integer diameter, String climate,
			String terrain, Long population) {
		super();
		this.id = id;
		this.name = name;
		this.diameter = diameter;
		this.climate = climate;
		this.terrain = terrain;
		this.population = population;
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

	public Integer getDiameter() {
		return diameter;
	}

	public void setDiameter(Integer diameter) {
		this.diameter = diameter;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

}
