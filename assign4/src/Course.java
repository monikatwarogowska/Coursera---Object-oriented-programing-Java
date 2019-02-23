import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici
 *******************************************/
class Vehicule {
	private String nom;
	private double vitesseMax;
	private int poids;
	private int carburant;
	
	public Vehicule() {
		nom = "Anonyme";
		vitesseMax = 130;
		poids = 1000;
		carburant = 0;
	}
	public Vehicule(String nom, double vitesseMax, int poids, int carburant) {
		this.nom = nom;
		this.vitesseMax = vitesseMax;
		this.poids = poids;
		this.carburant = carburant;
	}
	
	public String toString() {
		return nom + " -> vitesse max = " + vitesseMax + " km/h, poids = " + poids + " kg ";
	}
	
	public boolean meilleur(Vehicule autreVehicule) {
		return performance() > autreVehicule.performance();
	}
	
	public double performance() {
		return vitesseMax/poids;
	}
	
	public String getNom() {return nom;}
	public double getVitesseMax() {return vitesseMax;}
	public int getPoids() {return poids;}
	public int getCarburant() {return carburant;}
	
    public boolean estDeuxRoues() {
		return false;
	}
}

class Voiture extends Vehicule {
	private String categorie;
	
	public Voiture(String categorie) {
		super();
		this.categorie = categorie; 
	}
	
	public Voiture(String nom, double vitesseMax, int poids, int carburant, String categorie) {
		super(nom, vitesseMax, poids, carburant);
		this.categorie = categorie;
	}
	
	public String toString() {
		return getNom() + " -> vitesse max = " + getVitesseMax() + " km/h, poids = " + getPoids() + " kg, Voiture de " + categorie;
	}
	
	public String getCategorie() {return categorie;}
	
    public boolean estDeuxRoues() {
		return false;
	}
}

class Moto extends Vehicule {
	private boolean sidecar;
	
	public Moto(boolean sidecar) {
		super();
		this.sidecar = sidecar; 
	}
	
	public Moto(String nom, double vitesseMax, int poids, int carburant) {
		super(nom, vitesseMax, poids, carburant);
		this.sidecar = false;
	}
	
	public Moto(String nom, double vitesseMax, int poids, int carburant, boolean sidecar) {
		super(nom, vitesseMax, poids, carburant);
		this.sidecar = sidecar;
	}
	
	public String toString() {
		if (sidecar) {
		return getNom() + " -> vitesse max = " + getVitesseMax() + " km/h, poids = " + getPoids() + " kg, Moto, avec sidecar";
		} else {
			return getNom() + " -> vitesse max = " + getVitesseMax() + " km/h, poids = " + getPoids() + " kg, Moto";
		}
	}
	
    public boolean estDeuxRoues() {
		if (sidecar) {
    	    return false;
		} else {
			return true;
		}
	}
}

abstract class Rallye {
	
	public Rallye(){
		super();
	}
	
	public abstract boolean check();
}

class GrandPrix extends Rallye {
	private ArrayList<Vehicule> collection;
	
	public GrandPrix() {
		super();
		collection = new ArrayList<Vehicule>();
	}
	
	public boolean check() {
		ArrayList<Boolean> test_roues = new ArrayList<Boolean>();
		ArrayList<Boolean> ref_2Roues = new ArrayList<Boolean>();
		ArrayList<Boolean> ref_4Roues = new ArrayList<Boolean>();
		for (int i=0; i<collection.size(); i++) {
			test_roues.add(collection.get(i).estDeuxRoues());
			ref_2Roues.add(true);
			ref_4Roues.add(false);
			//System.out.println(test_roues.get(i));
		}
		
		if (test_roues.equals(ref_2Roues)) {
			return true;
		} else if (test_roues.equals(ref_4Roues)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void ajouter(Vehicule veh) {
		collection.add(veh);
	}
	
	public void run(int tours) {
		if (check()) {
			ArrayList<Vehicule> startList = new ArrayList<Vehicule>();
			ArrayList<Double> perfList = new ArrayList<Double>();
			
			for (int i=0; i<collection.size(); i++) {
				if (collection.get(i).getCarburant()>tours) {
					startList.add(collection.get(i));
					perfList.add(collection.get(i).performance());
				}
			}
			
			if (startList.size() != 0) {
 			    Vehicule winner = new Vehicule();
			    winner = startList.get(0);
			    for (int i=1; i<startList.size(); i++) {
				    if (startList.get(i).performance()>winner.performance()) {
					    winner = startList.get(i);
				    }
			    }
			    System.out.println("Le gagnant du grand prix est : ");
			    System.out.println(winner);
			} else {
				System.out.println("Elimination de tous les vehicules");
			}
		} else { System.out.println("Pas de Grand Prix");}
	}
}


/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class Course {

    public static void main(String[] args) {

        // PARTIE 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        Vehicule v0 = new Vehicule();
        System.out.println(v0);

        // les arguments du constructeurs sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        Vehicule v1 = new Vehicule("Ferrari", 300.0, 800, 30);
        Vehicule v2 = new Vehicule("Renault Clio", 180.0, 1000, 20);
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(v2);

        if (v1.meilleur(v2)) {
            System.out.println("Le premier vehicule est meilleur que le second");
        } else {
            System.out.println("Le second vehicule est meilleur que le premier");
        }
        // FIN PARTIE 1

        // PARTIE2
        System.out.println();
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la presence d'un sidecar
        Moto m1 = new Moto("Honda", 200.0, 250, 15, true);
        Moto m2 = new Moto("Kawasaki", 280.0, 180, 10);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la categorie
        Voiture vt1 = new Voiture("Lamborghini", 320, 1200, 40, "course");
        Voiture vt2 = new Voiture("BMW", 190, 2000, 35, "tourisme");
        System.out.println(vt1);
        System.out.println();
        System.out.println(vt2);
        System.out.println();
        // FIN PARTIE 2

        // PARTIE 3
        System.out.println();
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        GrandPrix gp1 = new GrandPrix();
        gp1.ajouter(v1);
        gp1.ajouter(v2);
        System.out.println(gp1.check());

        GrandPrix gp2 = new GrandPrix();
        gp2.ajouter(vt1);
        gp2.ajouter(vt2);
        gp2.ajouter(m2);
        System.out.println(gp2.check());

        GrandPrix gp3 = new GrandPrix();
        gp3.ajouter(vt1);
        gp3.ajouter(vt2);
        gp3.ajouter(m1);
        System.out.println(gp3.check());

        GrandPrix gp4 = new GrandPrix();
        gp4.ajouter(m1);
        gp4.ajouter(m2);
        System.out.println(gp4.check());
        // FIN PARTIE 3

        // PARTIE 4
        System.out.println();
        System.out.println("Test partie 4 : ");
        System.out.println("----------------");
        GrandPrix gp5 = new GrandPrix();
        gp5.ajouter(vt1);
        gp5.ajouter(vt2);

        System.out.println("Premiere course :");
        gp5.run(11);
        System.out.println();

        System.out.println("Deuxieme  course :");
        gp3.run(40);
        System.out.println();

        System.out.println("Troisieme  course :");
        gp2.run(11);
        // FIN PARTIE 4
    }
}
