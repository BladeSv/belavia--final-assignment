package by.htp.belavia.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends AbstractPage {

	WebDriverWait wait =new WebDriverWait(driver, 10);
	private By findEnterPlacelaunch = By.xpath("//*[@id='OriginLocation_Combobox']");
	
	private By findEnterDestinationLocation = By.xpath("//*[@id='DestinationLocation_Combobox']");
	private By choosePlacelaunch = By.xpath("//*[@id='ui-id-2']//a");
	private By chooseDestinationLocation = By.xpath("//*[@id='ui-id-3']//a");

	private By chooseRadioButtenOneWay = By.xpath("//*[@id='ibe']/div/form/div[2]/div/label[1]");
	private By findCalendarPlacelaunch = By.xpath("//*[@id='ibe']/div/form/div[3]/div[1]/div/a");
	private By findCalendarReturn = By.xpath("//*[@id='ibe']/div/form/div[3]/div[2]/div/a");
	private By chooseDatePlacelaunch = By.xpath("//*[@id='datepicker']/div/div[1]/table/tbody//td[a=15]");
	private By chooseDateReturn = By.xpath("//*[@id='datepicker']/div/div[1]/table/tbody//td[a=16]");
	public SearchPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public void openPage(String url) {
		driver.get(url);

	}

	public void enterPlacelaunch(String from) {
		WebElement element = driver.findElement(findEnterPlacelaunch);
		element.sendKeys(from);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dumpingPoint = driver.findElement(choosePlacelaunch);
		dumpingPoint.click();
	}

	public void EnterDestinationLocation(String where) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(findEnterDestinationLocation);
		element.sendKeys(where);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dumpingPoint = driver.findElement(chooseDestinationLocation);
		dumpingPoint.click();

	}

	public void chooseRadioButtenOneWay() {
		WebElement element = driver.findElement(chooseRadioButtenOneWay);
		element.click();

	}

	public void chooseDatePlacelaunch() {
		WebElement element = driver.findElement(findCalendarPlacelaunch);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element2 = driver.findElement(chooseDatePlacelaunch);
		element2.click();
		//element.submit();

	}
	public void chooseDateReturn() {
	
		WebElement element = driver.findElement(findCalendarReturn);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element2 = driver.findElement(chooseDateReturn);
		wait.until(ExpectedConditions.elementToBeClickable(element2));
		element2.click();
		element.submit();

	}

	public void oneWaySubmit() {
		WebElement element = driver.findElement(findCalendarPlacelaunch);
		element.submit();
	}
	public void twoWaySubmit() {
		WebElement element = driver.findElement(findCalendarReturn);
		element.submit();
	}
}
