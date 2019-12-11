package tests.day14;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase {

    @Ignore
    @Test
    public void test1(){
        //read url value from the properties file
        String url = ConfigurationReader.getProperty("url");
        //Driver.getDriver() --> will return webdriver object
        //and then we can call webdriver methods like getDriver(), findElement()....
//        WebDriver driver = Driver.getDriver();
        Driver.getDriver().get(url);
        //print page title
        System.out.println(Driver.getDriver().getTitle());
        BrowserUtils.wait(2);
        Driver.closeDriver();
    }

    @Test
    public void test2(){
        System.out.println(Driver.getDriver().getTitle());
        BrowserUtils.wait(2);
    }
}
