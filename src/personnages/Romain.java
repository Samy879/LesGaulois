package personnages;
import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equip = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(force);
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup>=0 : "la force du coup reçu est positive";
		
		int force_d = this.force;
		this.force -= forceCoup;
		if (force<1) {
			force = 0;
			parler("J'abandonne !");
		}
		else {
			parler("Aïe");
		}
		int force_f = this.force;
		assert isInvariantVerified(force);
		assert force_f<force_d : "la force d'un ROmain a diminué.";
	}
	
	private boolean isInvariantVerified(int force) {
		return force>=0;
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	private void ajouterEquipement(Equipement equipement) {
	    equip[nbEquipement] = equipement;
	    nbEquipement++;
	    System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		 switch (nbEquipement) {
		 	case 2:
		 		System.out.println("Le soldat "+nom+" est déjà bien protégé !");
		 		break;
		 	case 1:
		 		if (equipement==equip[0]) {
		 			System.out.println("Le soldat "+nom+" possède déjà un "+equipement+"!");
		 		}
		 		else {
		 			ajouterEquipement(equipement);
		 		}
		 		break;
		 		
		 	case 0:
		 		ajouterEquipement(equipement);
		 		break;
		 		
		 }
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(3);
		
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		
	}
	
}
