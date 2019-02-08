import java.util.Scanner;

/* Program that allows user to enter coordinates (x,y) of triangle sommets. 
 * Then it calculates and shows the perimeter and a message if the triangle is isoscele. 
 */

public class geometry 
{
	public static void main (String[] args)
	{
		triangle tr = new triangle();
		
		tr.setSommets();
		System.out.println("Perimeter of the triangle is:" + tr.perimeter());
		System.out.println("Is the triangle isoscele: " + tr.isIsoscele());
	}
}


class triangle 
{
	private double[][] sommets;
	private double[] dist_sommets;
	
	Scanner input = new Scanner(System.in);
	
	public void setSommets() 
	{ 
		sommets = new double[3][2];

		System.out.println("Coordinates of the first sommet:");
		System.out.println("x: ");
		sommets[0][0] = input.nextDouble();
		System.out.println("y: ");
		sommets[0][1] = input.nextDouble();
		
		System.out.println("Coordinates of the second sommet:");
		System.out.println("x: ");
		sommets[1][0] = input.nextDouble();
		System.out.println("y: ");
		sommets[1][1] = input.nextDouble();
		
		System.out.println("Coordinates of the third sommet:");
		System.out.println("x: ");
		sommets[2][0] = input.nextDouble();
		System.out.println("y: ");
		sommets[2][1] = input.nextDouble();
	}
	
	public double perimeter()
	{
	    dist_sommets = new double[3];
		
	    dist_sommets[0] = Math.sqrt( Math.pow(sommets[0][0] - sommets[1][0],2) + Math.pow(sommets[0][1] - sommets[1][1],2) );
	    dist_sommets[1] = Math.sqrt( Math.pow(sommets[0][0] - sommets[2][0],2) + Math.pow(sommets[0][1] - sommets[2][1],2) );
	    dist_sommets[2] = Math.sqrt( Math.pow(sommets[1][0] - sommets[2][0],2) + Math.pow(sommets[1][1] - sommets[2][1],2) );
		
		return dist_sommets[0] + dist_sommets[1] + dist_sommets[2];
	}
	
	public boolean isIsoscele()
	{
		return ( dist_sommets[0] == dist_sommets[1] || dist_sommets[0] == dist_sommets[2] || dist_sommets[1] == dist_sommets[2]) ;		
	}
}