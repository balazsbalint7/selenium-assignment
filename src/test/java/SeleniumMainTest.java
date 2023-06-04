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
    public void testLoginPage() // login, send a form, logout
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

	@Test
	public void testHomePage() // test a static webpage
	{
		HomePage homePage = new HomePage(this.driver.getDriver());

		Assert.assertTrue(homePage.getTitle().contains("AQUA"));
		String offerStr = homePage.getOfferHTML();

		Assert.assertFalse(offerStr.isEmpty());
		Assert.assertTrue(offerStr.contains("price"));

		Assert.assertTrue(homePage.getBodyText().contains("100%-ban magyar tulajdon"));
	}

	@Test
	public void testMultipleStaticPage()
	{
		StaticPageConfig multiplePages[] = 
		{
			new StaticPageConfig("jatekok/gran-turismo-sport-playstation-hits-ps4-t863687", "Gran Turismo Sport", By.xpath("//section[@class='product']//a[@data-fancybox='gallery']")),
			new StaticPageConfig("top_eladasok.html", "Top", By.xpath("//div[@id='insideWrapper']//section[@id='top_eladasok']//h1")),
			new StaticPageConfig("alkatreszek/cooler-master-600w-elite-v3-series-tapegyseg-mpw-6001-acabn1-eu-t607884", "Cooler Master 600W",  By.xpath("//section[@class='product_details']//div[@class='product_specifications']"))
		};

		for (StaticPageConfig conf : multiplePages)
		{
			StaticPage page = new StaticPage(driver.getDriver(), conf.url);
			page.setElementBy(conf.pageElement);

			Assert.assertTrue(page.getTitle().contains(conf.titleValue));
			Assert.assertFalse(page.getHTML().isEmpty());
		}
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
