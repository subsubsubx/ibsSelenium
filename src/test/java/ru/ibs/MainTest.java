package ru.ibs;

import org.junit.Test;
import ru.ibs.framework.enums.DriverEnums;
import ru.ibs.framework.managers.PageManager;

public class MainTest extends BaseTest {

    @Test
    public void mainTest() {
        PageManager.getPageManager().getLoginPage().fillLoginData(DriverEnums.LOGIN.getValue(),
                        DriverEnums.PASSWORD.getValue()).submitLogin()
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
