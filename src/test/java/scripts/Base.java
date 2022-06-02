package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait wait;
    Wait fluentWait;
    SoftAssert softAssert;
    EtsySearchPage etsySearchPage;
    TGApplicationPage tgApplicationPage;
    GoogleSearchPage googleSearchPage;
    GoogleSearchResultPage googleSearchResultPage;
    HeroAppPage heroAppPage;
    FaceBookPage faceBookPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver,15);
        Wait fluentWait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(Exception.class);
        SoftAssert softAssert = new SoftAssert();
        etsySearchPage = new EtsySearchPage(driver);
        tgApplicationPage = new TGApplicationPage(driver);
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
        heroAppPage = new HeroAppPage(driver);
        faceBookPage = new FaceBookPage(driver);
    }

    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver();
    }

}