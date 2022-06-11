package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.security.Key;
import java.util.List;

public class _12_Actions_Class extends Base{
    @Test(priority = 1, description = "Actions | move to element 1")
    public void moveToElementPractice1(){
        driver.get("https://www.techglobalschool.com/");

        WebElement address = driver.findElement(By.cssSelector("#comp-kixny3ro span>span"));

        Actions actions = new Actions(driver);
        actions.moveToElement(address).perform(); //This will not work unless you add .build().perform() with Selenium 3 we can add just the perform
        Waiter.pause(2);

        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");
    }

    @Test(priority = 2, description = "Actions class | move to element 2")
    public void moveToElementPractice2(){
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
}
