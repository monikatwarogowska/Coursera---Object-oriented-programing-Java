import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    
    private String code;
    private int annee;
    private String pays;
    private double valeurFaciale;
    
    public Timbre() {
    	code = CODE_DEFAUT;
    	annee = ANNEE_COURANTE;
    	pays = PAYS_DEFAUT;
    	valeurFaciale = VALEUR_TIMBRE_DEFAUT;
    }
    
    public Timbre(String code) {
    	this.code = code;
    	annee = ANNEE_COURANTE;
    	pays = PAYS_DEFAUT;
    	valeurFaciale = VALEUR_TIMBRE_DEFAUT;
    }
    
    public Timbre(String code, int annee) {
    	this.code = code;
    	this.annee = annee;
    	pays = PAYS_DEFAUT;
    	valeurFaciale = VALEUR_TIMBRE_DEFAUT;
    }
    
    public Timbre(String code, int annee, String pays) {
    	this.code = code;
    	this.annee = annee;
    	this.pays = pays;
    	valeurFaciale = VALEUR_TIMBRE_DEFAUT;
    }
    
    public Timbre(String code, int annee, String pays, double valeurFaciale) {
    	this.code = code;
    	this.annee = annee;
    	this.pays = pays;
    	this.valeurFaciale = valeurFaciale;
    }
    
    public String getCode() {return code;}
    public int getAnnee() {return annee;}
    public String getPays() {return pays;}
    public double getValeurFaciale() {return valeurFaciale;}
    
    public double vente() {
    	if (ANNEE_COURANTE - annee<5) {
    		return valeurFaciale;
    	} else {
    		return (ANNEE_COURANTE-annee)*valeurFaciale*2.5;
    	}
	}
    
    public int age() {
    	return ANNEE_COURANTE - annee;
    }
    
    @Override
    public String toString() {
    	String s = " Timbre de code " + code + " datant de " + annee + " (provenance " + pays + ") ayant pour valeur faciale " + valeurFaciale + " francs\n";
    	return s;
    }
       
}


class Rare extends Timbre {
	private int exemplaires;
	
	public Rare(int exemplaires) {
		super();
		this.exemplaires = exemplaires;
	}
	
	public Rare(String code, int exemplaires) {
		super(code);
		this.exemplaires = exemplaires;
	}
	
	public Rare(String code, int annee, int exemplaires) {
		super(code, annee);
		this.exemplaires = exemplaires;
	}
	
	public Rare(String code, int annee, String pays, int exemplaires) {
		super(code, annee, pays);
		this.exemplaires = exemplaires;
	}
	
	public Rare(String code, int annee, String pays, double valeurFaciale, int exemplaires) {
		super(code, annee, pays, valeurFaciale);
		this.exemplaires = exemplaires;
	}
	
	public int getExemplaires() {return exemplaires;}
	
	public double vente() {
		double prixBase;
		if (exemplaires<BASE_1_EXEMPLAIRES) {
			prixBase = PRIX_BASE_1;
		} else if (exemplaires>BASE_1_EXEMPLAIRES && exemplaires<BASE_2_EXEMPLAIRES) {
			prixBase = PRIX_BASE_2;} 
		else {
			prixBase = PRIX_BASE_3;}
		return 0.1*prixBase*(ANNEE_COURANTE-getAnnee());
	}
	
	 @Override
	    public String toString() {
	    	String s = super.toString();
	    	s+= "Nombre d’exemplaires -> " + exemplaires;
	    	return s;
	    }
}


class Commemoratif extends Timbre {
	
	public Commemoratif() {
		super();
	}
	
	public Commemoratif(String code) {
		super(code);
	}
	
	public Commemoratif(String code, int annee) {
		super(code, annee);
	}
	
	public Commemoratif(String code, int annee, String pays) {
		super(code, annee, pays);
	}
	
	public Commemoratif(String code, int annee, String pays, double valeurFaciale) {
		super(code, annee, pays, valeurFaciale);
	}
	
	public double vente() {
		return super.vente()*2;
	}
	
	 @Override
	    public String toString() {
	    	String s = super.toString();
	    	s+= "Timbre celebrant un evenement";
	    	return s;
	    }
}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

