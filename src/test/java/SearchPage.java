import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.*;

class SearchPage extends PageBase
{
    private final String url = "kereses.html";

    private final By searchInputBy = By.xpath("//div[@class='search_bar']//div[@class='input_container']//input");
    private final By searchBtnBy = By.xpath("//div[@class='search_bar']//div[@class='input_container']//span[@id='search']");

    public SearchPage(WebDriver driver)
	{
        super(driver);
        setAddress(url);
    }

    public String searchForInput(String input)
    {
        WebElement searchInput = waitAndReturnElement(searchInputBy);
        searchInput.sendKeys(input);

        WebElement searchBtn = waitAndReturnElement(searchBtnBy);
        searchBtn.click();

        return driver.getCurrentUrl();
    }
}