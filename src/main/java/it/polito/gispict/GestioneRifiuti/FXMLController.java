package it.polito.gispict.GestioneRifiuti;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.gispict.GestioneRifiuti.model.Cestino;
import it.polito.gispict.GestioneRifiuti.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAcquisisciSensore;

    @FXML
    private Button btnAnnulla;

    @FXML
    private Button btnAvviaSimulazione;

    @FXML
    private Button btnElimina;

    @FXML
    private Button btnInformazioni;

    @FXML
    private TextField txtNumCestini;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void acquisireSensore(ActionEvent event) {
    	System.out.println("Funziona il pulsante");
    }

    @FXML
    void annullaSimulazione(ActionEvent event) {
    	System.out.println("Ciao il pulsante");
    }

    @FXML
    void avvioSimulazione(ActionEvent event) {
    	String numeroCestini = txtNumCestini.getText();
    	
    	// inserire controllo sul valore massimo (limiti di calcolo)
    	
    	try {
    		
    		int numCestini = Integer.parseInt(numeroCestini);
    		List<Cestino> cestini = model.generaCestini(numCestini);
    		
    		model.creaGrafo(cestini);
    		
    	} catch(NumberFormatException e) {
    		txtRisultato.appendText("Errore di formattazione del numero cestini \n");
    		return;
    	}
    	
    	
    }
    
    @FXML
    void eliminaRisultato(ActionEvent event) {
    	txtNumCestini.clear();
    	txtRisultato.clear();
    }

    @FXML
    void fornisciInformazioni(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAcquisisciSensore != null : "fx:id=\"btnAcquisisciSensore\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnnulla != null : "fx:id=\"btnAnnulla\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAvviaSimulazione != null : "fx:id=\"btnAvviaSimulazione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnElimina != null : "fx:id=\"btnElimina\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInformazioni != null : "fx:id=\"btnInformazioni\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumCestini != null : "fx:id=\"txtNumCestini\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}
