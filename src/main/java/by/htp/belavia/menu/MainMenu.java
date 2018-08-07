package by.htp.belavia.menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import by.htp.belavia.Sort.Sort;
import by.htp.belavia.entitis.OrderList;
import by.htp.belavia.steps.StepsOneWay;
import by.htp.belavia.steps.StepsTwoWay;

public class MainMenu {

	OrderList oneWayList = new OrderList();
	public static GregorianCalendar finishDay = new GregorianCalendar();
	public static GregorianCalendar starstDay = new GregorianCalendar();
	Sort sort = new Sort(oneWayList.getOrderList());

	public void mainMenu() {
		String startPage = "https://booking.belavia.by";

		try {
			finishDay.setTime((new SimpleDateFormat("dd.MM.yyyy").parse("20.08.2018")));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		try {
			starstDay.setTime((new SimpleDateFormat("dd.MM.yyyy").parse("15.08.2018")));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		do {
			System.out.println("Select menu item");
			System.out.println("1-Look tickeds in one way at 15.08.2018 to 15.11.2018");
			System.out.println("2-Look for tickets in two directions at 15.08.2018 to 15.11.2018");
			System.out.println("3-Sort tickets by cost");
			System.out.println("4-Sort tickets by date of departure");
			System.out.println("5-Exit");

			Scanner sc = new Scanner(System.in);
			String choose = sc.nextLine();
			switch (choose) {
			case "1":
				StepsOneWay stepsOneWay = new StepsOneWay(oneWayList.getOrderList());
				stepsOneWay.startSearch(startPage);
				stepsOneWay.CalendarTariffs();
				break;
			case "2":
				StepsTwoWay stepsTwoWay =new StepsTwoWay(oneWayList.getOrderList());
				stepsTwoWay.startSearch(startPage);
				stepsTwoWay.CalendarTariffs();
				break;
			case "3":
				sort.sortPrice();
				break;
			case "4":
				sort.sortDate();
				break;
			case "5":
				System.exit(0);
				break;
			default:
				System.out.println("Entered the wrong menu item");

			}

		} while (true);
	}
}