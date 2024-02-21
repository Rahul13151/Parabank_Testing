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


public class OpenNewAccount {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "type")
    WebElement accountTypeDropdown;
    @FindBy(css = "input[value='Open New Account']")
    WebElement openNewAccountButton;
    @FindBy(id = "newAccountId")
    WebElement newAccountNumber;
    @FindBy(xpath = "//a[text()='Transfer Funds']")
    WebElement fundTransferButton;
    @FindBy(css = ".title")
    WebElement accountResponseTitle;
    @FindBy(xpath = "//select[@id='fromAccountId'] /option[1]")
    WebElement firstExsistingAccountOption;
    @FindBy(id="fromAccountId")
    WebElement fromAccountDropdown;
    public OpenNewAccount(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void selectSavingAccountOption(){
        Select typeDropdownSelector = new Select(accountTypeDropdown);
        typeDropdownSelector.selectByValue("1");
    }
    public void selectCheckingAccountOption(){
        Select typeDropdownSelector = new Select(accountTypeDropdown);
        typeDropdownSelector.selectByValue("0");
    }
    public void selectExsistingAccount(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(firstExsistingAccountOption));
        wait.until(ExpectedConditions.elementToBeClickable(fromAccountDropdown));
        //important
        //Mandatory to apply Thread.sleep() as text inside dropdown is taking sometime to appear and Explicit wait(wait.until) is unable to handle this
        try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}

    }


    public void clickOpenNewAccountBtn(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(openNewAccountButton));
        openNewAccountButton.click();
    }
    public String getNewAccountNumber(){
        return newAccountNumber.getText();
    }
    public void openTransferFundsPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(fundTransferButton));
        fundTransferButton.click();

    }
    public String returnOpenAccountStatus(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".title"),"Account Opened!"));
        return accountResponseTitle.getText();
    }
}
