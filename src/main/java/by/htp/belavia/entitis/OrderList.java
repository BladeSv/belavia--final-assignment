package by.htp.belavia.entitis;

import java.util.LinkedList;
import java.util.List;

public class OrderList {
	private List<Order> orderList = new LinkedList<>();

public OrderList() {
	super();
	// TODO Auto-generated constructor stub
}

public OrderList(List<Order> orderList) {
	super();
	this.orderList = orderList;
}

public List<Order> getOrderList() {
	return orderList;
}

public void setOrderList(List<Order> orderList) {
	this.orderList = orderList;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((orderList == null) ? 0 : orderList.hashCode());
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
	OrderList other = (OrderList) obj;
	if (orderList == null) {
		if (other.orderList != null)
			return false;
	} else if (!orderList.equals(other.orderList))
		return false;
	return true;
}

@Override
public String toString() {
	return "OrderList [orderList=" + orderList + "]";
}


}
