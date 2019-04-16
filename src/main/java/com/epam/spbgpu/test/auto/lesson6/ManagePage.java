package com.epam.spbgpu.test.auto.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManagePage extends AbstractPage {

    @FindBy(xpath = "//ul[contains(@class, 'nav-tabs')]//a")
    private List<WebElement> manageTabs;

    public ManagePage(WebDriver driver) {
        super(driver);
    }

    public void clickTab(String name) {
        for (WebElement manageTab : manageTabs) {
            if (manageTab.getText().trim().equals(name)) {
                manageTab.click();
                break;
            }
        }
    }
}
