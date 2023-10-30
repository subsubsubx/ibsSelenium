package ru.ibs.framework.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.AssignmentPage;

public class AssignmentPageStep {

    final AssignmentPage assignmentPage = PageManager.getPageManager().getAssignmentPage();

    @Then("Проверяем переход в раздел Все командировки")
    public void checkOpenAssignmentPage() {
        assignmentPage.checkAssignmentPage();
    }


    @And("Переходим в форму заполнения командировки")
    public void clickAssignmentForm() {
        assignmentPage.openAssignmentFormPage();
    }


}
