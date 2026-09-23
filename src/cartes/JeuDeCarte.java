package cartes;

public class JeuDeCarte {

	public JeuDeCarte() {
	}

	private class Configuration {
		private Integer nbExemplaires;
		
		private Configuration(Carte carte, Integer nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
		}
		
		public Carte getCarte() {
			return getCarte();
		}
		
		public Integer getNbExemplaires() {
			return nbExemplaires;
		}
	}
}
