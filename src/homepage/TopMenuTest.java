package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));
        String epectedTabDisplayText = menu;
        String actualTabDisplayText = getTextFromElement(By.tagName("h1"));
        Assert.assertEquals("Link not working.", epectedTabDisplayText, actualTabDisplayText);
    }
    @Test
    public void verifyPageNavigation(){
        selectMenu("Computers");
        selectMenu("Electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
