package Village_gaulois;

import personnages.Gaulois;

public class Village {
    private String nom;
    private Gaulois chef;
    private Gaulois[] villageois;
    private int nbVillageois;

    public Village(String nom, Gaulois chef, int capacite) {
        this.nom = nom;
        this.chef = chef;
        this.villageois = new Gaulois[capacite];
        this.nbVillageois = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Gaulois getChef() {
        return chef;
    }

    public void setChef(Gaulois chef) {
        this.chef = chef;
    }

    public Gaulois[] getVillageois() {
        return villageois;
    }

    public void setVillageois(Gaulois[] villageois) {
        this.villageois = villageois;
    }

    public int getNbVillageois() {
        return nbVillageois;
    }

    public void ajouterVillageois(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
            gaulois.setVillage(this);
        }
    }

    public Gaulois trouverVillageois(int numero) {
        if (numero >= 1 && numero <= nbVillageois) {
            return villageois[numero - 1];
        }

        System.out.println(
            "Il n’y a pas autant d’habitants dans notre village !"
        );
        return null;
    }

    public void afficherVillageois() {
        System.out.println("Dans le village \"" + nom
                + "\" du chef " + chef.getNom());
        System.out.println("vivent les légendaires gaulois :");

        for (int i = 0; i < nbVillageois; i++) {
            System.out.println("- " + villageois[i].getNom());
        }
    }
    
    public static void main(String[] args) {
        Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);

        Village village = new Village(
            "Village des Irréductibles", abraracourcix, 30
        );

        village.trouverVillageois(30);

        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterVillageois(asterix);

        Gaulois gaulois = village.trouverVillageois(1);
        System.out.println(gaulois);

        gaulois = village.trouverVillageois(2);
        System.out.println(gaulois);

        village.afficherVillageois();

        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterVillageois(obelix);

        Gaulois doublePolemix = new Gaulois("Doublepolémix", 4);

        village.afficherVillageois();

        abraracourcix.sePresenter();
        asterix.sePresenter();
        doublePolemix.sePresenter();
    }
}
