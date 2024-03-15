package Vtiger;

import Common.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leadpage extends PageActions {
    public Leadpage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(linkText = "New Lead")
    WebElement lnk_NewLead;

    @FindBy(linkText = "Leads")
    WebElement lnk_leads;

    @FindBy(name = "firstname")
    WebElement tb_firstname;
    @FindBy(name = "lastname")
    WebElement tb_lastname;

    @FindBy(name = "company")
    WebElement tb_company;

    @FindBy(name = "button")
    WebElement btn_save;

    public void login(String lname, String company, String firstname )
    {
        setfirstname(firstname);
        setlastname(lname);
        setcompany(company);
        Clicksavebutton();
    }

    public void setfirstname(String fname)
    {

        Inputtext(tb_firstname, fname);
    }
    public void setlastname(String lname)
    {

        Inputtext(tb_lastname, lname);
    }

    public void setcompany(String company)
    {

        Inputtext(tb_company, company);
    }

    public void Clicksavebutton()
    {

        Clickelemnt(btn_save);
    }

    public void Clicknewlead()
    {

        Clickelemnt(lnk_NewLead);
    }

}
