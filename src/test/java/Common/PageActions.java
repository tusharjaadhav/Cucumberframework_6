package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActions {

    public WebDriver driver;
    public WebDriverWait wait;

    public PageActions(WebDriver driver)
    {
        this.driver = driver;
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void Inputtext(WebElement elm, String value)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(value);

        }
        catch (Exception ignored)
        {
          ignored.printStackTrace();
        }
    }
    public void Clickelemnt(WebElement elm)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();

        }
        catch (Exception ignored)
        {
            ignored.printStackTrace();
        }
    }

    public void Elementexist(WebElement elm)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();

        }
        catch (Exception ignored)
        {
            ignored.printStackTrace();
        }
    }

}

