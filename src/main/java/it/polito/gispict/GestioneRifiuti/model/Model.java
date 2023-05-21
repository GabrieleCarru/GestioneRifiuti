package it.polito.gispict.GestioneRifiuti.model;

import java.util.List;

import org.checkerframework.checker.units.qual.min;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import java.util.ArrayList;

public class Model {

	private List<Cestino> listaCestini;
	private Graph<Cestino, DefaultWeightedEdge> grafo;
	private List<Cestino> cestiniNavigati;
	private List<Cestino> cestiniNavigatiPieni;
	private List<Cestino> cestiniPieni;
	private Integer punteggioMassimo;
	
	/**
	 * Genera una lista di elementi "Cestino" a partire da un valore intero fornito dall'utente. 
	 * Alla creazione del Cestino, genera randomicamente i valori di latitudine e longitudine 
	 * (valore massimo stabilito all'interno del metodo, da trasferire come variabile locale per 
	 * agevolare modifiche future). Inoltre, assegna casualmente un valore da 0 a 100 all'attributo "punteggio", 
	 * così da determinare in maniera casuale lo stato di riempimento del Cestino.
	 * @param numCestini : valore fornito dall'utente (nel nostro caso, interfaccia JavaFX)
	 * @return List<Cestino> : lista di numCestini generati con attribuiti randomici
	 */
	public List<Cestino> generaCestini(int numCestini) {
		
		listaCestini = new ArrayList<>();
		
		int i = 0;
		for(i=0; i<numCestini; i++) {
			
			int lat = (int)(Math.random()*100);
			int lon = (int)(Math.random()*100);
			
			// definizione delle variabili generate randomicamente
			Posizione p = new Posizione (lat,lon);
			Integer punt = (int)(Math.random()*100); 
			
			Cestino c = new Cestino(i+1, p, punt);
			listaCestini.add(c);
			
		}
		
		return listaCestini;
		
	}
	
	/**
	 * @param cestini
	 */
	public void creaGrafo(List<Cestino> cestini) {
		
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		// aggiungo i vertici al grafo (vertice: Cestino)
		Graphs.addAllVertices(grafo, cestini);
		
		// aggiungo gli archi al grafo (archi: distanza euclidea tra le Posizioni dei cestini
		for(Cestino c1 : cestini) {
			for(Cestino c2 : cestini) {
				
				if(!c1.equals(c2)) {
					DefaultWeightedEdge edge = this.grafo.getEdge(c1, c2);
					if(edge == null) {
						
						double a = c1.getPosizione().getLatitudine() - c2.getPosizione().getLatitudine();
						double b = c1.getPosizione().getLongitudine() - c2.getPosizione().getLongitudine(); 
						
						double peso = Math.sqrt(
								Math.pow(a, 2) +
								Math.pow(b, 2)
								);
								
						this.grafo.addEdge(c1, c2);
						this.grafo.setEdgeWeight(c1, c2, peso);
					}
				}
			}
		}
		
	}
	
	/**
	 * @return
	 */
	public Integer getNumeroArchi() {
		
		int numArchi = 0;
		numArchi = this.grafo.edgeSet().size();
		return numArchi;
		
	}

	/**
	 * 
	 */
	public void stampaArchi() {
		
		for(DefaultWeightedEdge e : this.grafo.edgeSet()) {
			System.out.println("Peso: " + this.grafo.getEdgeWeight(e) + " -> " + this.grafo.getEdgeSource(e) 
			+ " ; " + this.grafo.getEdgeTarget(e) + "\n");
		}
		
	}
	
	/**
	 * @param cestini
	 * @return
	 */
	public Double camminoGrafoCompleto(List<Cestino> cestini) {
		
		double risultato = 0;
		cestiniNavigati = new ArrayList<>();
		Cestino daAnalizzare = cestini.get(0);
		int indice = 1;
		
		do {
			
			double minimoCammino = 1000000;
			DefaultWeightedEdge arcoVincente = null;
			
			for(DefaultWeightedEdge e : this.grafo.edgesOf(daAnalizzare)) {
				
				//System.out.println("Sono qui" + indice + getCamminoMinimoCompleto());
				
				if((this.grafo.getEdgeWeight(e) < minimoCammino) 
						&& (!cestiniNavigati.contains(this.grafo.getEdgeSource(e))) 
						&& (!cestiniNavigati.contains(this.grafo.getEdgeTarget(e)))) {
					minimoCammino = this.grafo.getEdgeWeight(e);
					arcoVincente = e;
				}
				
			}
			risultato = risultato + minimoCammino;
			
			// controllare che Source e Target coprano la casistica di interesse; altrimenti ciclare finché non si ottiene destinazione
			Cestino possibileDestinazione1 = this.grafo.getEdgeSource(arcoVincente);
			Cestino possibileDestinazione2 = this.grafo.getEdgeTarget(arcoVincente);
			
			indice = indice +1;
			
			if(!possibileDestinazione1.equals(daAnalizzare)) {
				cestiniNavigati.add(daAnalizzare);
				daAnalizzare = possibileDestinazione1;
			} else {
				cestiniNavigati.add(daAnalizzare);
				daAnalizzare = possibileDestinazione2;
			}
			
			
			
		} while (cestiniNavigati.size()<cestini.size()-1);
		
		// manca l'ultimo cestino
		for(Cestino c1 : cestini) {
			if(!cestiniNavigati.contains(c1)) {
				cestiniNavigati.add(c1);
				//risultato = risultato + 
				//		this.grafo.getEdgeWeight(this.grafo.getEdge(c1, cestiniNavigati.get(cestini.size()-2)));
			}
		}
		
		return risultato;
		
	}
	
	/**
	 * @return
	 */
	public List<Cestino> getCamminoMinimoCompleto() {
		return cestiniNavigati;
	}
	
	/**
	 * @param cestini
	 * @return
	 */
	public Double camminoGrafoCestiniPieni(List<Cestino> cestini) {
		
		punteggioMassimo = 75;
		cestiniNavigatiPieni = new ArrayList<>();
		cestiniPieni = new ArrayList<>();
		
		for(Cestino c : cestini) {
			if(c.getPunteggio() >= punteggioMassimo) {
				cestiniPieni.add(c);
			}
		}
		
		try {
			Cestino daAnalizzare = cestiniPieni.get(0);
		
		double risultato = 0;
		
		do {
			
			double minimoCammino = 1000000;
			try {
				DefaultWeightedEdge arcoVincente = null;
			
			
				for(DefaultWeightedEdge e : this.grafo.edgesOf(daAnalizzare)) {
				
					//System.out.println("Sono qui" + indice + getCamminoMinimoCompleto());
				
					if((this.grafo.getEdgeWeight(e) < minimoCammino) 
							&& (!cestiniNavigatiPieni.contains(this.grafo.getEdgeSource(e))) 
							&& (!cestiniNavigatiPieni.contains(this.grafo.getEdgeTarget(e)))
							&& (this.grafo.getEdgeSource(e).getPunteggio()>punteggioMassimo)
							&& (this.grafo.getEdgeTarget(e).getPunteggio()>punteggioMassimo)) {
						minimoCammino = this.grafo.getEdgeWeight(e);
						arcoVincente = e;
					}
				
				}
				risultato = risultato + minimoCammino;
			
				// controllare che Source e Target coprano la casistica di interesse; altrimenti ciclare finché non si ottiene destinazione
				Cestino possibileDestinazione1 = this.grafo.getEdgeSource(arcoVincente);
				Cestino possibileDestinazione2 = this.grafo.getEdgeTarget(arcoVincente);
			
			
			
				if(!possibileDestinazione1.equals(daAnalizzare)) {
					cestiniNavigatiPieni.add(daAnalizzare);
					daAnalizzare = possibileDestinazione1;
				} else {
					cestiniNavigatiPieni.add(daAnalizzare);
					daAnalizzare = possibileDestinazione2;
				}
			
			} catch (NullPointerException e) {
				System.out.println("Avendo trovato un solo cestino, non posso stabilire la distanza per raggiungerlo");
			}
			
		} while (cestiniNavigatiPieni.size()<cestiniPieni.size()-1);
		
		// manca l'ultimo cestino
		for(Cestino c1 : cestiniPieni) {
			if(!cestiniNavigatiPieni.contains(c1)) {
				cestiniNavigatiPieni.add(c1);
				//risultato = risultato + 
				//		this.grafo.getEdgeWeight(this.grafo.getEdge(c1, cestiniNavigati.get(cestini.size()-2)));
			}
		}
		
		
		return risultato;
		
		} catch (IndexOutOfBoundsException e) {
			System.out.println("PIPPO COCA");
			return null;
		}
	}
	
	/**
	 * @return
	 */
	public List<Cestino> getCamminoMinimoOttimizzato() {
		return cestiniNavigatiPieni;
	}
	
	
}
