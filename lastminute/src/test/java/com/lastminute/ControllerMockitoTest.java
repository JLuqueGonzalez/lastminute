package com.lastminute;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import controller.Calendary;
import controller.Controller;
import model.Model;
import model.Records;
import view.LastMinuteFrame;

public class ControllerMockitoTest {
	LastMinuteFrame view = new LastMinuteFrame(false);
	  Model model = new Model(view);
	@InjectMocks
	private Controller controller = new Controller(model);

	@Mock
	private Calendary calendary;

	@Before
	public void inicializaMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test1() {
		String departure = "11/04/2019";

		when(calendary.calculateDaysTo(departure)).thenReturn(31);
		
		Records result = controller.search("AMS", "FRA", departure, 1);

		assertEquals(3, result.getData().size());
	    assertEquals(result.getData().get(0).getCode(), "TK2372");
	    assertEquals(result.getData().get(0).getPrice(), Double.parseDouble("157.6"), 0.1);
	    assertEquals(result.getData().get(1).getCode(), "TK2659");
	    assertEquals(result.getData().get(1).getPrice(), Double.parseDouble("198.4"), 0.1);
	    assertEquals(result.getData().get(2).getCode(), "LH5909");
	    assertEquals(result.getData().get(2).getPrice(), Double.parseDouble("90.4"), 0.1);
	}
	
	@Test
	public void test2() {
		String departure = "11/04/2019";

		when(calendary.calculateDaysTo(departure)).thenReturn(15);
		
		Records result = controller.search("LHR", "IST", departure, 3);

		assertEquals(2, result.getData().size());
	    assertEquals(result.getData().get(0).getCode(), "TK8891");
	    assertEquals(result.getData().get(0).getPrice(), 900, 0.1);
	    assertEquals(result.getData().get(1).getCode(), "LH1085");
	    assertEquals(result.getData().get(1).getPrice(), 532.8, 0.1);
	}
	
	@Test
	public void test3() {
		String departure = "11/04/2019";

		when(calendary.calculateDaysTo(departure)).thenReturn(2);
		
		Records result = controller.search("BCN", "MAD", departure, 2);

		assertEquals(2, result.getData().size());
	    assertEquals(result.getData().get(0).getCode(), "IB2171");
	    assertEquals(result.getData().get(0).getPrice(), 777, 0.1);
	    assertEquals(result.getData().get(1).getCode(), "LH5496");
	    assertEquals(result.getData().get(1).getPrice(), 879, 0.1);
	}
	
	@Test
	public void test4() {
		String departure = "11/04/2019";

		when(calendary.calculateDaysTo(departure)).thenReturn(2);
		
		Records result = controller.search("CDG", "FRA", departure, 2);

		assertEquals(0, result.getData().size());
	}
}
