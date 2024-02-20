package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPay {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(name = "payee.name")
    WebElement payeeNameInputBox;
    @FindBy(name = "payee.address.street")
    WebElement addressInputBox;
    @FindBy(name = "payee.address.city")
    WebElement cityInputBox;
    @FindBy(name = "payee.address.state")
    WebElement stateInputBox;
    @FindBy(name="payee.address.zipCode")
    WebElement zipCodeInputBox;
    @FindBy(name = "payee.phoneNumber")
    WebElement phoneNumberInputBox;
    @FindBy(name="payee.accountNumber")
    WebElement payeeAccountNoInputBox;
    @FindBy(name="verifyAccount")
    WebElement verifyAccountNoInputBox;
    @FindBy(name = "amount")
    WebElement amountInputBox;
    @FindBy(name = "fromAccountId")
    WebElement fromAccountDropdown;
    @FindBy(css = "input[value='Send Payment']")
    WebElement sendPaymentBtn;
    @FindBy(xpath = "//a[text()='Request Loan']")
    WebElement requestLoanBtn;
    public BillPay(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void enterPayeeName(String name){
        payeeNameInputBox.sendKeys(name);
    }
    public void enterPayeeAddress(String streetAdd,String city,String state,String zip){
        addressInputBox.sendKeys(streetAdd);
        cityInputBox.sendKeys(city);
        stateInputBox.sendKeys(state);
        zipCodeInputBox.sendKeys(zip);
    }
    public void enterPhoneNo(String phoneNo){
        phoneNumberInputBox.sendKeys(phoneNo);
    }
    public void enterPayeeAccountNo(String accountNo){
        payeeAccountNoInputBox.sendKeys(accountNo);
    }
    public void enterConfirmAccountNo(String accountNo){
        verifyAccountNoInputBox.sendKeys(accountNo);
    }
    public void enterAmount(String amount){
        amountInputBox.sendKeys(amount);
    }
    public void clickSendPayment(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(sendPaymentBtn));
        sendPaymentBtn.click();
    }
    public void selectFromAccount(String accountNumber){
        Select fromDropdownSelector = new Select(fromAccountDropdown);
        fromDropdownSelector.selectByValue(accountNumber);
    }
    public void openRequestLoanPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(requestLoanBtn));
        requestLoanBtn.click();
    }


}
