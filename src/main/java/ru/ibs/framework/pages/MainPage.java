package ru.ibs.framework.pages;

import org.junit.Assert;
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


    public MainPage checkOpenMainPage() {
        waitVisibilityOfElement(subtitle);
        Assert.assertEquals("Панель быстрого запуска", subtitle.getText());
        return this;
    }

    public MainPage selectNavBarByValue(String s) {
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