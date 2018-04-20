package com.accionlabs.srik;

import java.io.Serializable;

public class Movie implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	private int id;
	private String name;
	private String director;
	
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
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
}
