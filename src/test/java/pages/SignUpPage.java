package pages;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {

    public SignUpPage fillSignUpForm() {
        $("#id_gender1").click();
        $(by("data-qa", "password")).setValue("qwerty1"); //ill change
        $("#days").$(byValue("3")).click();
        $("#months").$(byValue("5")).click();
        $("#years").$(byValue("2000")).click();
        $("#newsletter").scrollTo().click();
        $("#optin").click();
        $(by("data-qa", "first_name")).setValue("John");
        $(by("data-qa", "last_name")).setValue("Smith");
        $(by("data-qa", "company")).setValue("JohnLT");
        $(by("data-qa", "address")).setValue("Some Street");
        $(by("data-qa", "address2")).setValue("apartment 18");
        $(by("data-qa", "country")).$(byValue("United States")).click();
        $(by("data-qa", "state")).setValue("California");
        $(by("data-qa", "city")).setValue("Antioch");
        $(by("data-qa", "zipcode")).setValue("92036");
        $(by("data-qa", "mobile_number")).setValue("5417639475");
        return this;
    }

    public SignUpPage clickCreateAccountButton() {
        $(by("data-qa", "create-account")).scrollTo().click();
        return this;
    }

    public SignUpPage verifyAccountCreatedHeader() {
        $(by("data-qa", "account-created")).getText().equals("Account Created!");
        return this;
    }

    public SignUpPage verifyFilledNameAndEmail(String name, String email) {
        $("#name").getValue().equals(name);
        $("#email").getValue().equals(email);
        return this;
    }

    public SignUpPage clickContinueButton() {
        $(by("data-qa", "continue-button")).click();
        return this;
    }
}
