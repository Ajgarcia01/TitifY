package es.jgl.model.Car;


public class Car {
	protected String plate;
	protected String brand ;
	protected String model;
	protected int age;
	protected int price;
	
	//*CONSTRUCTORES*
	
	//BASICO
	public Car() {
	}
	
	//FULL
	public Car(String plate, String brand, String model,int price) {
		this.plate=plate;
		this.brand=brand;
		this.model=model;

		this.price=price;

	}
	
	public Car(int price) {
		this.price=price;
	}
	
	public Car(String brand, String model,int age) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Car [plate=" + plate + ", brand=" + brand + ", model=" + model + "price=" + price + "age=" + age;
	}
	
	
	
	
	
}
