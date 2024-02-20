package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestLoan {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id="amount")
    WebElement loanAmountInputBox;
    @FindBy(id="downPayment")
    WebElement downPaymentInputBox;
    @FindBy(id = "fromAccountId")
    WebElement fromAccountDropdown;
    @FindBy(css = "input[value='Apply Now']")
    WebElement applyNowBtn;
    @FindBy(id = "loanStatus")
    WebElement statusLocator;
    public RequestLoan(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void enterLoanDetails(String loanAmount,String downPayment,String fromAccount){
        loanAmountInputBox.sendKeys(loanAmount);
        downPaymentInputBox.sendKeys(downPayment);
        Select fromDropdownSelector = new Select(fromAccountDropdown);
        fromDropdownSelector.selectByValue(fromAccount);

    }
    public void clickApplyNow(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(applyNowBtn));
        applyNowBtn.click();
    }
    public String getStatus(){
        return statusLocator.getText();
    }
}
