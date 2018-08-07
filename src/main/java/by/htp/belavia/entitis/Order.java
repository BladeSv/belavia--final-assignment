package by.htp.belavia.entitis;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Order {
	GregorianCalendar dayDeparture;
	String timeDeparture;
	String flightClass;
	double price;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(GregorianCalendar dayDeparture, String timeDeparture, String flightClass, double price) {
		super();
		this.dayDeparture = dayDeparture;
		this.timeDeparture = timeDeparture;
		this.flightClass = flightClass;
		this.price = price;
	}

	public GregorianCalendar getDayDeparture() {
		return dayDeparture;
	}

	public void setDayDeparture(GregorianCalendar dayDeparture) {
		this.dayDeparture = dayDeparture;
	}

	public String getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(String timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayDeparture == null) ? 0 : dayDeparture.hashCode());
		result = prime * result + ((flightClass == null) ? 0 : flightClass.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((timeDeparture == null) ? 0 : timeDeparture.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (dayDeparture == null) {
			if (other.dayDeparture != null)
				return false;
		} else if (!dayDeparture.equals(other.dayDeparture))
			return false;
		if (flightClass == null) {
			if (other.flightClass != null)
				return false;
		} else if (!flightClass.equals(other.flightClass))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (timeDeparture == null) {
			if (other.timeDeparture != null)
				return false;
		} else if (!timeDeparture.equals(other.timeDeparture))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order: departure date " + new SimpleDateFormat("dd.MM.yyyy").format(dayDeparture.getTime())
				+ ", departure time " + timeDeparture + ", class of flight " + flightClass + ", price " + price + "]";
	}

}
