package cartes;

public abstract class Carte {

	@Override
	public String toString() {
		return "Carte";
	}
	
	@Override
	public boolean equals(Object obj) { // mettre equals dans carte, borne et problème parole de la prof
		if(obj instanceof Carte) {
			return this.toString().equals(obj.toString()); 
		}
		return false;
	}
}
