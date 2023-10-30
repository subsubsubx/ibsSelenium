package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.managers.PageManager;

public class AssignmentPage extends BasePage {
    PageManager pageManager = PageManager.getPageManager();


    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement createAssignmentButton;

 //   @Step("Проверка открытия страницы с командировками")
    public AssignmentPage checkAssignmentPage() {
        waitInvisibilityOfElement(loadingSpinner);
        Assert.assertEquals("Значения не совпадают", "Все Командировки", subtitle.getText());
        return this;
    }

   // @Step("Клик \"Создать командировку\"")
    public AssignmentFormPage openAssignmentFormPage() {
        createAssignmentButton.click();
        waitInvisibilityOfElement(loadingSpinner);
        return pageManager.getAssignmentFormPage();
    }
}
