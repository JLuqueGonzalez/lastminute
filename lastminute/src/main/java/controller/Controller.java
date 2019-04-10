package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import model.Data;
import model.Model;
import model.Records;

public class Controller {

	private Model model;
	private Calendary calendary;

	public Controller(Model m) {
		model = m;
	}

	public Records search(String origin, String destination, String departure, int passengers) {
		Records flights = model.search(origin,destination);
		
		Records flightsPrices = calculatePrice(departure, passengers, flights);
		model.showflights(flightsPrices);
		return flightsPrices;
	}

	private Records calculatePrice(String departure, int passengers, Records flights) {
		Records flightsPrices = new Records();
		
		long days = calendary.calculateDaysTo(departure);
		
		int percent = calculatePerCent(days);
		
		for(Data data:flights.getData()) {
			Data d = new Data(data);
			d.setPrice(resultPrice(data.getPrice(), percent, passengers));
			flightsPrices.getData().add(d);
		}
		
		return flightsPrices;
		
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	private int calculatePerCent(long days) {
		if(days < 3) {
			return 150;
		} 
		if(days < 16) {
			return 120;
		}
		if(days < 31) {
			return 100;
		}
		return 80;
				
	}
	
	private double resultPrice(double price, int percent, int passengers) {
		
		return round((price/100)*percent*passengers, 2);
	}

}
