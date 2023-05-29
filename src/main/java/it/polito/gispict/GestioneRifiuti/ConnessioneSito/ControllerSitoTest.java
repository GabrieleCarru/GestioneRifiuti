/*package it.polito.gispict.GestioneRifiuti.ConnessioneSito;

import com.google.maps.*;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import java.util.List;

public class ControllerSitoTest {

	
	private Double latOrigin = 45.0703;
	private Double longOrigin = 7.6869;
	private Double latDestination = 45.0709;
	private Double longDestination = 7.6945;
	

	
	String apiKey = "AIzaSyCyn7sBi7dIKOEraHLduT1Q1mfAp_bVkzM";
	GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();
	
	LatLng origin = new LatLng(latOrigin, longOrigin); // Latitudine e longitudine del punto di partenza
	LatLng destination = new LatLng(latDestination, longDestination); // Latitudine e longitudine del punto di arrivo

	DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(context)
		    .origins(origin)
		    .destinations(destination);

		DistanceMatrix matrix = request.await();
		DistanceMatrixRow[] rows;// = matrix.rows;




		if (rows.length > 0) {
		    DistanceMatrixElement[] elements = rows[0].elements;

		    if (elements.length > 0) {
		        long durationInSeconds = elements[0].duration.inSeconds; // Tempo di percorrenza in secondi
		        // Puoi convertire il tempo di percorrenza come preferisci (minuti, ore, etc.)
		    }
		}
	}
}
*/

