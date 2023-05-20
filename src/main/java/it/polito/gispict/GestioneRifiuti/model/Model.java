package it.polito.gispict.GestioneRifiuti.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import java.util.ArrayList;

public class Model {

	private List<Cestino> cestini;
	private Graph<Cestino, DefaultWeightedEdge> grafo;
	
	public List<Cestino> generaCestini(int numCestini) {
		
		cestini = new ArrayList<>();
		
		int i = 0;
		for(i=0; i<numCestini; i++) {
			
			int lat = (int)(Math.random()*100);
			int lon = (int)(Math.random()*100);
			
			// definizione delle variabili generate randomicamente
			Posizione p = new Posizione (lat,lon);
			Integer punt = (int)(Math.random()*100); 
			
			Cestino c = new Cestino(i+1, p, punt);
			cestini.add(c);
			
		}
		
		return cestini;
		
	}
	
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
	
	public Integer getNumeroArchi() {
		
		int numArchi = 0;
		numArchi = this.grafo.edgeSet().size();
		return numArchi;
		
	}

	public void stampaArchi() {
		
		for(DefaultWeightedEdge e : this.grafo.edgeSet()) {
			System.out.println("Peso: " + this.grafo.getEdgeWeight(e) + "\n");
		}
		
	}
	
}
