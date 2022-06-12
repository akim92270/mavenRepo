package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeroAppPage;
import utilities.Waiter;

public class _13_Table extends Base {

    @Test(priority = 1, description = "Validate table 1 header")
    public void TableTest() {
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Sortable Data Tables");

        String[] tableHeaderLabels = {"Last Name", "First Name", "Email", "Due", "Web Site", "Action"};

        for (int i = 0; i < heroAppPage.tableHeader.size(); i++) {
            Waiter.waitUntilTextToBePresentInElement(driver, 3, heroAppPage.tableHeader.get(i), tableHeaderLabels[i]);
            Assert.assertEquals(heroAppPage.tableHeader.get(i).getText(), tableHeaderLabels[i]);
            System.out.println(heroAppPage.tableHeader.get(i).getText());
        }
    }

    @Test(priority = 2, description = "Tables | first row")
    public void testFirstRow() {
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Sortable Data Tables");

        String[] firstRowText = {"Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com", "edit delete"};

        for (int i = 0; i < heroAppPage.firstTableFirstColumn.size(); i++) {
            Assert.assertEquals(heroAppPage.firstTableFirstColumn.get(i).getText(), firstRowText[i]);
            System.out.println(heroAppPage.firstTableFirstColumn.get(i).getText());
        }
    }

    @Test(priority = 3, description = "Tables | second column")
    public void testSecondColumnExample2() {
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Sortable Data Tables");

        String[] secondColumnText = {"John", "Frank", "Jason", "Tim"};

        /*for (int i = 0; i < heroAppPage.secondTableSecondColumn.size(); i++) {
            Assert.assertEquals(heroAppPage.secondTableSecondColumn.get(i).getText(), secondColumnText[i]);
            System.out.println(heroAppPage.secondTableSecondColumn.get(i).getText());*/
        int index = 0;
        for (WebElement element : heroAppPage.secondTableSecondColumn) {
            Assert.assertEquals(element.getText(), secondColumnText[index++]);
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Test(priority = 4, description = "Tables | cell values not empty")
    public void testCheckTableValues() {
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Sortable Data Tables");
        System.out.println(heroAppPage.cellValues.size());

        int index = 0;
        for (WebElement element : heroAppPage.cellValues) {
            System.out.println(heroAppPage.cellValues.get(index++).getText());
            Assert.assertNotEquals(element.getText(), "");
        }
    }
}
