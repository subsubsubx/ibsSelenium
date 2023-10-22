/*
package ru.ibs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class TestTask1 {
    private WebDriver driver;
    private WebDriverWait driverWait;


    @BeforeEach
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() {

        //Шаги 1-3
        driver.get("http://training.appline.ru/user/login");
        waitVisibilityOfElement(By.xpath("//form[@id='login-form']"));


        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("Irina Filippova");
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys("testing");
        driver.findElement(By.xpath("//button[@name='_submit']")).click();
        waitVisibilityOfElement(By.xpath("//h1[@class='oro-subtitle']"));


        //Шаг 4
        WebElement dropDownList = driver
                .findElement(By.xpath("//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']"));
        dropDownList.click();
        waitVisibilityOfElement(dropDownList);

        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
        WebElement spinner = driver.findElement(By.xpath("//div[@class='loader-content']"));
        waitInvisibilityOfElement(spinner);

        //Шаг 5-6
        driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();
        waitInvisibilityOfElement(spinner);
        Assertions.assertTrue(driver
                .findElement(By.xpath("//h1[@class='user-name']")).isDisplayed());

        //Шаг 7-8
        WebElement depSelector = driver
                .findElement(By.xpath("//select[contains(@id, 'crm_business_trip_businessUnit-uid')]"));
        depSelector.click();
        Assertions.assertEquals("selector input-widget-select focus hover", depSelector
                .findElement(By.xpath("./..")).getAttribute("class"));

        depSelector.findElement(By.xpath("./option[@value='7']")).click();
        Assertions.assertEquals("Отдел внутренней разработки", depSelector
                .findElement(By.xpath("./../span")).getText());


        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
        Assertions.assertEquals("display: block;", driver
                .findElement(By.xpath("//div[@id='company-selector']")).getAttribute("style"));

        WebElement arrow = driver.findElement(By.xpath("//span[@class='select2-arrow']"));
        waitVisibilityOfElement(arrow);

        driver
                .findElement(By.xpath("//span[@class='select2-chosen' and text()='Укажите организацию']"))
                .click();
        Assertions.assertTrue(driver
                .findElement(By.xpath("//span[@class='select2-arrow']")).isDisplayed());
        waitInvisibilityOfElement(By.xpath("//li[@class='select2-searching']"));


        WebElement orgResult = driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]"));
        String s = orgResult.getText();
        orgResult.click();
        Assertions.assertEquals(driver
                .findElement(By.xpath("//span[@class='select2-chosen']"))
                .getText(), s);


        WebElement checkBox = driver
                .findElement(By.xpath("//label[text()='Заказ билетов']/../input[@type='checkbox']"));
        checkBox.click();
        Assertions.assertTrue(checkBox.isSelected());

        WebElement departureField = driver
                .findElement(By.xpath("//input[contains(@id, 'crm_business_trip_departureCity')]"));
        setField(departureField, "Test 123");

        WebElement arrivalField = driver
                .findElement(By.xpath("//input[contains(@id, 'crm_business_trip_arrivalCity')]"));
        setField(arrivalField, "Hello world!");

        WebElement departureDateField = driver
                .findElement(By.xpath("//input[contains(@id, 'date_selector_crm_business_trip_depart')]"));
        WebElement arrivalDateField = driver
                .findElement(By.xpath("//input[contains(@id, 'date_selector_crm_business_trip_return')]"));
        WebElement datePicker = driver
                .findElement(By.xpath("//div[@id='ui-datepicker-div']"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse("29.05.2022", formatter);
        LocalDate endDate = LocalDate.parse("26.06.2022", formatter);

        setField(departureDateField, startDate.format(formatter) + Keys.ESCAPE);
        waitInvisibilityOfElement(datePicker);
        setField(arrivalDateField, endDate.format(formatter) + Keys.ESCAPE);
        waitInvisibilityOfElement(datePicker);
        Assertions.assertEquals(ChronoUnit.DAYS.between(startDate, endDate) + 1, Long.parseLong(driver
                .findElement(By.xpath("//span[@id='duration-plan']")).getText()));

        //Шаг 9-10
        driver.findElement(By
                .xpath("//button[@type='submit' and contains(@class, 'success action')]")).click();
        waitInvisibilityOfElement(spinner);
        Assertions.assertTrue(driver
                .findElement(By.xpath("//span[@class='validation-failed']")).isDisplayed());
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    public void setField(WebElement e, String s) {
        e.click();
        e.sendKeys(Keys.CONTROL + "A");
        e.sendKeys(s);
    }


    public void waitVisibilityOfElement(By by) {
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public void waitVisibilityOfElement(WebElement e) {
        driverWait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitInvisibilityOfElement(By by) {
        driverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
    }

    public void waitInvisibilityOfElement(WebElement e) {
        driverWait.until(ExpectedConditions.invisibilityOf(e));
    }
}*/
