package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(name ="username")
    WebElement userNameInputBox;
    @FindBy(name ="password")
    WebElement passwordInputBox;
    @FindBy(css = "input[value='Log In']")
    WebElement logInButton;
    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerButton;
    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void enterLoginDetails(String userName,String password){
        userNameInputBox.sendKeys(userName);
        passwordInputBox.sendKeys(password);
    }
    public void clickLogInButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
    }
    public void clickOnRegisterButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }
    public boolean isErrorPageShown(){
        if(driver.getTitle().contains("Error"))
            return true;
        else
            return false;
    }
}
