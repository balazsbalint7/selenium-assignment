import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  

import java.net.URL;
import java.net.MalformedURLException;

public class SeleniumMainTest
{
    public CustomWebDriver _driver;
    
    @Before
    public void setup() throws MalformedURLException
	{
        _driver = new CustomWebDriver();
        // ChromeOptions options = new ChromeOptions();
        // driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        // driver.manage().window().maximize();
    }
    
    @Test
    public void testLoginPage() {
        LoginPage loginPage = new LoginPage(this._driver.getDriver());

        loginPage.runPageTests();
    }
    
    @After
    public void close()
    {
        if (_driver != null && _driver.getDriver() != null)
		{
            _driver.getDriver().quit();
        }
    }
}
