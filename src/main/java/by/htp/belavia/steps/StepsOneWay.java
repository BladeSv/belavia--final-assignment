package by.htp.belavia.steps;

import org.openqa.selenium.WebDriver;

import by.htp.belavia.driver.DriverSingleton;
import by.htp.belavia.pages.SearchPage;

public class StepsOneWay {
	WebDriver driver=DriverSingleton.getDriver();
	
	
	
		SearchPage searchPage =new SearchPage(driver);
		
		public void startSearch() {
			searchPage.openPage();
			searchPage.enterPlacelaunch("Минск");
			searchPage.EnterDestinationLocation("Рига");
			searchPage.chooseRadioButtenOneWay();
			searchPage.chooseDatePlacelaunch();
			searchPage.goToCalendarTariffs();
			
			
		}
		
		
}
