package model;

import java.util.ArrayList;
import java.util.List;

public class Records {
	private List<Data> data = null;

	public Records() {
		data = new ArrayList<Data>();
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
	public Records search(String origin, String destination) {
		Records result = new Records();
		for(Data d:data) {
			if((d.getOrigin().equals(origin)) && (d.getDestination().equals(destination))) {
				result.getData().add(d);
			}
		}
		return result;
	}
	public String toString() {
		String result = "";
		for(Data d:data) {
			result += d.getCode() + ", " + d.getPrice() + "€\n";
		}
		return result;
	}
}
