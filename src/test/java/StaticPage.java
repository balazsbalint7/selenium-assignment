import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

class StaticPage extends PageBase
{
	private final String url;

	private By elementBy;

	public StaticPage(WebDriver driver, String url)
	{
		super(driver);
		this.url = getBaseUrl() + url;
		
		this.driver.get(this.url);
	}

	public void setElementBy(By input)
	{
		this.elementBy = input;
	}

	public String getHTML()
	{
		this.driver.get(url);

		if (elementBy == null)
		{
			return new String();
		}
		
		WebElement pageElement = waitAndReturnElement(elementBy);
		return pageElement.getAttribute("innerHTML");
	}
}