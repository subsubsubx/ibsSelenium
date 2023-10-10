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
    static WebDriver driver;
    WebDriverWait driverWait;
    final String baseUrl = "http://training.appline.ru/user/login";
    final String login = "Irina Filippova";
    final String password = "testing";


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
        driver.get(baseUrl);
        driverWait.until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//form[@id='login-form']"))));

        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name='_submit']")).click();
        driverWait.until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//h1[@class='oro-subtitle']"))));

        //Шаг 4
        WebElement dropDownList = driver
                .findElement(By.xpath("//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']"));
        dropDownList.click();
        driverWait.until(ExpectedConditions.visibilityOf(dropDownList
                .findElement(By.xpath("./ancestor::li/ul"))));

        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
        WebElement loaderSpinner = driver
                .findElement(By.xpath("//div[@class='loader-content']"));
        driverWait.until(ExpectedConditions.invisibilityOf(loaderSpinner));

        //Шаг 5
        driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();

        driverWait.until(ExpectedConditions.invisibilityOf(loaderSpinner));
        Assertions.assertTrue(driver
                .findElement(By.xpath("//h1[@class='user-name']")).isDisplayed());

        //Заполнение полей на форме
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

        WebElement arrow = driverWait.until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//span[@class='select2-arrow']"))));
        driverWait.until(ExpectedConditions.visibilityOf(arrow));

        driver
                .findElement(By.xpath("//span[@class='select2-chosen' and text()='Укажите организацию']"))
                .click();
        Assertions.assertTrue(driver
                .findElement(By.xpath("//span[@class='select2-arrow']")).isDisplayed());
        driverWait.until(ExpectedConditions.invisibilityOf(driver
                .findElement(By.xpath("//li[@class='select2-searching']"))));


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

// хз как проверить эти поля
        WebElement departureField = driver
                .findElement(By.xpath("//input[contains(@id, 'crm_business_trip_departureCity')]"));
        departureField.click();
        departureField.sendKeys(Keys.CONTROL + "A");
        departureField.sendKeys("Test 123");

        WebElement arrivalField = driver
                .findElement(By.xpath("//input[contains(@id, 'crm_business_trip_arrivalCity')]"));
        arrivalField.click();
        arrivalField.sendKeys("Hello world");

        WebElement departureDateField = driver
                .findElement(By.xpath("//input[contains(@id, 'date_selector_crm_business_trip_depart')]"));
        WebElement arrivalDateField = driver
                .findElement(By.xpath("//input[contains(@id, 'date_selector_crm_business_trip_return')]"));
        WebElement datePicker = driver
                .findElement(By.xpath("//div[@id='ui-datepicker-div']"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse("29.05.2022", formatter);
        LocalDate endDate = LocalDate.parse("26.06.2022", formatter);

        departureDateField.click();
        departureDateField.sendKeys(startDate.format(formatter) + Keys.ESCAPE);
        driverWait.until(ExpectedConditions.invisibilityOf(datePicker));
        arrivalDateField.click();
        arrivalDateField.sendKeys(endDate.format(formatter) + Keys.ESCAPE);
        driverWait.until(ExpectedConditions.invisibilityOf(datePicker));
        Assertions.assertEquals(ChronoUnit.DAYS.between(startDate, endDate) + 1, Long.parseLong(driver
                .findElement(By.xpath("//span[@id='duration-plan']")).getText()));

        driver.findElement(By
                .xpath("//button[@type='submit' and contains(@class, 'success action')]")).click();
        driverWait.until(ExpectedConditions.invisibilityOf(loaderSpinner));
        Assertions.assertTrue(driver
                .findElement(By.xpath("//span[@class='validation-failed']")).isDisplayed());
    }

    @AfterEach
    public void quit() {
        //driver.quit();
    }
}