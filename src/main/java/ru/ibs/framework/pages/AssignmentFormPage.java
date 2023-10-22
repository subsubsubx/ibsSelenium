package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AssignmentFormPage extends BasePage {

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement createAssignmentTitle;

    @FindBy(xpath = "//select[contains(@id, 'crm_business_trip_businessUnit')]")
    private WebElement departmentSelector;

    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement orgButton;

    @FindBy(xpath = "//div[@id='company-selector']")
    private WebElement orgSelector;

    @FindBy(xpath = "//span[@class='select2-chosen' and text()='Укажите организацию']")
    private WebElement chooseAnOrg;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    private WebElement chosenElement;

    @FindBy(xpath = "//ul[@class='select2-results']//li[@class='select2-results-dept-0 select2-result select2-result-selectable']//div")
    private List<WebElement> orgList;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxList;

    @FindBy(xpath = "//input[contains(@id, 'crm_business_trip_departureCity')]")
    private WebElement departureCityInputField;

    @FindBy(xpath = "//input[contains(@id, 'crm_business_trip_arrivalCity')]")
    private WebElement arrivalCityInputField;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_crm_business_trip_depart')]")
    private WebElement departureDateField;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_crm_business_trip_return')]")
    private WebElement arrivalDateField;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']")
    private WebElement datePicker;

    @FindBy(xpath = "//span[@id='duration-plan']")
    private WebElement durationPlan;

    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'success action')]")
    private WebElement closeAndSaveButton;

    @FindBy(xpath = "//span[@class='validation-failed']")
    private WebElement validationFailed;

    @Step("Проверка открытия страницы с формой заполнения командировки")
    public AssignmentFormPage checkOpenAssignmentPage() {
        waitInvisibilityOfElement(loadingSpinner);
        Assert.assertEquals("Некорректное значение", "Создать командировку", createAssignmentTitle
                .getText());
        return this;
    }

    @Step("Заполнение департамента")
    public AssignmentFormPage fillDepartment() {
        departmentSelector.click();
        Assert.assertEquals("selector input-widget-select focus hover", departmentSelector
                .findElement(By.xpath("./..")).getAttribute("class"));
        waitClickability(departmentSelector.findElement(By.xpath("./option[@value='7']"))).click();
        Assert.assertEquals("Отдел внутренней разработки", departmentSelector
                .findElement(By.xpath("./../span")).getText());
        return this;
    }

    @Step("Выбор рандомной организации из селектора")
    public AssignmentFormPage fillOrgFromList() {
        waitVisibilityOfElement(orgButton).click();
        Assert.assertEquals("display: block;", orgSelector.getAttribute("style"));
        waitVisibilityOfElement(chooseAnOrg).click();
        waitVisibilityOfElements(orgList);
        WebElement chosenRand = orgList.get(ThreadLocalRandom.current().nextInt(0, orgList.size()));
        String s = chosenRand.getText(); // хз как обойти StaleElementException
        chosenRand.click();
        Assert.assertEquals("Значения не совпадают", s, chosenElement.getText());
        return this;
    }

    @Step("Проставление чекбокса под номером {num} напротив задач")
    public AssignmentFormPage tickCheckboxFromList(int num) {
        try {
            waitVisibilityOfElements(checkboxList);
            checkboxList.get(num - 1).click();
            Assert.assertTrue(checkboxList.get(num - 1).isSelected());
        } catch (IndexOutOfBoundsException e){
            Assert.fail("Выход за пределы массива, " + e.getMessage());
        }
        return this;
    }

    @Step("Заполнение города отправки значением {s}")
    public AssignmentFormPage fillDepartureCity(String s) {
        waitVisibilityOfElement(departureCityInputField);
        setField(departureCityInputField, s);
        return this;
    }

    @Step("Заполнение города прибытия {s}")
    public AssignmentFormPage fillArrivalCity(String s) {
        waitVisibilityOfElement(arrivalCityInputField);
        setField(arrivalCityInputField, s);
        return this;
    }


    @Step("Проверка полей с выбором дат")
    public AssignmentFormPage setDepartureAndArrivalDates() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse("29.05.2022", formatter);
        LocalDate endDate = LocalDate.parse("26.06.2022", formatter);
        setField(departureDateField, startDate.format(formatter) + Keys.ESCAPE);
        waitInvisibilityOfElement(datePicker);
        setField(arrivalDateField, endDate.format(formatter) + Keys.ESCAPE);
        waitInvisibilityOfElement(datePicker);
        Assert.assertEquals("Подсчет дней между датами некорректный", ChronoUnit.DAYS
                .between(startDate, endDate) + 1, Long.parseLong(durationPlan.getText()));
        return this;
    }

    @Step("Клик \"Сохранить и закрыть\"")
    public AssignmentFormPage clickCloseAndSave() {
        waitClickability(closeAndSaveButton).click();
        waitInvisibilityOfElement(loadingSpinner);
        Assert.assertTrue("Отсутствует валидация на фронте у командированных сотрудников",
                validationFailed.isDisplayed());
        return this;
    }
}