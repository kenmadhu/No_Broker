package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
 
public class LoginPage extends BasePage{
 
    //Constructor
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
 
    //Web Elements
    By firstnameBy = By.id("firstName");
    By lastnameBy = By.id("lastName");
    By emailBy= By.id("mail");
    By passwordBy = By.id("newPasswordInput");
    By reenterpassswordBy = By.id("retypeNewPasswordInput");
 
    //Page Methods
 
    public LoginPage loginToN11 (String fisrtname, String lastname){
        //Enter Username(Email)
        writeText(firstnameBy,fisrtname);
        //Enter Password
        writeText(lastnameBy, lastname);
        //Click Login Button
        click(loginButtonBy);
        return this;
    }
 
    //Verify Username Condition
    public LoginPage verifyUserName (String expectedText) {
        assertEquals(errorMessageUsernameBy, expectedText);
        return this;
    }
 
    //Verify Password Condition
    public LoginPage verifyPassword (String expectedText) {
        assertEquals(errorMessagePasswordBy, expectedText);
        return this;
    }
}