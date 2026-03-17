package personnages;
import village_gaulois.Village;

public class Gaulois {
    private String nom;
    private int force;
    private Village village;

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le gaulois " + nom + " : ";
    }
    
    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        romain.recevoirCoup(force / 3);
    }
    
    public void setVillage(Village village) {
        this.village = village;
    }
    public String toString() {
        return nom;
    }
    public void sePresenter() {
        String texte = "Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". ";

        if (village == null) {
            texte += "Je voyage de villages en villages.\"";
        } 
        else {
            if (village.getChef() == this) {
                texte += "Je suis le chef le village : " + village.getNom() + ".\"";
            } 
            else {
                texte += "J'habite le village : " + village.getNom() + ".\"";
            }
        }
        System.out.println(texte);
    }
}