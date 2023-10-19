package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignmentFormPage extends BasePage {

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement createAssignmentTitle;

    @FindBy(name = "crm_business_trip[businessUnit]")
    private WebElement departmentSelector;

    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement orgButton;

    public AssignmentFormPage checkOpenAssignmentPage() {
        waitInvisibilityOfElement(loadingSpinner);
        Assert.assertEquals("Создать командировку", createAssignmentTitle.getText());
        return this;
    }

    public AssignmentFormPage fillDepartment() {
        departmentSelector.click();
        Assert.assertEquals("selector input-widget-select focus hover", departmentSelector
                .findElement(By.xpath("./..")).getAttribute("class"));
        departmentSelector.findElement(By.xpath("./option[@value='7']")).click();
        Assert.assertEquals("Отдел внутренней разработки", departmentSelector
                .findElement(By.xpath("./../span")).getText());
        departmentSelector.sendKeys(Keys.ESCAPE);
        return this;
    }

    public AssignmentFormPage fillOrgFromList() {

        return this;
    }

}
