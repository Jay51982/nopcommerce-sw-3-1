package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

import java.util.Random;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        Thread.sleep(1000);
        mouseHoverOnly(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
        //1.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(1000);
        mouseHoverClick(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
        //1.3 Verify the text “Cell phones”
        Thread.sleep(1000);
        verifyText("Cell phones", getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")), "Incorrect Page2");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse Hover on “Electronics” Tab
        Thread.sleep(1000);
        mouseHoverOnly(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));

        //2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(1000);
        mouseHoverClick(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));

        //2.3 Verify the text “Cell phones”
        Thread.sleep(1000);
        verifyText("Cell phones", getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")), "Text message not incorrect");

        //2.4 Click on List View Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//div[@class='item-grid']//a[contains(text(),'Nokia Lumia 1020')]"), Keys.ENTER + "1");

        //2.6 Verify the text “Nokia Lumia 1020” & 	2.7 Verify the price “$349.00
        Thread.sleep(1000);
        verifyText("$349.00", getTextFromElement(By.xpath("//span[contains(text(),' $349.00 ')]")), "Price message incorrect");

        //2.8 Change quantity to 2
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), Keys.BACK_SPACE + "2");

        //2.9 Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(1000);
        verifyText("shopping cart", getTextFromElement(By.xpath("//a[contains(text(),'shopping cart')]")), "Message is not appear & Error.");

        //After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        mouseHoverOnly(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //	2.12 Verify the message "Shopping cart
        Thread.sleep(1000);
        verifyText("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")), "Shopping cart not appear");

        //	2.13 Verify the quantity is 2
        Thread.sleep(1000);
        verifyText("(2)", getTextFromElement(By.xpath("//span[contains(text(),'(2)')]")), "Incorrect Quantity");

        //2.14 Verify the Total $698.00
        Thread.sleep(1000);
        verifyText("$698.00", getTextFromElement(By.xpath("//span[contains(text(),'$698.00') and @class='product-subtotal']")), "Error");

        //2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on checkout
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //“2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        verifyText("Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")), "Error");

        //2.18 Click on “REGISTER” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        Thread.sleep(1000);
        verifyText("Register", getTextFromElement(By.xpath("//h1[contains(text(),'Register')]")), "Register - Error message");

        //	2.20 Fill the mandatory fields
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='gender-female']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Abc");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Xyz");
        clickOnElement(By.id("Email"));
        Random randomEmail = new Random();
        int randomInt = randomEmail.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "username" + randomInt + "@gmail.com");
        sendTextToElement(By.id("Password"), "abcxyz123");
        sendTextToElement(By.id("ConfirmPassword"), "abcxyz123");

        //2.21 Click on “REGISTER” Button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        Thread.sleep(1000);
        verifyText("Your registration completed", getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")), "Registration failed");

        //	2.23 Click on “CONTINUE” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //	2.24 Verify the text “Shopping cart”
        Thread.sleep(1000);
        verifyText("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")), "Shopping card Error");

        //2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //	2.27 Fill the Mandatory fields
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "159 Ealing Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HP20 1DA");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07565432789");

        //2.28 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

        //2.30 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        // 2.31 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

        // 2.33 Fill all the details
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Abc Xyz");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "225");

        //2.34 Click on “CONTINUE”CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(1000);
        verifyText("Credit Card", getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")), "Payment method error");
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        verifyText("2nd Day Air", getTextFromElement(By.xpath("//span[contains(.,'2nd Day Air')]")), "Courier - Error");
        // 2.37 Verify Total is “$698.00”
        Thread.sleep(1000);
        verifyText("$698.00", getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]")), "Amount - Error");

        //	2.38 Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //	2.39 Verify the Text “Thank You”
        Thread.sleep(1000);
        verifyText("Thank you", getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")), "Thank you Message -Error");

        //	2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(1000);
        verifyText("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")), "Message error");

        //	2.41 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store
        Thread.sleep(1000);
        verifyText("Welcome to our store", getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")), "Welcome to store message - error");

        //2.43 Click on “Logout” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/");
    }

    @After
    public void closeDown() {
        closeBrowser();
    }

}

