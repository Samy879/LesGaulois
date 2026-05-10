package personnages;
import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private static final String LE_SOLDAT = "Le soldat ";
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		if (!isInvariantVerified(force)) {
			throw new IllegalArgumentException("Force négative : "+force);
		}
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;
	    forceCoup = calculResistanceEquipement(forceCoup);
	    force -= forceCoup;
	    
	    if (force>0) {
	    	parler("Aïe");
            
	    }
	    else {
	    	equipementEjecte = ejecterEquipement();
	    	parler("J'abandonne...");
	    	
	    }
	    
	    return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
	    if (nbEquipement != 0) {
	        texte+="\nMais heureusement, grace à mon équipement sa force est diminué de ";
	        for (int i = 0; i < nbEquipement; i++) {
	            if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
	                resistanceEquipement += 6;

	            } else {
	                resistanceEquipement += 3;
	            }
	        }
	        
	        texte += resistanceEquipement + "!";
	        
	        if (resistanceEquipement>forceCoup) {
	        	resistanceEquipement = forceCoup;
	        	texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup 
	                    + "\nMais heureusement, grâce à mon équipement sa force a été complètement absorbée.";
	        }
	    }
	    
	    forceCoup -= resistanceEquipement;
	    parler(texte);
	    
	    return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
	    Equipement[] equipementEjecte = new Equipement[nbEquipement];
	    System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
	    
	    int nbEquipementEjecte = 0;
	    for (int i = 0; i < nbEquipement; i++) {
	        if (equipements[i] != null) {
	            equipementEjecte[nbEquipementEjecte] = equipements[i];
	            nbEquipementEjecte++;
	            equipements[i] = null;
	        }
	    }
	    return equipementEjecte;
	}
	
	private boolean isInvariantVerified(int force) {
		return force>=0;
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	private void ajouterEquipement(Equipement equipement) {
	    equipements[nbEquipement] = equipement;
	    nbEquipement++;
	    System.out.println(LE_SOLDAT + nom + " s'équipe avec un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		 switch (nbEquipement) {
		 	case 2:
		 		System.out.println(LE_SOLDAT+nom+" est déjà bien protégé !");
		 		break;
		 	case 1:
		 		if (equipement==equipements[0]) {
		 			System.out.println(LE_SOLDAT+nom+" possède déjà un "+equipement+"!");
		 		}
		 		else {
		 			ajouterEquipement(equipement);
		 		}
		 		break;
		 		
		 	default:
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
