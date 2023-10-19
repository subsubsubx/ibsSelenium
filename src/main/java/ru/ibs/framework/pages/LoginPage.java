package ru.ibs.framework.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.enums.DriverEnums;
import ru.ibs.framework.managers.PageManager;


public class LoginPage extends BasePage {
    PageManager pageManager = PageManager.getPageManager();

    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement loginForm;

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@name='_submit']")
    private WebElement submitButton;

    public LoginPage fillLoginData() {
        waitVisibilityOfElement(loginForm);
        setField(usernameField, DriverEnums.LOGIN.getValue());
        setField(passwordField, DriverEnums.PASSWORD.getValue());
        return this;
    }

    public MainPage submitLogin() {
        submitButton.click();
        return pageManager.getMainPage();
    }
}


