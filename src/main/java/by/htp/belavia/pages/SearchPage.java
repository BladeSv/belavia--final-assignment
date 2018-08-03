package by.htp.belavia.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends AbstractPage{

	
	
	private By findEnterPlacelaunch= By.xpath("//*[@id='OriginLocation_Combobox']");
	private By findEnterDestinationLocation= By.xpath("//*[@id='DestinationLocation_Combobox']");
	private By choosePlacelaunch= By.xpath("//*[@id='ui-id-2']//a");
	private By chooseDestinationLocation= By.xpath("//*[@id='ui-id-3']//a");
	
	private By chooseRadioButtenOneWay= By.xpath("//*[@id='ibe']/div/form/div[2]/div/label[1]");
	private By findCalendarPlacelaunch= By.xpath("//*[@id='ibe']/div/form/div[3]/div[1]/div/a");
	private By chooseDatePlacelaunch=By.xpath("//*[@id='datepicker']/div/div[1]/table/tbody//td[a=15]");
	private By chooseCalendarTariffs=By.xpath("//*[@id='outbound']/div[1]/div/div[2]/a");
	
	
	
	
	
	
	public SearchPage(WebDriver driver) {
		super(driver);
	
	}

	@Override
	public void openPage() {
		driver.get("https://booking.belavia.by");
		
	}

	public void enterPlacelaunch(String from) {
		WebElement element =driver.findElement(findEnterPlacelaunch);
		element.sendKeys(from);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dumpingPoint=driver.findElement(choosePlacelaunch);
		dumpingPoint.click();
	}
	
	public void EnterDestinationLocation(String where ) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element =driver.findElement(findEnterDestinationLocation);
		element.sendKeys(where);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dumpingPoint=driver.findElement(chooseDestinationLocation);
		dumpingPoint.click();
		
	}
	public void chooseRadioButtenOneWay() {
		WebElement element =driver.findElement(chooseRadioButtenOneWay);
		element.click();
		
	}
	public void chooseDatePlacelaunch() {
		WebElement element =driver.findElement(findCalendarPlacelaunch);
		element.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element2 =driver.findElement(chooseDatePlacelaunch);
		element2.click();
		element.submit();
		
	}
	public void goToCalendarTariffs() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element= driver.findElement(chooseCalendarTariffs);
		element.click();
		
	}
}
