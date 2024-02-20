package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "customer.firstName")
    WebElement firstNameInputBox;
    @FindBy(id = "customer.lastName")
    WebElement lastNameInputBox;
    @FindBy(id="customer.address.street")
    WebElement addressInputBox;
    @FindBy(id = "customer.address.city")
    WebElement cityInputBox;
    @FindBy(id="customer.address.state")
    WebElement stateInputBox;
    @FindBy(id="customer.address.zipCode")
    WebElement zipCodeInputBox;
    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumberInputBox;
    @FindBy(id = "customer.ssn")
    WebElement ssnInputBox;
    @FindBy (id="customer.username")
    WebElement usernameInputBox;
    @FindBy (id="customer.password")
    WebElement passwordInputBox;
    @FindBy (id="repeatedPassword")
    WebElement confirmPasswordInputBox;
    @FindBy(css ="input[value='Register']")
    WebElement registerButton;

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void enterFirstName(String firstName){
        firstNameInputBox.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        lastNameInputBox.sendKeys(lastName);
    }
    public void enterAddress(String address){
        addressInputBox.sendKeys(address);
    }
    public void enterCity(String city){
        cityInputBox.sendKeys(city);
    }
    public void enterState(String state){
        stateInputBox.sendKeys(state);
    }
    public void enterZipCode(String zip){
        zipCodeInputBox.sendKeys(zip);
    }
    public void enterPhoneNo(String phoneNo){
        phoneNumberInputBox.sendKeys(phoneNo);
    }
    public void enterSSN(String ssn){
        ssnInputBox.sendKeys(ssn);
    }
    public void enterUserName(String userName){
        usernameInputBox.sendKeys(userName);
    }
    public void enterPassword(String password){
        passwordInputBox.sendKeys(password);
    }
    public void enterConfirmPassword(String confirmPassword){
        confirmPasswordInputBox.sendKeys(confirmPassword);
    }
    public void clickRegisterButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }
}
