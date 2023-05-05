package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class CustomerLogingPage extends Utility {
    By clickCustomerLoginTab = By.xpath("//button[normalize-space()='Customer Login']");
    By createdCustomer = By.xpath("//select[@id='userSelect']");
    By clickOnLoginButton = By.xpath("//button[normalize-space()='Login']");

}
