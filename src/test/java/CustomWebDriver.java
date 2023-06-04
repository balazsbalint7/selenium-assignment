import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.CapabilityType;
import java.util.logging.*;
import java.util.*;

import java.net.URL;
import java.net.MalformedURLException;

public class CustomWebDriver 
{
    public ChromeOptions options;
    public URL url;

    public WebDriver driver;

    public CustomWebDriver() throws MalformedURLException
	{
		options = new ChromeOptions();
        url = new URL("http://selenium:4444/wd/hub");
        
        // custom options
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-sandbox");  
        options.addArguments("--disable-dev-shm-usage");  

        // performance logging
        LoggingPreferences loggingPrefs = new LoggingPreferences();
        loggingPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        options.setCapability(CapabilityType.LOGGING_PREFS, loggingPrefs);

        driver = new RemoteWebDriver(url, options);
        driver.manage().window().maximize();
	}

    public WebDriver getDriver()
    {
        return driver;
    }
}