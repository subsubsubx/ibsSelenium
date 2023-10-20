package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.managers.PageManager;

public class AssignmentPage extends BasePage {
    PageManager pageManager = PageManager.getPageManager();

    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement createAssignmentButton;

    public AssignmentPage checkAssignmentPage() {
        waitInvisibilityOfElement(loadingSpinner);
        Assert.assertEquals("Все Командировки", subtitle.getText());
        return this;
    }

    public AssignmentFormPage openAssignmentFormPage() {
        createAssignmentButton.click();
        waitInvisibilityOfElement(loadingSpinner);
        return pageManager.getAssignmentFormPage();
    }
}
