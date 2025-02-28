package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.DeleteAccountPage;
import pages.MainPage;
import pages.SignUpLoginPage;
import pages.SignUpPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private final String validEmail = "JohnSmith3@gmail.com";
    private static String nameInAccount = "John Smith";
    private final String validPassword = "qwerty1";
    private final String invalidEmail = "JohnSmith00@gmail.com";
    private final String invalidPassword = "@@@werty12";

    @BeforeAll
    static void beforeAll(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    SignUpLoginPage signUpLoginPage = new SignUpLoginPage();
    SignUpPage signUpPage = new SignUpPage();
    MainPage mainPage = new MainPage();
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage();

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

    public void openPage (String url) {
        open(url);
    }

    public String getValidEmail() {
        return validEmail;
    }

    public String getValidPassword() {
        return validPassword;
    }
    public String getInvalidEmail() {
        return invalidEmail;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public static String getNameInAccount() {
        return nameInAccount;
    }
}
