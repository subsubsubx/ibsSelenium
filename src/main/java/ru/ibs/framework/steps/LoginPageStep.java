package ru.ibs.framework.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.LoginPage;
import ru.ibs.framework.pages.MainPage;

public class LoginPageStep {
    final LoginPage loginPage = PageManager.getPageManager().getLoginPage();
    final MainPage mainPage = PageManager.getPageManager().getMainPage();

    @Given("^Вводим логин \"([^\"]*)\" и пароль \"([^\"]*)\"$")
    public void enterLoginData(String id, String pwd) {
        loginPage.fillLoginData(id, pwd);
    }

    @And("Клик подтверждение данных")
    public void submitClick() {
        loginPage.submitLogin();
    }

    @And("Проверяем успешный логин")
    public void checkSuccessLogin() {
        mainPage.checkOpenMainPage();
    }
}
