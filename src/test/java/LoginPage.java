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

    private final By areaCodeBy = By.xpath("//div[@class='adatlap-form-container']//input[@name='korzetszam']");
    private final By telNumBy = By.xpath("//div[@class='adatlap-form-container']//input[@name='telefonszam']");

    private final By saveDataBtnBy = By.xpath("//div[@class='adatlap-form-container']//button[contains(text(),'Alapadatok ment')]");

    public LoginPage(WebDriver driver) 
    {
        super(driver);
        this.driver.get(getBaseUrl() + "auth/login");
    }

    public void runPageTests()
    {
        testLoggedOut();

        login();

        testLoggedIn();

        sendForm();

        logout();

        testLoggedOut();
    }

    private void login()
    {
        WebElement unameElement = waitAndReturnElement(emailInputBy);
	    WebElement passwordElement = waitAndReturnElement(pwInputBy);
        
        unameElement.sendKeys("balazs.balint413@gmail.com");
	    passwordElement.sendKeys("k.y!5wkDrZjfGp7");

        WebElement loginButton = waitAndReturnElement(logintBtnBy);
        loginButton.click();
    }

    private void logout()
    {
        WebElement profileBtn = waitAndReturnElement(profileBtnBy);
        profileBtn.click();

        WebElement logoutBtn = waitAndReturnElement(logoutBtnBy);
        logoutBtn.click();
    }

    private void sendForm()
    {
        String areaCode = "30";
        String telNum = "1234455";

        this.driver.get(getBaseUrl() + "/ugyfelkapu/alapadatok.html");

        WebElement areaCodeInput = waitAndReturnElement(areaCodeBy);
        WebElement telNumInput = waitAndReturnElement(telNumBy);
        WebElement saveDataBtn = waitAndReturnElement(saveDataBtnBy);

        areaCodeInput.sendKeys(areaCode);
        telNumInput.sendKeys(telNum);
        saveDataBtn.click();
    }

    private void testLoggedOut()
    {
        WebElement profileBtn = waitAndReturnElement(profileBtnBy);
        Assert.assertTrue(profileBtn.getText().contains("Bejelentkez"));
    }

    private void testLoggedIn()
    {
        WebElement profileBtn = waitAndReturnElement(profileBtnBy);
        Assert.assertTrue(profileBtn.getText().contains("Profilom"));
    }
}
