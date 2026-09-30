package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	
	private Carte[] cartes;
	private int nbCartes;
	private int nbOperation = 0;
	
	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = cartes.length;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte newCarte) {
		if(nbCartes<cartes.length-1) {
			cartes[nbCartes] = newCarte;
			nbCartes++;
			nbOperation++;
		} else {
			throw new IllegalStateException();
		}
	}
	
	public Carte piocher() {
		 Iterator<Carte> iter = iterator();

	     if (!iter.hasNext()) {
	    	 throw new IllegalStateException("Le sabot est vide, impossible de piocher.");
	     }
	     Carte carte = iter.next();
	     iter.remove();
	     return carte;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte> {

		private int indiceIterateur;
		private boolean nextEffectue = false;
		private int nbOpReference = nbOperation;
		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
		    if (hasNext()){
		    	Carte carte = cartes[indiceIterateur];
		        indiceIterateur++;
		        nextEffectue = true;
		        return carte;
		    } else {
		        throw new NoSuchElementException(); // Pas d'élément suivant
		    }
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
		    if (nbCartes < 1 || !nextEffectue) {
		    	throw new IllegalStateException();
		    }
		    for (int i = indiceIterateur-1; i < nbCartes-1; i++){
		        cartes[i] = cartes[i+1];
		    }
		    nextEffectue = false;
		    indiceIterateur--; // Pro
		    nbCartes--;
		    nbOperation++;
		    nbOpReference++;
		}
		
		private void verificationConcurrence(){
			if (nbOperation != nbOpReference){
		        throw new ConcurrentModificationException();
		    }
		}
	}
}
