import java.util.ArrayList;
import java.util.Collections;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	// Completer la classe Auteur ici
	
	private String nom;
	private boolean estPrime;
	
	public Auteur(String nom, boolean estPrime) {
		this.nom = nom;
		this.estPrime = estPrime;
	}
	
	public String getNom() {return nom;}
	public boolean getPrix() {return estPrime;}
}

class Oeuvre
{
 	// Completer la classe Oeuvre ici
	private String titre;
	private Auteur auteur; 
	private String langue;
	
	public Oeuvre( String titre, Auteur auteur, String langue) {
		this.titre = titre;
		this.auteur = auteur;
		this.langue = langue;
	}
	
	public Oeuvre( String titre, Auteur auteur) {
		this.titre = titre;
		this.auteur = auteur;
		langue = "francais";
	}
	
	public String getTitre() { return titre;}
	public Auteur getAuteur() { return auteur; }
	public String getLangue() {return langue;}
	
	public void afficher() {
		System.out.println( getTitre() + ", " + getAuteur().getNom() + ", en " +  getLangue());
	}
}

// completer les autres classes ici

class Exemplaire {
	private Oeuvre oeuvre;
	
	public Exemplaire(Oeuvre o) {
		oeuvre = o;
		System.out.println("Nouvel exemplaire ->  " + o.getTitre() + ", " + o.getAuteur().getNom() + ", en " + o.getLangue());
	}
	
	public Exemplaire(Exemplaire e) {
		oeuvre = e.getOeuvre();
		System.out.println("Nouvel exemplaire ->  " + e.getOeuvre().getTitre() + ", " + e.getOeuvre().getAuteur().getNom() + ", en " + e.getOeuvre().getLangue());
	}
	
	public Oeuvre getOeuvre() {return oeuvre;}
	
	public void afficher() {
		System.out.println( "Un exemplaire de " + oeuvre.getTitre() + ", " + oeuvre.getAuteur().getNom() + ", en " +  oeuvre.getLangue());
	}
}

class Bibliotheque {
	
	private String nom;
	private ArrayList<Exemplaire> exemplaires;
	
	public Bibliotheque(String nom) {
		this.nom = nom;
		exemplaires = new ArrayList<Exemplaire>();
		System.out.println("La bibliotheque " + nom + " est ouverte !");
	}
	
	public String getNom() {return nom;}
	public int getNbExemplaires() {return exemplaires.size();}
	
	public void stocker(Oeuvre oeuvre, int nombre) {
		for (int i = 1; i <= nombre; i++) { 
			Exemplaire exemplaire_new = new Exemplaire(oeuvre);
			exemplaires.add(exemplaire_new); 
			}	
	}
	public void stocker(Oeuvre oeuvre) {
		 Exemplaire exemplaire_new = new Exemplaire(oeuvre);
		 exemplaires.add(exemplaire_new); 
	}
	
	public  ArrayList<Exemplaire> listerExemplaires(String langue) {
		ArrayList<Exemplaire> exemplairesList = new ArrayList<Exemplaire>();
		for (int i = 0; i < getNbExemplaires(); i++) {
			Oeuvre oeuvreTemp = exemplaires.get(i).getOeuvre();
			String currentLangue = oeuvreTemp.getLangue();
			if ( currentLangue == langue) {
				exemplairesList.add(exemplaires.get(i));
			}
		}
		return exemplairesList;
	}
	public  ArrayList<Exemplaire> listerExemplaires() {
		return exemplaires;
	}
	
	public int compterExemplaires(Oeuvre oeuvre) {
		ArrayList<Oeuvre> listTemp = new ArrayList<Oeuvre>();
		for (int i=0; i<exemplaires.size(); i++) {
			listTemp.add(exemplaires.get(i).getOeuvre());
		}
		int occurrences = Collections.frequency(listTemp, oeuvre);
		return occurrences;
	}
	
	public void afficherAuteur(boolean prixTest) {
		
		ArrayList<Oeuvre> oeuvresList = new ArrayList<Oeuvre>();
		for (int i=0; i<exemplaires.size(); i++) {
			if (!oeuvresList.contains(exemplaires.get(i).getOeuvre())) { 
				oeuvresList.add(exemplaires.get(i).getOeuvre());
			}
		}
		
		//
		if (prixTest) {
			for (int i=0; i<exemplaires.size();i++) {
				Auteur auteurTemp = exemplaires.get(i).getOeuvre().getAuteur(); 
				if (auteurTemp.getPrix()) {
					String name = auteurTemp.getNom();
					System.out.println(name);
				}
			}
		} else {
			for (int i=0; i<exemplaires.size();i++) {
				Auteur auteurTemp = exemplaires.get(i).getOeuvre().getAuteur();
				if (!auteurTemp.getPrix()) {
					String name = auteurTemp.getNom();
					System.out.println(name);
				}
			}
		}
	}
	
    public void afficherAuteur() {
		
		ArrayList<Oeuvre> oeuvresList = new ArrayList<Oeuvre>();
		for (int i=0; i<exemplaires.size(); i++) {
			if (!oeuvresList.contains(exemplaires.get(i).getOeuvre())) { 
				oeuvresList.add(exemplaires.get(i).getOeuvre());
			}
		}
		
		for (int i=0; i<exemplaires.size();i++) {
			Auteur auteurTemp = exemplaires.get(i).getOeuvre().getAuteur();
			if (auteurTemp.getPrix()) {
				String name = auteurTemp.getNom();
				System.out.println(name);
			}
		}
	}
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");
        
        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}

