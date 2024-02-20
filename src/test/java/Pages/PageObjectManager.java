package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjectManager {
    public WebDriver driver;
    Login login;
    BillPay billPay;
    DashboardPage dashboardPage;
    HomePage homePage;
    OpenNewAccount openNewAccount;
    RegisterPage registerPage;
    RequestLoan requestLoan;
    TransferFunds transferFunds;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
        login = new Login(driver);
        billPay = new BillPay(driver);
        dashboardPage = new DashboardPage(driver);
        homePage = new HomePage(driver);
        openNewAccount = new OpenNewAccount(driver);
        registerPage = new RegisterPage(driver);
        requestLoan = new RequestLoan(driver);
        transferFunds = new TransferFunds(driver);
    }


    public BillPay getBillPay() {
        return billPay;
    }

    public DashboardPage getDashboardPage() {
        return dashboardPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public Login getLogin() {
        return login;
    }

    public OpenNewAccount getOpenNewAccount() {
        return openNewAccount;
    }

    public RequestLoan getRequestLoan() {
        return requestLoan;
    }

    public TransferFunds getTransferFunds() {
        return transferFunds;
    }
}
