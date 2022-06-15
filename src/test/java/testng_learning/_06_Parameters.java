package testng_learning;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestData;

public class _06_Parameters {

    @Parameters({"username", "password"})
    @Test()
    public void login1(String username, String password){
        System.out.println("Username comes from xml = " + username);
        System.out.println("Password comes from xml = " + password);
    }


    @Test() //configuration password
    public void login2(){
        System.out.println("Username comes from configuration properties = " + ConfigReader.getProperties("username"));
        System.out.println("Password comes from configuration properties = " + ConfigReader.getProperties("password"));
    }

    @Test() //configuration password
    public void login3() {
        System.out.println("Username comes from TestData = " + TestData.username);
        System.out.println("Password comes from TestData = " + TestData.password);
    }
}
