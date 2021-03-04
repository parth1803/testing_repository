package testcase.cxHelpDesk;

import TestUtil.Constants;
import base.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cx_HelpDesk_page_CreateTicketLocator;
import pages.Cx_HelpDesk_page_LoginLocator;

public class CxHelpDesk_CreateTicketPageTests extends TestBase{

    Cx_HelpDesk_page_LoginLocator objLoginPage;
    Cx_HelpDesk_page_CreateTicketLocator objCreateTicketPage;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();

        objLoginPage = new Cx_HelpDesk_page_LoginLocator(driver);
        objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test
    public void createTicket(){
        try {
            objCreateTicketPage = new Cx_HelpDesk_page_CreateTicketLocator(driver);
            objCreateTicketPage.createTicket();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}