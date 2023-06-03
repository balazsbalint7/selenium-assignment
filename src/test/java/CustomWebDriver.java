import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;

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
        _options.addArguments("start-maximized");
        _options.addArguments("--ignore-certificate-errors");
        _options.addArguments("--disable-popup-blocking");

        _driver = new RemoteWebDriver(_url, _options);
        _driver.manage().window().maximize();
	}

    public WebDriver getDriver()
    {
        return _driver;
    }
}