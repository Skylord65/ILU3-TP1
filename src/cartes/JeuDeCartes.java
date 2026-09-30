package cartes;

public class JeuDeCartes {

	private Configuration[] typeDeCartes =  {new Configuration(new Borne(25),10),
		new Configuration(new Borne(50),10),
		new Configuration(new Borne(75),10),
		new Configuration(new Borne(100),12),
		new Configuration(new Borne(200),4),
		new Configuration(new FinLimite(),6),
		new Configuration(new Parade(Type.FEU),14),
		new Configuration(new Parade(Type.ESSENCE),6),
		new Configuration(new Parade(Type.CREVAISON),6),
		new Configuration(new Parade(Type.ACCIDENT),6),
		new Configuration(new Attaque(Type.FEU),5),
		new Configuration(new DebutLimite(),4),
		new Configuration(new Attaque(Type.ESSENCE),3),
		new Configuration(new Attaque(Type.CREVAISON),3),
		new Configuration(new Attaque(Type.ACCIDENT),1),
		new Configuration(new Botte(Type.FEU),1),
		new Configuration(new Botte(Type.ESSENCE),1),
		new Configuration(new Botte(Type.CREVAISON),1),
		new Configuration(new Botte(Type.ACCIDENT),1),
	};

	private class Configuration extends Carte {
		private Integer nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, Integer nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}
		
		public Carte getCarte() {
			return carte;
		}
		
		public Integer getNbExemplaires() {
			return nbExemplaires;
		}
	}
	
	public String affichageJeuDeCartes() {
		StringBuilder text = new StringBuilder();
		for (int i = 0 ; i < 18 ; i++) {
			text.append(typeDeCartes[i].getNbExemplaires());
			text.append(" ");
			text.append(typeDeCartes[i].getCarte().toString());
			text.append("\n");
		}
		return text.toString();
	}
	
	public Carte[] donnerCartes() {
		int taille = 0;
		for (int i = 0; i<18; i++) {
			taille += typeDeCartes[i].getNbExemplaires();
		}
		Carte[] jeu = new Carte[taille];
		int nbCarteDansJeu = 0;
		for (int i = 0; i<18; i++) {
			for (int j = 0; j < typeDeCartes[i].getNbExemplaires(); j++) {
				jeu[nbCarteDansJeu] = typeDeCartes[i].getCarte();
				nbCarteDansJeu++;
			}
		}
		return jeu;
	}
}
