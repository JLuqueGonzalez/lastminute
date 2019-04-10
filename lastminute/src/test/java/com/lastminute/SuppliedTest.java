package com.lastminute;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import controller.Controller;
import model.Model;
import model.Records;
import view.LastMinuteFrame;

public class SuppliedTest
{
  LastMinuteFrame view = new LastMinuteFrame(false);
  Model model = new Model(view);
  Controller controller = new Controller(model);

  @Test
  public void test1()
  {
    Records result = controller.search("AMS", "FRA", calculateDays(new Date(), 31), 1);
    assertEquals(3, result.getData().size());
    assertEquals(result.getData().get(0).getCode(), "TK2372");
    assertEquals(result.getData().get(0).getPrice(), Double.parseDouble("157.6"), 0.1);
    assertEquals(result.getData().get(1).getCode(), "TK2659");
    assertEquals(result.getData().get(1).getPrice(), Double.parseDouble("198.4"), 0.1);
    assertEquals(result.getData().get(2).getCode(), "LH5909");
    assertEquals(result.getData().get(2).getPrice(), Double.parseDouble("90.4"), 0.1);
  }
  
  @Test
  public void test2()
  {
    Records result = controller.search("LHR", "IST", calculateDays(new Date(), 15), 3);
    assertEquals(2, result.getData().size());
    assertEquals(result.getData().get(0).getCode(), "TK8891");
    assertEquals(result.getData().get(0).getPrice(), 900, 0.1);
    assertEquals(result.getData().get(1).getCode(), "LH1085");
    assertEquals(result.getData().get(1).getPrice(), 532.8, 0.1);
  }
  
  @Test
  public void test3()
  {
    Records result = controller.search("BCN", "MAD", calculateDays(new Date(), 2), 2);
    assertEquals(2, result.getData().size());
    assertEquals(result.getData().get(0).getCode(), "IB2171");
    assertEquals(result.getData().get(0).getPrice(), 777, 0.1);
    assertEquals(result.getData().get(1).getCode(), "LH5496");
    assertEquals(result.getData().get(1).getPrice(), 879, 0.1);
  }
  
  @Test
  public void test4()
  {
    Records result = controller.search("CDG", "FRA", calculateDays(new Date(), 2), 2);
    assertEquals(0, result.getData().size());
  }

  private String calculateDays(Date date, int i) {
	  	String strDateFormat = "dd/MM/yyyy";
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
	return objSDF.format(addDays(date, i));
}
  public static Date addDays(Date date, int days){
      if (days==0) return date;
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date); 
      calendar.add(Calendar.DAY_OF_YEAR, days);  
      return calendar.getTime(); 
}

}
