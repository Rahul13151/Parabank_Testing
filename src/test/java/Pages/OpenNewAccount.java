package Pages;

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
    public OpenNewAccount(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void selectSavingAccountOption(){
        Select typeDropdownSelector = new Select(accountTypeDropdown);
        typeDropdownSelector.selectByValue("1");
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
}
