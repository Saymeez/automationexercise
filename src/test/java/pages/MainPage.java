package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {



    private static final String pageUrl = "https://www.automationexercise.com/";
    private final SelenideElement header = $("[id=header]"),
            menu = $(byXpath("//div[@class='shop-menu pull-right']")),
            signUpLoginButton = $(byText("Signup / Login")),
            deleteAccountButton = $(byText("Delete Account")),
            loggedAsBlock = $("a > b"); //I'll change selector


    public static String getPageUrl() {
        return pageUrl;
    }
    @Step("Open main page")
    public MainPage openMainPage(){
        open(pageUrl);
        return this;
    }
    @Step("Verify account name in header")
    public MainPage verifyAccountNameInHeader(String value) {
        loggedAsBlock.shouldHave(text(value));
        return this;
    }
    @Step("Verify that header is visible")
    public MainPage verifyHeaderIsVisible() {
        header.shouldBe(visible);
        return this;
    }
    @Step("Verify that menu is visible")
    public MainPage verifyMenuIsVisible() {
        menu.shouldBe(visible);
        return this;
    }
    @Step("Click on 'Signup / Login' button")
    public MainPage clickSignUpLoginButton() {
        signUpLoginButton.click();
        return this;
    }
    @Step("Click on 'Delete Account' button")
    public MainPage clickDeleteAccountButton() {
        deleteAccountButton.click();
        return this;
    }



}
