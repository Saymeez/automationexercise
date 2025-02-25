import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainTests {
    @BeforeEach
    void beforeEach() {
        open("https://www.automationexercise.com/");
    }
    @Test
    void NewUserRegistration(){
        $("[id=header]").shouldBe(visible);
        $(byXpath("//div[@class='shop-menu pull-right']")).shouldBe(visible);
        $(byText("Signup / Login")).click();
        $(byText("New User Signup!")).shouldBe(visible);
        $(by("data-qa", "signup-name")).setValue("John Smith");
        $(by("data-qa", "signup-email")).setValue("JohnSmith22@gmail.com");
        $(byText("Signup")).click();
        $("#name").getValue().equals("John Smith");
        $("#email").getValue().equals("sdgsdgsdg@gmail.com");
        $("#id_gender1").click();
        $(by("data-qa", "password")).setValue("qwerty1");
        $("#days").$(byValue("3")).click();
        $("#months").$(byValue("5")).click();
        $("#years").$(byValue("2000")).click();
        $("#newsletter").scrollTo().click();
        $("#optin").click();
        $(by("data-qa", "first_name")).setValue("John");
        $(by("data-qa", "last_name")).setValue("Smith");
        $(by("data-qa", "company")).setValue("JohnLTD");
        $(by("data-qa", "address")).setValue("Some Street");
        $(by("data-qa", "address2")).setValue("apartment 18");
        $(by("data-qa", "country")).$(byValue("United States")).click();
        $(by("data-qa", "state")).setValue("California");
        $(by("data-qa", "city")).setValue("Antioch");
        $(by("data-qa", "zipcode")).setValue("92036");
        $(by("data-qa", "mobile_number")).setValue("5417639475");
        sleep(1000);
        $(by("data-qa", "create-account")).scrollTo().click();
        sleep(1000);
        $(by("data-qa", "account-created")).getText().equals("Account Created!");
        $(by("data-qa", "continue-button")).click();
        sleep(1000);
        $("a > b").shouldHave(text("John Smith")); // will change selector
        $(byText("Delete Account")).click();
        sleep(100);
        $(by("data-qa", "account-deleted")).shouldBe(visible);
        $(by("data-qa", "continue-button")).click();
        sleep(1000);
    }
    @Disabled
    @Test
    void loginTest() {
        open("https://www.automationexercise.com/login");
        $(by("data-qa", "login-email")).setValue("JohnSmith22332221@gmail.com");
        $(by("data-qa", "login-password")).setValue("qwerty1");
        $(by("data-qa", "login-button")).click();
        sleep(1000);
        $("a > b").shouldHave(text("John Smith")); // will change selector
        $(byText("Delete Account")).click();
        $(by("data-qa", "account-deleted")).shouldNotBe(visible);
        $(by("data-qa", "continue-button")).click();
    }


    @Test
    @Disabled
    void verifyMainPageHeader() {
        $("[id=header]").shouldBe(visible);
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
