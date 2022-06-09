package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _10_WindowHandles extends Base{
    /*
    TEST CASE 1: Validate FaceBook social media icon for TechGlobal School
    1. Go to https://www.techglobalschool.com/
    2. Click on FaceBook icon in the footer
    3. Validate user is routed to https://www.facebook.com/techglobalschool
     */
    @Test(priority = 1, description = "TEST CASE 1: Validate FaceBook social media icon for TechGlobal School")
    public void testTechGlobalSchoolFacebookIcon(){
        driver.get("https://www.techglobalschool.com/");

        String tgHomeWindowHandle = driver.getWindowHandle(); //CDwindow-052AF1B021AD27B045D33A528DE1A66E

        tgHomePage.faceBookIcon.click();

        //2 tabs
        for(String windowHandle : driver.getWindowHandles()){
            if(!windowHandle.equals(tgHomeWindowHandle)) driver.switchTo().window(windowHandle);
        }

        System.out.println("--------------Switching to FaceBook-----------------");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        System.out.println("--------------Switching to TechGlobal-----------------");
        driver.switchTo().window(tgHomeWindowHandle);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Multiple Windows” link DONE
    Click on “Click Here” link DONE
    Validate the heading3 as “New Window”
    Navigate back to previous window
    Validate the heading3 as “Opening a new window”
     */
    @Test(priority = 2, description = "TEST CASE 2: Multiple Windows")
    public void heading3(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Multiple Windows");

        heroAppPage.clickHere.click();

        String heroAppHandler = driver.getWindowHandle();

        for (String windowHandler : driver.getWindowHandles()) {
            if(!windowHandler.equals(heroAppHandler)) driver.switchTo().window(windowHandler);
        }

        Assert.assertEquals(heroAppPage.newWindow.getText(), "New Window");

        driver.switchTo().window(heroAppHandler);

        Assert.assertEquals(heroAppPage.openingANewWindow.getText(), "Opening a new window");

    }
}
