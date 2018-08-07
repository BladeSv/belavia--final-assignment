package by.htp.belavia.Sort;

import java.util.Comparator;

import by.htp.belavia.entitis.Order;

public class ComporatorPrice implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		if(o1.getPrice()==o2.getPrice()) {
		return o1.getDayDeparture().compareTo(o2.getDayDeparture());
		}else {
			return (int)(o1.getPrice()-o2.getPrice());
		}
	}

	

}
