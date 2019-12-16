package tests.testsOfAAssignment;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.TestBase;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.ExcelUtil;
import pages.OportunitiesPage;

public class OpportunitiePageTest extends TestBase {
    LoginPage login ;
    String user;
    String password;
    OportunitiesPage opportunitiesPage;
    ExcelUtil excel;

    @Test(description = "1 - Verify that user should be able to reach opportunities page under sales module")
    public void Test1(){
        opportunitiesPage = new OportunitiesPage();
        extentTest = extentReports.createTest("reach opportunities page ");
        excel = new ExcelUtil("vytrack_testusers.xlsx","QA1-short");
        user = excel.getCellData(6,0);
        password = excel.getCellData(6,1);
        login = new LoginPage();
        login.login(user,password);
        navigateTo("Sales","Opportunities");

        Assert.assertEquals(opportunitiesPage.getPageText(),"Opportunities");
        extentTest.pass("Opportunities page has been reached");
    }


    @Test(description = " 2 -Verify that Non-authorized user should not be able to see sales module")
    public  void Test2(){
        extentTest = extentReports.createTest(" Non-authorized user should not be able to see sales module ");
        login.login(excel.getCellData(1,0),excel.getCellData(1,1));
        Assert.assertTrue(moduleCorrection("Sales"));
        extentTest.pass(" Non-authorized user not able to see sales module");
    }

    @DataProvider(name = "Data")
    public Object[][] Data(){

        return opportunitiesPage.opportunityData();

    }



    @Test(description = "  3 - Verify that system should display general information about opportunity when user click any opportunity on the grid", dataProvider = "Data")
    public  void Test3(String str1, String str2) {
        extentTest = extentReports.createTest("display general information about opportunity ");
        login.login(user, password);
        navigateTo("Sales","Opportunities");
        waitUntilLoaderMaskDisappear();
        opportunitiesPage.opportunity.click();

        Assert.assertEquals(str1,"");
        Assert.assertEquals(str2,"");
        extentTest.pass("display general information about opportunity ");
    }
           // 4 - Verify that user should be able to filter opportunities by using manage filter)"*/
}
