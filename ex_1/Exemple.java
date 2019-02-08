class Exemple
{
	public static void main (String[] args)
	{
		Rectangle rect1 = new Rectangle();	
		
		rect1.setHeight(3.0);
		rect1.setLength(4.0);
		

		System.out.println("height : " + rect1.getHeight());
		System.out.println("surface : " + rect1.surface());
		
	}
}
	
	
class Rectangle 
{
	
	private double height;
	private double length;
	
	public double getHeight() { return height; }
	public double getLength() { return length; }
	
	public void setHeight(double h) {height = h; }
	public void setLength(double l) {length = l; }
	
	public double surface()
	{
		return height * length;
	}
	
}
