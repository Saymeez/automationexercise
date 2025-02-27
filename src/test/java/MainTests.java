import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DeleteAccountPage;
import pages.MainPage;
import pages.SignUpLoginPage;
import pages.SignUpPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class MainTests extends TestBase{
    @BeforeAll
    static void beforeAll(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    SignUpLoginPage signUpLoginPage = new SignUpLoginPage();
    SignUpPage signUpPage = new SignUpPage();
    MainPage mainPage = new MainPage();
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage();

    //TestBase testBase = new TestBase();
    @Test
    @DisplayName("New user registration and delete account")
    void NewUserRegistration() {
        mainPage.openMainPage()
                .verifyHeaderIsVisible()
                .verifyMenuIsVisible()
                .clickSignUpLoginButton();
        signUpLoginPage.clickSingUpButton()
                .setSignUpName("John Smith")
                .setSignUpEmail("JohnSmith1225@gmail.com")
                .clickSingUpButton();
        signUpPage.verifyFilledNameAndEmail()
                .fillSignUpForm()
                .clickCreateAccountButton()
                .verifyAccountCreatedHeader()
                .clickContinueButton();

        mainPage.verifyAccountNameInHeader("John Smith")
                .clickDeleteAccountButton();
        deleteAccountPage.verifyAccountDeletedIsVisible()
                .clickContinueButton();
    }
    @Disabled
    @Test
    void loginTest() {
        signUpLoginPage.openLoginPage()
                .setLoginEmail(getValidEmail())
                .setLoginPassword(getValidPassword())
                .clickLoginButton();
        mainPage.verifyAccountNameInHeader("John Smith");
    }

    @Test
    @Disabled
    void clickOnCard() {
        $("div.features_items > h2").scrollTo().shouldHave(text("Features Items"));
        $("div.productinfo > a").shouldBe(visible).click();
        $("div#cartModal").shouldBe(visible);
        $(byXpath("//div[@id='cartModal']//a")).click();
        sleep(10000);
    }
}
