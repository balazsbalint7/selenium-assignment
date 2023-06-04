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
    public CustomWebDriver driver;
    
    @Before
    public void setup() throws MalformedURLException
	{
        driver = new CustomWebDriver();
    }
    
    @Test
    public void testLoginPage()
	{
        LoginPage loginPage = new LoginPage(this.driver.getDriver());
		DefaultDataPage dataPage = new DefaultDataPage(this.driver.getDriver());

        loginPage.testLogged(false);

        loginPage.login();

        loginPage.testLogged(true);

		dataPage.runTitleTest();
        dataPage.sendForm();

        loginPage.logout();

        loginPage.testLogged(false);
    }
    
    @After
    public void close()
    {
        if (driver != null && driver.getDriver() != null)
		{
            driver.getDriver().quit();
        }
    }
}
