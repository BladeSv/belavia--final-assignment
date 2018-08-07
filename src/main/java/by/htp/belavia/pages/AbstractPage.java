package by.htp.belavia.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

	protected WebDriver driver;

	public abstract void openPage(String url);

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
}
