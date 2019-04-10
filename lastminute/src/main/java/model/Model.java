package model;

import static com.lastminute.CsvFiles.readAllRecords;

import java.io.File;
import java.util.List;

import view.LastMinuteFrame;

public class Model {

	private LastMinuteFrame view;
	private Records records;
	

	public Model(LastMinuteFrame v) {
		if(v == null) {
			
		} else {
			view = v;
		}
		
		
		records = loadData();
	}

	private Records loadData() {
		records = new Records();
		List<List<String>> prices = readAllRecords(fullPathTo("flight-prices.csv"));
		List<List<String>> routes = readAllRecords(fullPathTo("flight-routes.csv"));
		
		for(List<String> price:prices) {
			int i = 0;
			while(i < routes.size()) {
				if(price.get(0).equals(routes.get(i).get(2))) {
					Data data = new Data();
					data.setCode(price.get(0));
					data.setPrice(Integer.parseInt(price.get(1)));
					data.setOrigin(routes.get(i).get(0));
					data.setDestination(routes.get(i).get(1));
					records.getData().add(data);
					i = routes.size();
				}
				i++;
			}
		}
		return records;
	}
	
	private String fullPathTo(String fileName) {
		File file = fullPathToWindows(fileName);
		return file.getAbsolutePath();
	}
		  
	private File fullPathToWindows(String fileName) {
		String pngpath =getClass().getClassLoader().getResource(fileName).getFile();
		File file = new File(pngpath);
		return file;
	}

	public Records search(String origin, String destination) {
		return records.search(origin, destination);
		
	}

	public void showflights(Records flights) {
		view.showflights(flights);
		
	}

}
