import org.junit.*;
import org.openqa.selenium.WebDriver;

class StaticPage extends PageBase
{
    private final String titleToCheck;
    private final String url;

    public StaticPage(WebDriver driver, String url, String titleToCheck)
	{
        super(driver);
        this.titleToCheck = titleToCheck;
    }

    void runDefaultTest()
    {
        Assert.assertTrue(getTitle().contains(titleToCheck));
    }
}