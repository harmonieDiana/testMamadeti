import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillInForm {

    WebDriver driver;

    public FillInForm (WebDriver driver){
        this.driver = driver;
    }

    By registerButton = By.className("formId-15119811");
    By NameField = By.xpath("//*[@id=\"DEFAULT_FORM\"]/div[2]/div[2]/div/fieldset/div/div/div[1]/div[2]/div/input");
    By EmailField = By.xpath("//*[@id=\"DEFAULT_FORM\"]/div[2]/div[2]/div/fieldset/div/div/div[2]/div[2]/div/input");
    By TelField = By.xpath("//*[@id=\"DEFAULT_FORM\"]/div[2]/div[2]/div/fieldset/div/div/div[3]/div[2]/div/input");
    By submitButton = By.xpath("//*[@id=\"DEFAULT_FORM\"]/div[2]/div[2]/div/fieldset/div/div/div[5]/div/span/input");
    By formError = By.className("popup-error");

    public FillInForm registerForm (String name, String email, String tel) {
        driver.findElement(registerButton).click();
        driver.findElement(NameField).sendKeys(name);
        driver.findElement(EmailField).sendKeys(email);
        driver.findElement(TelField).sendKeys(tel);
        driver.findElement(submitButton).click();
        return this;
    }

    public String getErrorText(){

        return driver.findElement(formError).getText();
    }

}
