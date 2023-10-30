package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.framework.enums.DriverEnums;
import ru.ibs.framework.managers.DriverManager;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.PageFactory.initElements;
import static ru.ibs.framework.managers.DriverManager.getDriverManager;

public class BasePage {

    protected final DriverManager driverManager = getDriverManager();

    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),
            parseInt((DriverEnums.DRIVER_WAIT_SECONDS.getValue())),
            parseInt((DriverEnums.DRIVER_SLEEP_MILLIS.getValue())));

    @FindBy(xpath = "//div[@class='loader-content']")
    protected WebElement loadingSpinner;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    protected WebElement subtitle;


    public BasePage() {
        initElements(driverManager.getDriver(), this);
    }

    protected WebElement waitVisibilityOfElement(WebElement e) {
        return wait.until(ExpectedConditions.visibilityOf(e));
    }

    protected List<WebElement> waitVisibilityOfElements(List<WebElement> list) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }


    protected boolean waitInvisibilityOfElement(WebElement e) {
        return wait.until(ExpectedConditions.invisibilityOf(e));
    }

    protected WebElement waitClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

  //  @Step("Установка в поле {e} значения {s}")
    protected WebElement setField(WebElement e, String s) {
        e.click();
        e.sendKeys(Keys.CONTROL + "A");
        e.sendKeys(s);
        return e;
    }

}