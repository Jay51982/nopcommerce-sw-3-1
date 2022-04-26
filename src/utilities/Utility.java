package utilities;


import browserfactory.BaseTest;
import com.beust.jcommander.internal.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    /**
********************** This method will click on Web page element **************************
     */
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
        //driver.element(by).click();  // write also one line code as well.
    }

    /*
    *********************** This method will get text from element ****************************
     */
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    /**
     ********************* This method will send text on element *****************************
     */
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    //********************************Verify text*******************************************//

    public void verifyText(String exceptedMessage, String actualMessage, @Nullable String errorMessage)
    {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);
    }

    //***************************************************************************************
    //This method will calculate size of List <WebElement>
    public int sizeOfListWebElement(By by){
        List<WebElement> inventory = driver.findElements(by);
        int actualItems = inventory.size();
        return actualItems;
    }
    //***************************************************************************************
    //This method will clear the text box
    public void clearTheTextBox(By by){
        driver.findElement(by).clear();
    }



    //*************************************** Alert Methods ***************************
//This method will Switch to Alert Method
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method is for accepting Alerts
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //This method is for dismiss Alerts
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // This method is for get text from Alerts
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    // This method is for send text to Alerts
    public void sendTextAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //3)dismiss()
    //4)alert().getText()
    //5)alert().sendkys()
//*******select method**********//
    //1) select the option by visible text()  pass the blackcolour text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    //2)select by value blue colour
    public void selectByDropDown(By by ,String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }
    //3)select By Index()
    public void selectByIndex(By by,int text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(text);
    }
    //4)This method will select all options & choose 1 from all
    public void selectByAllOptions(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        //System.out.println("No. of Options:" + allOptions.size());
        for (WebElement element:allOptions) {
            System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
            }
        }
    }
    //4)getOption()
//   public void byGetOption(By by,int text){
//       WebElement dropdown = driver.findElement(by);
//       Select select = new Select(dropdown);
//       select.getOptions(text);
//   }
    //**************************************************** Action class ******************************************//
    //How to perform Mouse operation in selenium Wedriver?
    // 1)mouseHover click
    public void mouseHoverClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoverclick = driver.findElement(by);
        actions.moveToElement(mouseHoverclick).click().build().perform();
    }
    //2)mousehoveronly
    public void mouseHoverOnly(By by) {
        Actions actions = new Actions(driver);
        WebElement mousehHover1 = driver.findElement(by);
        actions.moveToElement(mousehHover1).build().perform();
    }
    //3)mousehoverand click
    //This method will be used to hover mouse on element & click

    public void mouseHoverToElementAndClick(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    //3)Drag and drop
    //4)slider
    //5)KeyBoard Events



   }






