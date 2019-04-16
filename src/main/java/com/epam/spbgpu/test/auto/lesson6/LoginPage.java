package com.epam.spbgpu.test.auto.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.assertEquals;

public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameTextField.sendKeys(username);
        loginButton.click();
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void shouldHaveTitle(String title) {
//        assertTrue(true);
        assertEquals(driver.getTitle(), title);
    }
}
