import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class PageServisesWomenCenter {
    By questionButton = By.className("link_ask_direction");
    By submitButton = By.className("block-button");
    By questionFormError = By.className("popup-error");

    public PageServisesWomenCenter open(){
        Selenide.open("/services/women-s-center/");
        return this;
    }

    public PageServisesWomenCenter questionForm(){
        $(questionButton).click();
        $(submitButton).click();
        return this;
    }

    public String getErrorText(){

        return $(questionFormError).text();
    }
}
