package personnages;
import objets.Equipement;
public class Romain {

    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        assert isInvariantVerified();
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
        assert forceCoup > 0;

        int ancienneForce = force;

        force -= forceCoup;

        if (force < 1) {
            force = 0;
            parler("J'abandonne !");
        } else {
            parler("Aïe");
        }

        assert isInvariantVerified();
        assert force < ancienneForce;
    }
    
    private boolean isInvariantVerified() {
        return force >= 0;
    }
    public static void main(String[] args) {
        System.out.println(objets.Equipement.CASQUE);
        System.out.println(objets.Equipement.BOUCLIER);
        Romain minus = new Romain("Minus", 6);

        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
    }
    
    private void afficherEquipement(String action, Equipement equipement) {
        System.out.println("Le soldat " + nom + " " + action
                + " " + equipement + ".");
    }
    
    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 0:
                ajouterEquipement(equipement);
                afficherEquipement("s'équipe avec un", equipement);
                break;

            case 1:
                if (equipements[0] == equipement) {
                    afficherEquipement("possède déjà", equipement);
                } else {
                    ajouterEquipement(equipement);
                    afficherEquipement("s'équipe avec un", equipement);
                }
                break;

            default:
                System.out.println(
                    "Le soldat " + nom + " est déjà bien protégé !"
                );
                break;
        }
    }
    
    private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
    }
}
