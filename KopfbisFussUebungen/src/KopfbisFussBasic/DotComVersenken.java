package KopfbisFussBasic;

import java.util.ArrayList;

public class DotComVersenken {
	
	private SpielHelfer helfer = new SpielHelfer();
	private ArrayList<DotCom> dotComListe = new ArrayList<DotCom>();
	private int anzahlVersuche = 0;

	public static void main(String[] args) {
		
		DotComVersenken spiel = new DotComVersenken();
		spiel.spielEinrichten();
		spiel.beginneSpiel();
	}
	
	
	private void spielEinrichten() {
		// Erst ein paar Dot-Coms machen und ihnen Namen geben
		DotCom eins = new DotCom();
		eins.setName("Haustiere.com");
		DotCom zwei = new DotCom();
		zwei.setName("BioWare.com");
		DotCom drei = new DotCom();
		drei.setName("FragMich.com");
		
		dotComListe.add(eins);
		dotComListe.add(zwei);
		dotComListe.add(drei);
		
		System.out.println("Ihre Aufgabe ist es, drei Dot-Cos zu versenken.");
		System.out.println(eins.getName() + ", " + zwei.getName() + ", " + drei.getName());
		System.out.println("Versuchen Sie, sie mit so wenig Versuchen wie möglich zu erledigen.Ihre Aufgabe ist es, drei Dot-Cos zu versenken.");
		
		for (DotCom aktuellesDotCom : dotComListe) {
			
			ArrayList<String> neuerOrt = helfer.platziereDotCom(3);
			aktuellesDotCom.setZellorte(neuerOrt);
		}
		
	}
	

	private void beginneSpiel() {
		
		// Solange die DotCom-Liste NICHT leer ist
		while (!dotComListe.isEmpty()) {
			String rateversuch = helfer.getBenutzereingabe("Geben Sie einen Rateversuch ein.");
			prüfeRateversuch(rateversuch);
		}
		beendeSpiel();
	}


	
	private void prüfeRateversuch(String rateversuch) {
		
		anzahlVersuche++;
		
		String ergebnis = "Vorbei";
		
		for (DotCom aktuellesDotCom : dotComListe) {
			ergebnis = aktuellesDotCom.prüfDich(rateversuch);
			if (ergebnis.equals("Treffer")) {
				break;                                              // Die Schleife vorzeitig verlassen, weil es sinnlos ist, die anderen zu prüfen
			}
			if (ergebnis.equals("Versenkt")) {
				dotComListe.remove(aktuellesDotCom);                // Der hier ist versenkt, also nehmen wir ihn aus der DotCom-Liste und steigen dann aus der Schleife aus.
				break;
			}
			
		} // for schließen
		System.out.println(ergebnis);
	}

	

	private void beendeSpiel() {
		System.out.println("Alle Dot-Coms sind versenkt! Ihre Aktien sind wertlos.");
		if (anzahlVersuche <= 18 ) {
			System.out.println("Sie haben nur " + anzahlVersuche + " Versuche benötigt. Sie erhalten den KinoWelt-Preis!");
		} else {
			System.out.println("Hat ja lange genug gedauert. " +anzahlVersuche + " Versuche.");
			System.out.println("Warum sind Sie nicht ausgestiegen, bevor der Kurs in den Keller fiel?");
		}
		// TODO Auto-generated method stub
		
	}
	

	
	
	

}
