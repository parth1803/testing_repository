package demo;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BNS_Sop extends TestBase {

    @FindBy(xpath ="//input[@id=\"userName\"]")
    WebElement username;

    @FindBy(xpath ="//input[@id=\"pass\"]")
    WebElement pwd;

    @FindBy(xpath ="//img[@name=\"Submit\"]")
    WebElement submit;

    public BNS_Sop(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public void test() throws InterruptedException {
        username.sendKeys("bnssop");
        Thread.sleep(1000);
        pwd.sendKeys("bnssop");
        Thread.sleep(1000);
        submit.click();
    }



}
