package it.polito.gispict.GestioneRifiuti.model;

import java.util.Objects;

public class Posizione {
	
	private Integer latitudine;
	private Integer longitudine;
	
	public Posizione(Integer latitudine, Integer longitudine) {
		super();
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}

	public Integer getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(Integer latitudine) {
		this.latitudine = latitudine;
	}

	public Integer getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(Integer longitudine) {
		this.longitudine = longitudine;
	}

	@Override
	public String toString() {
		return "Posizione [latitudine=" + latitudine + ", longitudine=" + longitudine + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitudine, longitudine);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posizione other = (Posizione) obj;
		return Objects.equals(latitudine, other.latitudine) && Objects.equals(longitudine, other.longitudine);
	}
	
	
	

}