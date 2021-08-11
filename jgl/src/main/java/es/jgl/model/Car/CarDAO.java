package es.jgl.model.Car;

import java.util.Date;

public class CarDAO extends Car {
	protected String plate;
	protected String brand ;
	protected String model;
	protected int age;
	protected int price;
	protected Date TimeLimit;
	
	
	//CONSTRUCTORES
	
	public CarDAO(String plate,String brand, String model, int age,int price, Date TimeLimit) {
		super(plate,brand,model,age,price,TimeLimit);
	}
	
	public CarDAO(String plate) {
		super(plate);
	}
	
	public CarDAO(String brand, String model, int age) {
		super(brand,model,age);
	}
	
	public CarDAO(int price) {
		super(price);
	}
	
	
	//METODOS
	
	
	
	
	
	
}
