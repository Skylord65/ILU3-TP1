package jeu;

import java.util.Iterator;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	
	private Carte[] carte;
	private int nbCartes;
	
	public Sabot(Carte[] carte) {
		this.carte = carte;
		this.nbCartes = carte.length;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte newCarte) {
			if(this.nbCartes<carte.length) {
				carte[nbCartes] = newCarte;
				nbCartes++;
			} else {
				throw new IllegalStateException();
			}
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte> {

		@Override
		public boolean hasNext() {
			return ;
		}

		@Override
		public Carte next() {
			
			return null;
		}
	}
}
