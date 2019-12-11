package tests.vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventPage;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;

public class CreateCalendarEventTests extends TestBase {


    @Test(description = "Verify owners name is equals to Stephan Haley (it works on qa1 storemenager85)")
    public void test1() {
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();

        extentTest = extentReports.createTest("Verify owners name is equals to Stephan Haley (it works on qa1 storemenager85)");
        //login as Stephan Haley (storemanager85)
        loginPage.login("storemanager85", "UserUser123");

        //go to calendar events page
        loginPage.navigateTo("Activities", "Calendar Events");

        //click on create calendar event button
        calendarEventsPage.waitUntilLoaderMaskDisappear();
        calendarEventsPage.clickToCreateCalendarEvent();

        calendarEventsPage.waitUntilLoaderMaskDisappear();
        String expectedOwner = "Stephan Haley";
        String actualOwner = createCalendarEventPage.owner.getText().trim();

        Assert.assertEquals(actualOwner, expectedOwner);

        extentTest.pass("Verify owners name is equals to Stephan Haley (it works on qa1 storemenager85)");


    }

    @Test
    public void verifyTitleColumn() {
        LoginPage loginPage = new LoginPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentTest = extentReports.createTest("Verify column that column names are adjustable");
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        //login
        loginPage.login(username, password);

        //go to Calendar Events page

        loginPage.navigateTo("Activities", "Calendar Events");

        //deselect title option from grid settings
        createCalendarEventPage.selectGridSetting("Title", false);
        BrowserUtils.wait(3);

        //Verify that title column name is not visible any more
        Assert.assertFalse(createCalendarEventPage.verifyHeaderExists("Title"), "Title column name still visible.");
        extentTest.pass("Verified that title column name is not visible any more.");

        //to close grid settings menu
        createCalendarEventPage.gridSettingsElement.click();
        extentTest.info("Click on grid settings button.");

        //select title option again
        createCalendarEventPage.selectGridSetting("Title", true);

        //Verify that title column name is visible again
        Assert.assertTrue(createCalendarEventPage.verifyHeaderExists("Title"), "Title column is not visible.");
        extentTest.pass("Verified that title column name is visible again.");
    }

    @Test(description = "Verify that date auto adjustable")
    public void verifyDateTest() {
        LoginPage loginPage = new LoginPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentTest = extentReports.createTest("Verify column that date is adjustable");

        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        //login
        loginPage.login(username, password);

        //go to Calendar Events page
        loginPage.navigateTo("Activities", "Calendar Events");

        createCalendarEventPage.clickOnCreateCalendarEvent();
        extentTest.info("Click on create calendar event button.");

        createCalendarEventPage.selectStartOrEndDate("8/15/2019", "start");

        //    verify start date is the same as end date
        Assert.assertEquals(createCalendarEventPage.getStartDate(), createCalendarEventPage.getEndDate());
        extentTest.pass("Verified start date is the same as end date");


    }

    @Test(description = "Verify that date auto adjustable with today's and tomorrow's date.")
    public void verifyTodayDateTest() {
        LoginPage loginPage = new LoginPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentTest = extentReports.createTest("Verify that date auto adjustable with today's and tomorrow's date.");

        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        //login
        loginPage.login(username, password);

        //go to Calendar Events page
        loginPage.navigateTo("Activities", "Calendar Events");

        //click to create calendar event
        calendarEventsPage.clickToCreateCalendarEvent();
        extentTest.info("Click on create calendar event button.");

        //select tomorrow date
        createCalendarEventPage.selectTomorrowDay();
        extentTest.info("Select tomorrows date.");

        Assert.assertEquals(createCalendarEventPage.getStartDate(), createCalendarEventPage.getEndDate());
        extentTest.pass("Verified that start date is equals to today's date.");

        //select today's date
        createCalendarEventPage.selectTodaysDate();

        //verify that start and end date is the same
        Assert.assertEquals(createCalendarEventPage.getStartDate(), createCalendarEventPage.getEndDate());
        extentTest.pass("Verified that start date is equals to today's date.");

    }

    @Test(description = "Verify that end time changes exactly 1 hour later.")
    public void verifyTimeTest() {
        LoginPage loginPage = new LoginPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentTest = extentReports.createTest("Verify that end time changes exactly 1 hours later");

        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        //login
        loginPage.login(username, password);

        //go to Calendar Events page
        loginPage.navigateTo("Activities", "Calendar Events");

        //click to create calendar event
        calendarEventsPage.clickToCreateCalendarEvent();
        extentTest.info("Click on create calendar event button.");
        calendarEventsPage.clickToCreateCalendarEvent();
        //select any time
        createCalendarEventPage.selectStartTime("1:00 PM");
        extentTest.info("Select start time as 1:00 PM");

        //Verify that end time changes exactly 1 hour later
        Assert.assertEquals(createCalendarEventPage.differenceBetweenStartTimeAndEndTime(), 1);
        extentTest.pass("Verified that end time exactly 1 hour later.");

    }

    @Test(description = "Verify that end time is 12:30 AM")
    public void verifyTimeTest2() {
        LoginPage loginPage = new LoginPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentTest = extentReports.createTest("Verify that end time is 12:30 AM");

        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        //login
        loginPage.login(username, password);

        //go to Calendar Events page
        loginPage.navigateTo("Activities", "Calendar Events");

        //click to create calendar event
        createCalendarEventPage.clickOnCreateCalendarEvent();
        extentTest.info("Click on create calendar event button.");

        //select 11:30 PM
        createCalendarEventPage.selectStartTime("11:30 PM");
        extentTest.info("Select start time: 1:30 PM");

        //Verify that end time is 12:30 AM
        Assert.assertEquals(createCalendarEventPage.getEndTime(), "12:30 AM");
        extentTest.pass("Verified that end time is 12:30 AM.");
    }

}
