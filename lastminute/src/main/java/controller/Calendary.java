package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class Calendary {

	public int calculateDaysTo(String departure) {
		Date date = new Date();
		String strDateFormat = "dd/MM/yyyy";
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		
		LocalDate dateBefore = LocalDate.parse(objSDF.format(date), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dateAfter = LocalDate.parse(departure, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
		//calculating number of days in between
		return (int)ChronoUnit.DAYS.between(dateBefore, dateAfter);
	}
}