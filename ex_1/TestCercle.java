
class TestCercle 
{
	public static void main (String[] args)
	{
			Cercle c1 = new Cercle();	
			
			c1.setRayon(1.0);
			c1.setCentre(0.0,0.0);
			
			double x1;
			double y1;
			x1 = 0.0;
			y1 = 0.0;

			System.out.println("surface : " + c1.surface());
			System.out.println("Point (" + x1 + "," + y1 + ") is inside: " + c1.estInterieur(x1,y1));
	}
}
	
		
		
class Cercle 
{		
	private double rayon;
	private double[] centre; 
				
	public void setCentre(double x,double y) 
	{ 
		centre = new double[2];
		centre[0] = x;
		centre[1] = y;
	}
		
	public void setRayon(double r) 
	{
		rayon = r; 
	}
		
	public double surface()
	{
		return Math.PI * rayon * rayon;
	}
	public boolean estInterieur(double x, double y)
	{
		return ( (centre[0]-x)*(centre[0]-x) + (centre[1]-y)*(centre[1]-y) <= rayon*rayon ) ;		
	}
}



