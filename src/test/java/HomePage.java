import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

class HomePage extends PageBase
{
	private final By offerDivBy = By.className("ajanlatframe");

	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver.get(getBaseUrl());
	}

	String getOfferHTML()
	{
		WebElement offerDiv = waitAndReturnElement(offerDivBy);
		return offerDiv.getAttribute("innerHTML");
	}

	void performHovers()
	{
		By mainCategoryBy = By.xpath("//div[@class='container']//a[@href='/kategoriak.html']");
		By subCategoryLeftSideBy = By.xpath("//div[@class='main_category_dropdown_left']//div[@data-id='8']//span[text()='Gaming, E-sport']");
		By subCategoryRightSideBy = By.xpath("//div[@class='main_category_dropdown_right']//div[@data-id='8']//a[@href='/termekek/mikrofon-602.html']");

		Actions actions = new Actions(this.driver);

		// perform first hover
		WebElement mainCategory = waitAndReturnElement(mainCategoryBy);
		actions.moveToElement(mainCategory).build().perform();

		// perform second hover
		WebElement subCategoryLeft = waitAndReturnElement(subCategoryLeftSideBy);
		actions.moveToElement(subCategoryLeft).build().perform();

		// find the element and click it
		WebElement subCategoryRight = waitAndReturnElement(subCategoryRightSideBy);
		subCategoryRight.click();
	}
}