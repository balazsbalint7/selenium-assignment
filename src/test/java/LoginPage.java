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

import java.util.concurrent.TimeUnit;

class LoginPage extends PageBase 
{
    private final By emailInputBy = By.xpath("//form[@action='/auth/login']//input[@name='l-email']");
    private final By pwInputBy = By.xpath("//form[@action='/auth/login']//input[@name='l-password']");

    private final By logintBtnBy = By.xpath("//form[@action='/auth/login']//button[contains(text(),'Bejelentkez')]");
    private final By logoutBtnBy = By.xpath("//div[@class='customer_portal_menu']//a[@href='/auth/logout']");

    private final By profileBtnBy = By.xpath("//div[@class='profile']//span[@class='btn_title']");

    private final String urlSuffix = "auth/login";

    public LoginPage(WebDriver driver) 
    {
        super(driver);
    }

    public void login()
    {
        setAddress(urlSuffix);

        WebElement unameElement = waitAndReturnElement(emailInputBy);
	    WebElement passwordElement = waitAndReturnElement(pwInputBy);
        
        unameElement.sendKeys("balazs.balint413@gmail.com");
	    passwordElement.sendKeys("k.y!5wkDrZjfGp7");

        WebElement loginButton = waitAndReturnElement(logintBtnBy);
        loginButton.click();
    }

    public void logout()
    {
        setAddress(urlSuffix);

        WebElement profileBtn = waitAndReturnElement(profileBtnBy);
        profileBtn.click();

        WebElement logoutBtn = waitAndReturnElement(logoutBtnBy);
        logoutBtn.click();
    }

    public void testLogged(boolean loggedIn)
    {
        setAddress(urlSuffix);

        WebElement profileBtn = waitAndReturnElement(profileBtnBy);
        if (loggedIn)
        {
            Assert.assertEquals("Profilom", profileBtn.getText());
        }
        else
        {
            Assert.assertTrue(getTitle().contains("Bejelentkez") && getTitle().contains("regiszt"));
            Assert.assertTrue(profileBtn.getText().contains("Bejelentkez"));
        }
    }
}
