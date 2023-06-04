import org.openqa.selenium.By;

class StaticPageConfig
{
    public final String url;
    public final String titleValue;
    public final By pageElement;

    public StaticPageConfig(String url, String titleValue, By pageElement)
    {
        this.url = url;
        this.titleValue = titleValue;
        this.pageElement = pageElement;
    }
}