package com.epam.spbgpu.test.auto.lesson6;

import com.epam.spbgpu.test.auto.lesson6.enums.MenuItem;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends AbstractBasePage {

    protected LeftSideBarElement leftSideBar;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        this.leftSideBar = new LeftSideBarElement(driver);
    }

    public void selectMenu(MenuItem item) {
        this.leftSideBar.clickMenuItem(item);
    }

    public LeftSideBarElement getLeftSideBar() {
        return leftSideBar;
    }
}
