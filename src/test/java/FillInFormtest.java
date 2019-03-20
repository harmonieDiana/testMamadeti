import com.codeborne.selenide.Configuration;
import org.junit.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class FillInFormtest {

    FillInForm fillInForm;
    PageServisesWomenCenter pageServisesWomenCenter;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        baseUrl = "https://mamadeti.ru";
        browser = "chrome";

    }

    @Test
    public void EmptyCreds(){
        fillInForm = new FillInForm();
        fillInForm.open();
        fillInForm.registerForm("", "", "");
        $(By.className("popup-error")).shouldHave(text("Обязательные поля не заполнены"));

    }

    @Test
    public void InvalidEmail(){
        fillInForm = new FillInForm();
        fillInForm.open();
        fillInForm.registerForm("test", "test", "222 2222222");
        $(By.className("popup-error")).shouldHave(text("Указан неправильный E-Mail"));
    }

    @Test
    public void emptyQuesrionForm(){
        pageServisesWomenCenter = new PageServisesWomenCenter();
        pageServisesWomenCenter.open();
        pageServisesWomenCenter.questionForm();
        $(By.className("popup-error")).shouldHave(text("Обязательные поля не заполнены"));

    }


}
