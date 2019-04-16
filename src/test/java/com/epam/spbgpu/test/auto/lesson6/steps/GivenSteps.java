package com.epam.spbgpu.test.auto.lesson6.steps;

import com.epam.spbgpu.test.auto.lesson6.ManagePage;
import com.epam.spbgpu.test.auto.lesson6.context.TestContext;
import com.epam.spbgpu.test.auto.lesson6.enums.MenuItem;
import cucumber.api.java.en.Given;

public class GivenSteps extends BaseStep {

    @Given("^I open Mantis Login page$")
    public void iOpenMantisLoginPage() {
        TestContext.getInstance().getDriver().get("http://localhost/mantisbt/login_page.php");
    }

    @Given("I login as '([^\"]*)' with password '([^\"]*)'")
    public void loginAs(String username, String password) {
        loginPage.login(username, password);
    }

    @Given("^I navigate to '([^\"]*)' page$")
    public void iNavigateTo(MenuItem menuItem) {
        loginPage.selectMenu(menuItem);
    }

    @Given("^I click to '(Manage Tags|Manage Users)' tab$")
    public void iClickToTab(String tabName) {
        new ManagePage(TestContext.getInstance().getDriver())
                .clickTab(tabName);
    }

}
