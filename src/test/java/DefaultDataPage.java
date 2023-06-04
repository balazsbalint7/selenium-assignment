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


class DefaultDataPage extends PageBase 
{
	private final String areaCode = "30";
	private final String telNum = "1234455";

	private final By areaCodeBy = By.xpath("//div[@class='adatlap-form-container']//input[@name='korzetszam']");
	private final By telNumBy = By.xpath("//div[@class='adatlap-form-container']//input[@name='telefonszam']");

	private final By saveDataBtnBy = By.xpath("//div[@class='adatlap-form-container']//button[contains(text(),'Alapadatok ment')]");

	private final String urlSuffix = "/ugyfelkapu/alapadatok.html";

	public DefaultDataPage(WebDriver driver)
	{
		super(driver);
	}

	public void sendForm()
	{
		setAddress(urlSuffix);
		
		WebElement areaCodeInput = waitAndReturnElement(areaCodeBy);
		WebElement telNumInput = waitAndReturnElement(telNumBy);
		WebElement saveDataBtn = waitAndReturnElement(saveDataBtnBy);

		areaCodeInput.sendKeys(areaCode);
		telNumInput.sendKeys(telNum);
		saveDataBtn.click();
	}

	public void runTitleTest()
	{
		setAddress(urlSuffix);
		
		Assert.assertTrue(getTitle().contains("Alapadatok"));
	}
}
