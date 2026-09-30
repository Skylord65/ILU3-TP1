package cartes;

public class JeuDeCartes {

	private Configuration[] typeDeCartes = new Configuration[19];
	
	public JeuDeCartes() {
		typeDeCartes[0] = new Configuration(new Borne(25),10);
		typeDeCartes[1] = new Configuration(new Borne(50),10);
		typeDeCartes[2] = new Configuration(new Borne(75),10);
		typeDeCartes[3] = new Configuration(new Borne(100),12);
		typeDeCartes[4] = new Configuration(new Borne(200),4);
		typeDeCartes[5] = new Configuration(new FinLimite(),6);
		typeDeCartes[6] = new Configuration(new Parade(Type.FEU),14);
		typeDeCartes[7] = new Configuration(new Parade(Type.ESSENCE),6);
		typeDeCartes[8] = new Configuration(new Parade(Type.CREVAISON),6);
		typeDeCartes[9] = new Configuration(new Parade(Type.ACCIDENT),6);
		typeDeCartes[10] = new Configuration(new Attaque(Type.FEU),5);
		typeDeCartes[11] = new Configuration(new DebutLimite(),4);
		typeDeCartes[12] = new Configuration(new Attaque(Type.ESSENCE),3);
		typeDeCartes[13] = new Configuration(new Attaque(Type.CREVAISON),3);
		typeDeCartes[14] = new Configuration(new Attaque(Type.ACCIDENT),1);
		typeDeCartes[15] = new Configuration(new Botte(Type.FEU),1);
		typeDeCartes[16] = new Configuration(new Botte(Type.ESSENCE),1);
		typeDeCartes[17] = new Configuration(new Botte(Type.CREVAISON),1);
		typeDeCartes[18] = new Configuration(new Botte(Type.ACCIDENT),1);
	}

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
		int nbCarteDansJeuPourquoiTuEsSiLong = 0;
		for (int i = 0; i<18; i++) {
			nbCarteDansJeuPourquoiTuEsSiLong++;
			for (int j = 0; j < typeDeCartes[i].getNbExemplaires(); j++) {
				jeu[nbCarteDansJeuPourquoiTuEsSiLong] = typeDeCartes[i].getCarte();
				nbCarteDansJeuPourquoiTuEsSiLong++;
			}
		}
		return jeu;
	}
}
