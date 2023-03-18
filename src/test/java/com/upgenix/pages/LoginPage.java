package com.upgenix.pages;

import com.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

        public LoginPage(){

                PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(css = "input#login")
        public WebElement emailInput;

        @FindBy(css = "input#password")
        public WebElement passwordInput;

        @FindBy(xpath = "//button[.='Log in']")
       public WebElement loginBtn;

        @FindBy(css = "p.alert.alert-danger")
        public WebElement wrongLoginMsg;



 }
