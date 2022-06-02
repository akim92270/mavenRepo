package testng_learning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _03_Soft_vs_Hard_Assertions {

    @Test(priority = 1, description = "Practicing hard assertions")
    public void method(){

        //Hard assertions
        //When there is an error at any line, the program flow will break and it will continue with the rest.
        Assert.assertTrue(true);
        Assert.assertTrue(false, "------Failed----------");

        System.out.println("Hello World");
    }

    @Test(priority = 2, description = "Practicing soft assertions")
    public void method2(){

        //Soft assertions
        //When there is an error at any line, the program flow it will still continue till the end.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(true);
        softAssert.assertTrue(false, "========Failure======="); //AssertionError

        System.out.println("Hello World");
        softAssert.assertAll();
    }
}
