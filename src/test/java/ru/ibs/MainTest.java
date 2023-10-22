package ru.ibs;

import org.junit.Test;
import ru.ibs.framework.managers.PageManager;

public class MainTest extends BaseTest {

    @Test
    public void mainTest() {
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
