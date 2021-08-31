package com.weborders.step_definitions;

import com.weborders.pages.HomePage;
import com.weborders.pages.LoginPage;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
//    instance = object

    @Given("user is homepage")
    public void user_is_homepage() {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
    }

    @When("user clicks on login")
    public void user_clicks_on_login() {
        WebElement login = Driver.getDriver().findElement(By.className("secondary-menu-label"));
        //xpath//span[.='Login']
        login.click();
    }
    @Then("user should see Login page opened")
    public void user_should_see_login_page_opened() {

    }










}