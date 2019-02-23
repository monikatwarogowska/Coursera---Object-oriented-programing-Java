/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;

class Construction {
	private int nbElements;
	private ArrayList<Composant> construction;
	
	public Construction(int nbElements){
		this.nbElements= nbElements;
		construction = new ArrayList<Composant>();
	}
	
	public int taille() {return construction.size();}
	public int tailleMax() {return nbElements;}
	
	public void ajouterComposant(Piece p, int quantite) {
		if (taille()<tailleMax()) {
			Composant c = new Composant(p,quantite);
			construction.add(c);
		} else {
			System.out.println("Ajout de composant impossible");
		}
	}
}

class Composant {
	private Piece piece;
	private int quantite;
	
	public Composant(Piece piece, int quantite) {
		this.piece = piece;
		this.quantite = quantite;
	}
	
	public Piece getPiece() {return piece;}
	public int getQuantite() {return quantite;}
}

class Piece {
	private String nom;
	
	public Piece(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {return nom;}
	
	@Override
	public String toString(){
		return nom;
	}
	
}

class Simple extends Piece{
	private String orientation;
	
	public Simple(String nom,String orientation) {
		super(nom);
		this.orientation = orientation;
	}
	
	public Simple(String nom) {
		super(nom);
		orientation = "aucune";
	}
	
	public String getOrientation() {return orientation;}
	
	@Override
	public String toString() {
		String s = super.toString();
		if (orientation!="aucune") { s+= " [" + orientation + "]";}
		return s;
	}
}

class Composee extends Piece{
	private ArrayList<Piece> composee;
	private int nbElements;
	
	public Composee(String nom, int nbElements) {
		super(nom);
		this.composee = new ArrayList<Piece>();
		this.nbElements = nbElements;
	}
	
	public int taille() {return composee.size();}
	public int tailleMax() {return nbElements;}
	
	public void construire(Piece p) {
		if (taille()<tailleMax()) {
			composee.add(p);
		} else {
			System.out.println("Construction impossible");
		}
	}
	
	public String toString() {
		String s = super.toString();
		if (taille() == 0) {
			return s;
		} else if (taille() == 1) {
		    s+= "(" + composee.get(0) + ")";
		    return s;
		} else {
		    s+= "(";
		    for (int i=0; i<taille()-1; i++) {
			    s+= composee.get(i) + "'";
		    }
		    s+= composee.get(taille()-1) + ")";
		    return s;
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

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}
