package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.framework.enums.DriverEnums;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.PropertyManager;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.PageFactory.initElements;
import static ru.ibs.framework.managers.DriverManager.getDriverManager;
import static ru.ibs.framework.managers.PropertyManager.getPropInstance;

public class BasePage {

    protected final DriverManager driverManager = getDriverManager();

    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),
            parseInt((DriverEnums.DRIVER_WAIT_SECONDS.getValue())),
            parseInt((DriverEnums.DRIVER_SLEEP_MILLIS.getValue())));

    @FindBy(xpath = "//div[@class='loader-content']")
    protected WebElement loadingSpinner;



    public BasePage() {
        initElements(driverManager.getDriver(), this);
    }

    protected WebElement waitVisibilityOfElement(WebElement e) {
        return wait.until(ExpectedConditions.visibilityOf(e));
    }

    protected boolean waitInvisibilityOfElement(WebElement e) {
        return wait.until(ExpectedConditions.invisibilityOf(e));
    }

    protected WebElement waitClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void setField(WebElement e, String s) {
        e.click();
        e.sendKeys(Keys.CONTROL + "A");
        e.sendKeys(s);
    }

/*    public void fillStartEndDates(WebElement start, WebElement end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse("29.05.2022", formatter);
        LocalDate endDate = LocalDate.parse("26.06.2022", formatter);
        setField(start, startDate.format(formatter) + Keys.ESCAPE);
        waitInvisibilityOfElement(start);
        setField(end, endDate.format(formatter) + Keys.ESCAPE);
        waitInvisibilityOfElement(end);
        Assert.assertEquals(ChronoUnit.DAYS.between(startDate, endDate) + 1, Long.parseLong(driver
                .findElement(By.xpath("//span[@id='duration-plan']")).getText())););
    }*/


}