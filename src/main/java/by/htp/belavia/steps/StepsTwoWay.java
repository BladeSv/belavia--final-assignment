package by.htp.belavia.steps;

import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.belavia.driver.DriverSingleton;
import by.htp.belavia.entitis.Order;
import by.htp.belavia.menu.MainMenu;
import by.htp.belavia.pages.CalendarTariffsPage;
import by.htp.belavia.pages.DayChoosePage;
import by.htp.belavia.pages.SearchPage;

public class StepsTwoWay {

	private List<Order> orderList;
	private GregorianCalendar dayDeparture;

	WebDriver driver = DriverSingleton.getDriver();

	String startPage = "https://booking.belavia.by";

	SearchPage searchPage = new SearchPage(driver);

	CalendarTariffsPage calTariff = new CalendarTariffsPage(driver);

	DayChoosePage dayChoosePage = new DayChoosePage(driver);

	public StepsTwoWay(List<Order> orderList) {
		super();
		this.orderList = orderList;

	}

	public void startSearch(String url) {
		searchPage.openPage(url);
		searchPage.enterPlacelaunch("Минск");
		searchPage.EnterDestinationLocation("Рига");
		searchPage.chooseDateReturn();
		searchPage.chooseDatePlacelaunch();
		
		searchPage.twoWaySubmit();

	}

	public void CalendarTariffs() {

		boolean endWeak = true;

		calTariff.goToCalendarTariffs();
		while (endWeak) {
			List<WebElement> elements = calTariff.findElementsTwoWayCalendar();

			dayDeparture = calTariff.choiceDayOneWayCalendar(elements);
			if (MainMenu.finishDay.equals(dayDeparture)) {

				endWeak = false;
			}

			List<WebElement> dayticketList = dayChoosePage.getClassOutFly();
	
			
			for (WebElement element : dayticketList) {

				String dateFly = dayChoosePage.getDepartureTime();

				dayChoosePage.chooseCreateOrderTwoFly(element, dayDeparture, dateFly, orderList);
			}

			calTariff.goToCalendarTariffs();

		}
	}
	
}
