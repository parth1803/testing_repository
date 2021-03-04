package testcase.cxHelpDesk;

import TestUtil.CaptureScreenshot;
import TestUtil.Constants;
import base.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cx_HelpDesk_page_LoginLocator;
import pages.Cx_HelpDesk_page_Master_CustomerLocator;

public class CxHelpDesk_Master_CustomerPageTests extends TestBase {

    Cx_HelpDesk_page_LoginLocator objLoginPage;
    Cx_HelpDesk_page_Master_CustomerLocator objMasterCustomerLocator;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();

        objLoginPage = new Cx_HelpDesk_page_LoginLocator(driver);
        objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test(priority = 1)
    public void createCustomer(){
        try {
            objMasterCustomerLocator = new Cx_HelpDesk_page_Master_CustomerLocator(driver);
            objMasterCustomerLocator.addCustomer("TestCustomerName","TestAddress","TestCounty",
                    "1234567890","VADODARA","395002","TestContactPersonName",
                    "9638527410", "963852","hardik.prajapati@luxshtech.com");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void editCustomer(){
        try {
            objMasterCustomerLocator = new Cx_HelpDesk_page_Master_CustomerLocator(driver);
            objMasterCustomerLocator.editCustomer("UpdatedTestCustomerName","UpdatedTestAddress","UpdatedTestCounty",
                    "149518520","BANGLURU","395002","UpdatedTestContactPersonName",
                    "9852367410", "963654","hardik.prajapati@luxshtech.com");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void deleteCustomer(){
        try {
            objMasterCustomerLocator = new Cx_HelpDesk_page_Master_CustomerLocator(driver);
            objMasterCustomerLocator.deleteCustomer("UpdatedTestCustomerName");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @AfterMethod
    public void captureScreenShot(ITestResult result){
        CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
        CaptureScreenshot.captureScreenshotPassedTests(driver,result);
    }
}
