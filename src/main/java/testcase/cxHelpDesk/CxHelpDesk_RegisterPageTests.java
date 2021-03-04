package testcase.cxHelpDesk;

import TestUtil.Constants;
import base.TestBase;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cx_HelpDesk_page_LoginLocator;
import pages.Cx_HelpDesk_page_RegisterLocator;

public class CxHelpDesk_RegisterPageTests {
    public Cx_HelpDesk_page_RegisterLocator objRegisterPage;
    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();
    }

    @Test()
    public void validateLogin(){
        try {
            objRegisterPage = new Cx_HelpDesk_page_LoginLocator(driver);
            objRegisterPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);

            Reporter.log("POSITIVE TESTCASE-1 :Login Page: verify Admin User type", true);
            Thread.sleep(3000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
