import org.junit.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class FillInFormtest {

    FillInForm fillInForm;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        baseUrl = "https://mamadeti.ru/news/pregnant-baby-shower-or-party/";
        browser = "chrome";

    }

    @Test
    public void EmptyCreds(){
        fillInForm = new FillInForm();
        fillInForm.open();
        fillInForm.registerForm("", "", "");
        String error = fillInForm.getErrorText();
        Assert.assertEquals("Обязательные поля не заполнены", error);
    }

    @Test
    public void InvalidEmail(){
        fillInForm = new FillInForm();
        fillInForm.open();
        fillInForm.registerForm("test", "test", "222 2222222");
        String error = fillInForm.getErrorText();
        Assert.assertEquals("Указан неправильный E-Mail", error);
    }


}
