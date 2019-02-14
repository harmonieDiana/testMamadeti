import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FillInFormtest {

    WebDriver driver;
    FillInForm fillInForm;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mamadeti.ru/news/pregnant-baby-shower-or-party/");

    }

    @Test
    public void EmptyCreds(){
        fillInForm = new FillInForm(driver);
        fillInForm.registerForm("", "", "");
        String error = fillInForm.getErrorText();
        Assert.assertEquals("Обязательные поля не заполнены", error);
    }

    @Test
    public void InvalidEmail(){
        fillInForm = new FillInForm(driver);
        fillInForm.registerForm("test", "test", "222 2222222");
        String error = fillInForm.getErrorText();
        Assert.assertEquals("Указан неправильный E-Mail", error);
    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}
