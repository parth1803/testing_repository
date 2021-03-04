package testcase.cxHelpDesk;

import TestUtil.CaptureScreenshot;
import TestUtil.Constants;
import base.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cx_HelpDesk_page_LoginLocator;
import pages.Cx_HelpDesk_page_Master_GroupLocator;

public class CxHelpDesk_Master_GroupPageTests extends TestBase {

    Cx_HelpDesk_page_LoginLocator objLoginPage;
    Cx_HelpDesk_page_Master_GroupLocator objMasterGroupLocator;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();

        objLoginPage = new Cx_HelpDesk_page_LoginLocator(driver);
        objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test(priority = 1)
    public void createGroup(){
        try {
            objMasterGroupLocator = new Cx_HelpDesk_page_Master_GroupLocator(driver);
            objMasterGroupLocator.createGroup("Group Name","Group Name");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void editGroup(){
        try {
            objMasterGroupLocator = new Cx_HelpDesk_page_Master_GroupLocator(driver);
            objMasterGroupLocator.editGroup("Updated Group Name","Updated Group Name");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void deleteGroup(){
        try {
            objMasterGroupLocator = new Cx_HelpDesk_page_Master_GroupLocator(driver);
            objMasterGroupLocator.deleteGroup("Updated Group Name");
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
