package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class OpenAccountPage extends Utility {
    By searchCustomer = By.xpath("//select[@id='userSelect']");
    By currencyPound = By.xpath("//select[@id='currency']");
    By clickProcessButton = By.xpath("//button[normalize-space()='Process']");


    public void selectCustomerName(String customerName){
        clickOnElement(searchCustomer);
        selectByVisibleTextFromDropDown(searchCustomer,customerName);
    }
    public void selectCurrency(String currencyName ){
        clickOnElement(currencyPound);
        selectByVisibleTextFromDropDown(currencyPound,currencyName);
    }
    public void clickOnProcessBtn(){clickOnElement(clickProcessButton);}

}
