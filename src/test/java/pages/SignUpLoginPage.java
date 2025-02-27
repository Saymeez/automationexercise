package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpLoginPage {
    private final SelenideElement
    signUpName = $(by("data-qa", "signup-name")),
    signUpEmail = $(by("data-qa", "signup-email")),
    signUpButton = $(byText("Signup")),
    loginEmail = $(by("data-qa", "login-email")),
    loginPassword = $(by("data-qa", "login-password")),
    loginButton = $(by("data-qa", "login-button")),
    newUserSignUp = $(byText("New User Signup!"));

    public SignUpLoginPage openLoginPage() {
        open("https://www.automationexercise.com/login");
        return this;
    }


    public SignUpLoginPage setSignUpName(String value) {
        signUpName.setValue(value);
        return this;
    }
    public SignUpLoginPage setSignUpEmail(String value) {
        signUpEmail.setValue(value);
        return this;
    }

    public SignUpLoginPage clickSingUpButton() {
        signUpButton.click();
        return this;
    }

    public SignUpLoginPage setLoginEmail(String value) {
        loginEmail.setValue(value);
        return this;
    }
    public SignUpLoginPage setLoginPassword(String value) {
        loginPassword.setValue(value);
        return this;
    }

    public SignUpLoginPage clickLoginButton () {
        loginButton.click();
        return this;
    }

}
