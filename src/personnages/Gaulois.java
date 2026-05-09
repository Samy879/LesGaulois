package personnages;
import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte){
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public String toString() {
		return nom;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(force*effetPotion/3);
		if (this.effetPotion > 1) {
	        this.effetPotion -= 1;
	    }
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	public Village setVillage(Village village) {
		this.village = village;
		return village;
	}

	public void sePresenter() {
		if (village!=null) {
			
			if (village.getChef()==this) {
				parler("Bonjour, je m'appelle "+nom+". Je suis le chef du village "+village.getNom()+".");
			}
			
			else {
				parler("Bonjour, je m'appelle "+nom+". J'habite le village "+village.getNom()+".");
			}
		}

		else {
			parler("Bonjour, je m'appelle "+nom+". Je voyage de villages en villages.");
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
}
