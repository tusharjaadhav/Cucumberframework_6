package Stepdefination;

import Vtiger.Homepage;
import Vtiger.Leadpage;
import Vtiger.Loginpage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class Vtigerlogin extends BaseDefination {


    @Before
    public void getTcnName(Scenario scenario)
    {
        TCName = scenario.getName();
    }

    @Given("user should be on login page")
    public void user_should_be_on_login_page() throws Exception {
        initiation();
    }

    @When("User enter valid user ID and Valid Password")
    public void user_enter_valid_user_id_and_valid_password()
    {
        Lp.setuserid("admin");
        Lp.setpassword("admin");
    }

    @When("Click on login button")
    public void click_on_login_button()
    {
      Lp.Clicklogin();
    }

    @Then("User should be navigate to home page")
    public void user_should_be_navigate_to_home_page()
    {
        driver.findElement(By.linkText("Home")).isDisplayed();
    }

    @Then("Logout link should appear on home page")
    public void logout_link_should_appear_on_home_page() {
        driver.findElement(By.linkText("Logout")).isDisplayed();
    }

    @When("user enter invalid credentials")
    public void user_enter_invalid_credentials() {
        Lp.setuserid(data.get(TCName).get("UserID"));
        Lp.setpassword(data.get(TCName).get("Password"));
        Lp.Clicklogin();

    }
    @Then("User can see error message")
    public void user_can_see_error_message()
    {
        Lp.VerifyErrorMsg();
    }

    @Given("user can validate logo on login page")
    public void user_can_validate_logo_on_login_page() {
        driver.findElement(By.xpath("//*[@src=\"include/images/vtiger-crm.gif\"]")).isDisplayed();
    }

    @When("user enter invalid user id as {string} and invalid password as {string}")
    public void user_enter_invalid_user_id_as_and_invalid_password_as(String username, String password)
    {
        Lp.setuserid(username);
        Lp.setpassword(password);
        Lp.Clicklogin();

    }

    @When("Create multiple lead with firstname as {string} and last name as {string} and company name as {string}")
    public void create_multiple_lead_with_firstname_as_and_last_name_as_and_company_name_as(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable)
    {
        List<Map<String,String>> dt = dataTable.asMaps();
        for (Map<String,String> m:dt)
        {
            Ldp.Clicknewlead();
            Ldp.setfirstname(m.get("fname"));
           Ldp.setlastname(m.get("Lname"));
            Ldp.setcompany(m.get("Company"));

        }

    }
    @When("Logout and close the browser")
    public void logout_and_close_the_browser()
    {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

}
