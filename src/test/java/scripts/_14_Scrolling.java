package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _14_Scrolling extends Base{
    @Test
    public void testScrolling() {
        driver.get("https://www.techglobalschool.com/");
        Waiter.pause(3);

        //actions.moveToElement(tgHomePage.registerForIntroLink).perform();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Waiter.pause(3);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);\n" +
        //        "var elementTop = arguments[0].getBoundingClientRect().top;\n" +
        //        "window.scrollBy(0, elementTop-(viewPortHeight/2));", tgHomePage.registerForIntroLink);
        js.executeScript ("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", tgHomePage.registerForIntroLink);
        js.executeScript ("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", tgHomePage.faceBookIcon);
        Waiter.pause(5);


    }

    @Test
    public void testScrolling1() {
        driver.get("https://www.techglobalschool.com/");
    }
}
