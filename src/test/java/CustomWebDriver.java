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
    public ChromeOptions _options;
    public URL _url;

    public WebDriver _driver;

    public CustomWebDriver() throws MalformedURLException
	{
		_options = new ChromeOptions();
        _url = new URL("http://selenium:4444/wd/hub");
        
        // custom options
        _options.addArguments("--start-maximized");
        _options.addArguments("--ignore-certificate-errors");
        _options.addArguments("--disable-popup-blocking");
        _options.addArguments("--no-sandbox");  
        _options.addArguments("--disable-dev-shm-usage");  
        
        // performance logging
        LoggingPreferences loggingPrefs = new LoggingPreferences();
        loggingPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        _options.setCapability(CapabilityType.LOGGING_PREFS, loggingPrefs);

        _driver = new RemoteWebDriver(_url, _options);
        _driver.manage().window().maximize();
	}

    public WebDriver getDriver()
    {
        return _driver;
    }
}