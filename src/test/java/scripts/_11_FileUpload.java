package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeroAppPage;
import utilities.Waiter;

public class _11_FileUpload extends Base{
    /*
    Create a MS-Word file on your desktop called “myFile.docx”
    Go to http://the-internet.herokuapp.com/
    Click on “File Upload” link
    Choose created file to be uploaded to the page
    Click on “Upload” button
    Validate “File Uploaded!” heading3 text
    Validate ”myFile.docx” in the uploaded file list
     */
    @Test(priority = 1, description = "File Upload")
    public void testFileUpload1(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("File Upload");
        heroAppPage.chooseFile.sendKeys("C:\\Users\\abrah\\IdeaProjects\\testing_framework\\myFileBanana.txt");
        heroAppPage.upload.click();

        Waiter.pause(10);

        Assert.assertEquals(heroAppPage.banana.getText(), "File Uploaded!");
        Assert.assertEquals(heroAppPage.uploadedFiles.getText(), "myFileBanana.txt");


    }
}
