package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _04_GoogleSearchTest extends Base {

    /*
    TC765: Validate Google search
    1. Go to "https://www.google.com/"
    2. Search for "Selenium"
    3. Validate the results are more than zero
     */

    @Test(priority = 1, description = "TC765: Validate Google search")
    public void testGoogleSearch() {
        driver.get("https://www.google.com/");

        googleSearchPage.searchInputBox.sendKeys("Apple" + Keys.ENTER);

        String results = googleSearchResultPage.resultTag.getText(); //About 1,220,000,000 results (0.51 seconds)

        Assert.assertTrue(Long.parseLong(results.substring(results.indexOf(" ") + 1, results.indexOf("results") - 1).replace(",", "")) > 0);
    }

    /*
   1. Go to https://www.google.com/
   2. Click on "Store" link
   3. Validate the title of the page is "Google Store for Google Made Devices & Accessories"
    */

    @Test(priority = 2, description = "TC123: Validate Google Store Link")
    public void testGoogleStoreLink() {
        driver.get("https://www.google.com");

        Waiter.waitForVisibilityOfElement(driver, googleSearchPage.storeLink, 30);// 120 attempts
        googleSearchPage.storeLink.click();

        //Throw exception - Use explicit wait to prevent

        //explicitWait.until(ExpectedConditions.titleIs("Google Store for Google Made Devices & Accessories"));
        Waiter.waitUntilTitleIs(driver, 30, "Google Store for Google Made Devices & Accessories");

        Assert.assertEquals(driver.getTitle(), "Google Store for Google Made Devices & Accessories");
    }
}