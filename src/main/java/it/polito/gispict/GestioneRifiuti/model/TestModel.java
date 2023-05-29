package it.polito.gispict.GestioneRifiuti.model;

import java.util.List;
import java.util.ArrayList;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model modello;
		List<Cestino> cestini;
		Integer numeroCestini = 30;
		
		modello = new Model();
		cestini = new ArrayList<>();
		cestini = modello.generaCestini(numeroCestini);
		
		modello.creaGrafo(cestini);
		
		System.out.println("\nPer effettuare la simulazione sono stati generati " + numeroCestini + " cestini. \n" + 
								"Ogni cestino è stato collocato CASUALMENTE in una mappa di dimensioni 100x100 " + 
								"così da rendere ogni simulazione differente \ndalla precedente. \n" +
								"Anche lo stato di riempimento del cestino è stato generando in maniera CASUALE, " +
								"ciò è stato fatto per evitare, \ninvoltariamente, di 'pilotare' la simulazione. \n");
		
		//System.out.println("SIMULAZIONE 1: \n");
		
		System.out.println("Nella simulazione è stato scelto un punto sulla mappa (il punto (10;10)) " + 
								"come punto di partenza, ipotizzando che sia \nil centro di gestione rifiuti. \n\n\n");
		
		int numeroArchi = modello.getNumeroArchi();
		
		//System.out.println("Il numero di archi è " + numeroArchi);
		
		/*for(Cestino c : cestini) {
			System.out.println(c + "\n");
		}*/
		
		//modello.stampaArchi();
		
		System.out.println("CASO 1: RACCOLTA DI TUTTI I CESTINI \n");
		
		double risultatoNavigazioneCompleta = modello.camminoGrafoCompleto(cestini);
		System.out.println("Il tempo impiegato per la raccolta di tutti i cestini è pari a: " 
														+ risultatoNavigazioneCompleta + "\n");
		//System.out.println(modello.getCamminoMinimoCompleto());
		List<Cestino> elencoCestini = modello.getCamminoMinimoCompleto();
		System.out.println("L'ordine con cui raccogliere i cestini è: \n");
		for(Cestino c1 : elencoCestini) {
			System.out.println("- " + c1 + "\n");
		}
		
		System.out.println("\n");
		
		System.out.println("CASO 2: RACCOLTA +SOLO+ DEI CESTINI PIENI \n");
		
		double risultatoOttimizzato = modello.camminoGrafoCestiniPieni(cestini);
		System.out.println("Il tempo impiegato per la raccolta ottimizzata dei cestini è pari a: " 
														+ risultatoOttimizzato + "\n");
		List<Cestino> elencoCestiniPieni = modello.getCamminoMinimoOttimizzato();
		System.out.println("L'ordine con cui raccogliere i cestini è: \n");
		for(Cestino c2 : elencoCestiniPieni) {
			System.out.println("- " + c2 + "\n");
		}
		
		System.out.println("\n");
		
		double differenzaTempo = risultatoNavigazioneCompleta-risultatoOttimizzato;
		double scale = Math.pow(10, 2);
		double differenzaTempoArr = Math.round(differenzaTempo*scale)/scale;
		
		double percentualeRisparmio =((differenzaTempoArr*100)/risultatoNavigazioneCompleta);
		double percentualeRisparmioArr = Math.round(percentualeRisparmio*scale)/scale;
		
		System.out.println("CONCLUSIONE: Il tempo risparmiato è pari a: " + differenzaTempoArr + " con un risparmio " +
								"in termini percentuali pari al " + percentualeRisparmioArr + "%.");
		
		//System.out.println(modello.getCamminoMinimoOttimizzato());
		
	}

}