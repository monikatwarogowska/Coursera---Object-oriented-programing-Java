import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

class OptionVoyage {
	
	private String nom;
	private double prixForfaitaire;
	
	public OptionVoyage(String nom, double prixForfaitaire) {
		this.nom = nom;
		this.prixForfaitaire = prixForfaitaire;
	}
	
	public String getNom() {return nom;}
	public double prix() {return prixForfaitaire;};
	
	public String toString() {
		return nom + " -> " + prix() + " CHF ";
	}
}

class Transport extends OptionVoyage {
	
	public static final double TARIF_LONG = 1500.0;
	public static final double TARIF_BASE = 200.0;
	
	private boolean tarif;
	
	public Transport(String nom, double prixForfaitaire) {
		super(nom,prixForfaitaire);
		this.tarif = false;
	}
	
	public Transport(String nom, double prixForfaitaire, boolean tarif) {
		super(nom,prixForfaitaire);
		this.tarif = tarif;
	}
	
	public double prix() {
		if (tarif) {
			return super.prix() + TARIF_LONG;
		} else {
			return super.prix() + TARIF_BASE;
		}
	}
	
}

class Sejour extends OptionVoyage {
	private int nbNuits;
	private double prixNuit;
	
	public Sejour(String nom, double prix, int nbNuits, double prixNuit) {
		super(nom,prix);
		this.nbNuits = nbNuits;
		this.prixNuit = prixNuit;
	}
	
	public double prix() {
		return prixNuit * nbNuits + super.prix();
	}
}

class KitVoyage {
	private ArrayList<OptionVoyage> collection;
	private String depart;
	private String destination;
	
	public KitVoyage(String depart, String destination) {
		this.collection = new ArrayList<OptionVoyage>();
		this.depart = depart;
		this.destination = destination;
	}
	
	public double prix() {
		double p = 0;
		for (int i=0; i<collection.size(); i++) {
			p += collection.get(i).prix();
		}
		return p;
	}
	
	public String toString() {
		String s = new String();
		s = "Voyage de " + depart + " à " + destination + ", avec pour options :\n";
		for (int i=0; i<collection.size(); i++) {
			s += "  - " + collection.get(i).toString() + "\n";
		}
		s += "Prix total : " + prix() + " CHF\n";
		return s;
	}
	
	public void ajouterOption(OptionVoyage option) {
		if (option != null) {collection.add(option);}
	}
	
	public int getNbOptions() {return collection.size();}
	
	public void annuler() {collection.clear();}
}

/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

       // FIN TEST 1


        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2


        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }
}

