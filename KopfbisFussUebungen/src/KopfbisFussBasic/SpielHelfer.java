package KopfbisFussBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SpielHelfer {
	
	private static final String alphabet = "abcdefg";
	private int rasterLänge = 7;
	private int rasterGröße = 49;
	private int [] raster = new int [rasterGröße];
	private int dotComAnzahl = 0;
	
	
	public String getBenutzereingabe (String prompt) {
		String eingabeZeile = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			eingabeZeile = is.readLine();
			if (eingabeZeile.length() == 0 ) {
				return null;
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return eingabeZeile.toLowerCase();
	}
	
	
	public ArrayList<String> platziereDotCom(int dotComGröße) {
		ArrayList<String> alphaZellen = new ArrayList<String>();       // enthält Koordinaten der Form f6
		String temp = null;                                            // temporärer String für concat
		int [] koordinaten = new int[dotComGröße];                     // aktuelle Koordinatenkandidaten
		int versuche = 0;                                              // aktueller Versuchszähler
		boolean erfolg = false;                                        // schalter = einen guten Ort gefunden?
		int ort = 0;                                                   // aktuelle Startposition
		
		dotComAnzahl++;                                                // n-tes zu platzierendes Dot-Com
		int inkrement = 1;                                             // horizontales Inkrement setzen
		if ((dotComAnzahl % 2) == 1) {                                 // wenn ungerades Dot-Com (vertikal plaztieren)
			inkrement = rasterLänge;                                   // vertikales Inkrement setzen
		}
		
		while ( !erfolg & versuche++ < 200 ) {                   // Haupt-Suchschleife
			ort = (int) (Math.random() * rasterGröße);           // zufälligen Startpunkt holen
			// System.out.print( "Versuche " + ort);
			int x = 0;                                           // n-te Position in zu platzierendem Dot-Com
			erfolg = true;                                       // von Erfolg ausgehen
			while (erfolg && x < dotComGröße) {                  // nach angrenzenden freien Orten suchen
				if (raster[ort] == 0) {                          // wenn noch nicht benutzt
					koordinaten[x++] = ort;                      // Ort speichern
					ort += inkrement;                            // 'nächste' angrenzende Zelle versuchen
					if (ort >= rasterGröße) {                    // außerhalb der Grenzen - 'Ende'
						erfolg = false;                          // Fehlschlag
					}
				if (x>0 & (ort % rasterLänge == 0)) {            // außerhalb der Grenzen - rechter Rand
					erfolg = false;                              // Fehlschlag
				}
				} else {
					// System.out.print( "Versuche " + ort);
					erfolg = false;
				}
			}
		}
		
		
		int x = 0;                                                // den Ort in alphabetische Koordinaten umwandeln
		int zeile = 0;
		int spalte = 0;
		// System.out.println("\n");
		while (x < dotComGröße) {
			raster[koordinaten[x]] = 1;                           // die Punkte im Referenzraster als 'verwendet' markieren
			zeile = (int) (koordinaten[x] / rasterLänge);         // Zeilenwert holen
			spalte = koordinaten[x] % rasterLänge;                // numerischen Spaltenwert holen
			temp = String.valueOf(alphabet.charAt(spalte));       // in alphabetisches Zeichen umwandeln
			
			alphaZellen.add(temp.concat(Integer.toString(zeile)));
			x++;
			System.out.print(" Koordinaten "+x+" = " + alphaZellen.get(x-1)); // Diese Zeile sagt Ihnen genau, wo das Dot-Com platziert wurde.
		}
		
		System.out.println("\n");
		
		
		return alphaZellen;
	}
	
	
	
	

	

}
