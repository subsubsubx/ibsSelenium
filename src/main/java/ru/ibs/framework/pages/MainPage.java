package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.managers.PageManager;

import java.util.List;

public class MainPage extends BasePage {

    PageManager pageManager = PageManager.getPageManager();

    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li/a/span")
    private List<WebElement> navBarList;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]/li/a/span")
    private List<WebElement> dropDownOptionsList;

    @Step("")
    public MainPage checkOpenMainPage() {
        Assert.assertFalse("Неправильный логин/пароль", driverManager.getDriver().findElement(By
                .xpath("//div[@class='alert alert-error']")).isDisplayed());
        waitVisibilityOfElement(subtitle);
        Assert.assertEquals("Страница не открыта, элемент не найден", "Панель быстрого запуска", subtitle
                .getText());
        return this;
    }

    public MainPage selectNavBarByValue(String s) {
        System.out.println(navBarList.size());
        for (WebElement element : navBarList) {
            if (element.getText().equals(s)) {
                waitClickability(element).click();
                return this;
            }
        }
        Assert.fail("Меню '" + s + "' не найдено");
        return this;
    }


    public AssignmentPage selectDropDownOptionByValue(String s) {
        System.out.println(dropDownOptionsList.size());
        for (WebElement element : dropDownOptionsList) {
            if (element.getText().equals(s)) {
                waitVisibilityOfElement(element).click();
                return pageManager.getAssignmentPage();
            }
        }
        Assert.fail("Пункт подменю '" + s + "' не найден");
        return pageManager.getAssignmentPage();
    }
}