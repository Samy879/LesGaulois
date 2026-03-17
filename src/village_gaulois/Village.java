package village_gaulois;

import personnages.Gaulois;

public class Village {
    private String nom;
    private Gaulois chef;
    private Gaulois[] villageois;
    private int nbVillageois = 0;
    private static final int NB_VILLAGEOIS_MAX = 100;

    public Village(String nom, int nbVillageoisMax, Gaulois chef) {
        this.nom = nom;
        this.chef = chef;
        this.villageois = new Gaulois[nbVillageoisMax];
    }

    public String getNom() {
        return nom;
    }

    public Gaulois getChef() {
        return chef;
    }

   
    public void ajouterVillageois(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
            gaulois.setVillage(this);
        }
            
    }
    public Gaulois trouverVillageois(int numVillageois) {
           
       if (numVillageois > 0 && numVillageois <= nbVillageois) { 
            return villageois[numVillageois - 1];
        }
        System.out.println("Il n'y a pas autant d'habitants dans notre village !");
        return null;
    }   
    
    public void afficherVillageois() {
        System.out.println("Dans le village \"" + nom + "\" du chef " + chef.getNom() 
            + " vivent les légendaires gaulois :");
        
        for (int i = 0; i < nbVillageois; i++) {
            System.out.println("- " + villageois[i].getNom());
        }
    }
    
    public static void main(String[] args) {
        Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
        Village village = new Village("Village des Irréductibles", 30, abraracourcix);

        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterVillageois(asterix);

        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterVillageois(obelix);
        
        village.afficherVillageois();
        
        Gaulois doublePolemix = new Gaulois("Doublepolémix", 4);

        abraracourcix.sePresenter();
        asterix.sePresenter();
        doublePolemix.sePresenter();
    }
        
}