package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DashboardPage  {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[text()='Open New Account']")
    WebElement openNewAccountButton;
    public DashboardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnOpenNewAccountBtn(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(openNewAccountButton));
        openNewAccountButton.click();
    }
}
