package testcase.cxHelpDesk;

import TestUtil.Constants;
import base.TestBase;
import demo.BNS_Sop;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cx_HelpDesk_page_LoginLocator;

public class bns_Test  extends TestBase {

    BNS_Sop objBnsSopPage;

    @BeforeTest
    public void initialBrowserDriver() throws InterruptedException {
        driver = TestBase.testBase();
    }

    @Test
    public void Test1() throws InterruptedException {
        objBnsSopPage = new BNS_Sop(driver);
        objBnsSopPage.test();
    }
}
