package it.polito.gispict.GestioneRifiuti.model;

import java.time.LocalDate;
import java.util.Objects;

public class Cestino {
	
	private Integer idCestino;
	//	definizione di una classe "Posizione" che comprende longitudine e latitudine
	//	oltre ai metodi per il calcolo della distanza
	private Posizione posizione;
	private Integer punteggio; // Intero 0-100 (?)
	private Boolean statoFunzionamento;
	private LocalDate dataSvuotamento;
	
	public Cestino(Integer idCestino, Posizione posizione, Integer punteggio) {
		super();
		this.idCestino = idCestino;
		this.posizione = posizione;
		this.punteggio = punteggio;
		this.statoFunzionamento = true;
	}

	public Integer getIdCestino() {
		return idCestino;
	}

	public void setIdCestino(Integer idCestino) {
		this.idCestino = idCestino;
	}

	public Posizione getPosizione() {
		return posizione;
	}

	public void setPosizione(Posizione posizione) {
		this.posizione = posizione;
	}

	public Integer getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Integer punteggio) {
		this.punteggio = punteggio;
	}

	public Boolean getStatoFunzionamento() {
		return statoFunzionamento;
	}

	public void setStatoFunzionamento(Boolean statoFunzionamento) {
		this.statoFunzionamento = statoFunzionamento;
	}

	public LocalDate getDataSvuotamento() {
		return dataSvuotamento;
	}

	public void setDataSvuotamento(LocalDate dataSvuotamento) {
		this.dataSvuotamento = dataSvuotamento;
	}

	@Override
	public String toString() {
		return "Cestino " + idCestino + " [(" + posizione.getLatitudine() + ";" + posizione.getLongitudine() + 
					") ; pieno al " + punteggio + "%]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCestino);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cestino other = (Cestino) obj;
		return Objects.equals(idCestino, other.idCestino);
	}
	
	
	
	
	
}