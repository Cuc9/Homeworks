package lesson4.student;
import java.util.Date;
import java.util.Scanner;


public class Student {
	private String name;
	private String surname;
	private Date birth;
	
	public Student(String name, String surname, Date birth) {
		this.name = name;
		this.surname = surname;
		this.birth = birth;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Date getBirth() {
		return birth;
	}
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}



	public void inputSurname () {
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите фамилию студента: ");
		if (sc.hasNextLine()){
			this.surname = sc.nextLine();
		}
	}


}
