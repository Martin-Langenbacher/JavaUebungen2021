package KopfbisFussBasic;

import java.util.ArrayList;

public class DotCom {
	
	private ArrayList<String> zellorte;
	private String name;
	
	
/*
	public ArrayList<String> getZellorte() {
		return zellorte;
	}
	*/



	public void setZellorte(ArrayList<String> orte) {
		this.zellorte = orte;
	}



	public String getName() {
		return name;
	}



	public void setName(String n) {
		this.name = n;
	}
	
	
	public String prüfDich(String benutzereingabe) {
		String ergebnis = "Vorbei";
		int index = zellorte.indexOf(benutzereingabe);
		if (index >= 0 ) {
			zellorte.remove(index);
			
			if (zellorte.isEmpty()) {
				ergebnis = "Versenkt";
				System.out.println("Grrr! Sie haben " + name + " versenkt  :-( ");
			} else {
				ergebnis = "Treffer";
			}
		}
		
		return ergebnis;
		
	}

}
