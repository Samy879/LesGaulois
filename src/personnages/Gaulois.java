package personnages;
import village_gaulois.Village;
import objets.Equipement;
import village_gaulois.Musee;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	
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
	
	public void frapper(Romain romain) {
	    System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
	    
	    Equipement[] equipementEjectes = romain.recevoirCoup((force / 2) * effetPotion);
	    
	    effetPotion--;
	    if (effetPotion < 1) {
	        effetPotion = 1;
	    }

	    for (int i = 0; equipementEjectes != null && i < equipementEjectes.length; i++, nbTrophees++) {
	        this.trophees[nbTrophees] = equipementEjectes[i];
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
			String bonjour = "Bonjour, je m'appelle ";
			
			if (village.getChef()==this) {
				parler(bonjour+nom+". Je suis le chef du village "+village.getNom()+".");
			}
			
			else {
				parler(bonjour+nom+". J'habite le village "+village.getNom()+".");
			}
		}

		else {
			parler("Bonjour, je m'appelle "+nom+". Je voyage de villages en villages.");
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		if (trophees[0]!=null){
			String texte = "Je donne au musee tous mes trophees : ";
			for (int i=0; i<100; i++) {
				if(trophees[i]!=null) {
					texte+="\n- "+trophees[i];
					musee.donnerTrophees(this, trophees[i]);
					trophees[i]=null;
				}
			}
			parler(texte);
			this.nbTrophees = 0;
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
}
