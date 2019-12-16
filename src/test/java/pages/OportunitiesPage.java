package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;
import utils.ExcelUtil;

import java.util.Arrays;
import java.util.List;

public class OportunitiesPage extends BasePage {

    @FindBy(css = "tbody tr td:nth-of-type(2)")
    public WebElement opportunity;
    @FindBy(css = "#breadcrumb li:nth-of-type(2)")
    public WebElement pageName;


    public String getPageText(){
        waitUntilLoaderMaskDisappear();
        return pageName.getText();
    }
    public  Object[][] opportunityData(){
        ExcelUtil excel1 =  new ExcelUtil("vytrack_testusers.xlsx","Opportunity");
        Object[][] excelData = excel1.getDataArray();
        Object[][] result = new Object[14][2];


        int i = 0;
        for (Object[] each   : excelData    ) {
            result [i][0] = each[0];
            result[i][1] =Driver.get().findElement(By.cssSelector(".control-group.attribute-row:nth-of-type("+ i +") label")).getText();
            result[++i][0] = each[1];
            result[i][1] = Driver.get().findElement(By.cssSelector(" .control-group.attribute-row:nth-of-type("+ (i-1) +") div div")).getText();
            i++;
        }
        return result;
    }





}
