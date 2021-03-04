package testcase.cxHelpDesk;

import TestUtil.CaptureScreenshot;
import TestUtil.Constants;
import base.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cx_HelpDesk_page_LoginLocator;
import pages.Cx_HelpDesk_page_Master_EmployeeLocator;

public class CxHelpDesk_Master_EmployeePageTests extends TestBase {

    Cx_HelpDesk_page_LoginLocator objLoginPage;
    Cx_HelpDesk_page_Master_EmployeeLocator objMasterEmployeeLocator;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();

        objLoginPage = new Cx_HelpDesk_page_LoginLocator(driver);
        objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test(priority = 1)
    public void createEmployee(){
        try {
            objMasterEmployeeLocator = new Cx_HelpDesk_page_Master_EmployeeLocator(driver);
            objMasterEmployeeLocator.createEmployee("Employee Test","EmpTest@test.com", "EmpTest", "Agent", "EmpTest");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void editEmployee(){
        try {
            objMasterEmployeeLocator = new Cx_HelpDesk_page_Master_EmployeeLocator(driver);
            objMasterEmployeeLocator.editEmployee("Updated Employee Test","UpdatedEmpTest@test.com",
                    "UpdatedEmpTest", "Admin", "UpdatedEmpTest");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void deleteEmployee(){
        try {
            objMasterEmployeeLocator = new Cx_HelpDesk_page_Master_EmployeeLocator(driver);
            objMasterEmployeeLocator.deleteEmployee("UpdatedEmpTest");
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
