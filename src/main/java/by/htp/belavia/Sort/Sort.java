package by.htp.belavia.Sort;

import java.util.LinkedList;
import java.util.List;

import by.htp.belavia.entitis.Order;

public class Sort {
	private List<Order> orderList = new LinkedList<>();

	public Sort() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sort(List<Order> orderList) {
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
	public String toString() {
		return "Sort [orderList=" + orderList + "]";
	}

	public void sortPrice() {
		if (!orderList.isEmpty()) {
			orderList.sort(new ComporatorPrice());
			for (Order order : orderList) {
				System.out.println(order);

			}
		} else {
			System.out.println("Order list is empty, start by searching");
		}

	}

	public void sortDate() {
		if (!orderList.isEmpty()) {
			orderList.sort(new ComparatorDate());
			for (Order order : orderList) {
				System.out.println(order);

			}
		} else {
			System.out.println("Order list is empty, start by searching");
		}
	}

}
