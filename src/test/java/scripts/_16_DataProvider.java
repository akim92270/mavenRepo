package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _16_DataProvider extends Base{

    @Test(priority = 1)
    public void testGoogleSearch1(){
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Apple" + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("Apple"));
    }

    @Test(priority = 1)
    public void testGoogleSearch2(){
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Orange" + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("Orange"));
    }


}
