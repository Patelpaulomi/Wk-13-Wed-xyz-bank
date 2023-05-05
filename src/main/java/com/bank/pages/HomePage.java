package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By bankManagerLogin = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    By customerLogin = By.xpath("//button[normalize-space()='Customer Login']");


    public void clickOnBankManagerbutton(){clickOnElement(bankManagerLogin);}
    public void clickOnCustomerLogin(){clickOnElement(customerLogin);}


}
