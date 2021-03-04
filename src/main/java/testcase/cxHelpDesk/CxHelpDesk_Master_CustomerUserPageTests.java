package testcase.cxHelpDesk;

import TestUtil.CaptureScreenshot;
import TestUtil.Constants;
import base.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cx_HelpDesk_page_LoginLocator;
import pages.Cx_HelpDesk_page_Master_CustomerUserLocator;

public class CxHelpDesk_Master_CustomerUserPageTests extends TestBase {

    Cx_HelpDesk_page_LoginLocator objLoginPage;
    Cx_HelpDesk_page_Master_CustomerUserLocator objMasterCustomerUserLocator;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();

        objLoginPage = new Cx_HelpDesk_page_LoginLocator(driver);
        objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test(priority = 1)
    public void createCustomerUser(){
        try {
            objMasterCustomerUserLocator = new Cx_HelpDesk_page_Master_CustomerUserLocator(driver);
            objMasterCustomerUserLocator.createCustomerUser("TestCustomerName","TestCustomer","TestCustomer",
                    "12345678","12345678","Test Department","Test Designation",
                    "TEST CUSTOMER");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void editCustomerUser(){
        try {
            objMasterCustomerUserLocator = new Cx_HelpDesk_page_Master_CustomerUserLocator(driver);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @AfterMethod
    public void captureScreenShot(ITestResult result){
        CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
        CaptureScreenshot.captureScreenshotPassedTests(driver,result);
    }
}
