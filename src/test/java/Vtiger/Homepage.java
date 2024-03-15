package Vtiger;

import Common.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends PageActions {


    public Homepage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Logout")
    WebElement lnk_logout;

    @FindBy(xpath = "//*[@name=\"user_password\"]")
    WebElement tb_password;

    public void Logout()
    {

        Clickelemnt(lnk_logout);
    }

    public void Verifylogut()
    {

        Elementexist(lnk_logout);
    }


}
