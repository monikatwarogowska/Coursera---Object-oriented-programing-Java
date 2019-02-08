/* ask for age a and sum of money m in a pocket (less then 100 euro)
 * read the numbers
 * 
 *  (a*2 + 5)*50 + m - 365
 *  tell loudly the result
 *  add to the result 115
 * 
 */
import java.util.Scanner;

public class magie 
{
	public static void main (String[] args)
	{
		
		
		Spectateur Alice = new Spectateur();
		Alice.candidature();
		
		Assistant Bob = new Assistant();
		Magicien Mag = new Magicien();
	
		Mag.magicTour(Alice,Bob);
		
		
	}
}


class Paper 
{
	private double age;
	private double money;
	
	public void write(double age_temp, double money_temp) {
		age = age_temp;
		money = money_temp;
	}
	
	public double readAge() {
		return age;
	}
	public double readMoney() { 
		return money;
	}
}


class Spectateur
{
	private double age;
	private double money;
	
	Scanner input = new Scanner(System.in);
	
	public void candidature() {
		System.out.println("[Spectateur] (I enter on the scene)");
		System.out.println("What is my age: ");
		
		age = input.nextInt(); 	   	
		
		money  = 200;
		while (money > 100) {
    		System.out.println("How much money do I have in my pocket? (<100) ");
		    money = input.nextDouble();
		}
	}
	
	public void write(Paper note) {
		System.out.println("[Spectateur] (I write on paper)");
		note.write(age,money);
	}
}

class Assistant
{
	private double ageData;
	private double moneyData;
	private double result;
	
	public void read(Paper note) {
		System.out.println("[Assistant] (I read paper)");
		ageData = note.readAge();
		moneyData = note.readMoney();
	}
	
    public void secretCalcul() {
     	   result = (ageData*2.0 + 5.0)*50.0 + moneyData - 365.0;
    }
    
    public double communicate() {
		System.out.println("[Assistant]  Number is: " + result);
		return result;
    }
}

class Magicien
{
	private int ageGuess;
	private int moneyGuess;
	
	public void magicTour(Spectateur s, Assistant a) {
		Paper note = new Paper();
		System.out.println("[Magicien] A small magic tour...");
		s.write(note);
		a.read(note);
		a.secretCalcul();
		magicCalcul(a.communicate());
		magicResult();
	}
	
	private void magicCalcul(double resultData) {
		ageGuess = (int) Math.round((resultData + 115)/100);
		moneyGuess = (int) Math.round((resultData + 115)%100);
	}
	
	private void magicResult() {
		System.out.println("[Magician] Age is " + ageGuess + "and sum of money is" + moneyGuess);
	}
}
