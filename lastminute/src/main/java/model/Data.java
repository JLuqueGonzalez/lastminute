package model;

public class Data {
	
	private String code;
	private String origin;
	private String destination;
	private double price;
	public String getCode() {
		return code;
	}
	
	public Data(Data d) {
		super();
		this.code = d.code;
		this.origin = d.origin;
		this.destination = d.destination;
		this.price = d.price;
	}
	public Data() {
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
