package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    /*Test name ()
	1.1 Click on Computer Menu.
	1.2 Click on Desktop
	1.3 Select Sort By position "Name: Z to A"
	1.4 Verify the Product will arrange in Descending order. */
    public void veriftyPriceLowToHigh(){
        mouseHoverOnly(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        // Click on Desktop
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //Select Sort by price : "Price : Low to High"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Price: Low to High");
        //1.4 Verify the Product will arrange in Descending order.
        verifyText("Name: Z to A", getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]")), "Error, Message not displayed");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

//        2.1 Click on Computer Menu.
        mouseHoverOnly(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

//        2.2 Click on Desktop
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));

//        2.3 Select Sort By position "Name: A to Z"
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: Z to A");
    //        2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        mouseHoverClick(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));

//     2.5 Verify the Text "Build your own computer"
      //  verifyText("Build your own computer", getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]")), "Error, Message not displayed");

//        2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");

//        2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");


//        2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        mouseHoverOnly(By.xpath("//label[@for='product_attribute_3_7']"));
        clickOnElement(By.xpath("//label[@for='product_attribute_3_7']"));

//        2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_4_9']"));

//        2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
//        Thread.sleep(1000);
//        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_5_12']"));

//        2.11 Verify the price "$1,475.00"
        Thread.sleep(1000);
        verifyText("$1,475.00",getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]")), "Total not matched");


//        2.12 Click on "ADD TO CART" Button.
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[@id='add-to-cart-button-1']"));

//        2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(1000);
        verifyText("The product has been added to your shopping cart", getTextFromElement(By.xpath("//p[@class='content']")),"Message not found");
////p[@class='content']
//        After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//span[@title='Close']"));


//        2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        mouseHoverOnly(By.xpath("//span[@class='cart-label']"));
        mouseHoverClick(By.xpath("//button[normalize-space()='Go to cart']"));

//        2.15 Verify the message "Shopping cart"
        verifyText("Shopping cart",getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']")),"Message not found");

//        2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
        sendTextToElement(By.xpath("(//input[contains(@id, 'itemquantity')])"), Keys.BACK_SPACE + "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));


//        2.17 Verify the Total"$2,950.00"
        Thread.sleep(1000);
        verifyText("$2,950.00",getTextFromElement(By.xpath("//span[@class='product-subtotal']")),"Total not found");

//        2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

//        2.19 Click on “CHECKOUT”
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[@id='checkout']"));

//        2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        verifyText("Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")),"Message not found");

//        2.21Click on “CHECKOUT AS GUEST”Tab
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[normalize-space()='Checkout as Guest']"));

//        2.22 Fill the all mandatory field
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Abc");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Xyz");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"abc@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Brighton Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"123 456");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"01234 567890");


//        2.23 Click on “CONTINUE”
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[@onclick='Billing.save()']"));

//        2.24 Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//input[@id='shippingoption_1']"));

//        2.25 Click on “CONTINUE”
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

//        2.26 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//input[@id='paymentmethod_1']"));

//        2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(1000);
        //selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
        mouseHoverToElementAndClick(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

//        2.28 Fill all the details
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Mr Abc Xyz");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"),"01");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"225");

//        2.29 Click on “CONTINUE”
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

//        2.30 Verify “Payment Method” is “Credit Card”
        Thread.sleep(1000);
        verifyText("Credit Card",getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']")), "Payment method details not found");


//        2.32 Verify “Shipping Method” is “Next Day Air”
        Thread.sleep(1000);
    //    verifyText("Next Day Air", getTextFromElement(By.xpath("//*[@id=\"shipping-methods-form\"]/ul/li[2]/div[1]') and @class='value']")), "Shipping method message not found");

//        2.33 Verify Total is “$2,950.00”
        Thread.sleep(1000);
        verifyText("$2950.00",getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]")), "Total not found.");

//        2.34 Click on “CONFIRM”
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[normalize-space()='Confirm']"));
//        2.35 Verify the Text “Thank You”
        Thread.sleep(1000);
        verifyText("Thank you",getTextFromElement(By.xpath("//button[normalize-space()='Confirm']")), "Thank you message not found.");

//        2.36 Verify the message “Your order has been successfully processed!”
        Thread.sleep(1000);
        verifyText("Your order has been successfully processed!",getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")), "Message not found");

//        2.37 Click on “CONTINUE”
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[normalize-space()='Continue']"));

//        2.37 Verify the text “Welcome to our store”
        Thread.sleep(1000);
        verifyText("Welcome to our store",getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']")),"Welcome message not found.");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}


