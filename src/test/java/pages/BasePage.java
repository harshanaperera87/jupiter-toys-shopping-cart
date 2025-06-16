package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 40);
        PageFactory.initElements(factory,this);
    }

}
