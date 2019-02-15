import java.util.ArrayList;

import java.util.Calendar;


public class SchoolOrganization {
	public static void main(String[] args) {
		School univ = new School(); 
		univ.addMember(new Teacher("Mathieu Matheu", 1998, "LMEP", 10000, "Physics"));
		univ.addMember(new RegularStudent("Shrek", 2005, "Bagno", 4.5));
		
		univ.displayMembers();
		System.out.println("Total number of membres : " + univ.nbMembers());
		System.out.println("Total number of students : " + univ.nbStudents());
		System.out.println("Czas : " + univ.AffilationPeriod());
	}
}

class School {
	private ArrayList<SchoolMember> members;

	public School() {
		this.members = new ArrayList<SchoolMember>();
	}
	
	public void addMember(SchoolMember member) {
		if (member != null) {members.add(member);}
		System.out.println("New employee");
	}
	
	public void displayMembers() {
		System.out.println("Liste of school members : ");
		for (SchoolMember m : members)
			m.display();
	}
	
	public int nbMembers() {
		return members.size();
	}
	
	public int nbStudents() {
	    int nbStudents = 0;
	    for (int i = 0; i < members.size(); i++) {
		    if (members.get(i).isStudent()) 
		    {
		    	nbStudents = nbStudents + 1;
		    }
	    }
	    return nbStudents;
	}
	
	public int AffilationPeriod() {
		int today = Calendar.getInstance().get(Calendar.YEAR);
		int dt = 0;
		for (int i = 0; i < members.size(); i++) {
			dt = dt + (today - members.get(i).getArrivalDate() );
		}
		return dt/members.size();
	}
}



class  SchoolMember{
	private String name;
	private int arrivalDate;
	
	public SchoolMember(String name, int arrivalDate) {
		this.name = name;
		this.arrivalDate = arrivalDate;
	}
	
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Arrival date: " + arrivalDate);
	}
	
	public String getName() { return name;}
	public int getArrivalDate() {return arrivalDate;}
	
	public boolean isStudent() {return false;}
	
}

class Personel extends SchoolMember {
	private String nameLab;
	private double salary;
	
	public Personel(String name, int arrivalDate, String nameLab, double salary) {
		super(name,arrivalDate);
		this.nameLab = nameLab;
		this.salary = salary;
	}
	
	public void display() {
		super.display();
		System.out.println("Lab : " + nameLab);
		System.out.println("Salary : " + salary);
	}
	
	public String getNameLab() {return nameLab;}
	public double getSalary() {return salary;}
}


class Secretary extends Personel {
	
	public Secretary(String name, int arrivalDate, String nameLab, double salary) {
		super(name,arrivalDate,nameLab,salary);
	}
	
	public void display() {
		System.out.println("Secretary : ");
		super.display();
	}
}

class Teacher extends Personel {
	private String nameSection;
	
	public Teacher(String name, int arrivalDate, String nameLab, double salary, String nameSection){
		super(name, arrivalDate, nameLab, salary);
		this.nameSection = nameSection;
	}
	
	public void display() {
		System.out.println("Teacher : ");
		super.display();
		System.out.println("Section : " + nameSection);
	}
}

class Student extends SchoolMember {
	private String nameSection;
	
	public Student(String name, int arrivalDate, String nameSection) {
		super(name,arrivalDate);
		this.nameSection = nameSection;
	}
	
	public void display() {
		super.display();
		System.out.println("Section: " + nameSection);
	}
	
	public String getNameSection() {return nameSection;}
	
	public boolean isStudent() { return true;}
}

class ExternalStudent extends Student {
	private String homeUniv;
	
	public ExternalStudent (String name, int arrivalDate, String nameSection, String homeUniv) {
		super(name, arrivalDate, nameSection);
		this.homeUniv = homeUniv;
	}
	
	public void display() {
		System.out.println("External student : ");
		super.display();
		System.out.println("Home Univeristy : " + homeUniv);
	}	
}

class RegularStudent extends Student {
	private double grade;
	
	public RegularStudent (String name, int arrivalDate, String nameSection, double grade) {
		super(name, arrivalDate, nameSection);
		this.grade = grade;
	}
	
	public void display() {
		System.out.println("Regular student : ");
		super.display();
		System.out.println("Average grade : " + grade);
	}
	
}
