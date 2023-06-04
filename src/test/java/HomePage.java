import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
}