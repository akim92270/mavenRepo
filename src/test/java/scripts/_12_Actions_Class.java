package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import utilities.Waiter;

import java.time.Duration;
import java.util.List;

public class _12_Actions_Class extends Base {
    @Test(priority = 1, description = "Actions | move to element 1")
    public void moveToElementPractice1() {
        driver.get("https://www.techglobalschool.com/");

        WebElement address = driver.findElement(By.cssSelector("#comp-kixny3ro span>span"));

        actions.moveToElement(address).perform(); //This will not work unless you add .build().perform() with Selenium 3 we can add just the perform
        Waiter.pause(2);

        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");
    }

    @Test(priority = 2, description = "Actions class | move to element 2")
    public void moveToElementPractice2() {
        driver.get("https://www.carvana.com/");

        /*WebElement financeDropdown = null;

        for (int i = 0; i < 5; i++) {
            if(financeDropdown != null) break;
            try{
                driver.navigate().refresh();
                financeDropdown = driver.findElement(By.cssSelector("div[data-cv-test='headerFinanceDropdown']"));
            }catch(StaleElementReferenceException e){
                e.printStackTrace();
            }
        }*/

        Waiter.pause(5); //not proper
        WebElement financeDropdown = driver.findElement(By.cssSelector("div[data-cv-test='headerFinanceDropdown']"));
        List<WebElement> financeDropdownOptions = driver.findElements(By.cssSelector("a[data-cv-test^=headerFi]"));
        Waiter.pause(2);
        actions.moveToElement(financeDropdown).perform();
        String[] financeMenu = {"WHY FINANCE WITH CARVANA", "GET PREQUALIFIED", "AUTO LOAN CALCULATOR"};
        for (int i = 0; i < financeDropdownOptions.size(); i++) {
            Assert.assertTrue((financeDropdownOptions.get(i).isDisplayed()));
            Assert.assertEquals(financeDropdownOptions.get(i).getText(), financeMenu[i]);
            System.out.println("==============" + financeDropdownOptions.get(i).getText() + "=====================");
        }
    }

    /*
    Go to https://www.techglobalschool.com/
    Click on "Register for Intro Session" link
    Validate the url is https://www.techglobalschool.com/apply-now-1
     */

    @Test(priority = 3, description = "Actions | Click")
    public void clickOnElementPractice() {
        driver.get("https://www.techglobalschool.com/");

        WebElement registerForIntroLink = driver.findElement(By.cssSelector("#comp-kvjohd5t5>a"));
//        actions.moveToElement(registerForIntroLink).perform();
//        Waiter.pause(2);
//        actions.click(registerForIntroLink).perform();

        actions.moveToElement(registerForIntroLink).pause(Duration.ofSeconds(2)).click().perform();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.techglobalschool.com/apply-now-1");
    }

    /*
    Go to https://www.techglobalschool.com/
    Right click on "Register for Intro Session" link
    Validate the url is https://www.techglobalschool.com/
     */

    @Test(priority = 4, description = "Actions | Right Click")
    public void rightClickOnElementPractice() {
        driver.get("https://www.techglobalschool.com/");
        WebElement registerForIntroLink = driver.findElement(By.cssSelector("#comp-kvjohd5t5>a"));

        actions.contextClick(registerForIntroLink).perform();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.techglobalschool.com/");
    }

    /*PRACTICE

    Go to https://demoqa.com/droppable
    Click and hold ”Drag me” box and release it on “Drop here” box
    Validate “Drop here” text is replaced with “Dropped!”

    Method name = clickHoldAndReleasePractice()
    Test name = Actions class | click-hold-release an element*/


    @Test(priority = 5, description = "Actions | Click - hold and release | Drag and drop")
    public void clickHoldAndReleasePractice() {
        driver.get("https://demoqa.com/droppable");

        WebElement dragMeBox = driver.findElement(By.id("draggable"));
        WebElement dropHereBox = driver.findElement(By.id("droppable"));

        //actions.clickAndHold(dragMeBox).moveToElement(dropHereBox).release().perform();
        actions.dragAndDrop(dragMeBox, dropHereBox).perform();

        Assert.assertEquals(dropHereBox.getText(), "Dropped!");
    }

    /*
    Go to https://www.google.com/
    Enter "Hello" to search input box
    Validate value attribute is "Hello"

    Method name = sendKeysToAnElement ()
    Test name = Actions class | send keys to an element
     */
    @Test(priority = 6, description = "Actions | Send Keys to an element")
    public void sendKeysToAnElement() {
        driver.get("https://www.google.com/");
        Waiter.pause(10);
        actions.sendKeys(driver.findElement(By.name("q")), "Hello").perform();
        Waiter.pause(10);
        Assert.assertEquals(driver.findElement(By.name("q")).getAttribute("value"), "Hello");
    }


    /*
Go to https://www.google.com/
Enter "techglobal" to search input box with uppercases
Validate the value attribute for search input box is "TECHGLOBAL"
Then, copy the text and paste again
Validate the value attribute for search input box is "TECHGLOBALTECHGLOBAL"
 */

    @Test(priority = 7, description = "Actions | key down and key up")
    public void practiceKeyDownAndKeyUp(){
        driver.get("https://www.google.com/");

        //googleSearchPage.searchInputBox.sendKeys("TECHGLOBALTECHGLOBAL");

        actions.keyDown(Keys.SHIFT)
                .sendKeys(googleSearchPage.searchInputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .pause(Duration.ofSeconds(2))
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.ARROW_RIGHT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.CONTROL).sendKeys("v")
                .perform();

        Waiter.pause(2);

        Assert.assertEquals(googleSearchPage.searchInputBox.getAttribute("value"), "TECHGLOBALTECHGLOBAL");
    }
}