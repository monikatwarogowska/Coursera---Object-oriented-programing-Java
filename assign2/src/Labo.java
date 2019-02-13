class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/

    private int poids;
    private String couleur;
    private int age;
    private int esperanceVie;
    private boolean clonee;
    
    public Souris(int p, String c, int a, int le ) {
    	poids  = p;
    	couleur   = c;
    	age     = a;
    	esperanceVie = le;
    	System.out.println("Une nouvelle souris ! ");
    }
    
    public Souris(int p, String c, int a) {
    	poids  = p;
    	couleur   = c;
    	age     = a;
    	esperanceVie = ESPERANCE_VIE_DEFAUT;
    	System.out.println("Une nouvelle souris ! ");
    }
    
    public Souris(int p, String c) {
    	poids  = p;
    	couleur   = c;
    	age     = 0;
    	esperanceVie = ESPERANCE_VIE_DEFAUT;
    	System.out.println("Une nouvelle souris ! ");
    }
    
    public Souris(Souris clSouris) {
    	poids = clSouris.getPoids();
    	couleur = clSouris.getCouleur();
    	age = clSouris.getAge();
    	
    	int val = (int) (0.8*clSouris.getEsperanceVie()); 
    	esperanceVie = val;
    	clonee = true;
    	System.out.println("Clonage d'une souris ! ");
    }
    
    public int getPoids() { return poids; }
    public String getCouleur() { return couleur; }
    public int getAge() { return age; }
    public int getEsperanceVie() { return esperanceVie; }
    
    
    public String toString() {
    	if (clonee) {
    	    return "Une souris " + couleur + ", clonee, de " + age + " mois et pesant " + poids + " grammes ";
    	} else {
        	return "Une souris " + couleur + " de " + age + " mois et pesant " + poids + " grammes ";
    	}
    }
   
    public void evolue() { 
    	while (age != esperanceVie) { vieillir(); }
    }
    
    public void vieillir() {
    	age = age + 1;
    	int th_age = (int) Math.round(0.5*esperanceVie); 
    	if (clonee && age > th_age) { couleur = "verte"; }
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
