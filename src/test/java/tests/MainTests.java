package tests;

import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class MainTests extends TestBase {
    //@Disabled
    @Test
    @DisplayName("New User registration and delete account test")
    void NewUserRegistration() {
        mainPage.openMainPage()
                .verifyHeaderIsVisible()
                .verifyMenuIsVisible()
                .clickSignUpLoginButton();
        signUpLoginPage.setSignUpName("John Smith")
                .setSignUpEmail("JohnSmith4535@gmail.com")
                .clickSingUpButton();
        signUpPage.verifyFilledNameAndEmail("John Smith","JohnSmith4535@gmail.com")
                .fillSignUpForm()
                .clickCreateAccountButton()
                .verifyAccountCreatedHeader()
                .clickContinueButton();
        mainPage.verifyAccountNameInHeader("John Smith")
                .clickDeleteAccountButton();
        deleteAccountPage.verifyAccountDeletedIsVisible()
                .clickContinueButton();
    }
    @Test
    @DisplayName("Register new User with existing email test")
    void registerUserWithExistingEmailTest () {
        mainPage.openMainPage()
                .verifyHeaderIsVisible()
                .verifyMenuIsVisible()
                .clickSignUpLoginButton();
        signUpLoginPage.clickSingUpButton()
                .setSignUpName("John Smith")
                .setSignUpEmail("JohnSmith3@gmail.com")
                .clickSingUpButton()
                .verifyIncorrectSignupDataTextIsVisible();
    }

    @Test
    @DisplayName("User login test")
    void loginTest() {
        signUpLoginPage.openLoginPage()
                .setLoginEmail(getValidEmail())
                .setLoginPassword(getValidPassword())
                .clickLoginButton();
        mainPage.verifyAccountNameInHeader(getNameInAccount());
    }

    @Test
    @DisplayName("User login with invalid data test")
    void loginWithIncorrectDataTest() {
        signUpLoginPage.openLoginPage()
                .setLoginEmail(getInvalidEmail())
                .setLoginPassword(getInvalidPassword())
                .clickLoginButton()
                .verifyIncorrectLoginDataTextIsVisible();
    }
    @Disabled
    @Test
    @DisplayName("User logout test")
    void logoutTest() {
        signUpLoginPage.openLoginPage()
                .setLoginEmail(getValidEmail())
                .setLoginPassword(getValidPassword())
                .clickLoginButton();
        mainPage.verifyAccountNameInHeader(getNameInAccount())
                .clickLogoutButton();
    }

    @Test
    @DisplayName("Click on card")
    //@Disabled
    void clickOnCard() {
        $("div.features_items > h2").scrollTo().shouldHave(text("Features Items"));
        $("div.productinfo > a").shouldBe(visible).click();
        $("div#cartModal").shouldBe(visible);
        $(byXpath("//div[@id='cartModal']//a")).click();
        sleep(10000);
    }
}
