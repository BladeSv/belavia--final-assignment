package by.htp.belavia.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.belavia.menu.MainMenu;

public class CalendarTariffsPage extends AbstractPage {
	private GregorianCalendar startDay = new GregorianCalendar();
	private GregorianCalendar finishDay = new GregorianCalendar();
	private GregorianCalendar dayDeparture = new GregorianCalendar();
	private GregorianCalendar dayReturn = new GregorianCalendar();
	private SimpleDateFormat sf = new SimpleDateFormat("yy-MM-dd");

	Set<GregorianCalendar> chechedDate = new HashSet<>();

	public CalendarTariffsPage(WebDriver driver) {
		super(driver);

	}

	public CalendarTariffsPage(WebDriver driver, GregorianCalendar finishDay) {
		super(driver);

		this.finishDay = finishDay;
	}

	public GregorianCalendar getStartDay() {
		return startDay;
	}

	public void setStartDay(GregorianCalendar startDay) {
		this.startDay = startDay;
	}

	public GregorianCalendar getFinishDay() {
		return finishDay;
	}

	public void setFinishDay(GregorianCalendar finishDay) {
		this.finishDay = finishDay;
	}

	

	private By chooseCalendarTariffs = By.xpath("//*[@id='outbound']//a");
	private By findsElemensOnOneWay = By.xpath("//*[@class='one-way']//div[@class='details']//input");
	private By findsElemensOnTwoWay = By.xpath("//div[@id='matrix']//div[@class='price']//input");

	private String findLabelByIdStart = "//label[@for='";
	private String findLabelByIdEnd = "']";

	private WebDriverWait wait = new WebDriverWait(driver, 20);

	@Override
	public void openPage(String url) {
		driver.get(url);

	}

	public void goToCalendarTariffs() {
		try {
			new Thread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		WebElement element = driver.findElement(chooseCalendarTariffs);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));

		element.click();

	}

	public List<WebElement> findElementsOneWayCalendar() {
		List<WebElement> elemets = driver.findElements(findsElemensOnOneWay);
		return elemets;

	}
	public List<WebElement> findElementsTwoWayCalendar() {
		List<WebElement> elemets = driver.findElements(findsElemensOnTwoWay);
		return elemets;

	}
	

	public GregorianCalendar choiceDayOneWayCalendar(List<WebElement> elements) {
		for (WebElement elemet : elements) {
			String value = elemet.getAttribute("value");

			String id = elemet.getAttribute("id");

			try {
				dayDeparture.setTime(sf.parse(value));
			} catch (ParseException e) {
				System.out.println("Incorrect Date formate");
				e.printStackTrace();
			}

			if (((dayDeparture.before(MainMenu.finishDay)) && (!chechedDate.contains(dayDeparture))
					&& (dayDeparture.after(MainMenu.starstDay))) || (dayDeparture.equals(MainMenu.finishDay))) {

				try {
					new Thread();
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				WebElement labelClick = driver.findElement(By.xpath(findLabelByIdStart + id + findLabelByIdEnd));

				wait.until(ExpectedConditions.elementToBeClickable(labelClick));

				labelClick.click();

				elemet.submit();
				chechedDate.add(dayDeparture);
				return dayDeparture;
			}

		}
		return null;

	}
	
	public GregorianCalendar choiceDayTwoWayCalendar(List<WebElement> elements) {
		
		for (WebElement elemet : elements) {
			
			String value = elemet.getAttribute("value");

			String id = elemet.getAttribute("id");	
			String[] daysFly=value.split(":");
			try {
				dayDeparture.setTime(sf.parse(daysFly[0]));
			} catch (ParseException e) {
				System.out.println("Incorrect Date formate");
				e.printStackTrace();
			}
			try {
				dayReturn.setTime(sf.parse(daysFly[1]));
			} catch (ParseException e) {
				System.out.println("Incorrect Date formate");
				e.printStackTrace();
			}
			dayReturn.add(Calendar.DAY_OF_MONTH, -1);
			if(dayDeparture.equals(dayReturn)) {
			
				if (((dayDeparture.before(MainMenu.finishDay)) && (!chechedDate.contains(dayDeparture))
						&& (dayDeparture.after(MainMenu.starstDay))) || (dayDeparture.equals(MainMenu.finishDay))) {

					try {
						new Thread();
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					WebElement labelClick = driver.findElement(By.xpath(findLabelByIdStart + id + findLabelByIdEnd));

					wait.until(ExpectedConditions.elementToBeClickable(labelClick));

					labelClick.click();

					elemet.submit();
					chechedDate.add(dayDeparture);
					return dayDeparture;
				}
				
				
				
				
				
				
				
				
				
			}
			
			
			
		}
		return null;
	}
	
	
	
	
	
	

	public boolean checkEndWeek(WebElement elemet) {
		String id = elemet.getAttribute("id");
		if (id.equals("LowFareMatrixDataModels_6__0_")) {
			return false;
		}
		return true;
	}
}
