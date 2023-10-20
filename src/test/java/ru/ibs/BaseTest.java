package ru.ibs;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.ibs.framework.enums.DriverEnums;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.BasePage;


public class BaseTest extends BasePage {
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        driverManager.getDriver().get((DriverEnums.BASE_URL.getValue()));
    }

    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }

    @Test
    public void test() {
        PageManager.getPageManager().getLoginPage().fillLoginData().submitLogin()
                .checkOpenMainPage()
                .selectNavBarByValue("Расходы")
                .selectDropDownOptionByValue("Командировки")
                .checkAssignmentPage()
                .openAssignmentFormPage()
                .checkOpenAssignmentPage()
                .fillDepartment()
                .fillOrgFromList()
                .tickCheckboxFromList(1)
                .fillDepartureCity("Не кури")
                .fillArrivalCity("Не пей")
                .setDepartureAndArrivalDates()
                .clickCloseAndSave();
    }
}
