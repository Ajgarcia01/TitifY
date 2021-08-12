package es.jgl.model.Car;


public class CarDAO extends Car {
	protected String plate;
	protected String brand;
	protected int age;
	protected String model;
	protected int price;
	
	
	//CONSTRUCTORES
	
	public CarDAO(String plate,String brand, String model,int price) {
		super(plate,brand,model,price);
	}
	
	public CarDAO(String plate) {
		super(plate);
	}
	
	
	public CarDAO(int price) {
		super(price);
	}
	
	public CarDAO(String brand, String model, int age) {
		super(brand,model,age);
	}
	
	
	//METODOS
	
	
	
	
	
	
}
