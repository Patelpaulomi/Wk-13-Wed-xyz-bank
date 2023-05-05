package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {
    AccountPage accountPage = new AccountPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    CustomerLogingPage customerLogingPage = new CustomerLogingPage();
    CustomersPage customersPage = new CustomersPage();
    HomePage homePage = new HomePage();
    OpenAccountPage openAccountPage = new OpenAccountPage();

    @Test
    public void bankManagerShouldAddCustomerSuccessfully(){
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerbutton();
       // click On "Add Customer" Tab
        bankManagerLoginPage.addCustomerTab();
        // enter FirstName
        addCustomerPage.enterFirstName("Mohan");
        //enter LastName
        addCustomerPage.enterLastName("Shah");
        //enter PostCode
        addCustomerPage.enterPostCode("Ha39je");
        //click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomerButton();
        //popup display
       // verify message "Customer added successfully"
        switchToAlert();
        String expectedMessage = "Customer added successfully";
        String actualMessage = getTextFromAlert().substring(0, 27);
       Assert.assertEquals(actualMessage, expectedMessage, "Customer added successfully");
       // click on "ok" button on popup.
        acceptAlert();
    }
    @Test
    public void bankManagerShouldOpenAccountSuccessfully() {
        //  click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerbutton();
        // click On "Open Account" Tab
        bankManagerLoginPage.opencustomerButton();
        // Search customer that created in first test
        openAccountPage.selectCustomerName("Harry Potter");
        //  Select currency "Pound"
        openAccountPage.selectCurrency("Pound");
        // click on "process" button
        openAccountPage.clickOnProcessBtn();
        // verify message "Account created successfully"
        switchToAlert();
        String expectedMessage = "Account created successfully";
        String actualMessage = getTextFromAlert().substring(0, 28);
        Assert.assertEquals(actualMessage, expectedMessage, "Account created successfully");
        // click on "ok" button on popup.
        acceptAlert();
    }
    @Test
    public void customerShouldLoginAndLogoutSuceessfully() {
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLogin();
        // search customer that you created.
        customersPage.selectYourName("Harry Potter");
        //  click on "Login" Button
        customersPage.clickLoginButton();
        //verify "Logout" Tab displayed.
        String expectedMessage = "Logout";
        String actualMessage = accountPage.verifyLogout();
       Assert.assertEquals(actualMessage, expectedMessage, "ABC");
        // click on "Logout"
        accountPage.clickOnLogout();
        // verify "Your Name" text displayed.
        String expectedText = "Your Name :";
        String actualText = customersPage.verifyYourNameText();
        Assert.assertEquals(actualText, expectedText, "ABC");
    }
    @Test
    public void customerShouldDepositMoneySuccessfully() {
        // click on "Customer Login" Tab
        homePage.clickOnCustomerLogin();
        // search customer that you created.
        customersPage.selectYourName("Harry Potter");
        // click on "Login" Button
        customersPage.clickLoginButton();
        // click on "Deposit" Tab
        accountPage.clickOnDepositButton();
        // Enter amount 2000
        accountPage.enterAmountDeposit("2000");
        // click on "Deposit" Button
        accountPage.clickOnDeposit();
        // verify message "Deposit Successful"
        String expectedText = "Deposit Successful";
        String actualText = accountPage.verifyDepositSuccessfull();
        Assert.assertEquals(expectedText, actualText, "Deposit Successful");
    }
    @Test
    public void customerShouldWithdrawMoneySuccessfully() {
        // click on "Customer Login" Tab
        homePage.clickOnCustomerLogin();
        // search customer that you created
        customersPage.selectYourName("Harry Potter");
        // click on "Login" Button
        customersPage.clickLoginButton();
        // click on "Withdrawl" Tab
        accountPage.clickOnWithdrawl();
        // Enter amount 50
        accountPage.amountWithdrawl("50");
        // click on "withdraw" Button
        accountPage.clickOnWithdrawlBtn();
        //verify message "Transaction Successful"
        String expectedText = "Transaction successful";
        String actualText = accountPage.verifyTransationSuccessful();
        Assert.assertEquals(expectedText, actualText, "Transaction successful");
    }

}
