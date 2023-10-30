package ru.ibs.framework.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.MainPage;


public class MainPageStep {
    final MainPage mainPage = PageManager.getPageManager().getMainPage();


    @Given("^Выбор \"([^\"]*)\" в навбаре$")
    public void selectNavBarByValue(String s) {
        mainPage.selectNavBarByValue(s);
    }

    @When("^Выбор \"([^\"]*)\" в выпадающем списке$")
    public void selectDropDownOptionByValue(String s) {
        mainPage.selectDropDownOptionByValue(s);
    }
}
