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

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
    }
    @When("user searches {string}")
    public void user_searches(String string) {
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("Open Lending"+ Keys.ENTER);
    }

    @Then("user clicks on {string}")
    public void user_clicks_on(String string) {
        JavascriptExecutor jsx = (JavascriptExecutor)Driver.getDriver();
        jsx.executeScript("window.scrollBy(0,700)", "");

        WebElement destination = Driver.getDriver().findElement(By.xpath("//h3[.='Open Lending | LinkedIn']"));

        destination.click();
    }
    @Then("user enters valid credentials")
    public void user_enters_valid_credentials() {
          loginPage.login();
    }

    @Then("user should see Open Lending Linkedn Title")
    public void user_should_see_open_lending_linkedn_title() {

        WebElement openLending = Driver.getDriver().findElement(By.xpath("//p[@class='org-top-card-summary__tagline t-16 t-black']"));

        Assert.assertEquals("Verification Passed", openLending.getText(), "Say YES to more automotive loans.");
    }






}