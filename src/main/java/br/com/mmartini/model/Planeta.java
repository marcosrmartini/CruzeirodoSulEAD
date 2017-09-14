package br.com.mmartini.model;

public class Planeta {

	private String name;
	private Integer diameter;
	private String climate;
	private String terrain;
	private Long population;

	public Planeta(String name, Integer diameter, String climate,
			String terrain, Long population) {
		super();
		this.name = name;
		this.diameter = diameter;
		this.climate = climate;
		this.terrain = terrain;
		this.population = population;
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
