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
		
		double risultatoNavigazioneCompleta = modello.camminoGrafoCompleto(cestini);
		System.out.println("Il tempo impiegato per raccolta completa è pari a: " 
														+ risultatoNavigazioneCompleta + "\n");
		System.out.println(modello.getCamminoMinimoCompleto());
		
		System.out.println("\n\n");
		
		double risultatoOttimizzato = modello.camminoGrafoCestiniPieni(cestini);
		System.out.println("Il tempo impiegato per raccolta ottimizzata è pari a: " 
														+ risultatoOttimizzato + "\n");
		System.out.println(modello.getCamminoMinimoOttimizzato());
		
	}

}
