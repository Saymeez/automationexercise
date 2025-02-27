import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private String validEmail = "JohnSmith11@gmail.com";
    private static String nameInAccount = "John Smith";
    private String validPassword = "qwerty1";


    public void openPage (String url) {
        open(url);
    }

    public String getValidEmail() {
        return validEmail;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public static String getNameInAccount() {
        return nameInAccount;
    }
}
