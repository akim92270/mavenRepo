package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeroAppPage {
    public HeroAppPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul/li/a")
    public List<WebElement> links;

    @FindBy(css = "#checkboxes>input")
    public List<WebElement> checkboxes;

    @FindBy(xpath = "//ul//button")
    public List<WebElement> alertButtons;

    @FindBy(id = "result")
    public WebElement resultParagraph;

    @FindBy(xpath = "//a[text()='iFrame']")
    public WebElement iFrameLink;

    @FindBy(css = "#tinymce>p")
    public WebElement contentBox;

    @FindBy(xpath = "//h3")
    public WebElement iFrameHeading3;

    @FindBy(id = "mce_0_ifr")
    public WebElement innerIFrame;

    @FindBy(css = "a[href='/windows/new']")
    public WebElement clickHere;

    @FindBy(css = ".example>h3")
    public WebElement openingANewWindow;

    @FindBy(css = ".example>h3")
    public WebElement newWindow;

    @FindBy(id="file-upload")
    public WebElement chooseFile;

    @FindBy(id="file-submit")
    public WebElement upload;

    @FindBy(id="uploaded-files")
    public WebElement uploadedFiles;

    @FindBy(css = ".example h3")
    public WebElement banana;

    @FindBy(linkText = "myFileBanana.txt")
    public WebElement myDownloadFile;

    @FindBy(css = "#table1 th")
    public List<WebElement> tableHeader;

    @FindBy(css = "#table1>tbody>tr:nth-child(1)>td")
    public List<WebElement> firstTableFirstColumn;

    @FindBy(css = "#table1>tbody td:nth-child(2)")
    public List<WebElement> secondTableSecondColumn;

    @FindBy(css = "#table1 td")
    public List<WebElement> cellValues;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = ".radius")
    public WebElement loginButton;

    public void clickOnLink(String linkText){
        for (WebElement link : links) {
            if(link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }

    public void clickOnAlertButton(String buttonText){
        for(WebElement element: alertButtons){
            if(element.getText().equals(buttonText)){
                element.click();
                break;
            }
        }
    }
}