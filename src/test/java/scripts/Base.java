package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.EtsySearchPage;
import pages.TGApplicationPage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    EtsySearchPage etsySearchPage;
    TGApplicationPage tgApplicationPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        etsySearchPage = new EtsySearchPage(driver);
        tgApplicationPage = new TGApplicationPage(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}