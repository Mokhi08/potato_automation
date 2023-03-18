package com.upgenix.step_definitions;

import com.upgenix.pages.LoginPage;
import com.upgenix.utilities.ConfigurationReader;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class login_stepDefinitions {

 LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user enters valid username {string}")
    public void user_enters_valid_username(String string) {

       loginPage.emailInput.sendKeys(string);

    }
    @When("user enters valid password {string}")
    public void user_enters_valid_password(String string) {

       loginPage.passwordInput.sendKeys(string);
    }
    @When("user clicks the login button")
    public void user_clicks_the_login_button() {

       loginPage.loginBtn.click();
    }
    @Then("user should be on the homepage")
    public void user_should_be_on_the_homepage() {

       String expectedTitle = "#Inbox - Odoo";
       String actualTitle = Driver.getDriver().getTitle();
       Assert.assertTrue(actualTitle.contains("Odoo"));


    }




   
    @When("user enters invalid password {string}")
    public void user_enters_invalid_password(String string) {

       loginPage.passwordInput.sendKeys(string);
    }

    @Then("user should see Wrong login\\/password message")
    public void user_should_see_wrong_login_password_message() {

       String expectedMsg = "Wrong login/password";
       String actualMsg = loginPage.wrongLoginMsg.getText();
       Assert.assertEquals(expectedMsg, actualMsg);

    }




    @When("user enters invalid username {string}")
    public void user_enters_invalid_username(String string) {

       loginPage.emailInput.sendKeys(string);
    }





    @When("username input box is empty")
    public void username_input_box_is_empty() {

       loginPage.emailInput.sendKeys("");
    }
    @When("user enters password {string} in the password input box")
    public void user_enters_password_in_the_password_input_box(String string) {

       loginPage.passwordInput.sendKeys(string);
    }

    @Then("user should see Please fill out this field message")
    public void user_should_see_please_fill_out_this_field_message() {


      Assert.assertTrue(loginPage.emailInput.getText().isEmpty());

       boolean hasRequired = Boolean.parseBoolean(loginPage.emailInput.getAttribute("required"));
       Assert.assertTrue(hasRequired);

       String validationMsg = loginPage.emailInput.getAttribute("validationMessage");
       Assert.assertEquals(validationMsg, "Please fill in this field.");

    }

    @When("user enters username {string} in username input box")
    public void user_enters_username_in_username_input_box(String string) {

       loginPage.emailInput.sendKeys(string);
    }
    @When("leaves password input box is empty")
    public void leaves_password_input_box_is_empty() {

       loginPage.passwordInput.sendKeys("");
    }
    @Then("user clicks login button")
    public void user_clicks_login_button() {

       loginPage.loginBtn.click();
    }

   @Then("user should see Please fill out this field message for empty password")
   public void userShouldSeePleaseFillOutThisFieldMessageForEmptyPassword() {


      Assert.assertTrue(loginPage.passwordInput.getText().isEmpty());

      boolean required = Boolean.parseBoolean(loginPage.passwordInput.getAttribute("required"));
      Assert.assertTrue(required);

      String validationMsg = loginPage.passwordInput.getAttribute("validationMessage");
       System.out.println(validationMsg);
      Assert.assertEquals( "Please fill in this field.", validationMsg);
   }



    @Given("user types password {string} into the password input box")
    public void user_types_password_into_the_password_input_box(String string) {

       loginPage.passwordInput.sendKeys(string);
    }
    @Then("user should see bullet signs by default")
    public void user_should_see_bullet_signs_by_default() {

       if(loginPage.passwordInput.getAttribute("type").equals("password")){
          Assert.assertTrue(true);
       }else {
          Assert.assertTrue(false);
       }

    }




    @Given("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String string, String string2) {

       loginPage.emailInput.sendKeys(string);
       loginPage.passwordInput.sendKeys(string2);
    }
    @Then("user press Enter from keyboard")
    public void user_press_enter_from_keyboard() {

       loginPage.loginBtn.sendKeys(Keys.ENTER);

    }
    @Then("user should be landed on the homepage")
    public void user_should_be_landed_on_the_homepage() {

       WebElement searchBoxHomePage = Driver.getDriver().findElement(By.cssSelector("input.o_searchview_input"));
       Assert.assertTrue(searchBoxHomePage.isDisplayed());
    }



}
