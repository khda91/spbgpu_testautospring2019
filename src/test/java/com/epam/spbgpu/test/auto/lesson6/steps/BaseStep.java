package com.epam.spbgpu.test.auto.lesson6.steps;

import com.epam.spbgpu.test.auto.lesson6.LoginPage;
import com.epam.spbgpu.test.auto.lesson6.context.TestContext;

public abstract class BaseStep {

    static LoginPage loginPage;

    protected BaseStep() {
        loginPage = new LoginPage(TestContext.getInstance().getDriver());
    }
}
