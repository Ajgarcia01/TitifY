package es.jgl.model.Car;

import java.util.Date;

public class Car {
	protected String plate;
	protected String brand ;
	protected String model;
	protected int age;
	protected int price;
	protected Date TimeLimit;
	
	//*CONSTRUCTORES*
	
	//BASICO
	public Car() {
	}
	
	//FULL
	public Car(String plate, String brand, String model, int age, int price, Date TimeLimit) {
		this.plate=plate;
		this.brand=brand;
		this.model=model;
		this.age=age;
		this.price=price;
		this.TimeLimit=TimeLimit;
	}
	
	public Car(int price) {
		this.price=price;
	}
	
	public Car(String brand, String model, int age) {
		this.brand=brand;
		this.model=model;
		this.age=age;
	}
	
	
	public Car(String plate) {
		this.plate=plate;
	}
	
	//*GETTERS AND SETTERS*
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getTimeLimit() {
		return TimeLimit;
	}
	public void setTimeLimit(Date timeLimit) {
		TimeLimit = timeLimit;
	}

	@Override
	public String toString() {
		return "Car [plate=" + plate + ", brand=" + brand + ", model=" + model + ", age=" + age + ", price=" + price
				+ ", TimeLimit=" + TimeLimit + "]";
	}
	
	
	
	
	
}
