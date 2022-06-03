package testng_learning;

import org.junit.Assert;
import org.testng.annotations.Test;

public class _04_Optional_Assertion_Error_Messages {

    @Test
    public void method1(){
        //TestNG way
        //Assert.assertTrue(false, "Error message");
        org.testng.Assert.assertEquals("", "", "");


        //JUnit Way
        Assert.assertTrue("", false);
        Assert.assertEquals("", "","");
    }
}
