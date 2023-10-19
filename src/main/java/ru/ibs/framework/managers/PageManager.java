package ru.ibs.framework.managers;

import ru.ibs.framework.pages.AssignmentFormPage;
import ru.ibs.framework.pages.AssignmentPage;
import ru.ibs.framework.pages.LoginPage;
import ru.ibs.framework.pages.MainPage;

public class PageManager {

    private static PageManager pageManager;

    private LoginPage loginPage;

    private AssignmentFormPage assignmentFormPage;
    private MainPage mainPage;

    private AssignmentPage assignmentPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public AssignmentFormPage getAssignmentFormPage() {
        if (assignmentFormPage == null) {
            assignmentFormPage = new AssignmentFormPage();
        }
        return assignmentFormPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public AssignmentPage getAssignmentPage() {
        if (assignmentPage == null) {
            assignmentPage = new AssignmentPage();
        }
        return assignmentPage;
    }
}


