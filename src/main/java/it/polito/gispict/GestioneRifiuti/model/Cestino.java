package it.polito.gispict.GestioneRifiuti.model;

import java.time.LocalDate;

public class Cestino {
	
	private String idCestino;
	//	definizione di una classe "Posizione" che comprende longitudine e latitudine
	//	oltre ai metodi per il calcolo della distanza
	private Posizione posizione;
	private Integer punteggio; // Intero 0-100 (?)
	private Boolean statoFunzionamento;
	private LocalDate dataSvuotamento;
	
	public Cestino(String idCestino, Posizione posizione, Integer punteggio) {
		super();
		this.idCestino = idCestino;
		this.posizione = posizione;
		this.punteggio = punteggio;
	}

	public String getIdCestino() {
		return idCestino;
	}

	public void setIdCestino(String idCestino) {
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
		return "Cestino [idCestino=" + idCestino + ", posizione=" + posizione + "]";
	}
	
	
	
}
