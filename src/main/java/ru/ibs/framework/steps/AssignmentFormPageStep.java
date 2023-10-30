package ru.ibs.framework.steps;

import io.cucumber.java.en.And;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.AssignmentFormPage;

public class AssignmentFormPageStep {
    final AssignmentFormPage assignmentFormPage = PageManager.getPageManager().getAssignmentFormPage();


    @And("Проверяем успешный переход в форму заполнения командировок")
    public void checkOpenAssignmentFormPage() {
        assignmentFormPage.checkOpenAssignmentPage();
    }

    @And("Заполняем отдел на Внутренней разработки")
    public void fillDepartment() {
        assignmentFormPage.fillDepartment();
    }

    @And("Выбираем рандомную организацию из списка")
    public void fillOrgFromList() {
        assignmentFormPage.fillOrgFromList();
    }

    @And("^Выбираем чекбокс номер (\\d+)$")
    public void tickCheckboxFromList(int num) {
        assignmentFormPage.tickCheckboxFromList(num);
    }

    @And("^Заполняем город отправления - \"([^\"]*)\"$")
    public void fillDepartureCity(String s) {
        assignmentFormPage.fillDepartureCity(s);
    }

    @And("^Заполняем город прибытия - \"([^\"]*)\"$")
    public void fillArrivalCity(String s) {
        assignmentFormPage.fillArrivalCity(s);
    }

    @And("Проставляем даты")
    public void setDepartureAndArrivalDates() {
        assignmentFormPage.setDepartureAndArrivalDates();
    }

    @And("Нажимаем Сохранить и выйти")
    public void clickCloseAndSave() {
        assignmentFormPage.clickCloseAndSave();
    }

}
