package es.jgl.model.Client;

import java.util.Date;

public class Client {
	protected int dni;
	protected String name;
	protected String surname;
	protected int age;
	protected Date born;
	
	
	//*CONSTRUCTORES*
	
	public Client() {
		
	}
	
	public Client(int dni) {
		this.dni=dni;
	}
	
	
	public Client(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Client(int dni, String name, String surname, int age, Date born) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.born = born;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	@Override
	public String toString() {
		return "Client [dni=" + dni + ", name=" + name + ", surname=" + surname + ", age=" + age + ", born=" + born
				+ "]";
	} 
	
}