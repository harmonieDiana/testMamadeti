import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FillInForm {

    static By registerButton = By.className("formId-15119811");
    static By NameField = By.xpath("//*[@id=\"DEFAULT_FORM\"]/div[2]/div[2]/div/fieldset/div/div/div[1]/div[2]/div/input");
    static By EmailField = By.xpath("//*[@id=\"DEFAULT_FORM\"]/div[2]/div[2]/div/fieldset/div/div/div[2]/div[2]/div/input");
    static By TelField = By.xpath("//*[@id=\"DEFAULT_FORM\"]/div[2]/div[2]/div/fieldset/div/div/div[3]/div[2]/div/input");
    static By submitButton = By.xpath("//*[@id=\"DEFAULT_FORM\"]/div[2]/div[2]/div/fieldset/div/div/div[5]/div/span/input");
    static By formError = By.className("popup-error");


    public FillInForm open() {
        Selenide.open("/news/pregnant-baby-shower-or-party/");
        return this;
    }

    public FillInForm registerForm(String name, String email, String tel) {
        $(registerButton).click();
        $(NameField).setValue(name);
        $(EmailField).setValue(email);
        $(TelField).setValue(tel);
        $(submitButton).click();
        return this;
    }

    public String getErrorText() {
        return $(formError).text();
    }
}

   
