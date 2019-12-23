package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Driver;
import utils.ExcelUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OportunitiesPage extends BasePage {

    @FindBy(css = "tbody tr td:nth-of-type(2)")
    public WebElement opportunity;
    @FindBy(css = "#breadcrumb li:nth-of-type(2)")
    public WebElement pageName;

    public OportunitiesPage() {
        //it's mandatory if you want to use @FindBy annotation
        //this means LoginPage class
        //Driver.get() return webdriver object
        PageFactory.initElements(Driver.get(), this);
    }
    public String getPageText(){
        waitUntilLoaderMaskDisappear();
        return pageName.getText();
    }
    public boolean correct(){
        List<WebElement>list1= Driver.get().findElements(By.xpath("//div[@class='responsive-block'][1]/div[1]//label"));
        List<WebElement>list2= Driver.get().findElements(By.xpath("//div[@class='responsive-block'][1]/div[1]//div[@class='control-label']"));



    }






}
