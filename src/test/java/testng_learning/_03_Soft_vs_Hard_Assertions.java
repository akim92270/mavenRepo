package testng_learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Soft_vs_Hard_Assertions {

    @Test(priority = 1)
    public void method(){

        //Hard assertions
        Assert.assertTrue(true);
        Assert.assertTrue(false, "------Failed----------");

        System.out.println("Hello World");
    }
}
