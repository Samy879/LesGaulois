package personnages;
import objets.Equipement;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;
    
    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
                } else {
                    equiper(equipement);
                }
                break;
            case 0:
                equiper(equipement);
                break;
        }
    }

    private void equiper(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
    }
    
    private boolean isInvariantVerified() {
        return force >= 0;
    }
    
    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        assert isInvariantVerified() : "La force d'un Romain doit être positive !";
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le romain " + nom + " : ";
    }

    public void recevoirCoup(int forceCoup) {
        assert forceCoup >= 0 : "La force d'un coup doit être positive";

        int forceAvant = force;

        force -= forceCoup;
        if (force < 1) { 
            force = 0;
            parler("J'abandonne !");
        } else {
            parler("Aïe !");
        }

        assert force < forceAvant : "La force n'a pas diminué après le coup !";
        
        assert isInvariantVerified();
    }
    
    public static void main(String[] args) {
        
    	Romain minus2 = new Romain("Minus", 6);
        
        minus2.sEquiper(Equipement.CASQUE);
        minus2.sEquiper(Equipement.CASQUE);
        minus2.sEquiper(Equipement.BOUCLIER);
        minus2.sEquiper(Equipement.CASQUE);
        
        Romain bonRomain = new Romain("Validus", 10);
        System.out.println("\nTentative de donner un coup de force -2...");
        
        System.out.println("Tentative de création de Minus avec une force de -6...");
        Romain minus = new Romain("Minus", -6);
        bonRomain.recevoirCoup(-2);
        
    }
}