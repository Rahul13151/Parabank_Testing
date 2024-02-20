package Tests;

import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ProjectConfig;
import utils.TestContextSetup;

import java.time.Duration;

public class AssignedTest {
    TestContextSetup tcs;
    private String newAccountNumber;
    public void registerUser(){
        tcs.setup().getLogin().enterLoginDetails("adminn","admin@123");
        tcs.setup().getLogin().clickLogInButton();
        if(tcs.setup().getLogin().isErrorPageShown()) {
            tcs.setup().getLogin().clickOnRegisterButton();
            tcs.setup().getRegisterPage().enterFirstName("Vijay");
            tcs.setup().getRegisterPage().enterLastName("last");
            tcs.setup().getRegisterPage().enterAddress("A-3333");
            tcs.setup().getRegisterPage().enterCity("Noida");
            tcs.setup().getRegisterPage().enterState("UP");
            tcs.setup().getRegisterPage().enterZipCode("201301");
            tcs.setup().getRegisterPage().enterPhoneNo("8998484");
            tcs.setup().getRegisterPage().enterSSN("48940");
            tcs.setup().getRegisterPage().enterUserName("adminn");
            tcs.setup().getRegisterPage().enterPassword("admin@123");
            tcs.setup().getRegisterPage().enterConfirmPassword("admin@123");
            tcs.setup().getRegisterPage().clickRegisterButton();
        }
    }
    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browser){
         tcs= new TestContextSetup(browser);
         tcs.base.initializeDriver(browser).get(ProjectConfig.url);
         registerUser();
    }


    @Test(priority = 0)
    public void checkCreatingSavingsAccount(){
        tcs.setup().getHomePage().clickOnOpenNewAccountBtn();
        tcs.setup().getOpenNewAccount().selectSavingAccountOption();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tcs.setup().getOpenNewAccount().clickOpenNewAccountBtn();
        newAccountNumber = tcs.setup().getOpenNewAccount().getNewAccountNumber();
        String actualStatus =tcs.setup().getOpenNewAccount().returnOpenAccountStatus() ;
        Assert.assertEquals(actualStatus,"Account Opened!");
    }
    @Test(priority = 1)
    public void checkCreatingCheckingAccount(){
        tcs.setup().getHomePage().clickOnOpenNewAccountBtn();
        tcs.setup().getOpenNewAccount().selectCheckingAccountOption();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tcs.setup().getOpenNewAccount().clickOpenNewAccountBtn();
        newAccountNumber = tcs.setup().getOpenNewAccount().getNewAccountNumber();
        String actualStatus =tcs.setup().getOpenNewAccount().returnOpenAccountStatus() ;
        Assert.assertEquals(actualStatus,"Account Opened!");
    }/*
    @Test(priority = 2,dataProvider = "amountDataProvider",dataProviderClass = CustomDataProvider.class)
    public void validTransferFunds(String amount){
        tcs.setup().getOpenNewAccount().openTransferFundsPage();
        tcs.setup().getTransferFunds().transferFundsFromAccount1to2(amount);
        String actualStatus = tcs.setup().getTransferFunds().returnTransferFundStatus();
        Assert.assertEquals(actualStatus,"Transfer Complete!");
    }

    //Making Transfer when From and To accounts are Same
    @Test(priority=3,dataProvider = "amountDataProvider",dataProviderClass = CustomDataProvider.class)
    public void invalidFundsTransfer(String amount){
        tcs.setup().getOpenNewAccount().openTransferFundsPage();
        tcs.setup().getTransferFunds().transferFundsToSameAccount(amount);
        String actualStatus = tcs.setup().getTransferFunds().returnTransferFundStatus();
        Assert.assertNotEquals(actualStatus,"Transfer Complete!");
    }

    //Passing all valid
    @Test(priority = 4)
    public void validBillPay(){
        tcs.setup().getTransferFunds().openBillPayPage();
        tcs.setup().getBillPay().enterPayeeName("xyz");
        tcs.setup().getBillPay().enterPayeeAddress("a-222","noida","UP","20202");
        tcs.setup().getBillPay().enterPhoneNo("646561343");
        tcs.setup().getBillPay().enterPayeeAccountNo("101");
        tcs.setup().getBillPay().enterConfirmAccountNo("101");
        tcs.setup().getBillPay().enterAmount("500");
        tcs.setup().getBillPay().selectFromAccount(newAccountNumber);
        tcs.setup().getBillPay().clickSendPayment();
        String actualTitleAfterPayingBill = tcs.setup().getBillPay().getBillPaymentStatus();
        Assert.assertEquals(actualTitleAfterPayingBill,"Bill Payment Complete");
    }

    // Try to pay a bill with negative bill Amount
    @Test(priority = 4)
    public void invalidBillPay(){
        tcs.setup().getTransferFunds().openBillPayPage();
        tcs.setup().getBillPay().enterPayeeName("xyz");
        tcs.setup().getBillPay().enterPayeeAddress("a-222","noida","UP","20202");
        tcs.setup().getBillPay().enterPhoneNo("646561343");
        tcs.setup().getBillPay().enterPayeeAccountNo("101");
        tcs.setup().getBillPay().enterConfirmAccountNo("101");
        tcs.setup().getBillPay().enterAmount("-500");
        tcs.setup().getBillPay().selectFromAccount(newAccountNumber);
        tcs.setup().getBillPay().clickSendPayment();
        String actualTitleAfterPayingBill = tcs.setup().getBillPay().getBillPaymentStatus();
        Assert.assertNotEquals(actualTitleAfterPayingBill,"Bill Payment Complete");
    }
    @Test(priority = 5)
    public void validLoanRequest(){
        tcs.setup().getBillPay().openRequestLoanPage();
        tcs.setup().getRequestLoan().enterLoanDetails("2000","200",newAccountNumber);
        tcs.setup().getRequestLoan().clickApplyNow();
        String actualStatus= tcs.setup().getRequestLoan().getStatus();
        Assert.assertEquals(actualStatus,"Approved");
    }

    //Selecting negative loan Amount
    @Test(priority = 6)
    public void invalidLoanRequest(){
        tcs.setup().getBillPay().openRequestLoanPage();
        tcs.setup().getRequestLoan().enterLoanDetails("-2000","200",newAccountNumber);
        tcs.setup().getRequestLoan().clickApplyNow();
        String actualStatus= tcs.setup().getRequestLoan().getStatus();
        Assert.assertEquals(actualStatus,"Denied");
    }
    @AfterTest
    public void tearDown(){
        tcs.base.closeDriver();
    }

    */
}
