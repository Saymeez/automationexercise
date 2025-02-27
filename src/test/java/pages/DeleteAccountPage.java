package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class DeleteAccountPage {
    @Step("Click on 'Continue' button")
    public DeleteAccountPage clickContinueButton(){
        $(by("data-qa", "continue-button")).click();
        return this;
    }
    @Step("Verify that text 'Account Deleted' is visible")
    public DeleteAccountPage verifyAccountDeletedIsVisible() {
        $(by("data-qa", "account-deleted")).shouldBe(visible);
        return this;
    }
}
