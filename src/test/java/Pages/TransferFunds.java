package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFunds {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id="amount")
    WebElement amountInputBox;
    @FindBy(id = "fromAccountId")
    WebElement fromAccountDropdown;
    @FindBy(xpath = "//*[@id='fromAccountId']//option[1]")
    WebElement firstFromAccountOption;
    @FindBy(id="toAccountId")
    WebElement toAccountDropdown;
    @FindBy(xpath = "//*[@id='toAccountId']//option[1]")
    WebElement firstToAccountOption;
    @FindBy(css = "input[value='Transfer']")
    WebElement transferbutton;
    @FindBy(xpath = "//a[text()='Bill Pay']")
    WebElement billPayButton;
    @FindBy(css=".title")
    WebElement titleAfterTransaction;
    public TransferFunds(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void transferFundsFromAccount1to2(String amount){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("NO sotoooooooooooooop");
            throw new RuntimeException(e);
        }
        amountInputBox.sendKeys(amount);

        Select fromDropdownSelector = new Select(fromAccountDropdown);
        fromDropdownSelector.selectByIndex(0);
        Select toDropdownSelector = new Select(toAccountDropdown);
        toDropdownSelector.selectByIndex(1);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(transferbutton));
        transferbutton.click();
    }
    public void openBillPayPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(billPayButton));
        billPayButton.click();
    }
    public void transferFundsToSameAccount(String amount){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        amountInputBox.sendKeys(amount);

        Select fromDropdownSelector = new Select(fromAccountDropdown);
        fromDropdownSelector.selectByIndex(0);
        Select toDropdownSelector = new Select(toAccountDropdown);
        toDropdownSelector.selectByIndex(0);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(transferbutton));
        transferbutton.click();
    }
    public String returnTransferFundStatus(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".title"),"Transfer Complete!"));
        return titleAfterTransaction.getText();
    }

}
