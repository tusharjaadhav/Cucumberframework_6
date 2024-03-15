package Vtiger;

import Common.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends PageActions {



    public Loginpage(WebDriver driver)
    {
       super(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(name = "user_name")
    WebElement tb_username;

    @FindBy(xpath = "//*[@name=\"user_password\"]")
    WebElement tb_password;

    @FindBy (name = "Login")
    WebElement btn_login;

    @FindBy ( linkText = "//*[contains(text(),'You must specify a valid username and password.')]")
    WebElement texterrormsg;

    public void login( String userid, String password)
    {
        Inputtext(tb_username, userid);
        Clickelemnt(btn_login);

    }

    public void setuserid(String userid)
    {

        Inputtext(tb_username, userid);
    }

    public void setpassword(String password)
    {

        Inputtext(tb_password, password);
    }

    public void Clicklogin()
    {

        Clickelemnt(btn_login);
    }

    public void VerifyErrorMsg()
    {
        Elementexist(texterrormsg);
    }

}
