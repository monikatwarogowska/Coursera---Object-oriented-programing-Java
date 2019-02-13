/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

class Patient
{
	private double masse;
	private double hauteur; 
	
	public void init(double m, double h) {
		if (m < 0 || h < 0) {
			masse = 0;
			hauteur = 0; 
		} else { 
			masse = m;
			hauteur = h;
		}
	}
	
	public double poids() { return (double)Math.round(masse * 10d) / 10d ; }
	public double taille() {return (double)Math.round(hauteur * 10d) / 10d ; }
	
	public void afficher() {
		double m;
		m = (double)Math.round(masse * 10d) / 10d;
		double h; 
		h = (double)Math.round(hauteur * 10d) / 10d ;
		System.out.println("Patient : " + m + " kg pour " + h + " m"); 
	}
	
	public double imc() {
		if (hauteur == 0) {
			return  0.0;
		} else { return masse/(hauteur*hauteur); }
	}
    
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Imc {
    public static void main(String[] args) {

        Patient quidam = new Patient();
        quidam.init(74.5, 1.75);
        quidam.afficher();
        System.out.println("IMC : " + quidam.imc());
        quidam.init( -2.0, 4.5);
        quidam.afficher();
    }
}
