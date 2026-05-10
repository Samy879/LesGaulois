package village_gaulois;
import objets.Trophee;
import objets.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee] = new Trophee(gaulois, equipement);
		nbTrophee++;
	}
	
	public String extraireInstructionsOCaml() {
		
		String texte = "let musee = [";
		for (int i=0; i<nbTrophee; i++) {
			texte += "\n\t\"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement() + "\"";
			if (i<nbTrophee-1) {
				texte+=";";
			}
		}
		texte+="\n]";
		System.out.println(texte);
		
		return texte;
	}
}
