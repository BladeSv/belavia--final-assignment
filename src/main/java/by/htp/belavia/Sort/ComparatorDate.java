package by.htp.belavia.Sort;

import java.util.Comparator;

import by.htp.belavia.entitis.Order;

public class ComparatorDate implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		if(o1.getDayDeparture().getClass().equals(o2.getDayDeparture()) )  {
			return (int)(o1.getPrice()-o2.getPrice());
			}else {
				return o1.getDayDeparture().compareTo(o2.getDayDeparture());
			}
	}

}
