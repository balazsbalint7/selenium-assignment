import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


import java.awt.Robot;
import java.awt.event.InputEvent;

abstract class PageBase
{
	protected WebDriver driver;
	protected WebDriverWait wait;

	protected String _pageUrl = "https://aqua.hu/";

	public PageBase(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	protected WebElement waitAndReturnElement(By locator)
	{
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return this.driver.findElement(locator);
	}

	// In the main test class, you have to run this class only
	public abstract void runPageTests();

	public String getBaseUrl()
	{
		return _pageUrl;
	}

	public String getBodyText()
	{
		WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
		return bodyElement.getText();
	}
}
