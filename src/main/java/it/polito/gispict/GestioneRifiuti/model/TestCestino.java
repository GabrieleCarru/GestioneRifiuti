package it.polito.gispict.GestioneRifiuti.model;

import java.util.List;
import java.util.ArrayList;

public class TestCestino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model modello;
		List<Cestino> cestini;
		
		modello = new Model();
		cestini = new ArrayList<>();
		cestini = modello.generaCestini(4);
		
		modello.creaGrafo(cestini);
		
		int numeroArchi = modello.getNumeroArchi();
		
		System.out.println("Il numero di archi è " + numeroArchi);
		
		for(Cestino c : cestini) {
			System.out.println(c + "\n");
		}
		
		modello.stampaArchi();
		
		double risultato = modello.camminoGrafoCompleto(cestini);
		System.out.println("Il tempo impiegato è pari a: " + risultato + "\n");
		System.out.println(modello.getCamminoMinimoCompleto());

	}

}
