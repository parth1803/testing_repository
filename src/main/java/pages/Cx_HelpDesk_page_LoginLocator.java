package pages;

import TestUtil.Constants;
import TestUtil.GenericUtil;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Cx_HelpDesk_page_LoginLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;

    public Cx_HelpDesk_page_LoginLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 40);
    }

    @FindBy(xpath = "//img[@class=\"logo-default\"]")
    public WebElement logo_img;

    @FindBy(xpath = "//a[@class='switch register switch_btn']")
    public WebElement loginBtn;

    @FindBy(xpath = "//label[contains(text(),'UserName')]")
    public WebElement labelUsername;

    @FindBy(xpath = "//input[@name='User_id']")
    public WebElement textUsername;

    @FindBy(xpath = "//label[text()='Password']")
    public WebElement labelPassword;

    @FindBy(xpath = "(//input[@name='password'])[3]")
    public WebElement textPassword;

    @FindBy(xpath = "(//input[@type='submit'])[3]")
    public WebElement buttonSubmit;

    @FindBy(xpath = "//div[contains(text(),'User Name is required')]")
    public WebElement textUsername_error;

    @FindBy(xpath = "//div[contains(text(),'Password not allow blank Space.')]")
    public WebElement textPassword_error;

    @FindBy(xpath = "//div[contains(text(),'Password Does Not Matched. Please Enter Valid Password.')]")
    public WebElement errorMsgValidUsernameInvalidPwd;

    @FindBy(xpath = "//h1[contains(text(),'Luxsh Customer Services Help Desk')]")
    public WebElement adminTitle;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement usernameTitle;

    @FindBy(xpath = "(//span[@class=\"fa fa-eye fa-fw field-icon toggle-password\"])[3]")
    public WebElement eyeButton;

    @FindBy(xpath = "//ul[@id='drpprofilemenu']/li[2]")
    public WebElement buttonLogout;

    /**
     * POSITIVE TESTCASE METHOD
     *
     * @param username = Username
     * @param password = password
     */
    public void validateLogin(String username, String password) {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
            wait.until(ExpectedConditions.visibilityOf(logo_img));
            HighlightElement.highlightElement(logo_img);
            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(loginBtn);
            genericUtil.clickWithPause(loginBtn,500);

            HighlightElement.highlightElement(labelUsername);
            genericUtil.clickWithPause(labelUsername,500);

            HighlightElement.highlightElement(textUsername);
            genericUtil.writeTextWithPause(textUsername,username,500);

            HighlightElement.highlightElement(labelPassword);
            genericUtil.clickWithPause(labelPassword,500);

            HighlightElement.highlightElement(textPassword);
            genericUtil.writeTextWithPause(textPassword,password,1000);

            HighlightElement.highlightElement(eyeButton);
            genericUtil.click(eyeButton);

            HighlightElement.highlightElement(buttonSubmit);
            genericUtil.click(buttonSubmit);

//            genericUtil.pause(5000);
            wait.until(ExpectedConditions.visibilityOf(adminTitle));
            HighlightElement.highlightElement(adminTitle);
            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "dashboard");
            Reporter.log("SUCCESSFULLY ADMIN page is redirected.", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * NEGATIVE TESTCASE METHOD
     *
     * @param username = username
     * @param password = Password
     */
    public void invalidLogin(String username, String password) {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
            genericUtil.pause(3000);
            wait.until(ExpectedConditions.visibilityOf(logo_img));
            HighlightElement.highlightElement(logo_img);
            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(loginBtn);
            loginBtn.click();

            HighlightElement.highlightElement(textUsername);
            textUsername.clear();
            textUsername.sendKeys(username);
            Thread.sleep(2000);

            HighlightElement.highlightElement(textPassword);
            textPassword.clear();
            textPassword.sendKeys(password);
            Thread.sleep(2000);

            HighlightElement.highlightElement(eyeButton);
            genericUtil.click(eyeButton);

            HighlightElement.highlightElement(buttonSubmit);
            genericUtil.click(buttonSubmit);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * NEGATIVE TESTCASE-1 :Login Page-Empty username & Password!
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyEmptyUsernameEmptyPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
//        invalidLogin(username,password);

        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
            wait.until(ExpectedConditions.visibilityOf(logo_img));
            HighlightElement.highlightElement(logo_img);
            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(loginBtn);
            loginBtn.click();

            HighlightElement.highlightElement(textUsername);
            textUsername.clear();
            textUsername.sendKeys(username);
            genericUtil.pause(2000);

            HighlightElement.highlightElement(textPassword);
            textPassword.clear();
            textPassword.sendKeys(password);
            genericUtil.pause(2000);

            HighlightElement.highlightElement(buttonSubmit);
            buttonSubmit.click();

            wait.until(ExpectedConditions.visibilityOf(textPassword_error));
            wait.until(ExpectedConditions.visibilityOf(textUsername_error));

            if ((textUsername_error.isDisplayed() && textUsername_error.getText().equals("User Name is required")) &&
               (textPassword_error.isDisplayed() && (textPassword_error.getText().equals("Password not allow blank Space.")))) {
                Assert.assertEquals(expectedUrl,Constants.BASEURL);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * NEGATIVE TESTCASE-2	:Login Page: Empty Username & valid Password
     *
     * @param username = Username
     * @param password = password
     */
    public void validateEmptyUsernameValidPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        if (textUsername_error.getText().equals("User Name is required")) {
            Assert.assertEquals(expectedUrl, Constants.BASEURL + "login");
        }
    }

    /**
     * NEGATIVE TESTCASE-3	:Login Page: Valid Username & Empty Password
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyValidUsernameEmptyPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        if (textPassword_error.getText().equals("Password not allow blank Space.")) {
            Assert.assertEquals(expectedUrl, Constants.BASEURL + "login");
        }
    }

    /**
     * NEGATIVE TESTCASE-4	:Login Page: Invalid Username & valid Password
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyInvalidUsernameValidPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        if (textUsername_error.getText().equals("Invalid User Name")) {
            Assert.assertEquals(expectedUrl, Constants.BASEURL + "login");
        }
    }

    /**
     * NEGATIVE TESTCASE-5	:Login Page: Valid Username & invalid Password
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyValidUsernameInvalidPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        if (errorMsgValidUsernameInvalidPwd.getText().equals("Password Does Not Matched. Please Enter Valid Password.")) {
            Assert.assertEquals(expectedUrl, Constants.BASEURL + "login");
        }
    }

    /**
     * NEGATIVE TESTCASE-6	:Login Page: Invalid Username & invalid Password
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyInvalidUsernameInvalidPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        if (textUsername_error.getText().equals("Invalid User Name")) {
            Assert.assertEquals(expectedUrl, Constants.BASEURL + "login");
        }
    }

    /**
     * POSITIVE TESTCASE METHOD
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyAdminLogin(String username,String password){
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
            wait.until(ExpectedConditions.visibilityOf(logo_img));
            HighlightElement.highlightElement(logo_img);
            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(loginBtn);
            loginBtn.click();

            HighlightElement.highlightElement(labelUsername);
            genericUtil.clickWithPause(labelUsername,1000);

            HighlightElement.highlightElement(textUsername);
            genericUtil.writeTextWithPause(textUsername,username,2000);

            HighlightElement.highlightElement(labelPassword);
            genericUtil.clickWithPause(labelPassword,1000);

            HighlightElement.highlightElement(textPassword);
            genericUtil.writeTextWithPause(textPassword,password,2000);

            HighlightElement.highlightElement(buttonSubmit);
            genericUtil.click(buttonSubmit);

            HighlightElement.highlightElement(adminTitle);
            wait.until(ExpectedConditions.visibilityOf(adminTitle));
            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "dashboard");
            Reporter.log("SUCCESSFULLY ADMIN page is redirected.", true);

            wait.until(ExpectedConditions.visibilityOf(usernameTitle));
            logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyNormalUser(String username, String password) {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
            genericUtil.pause(3000);
            wait.until(ExpectedConditions.visibilityOf(logo_img));
            HighlightElement.highlightElement(logo_img);
            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(loginBtn);
            loginBtn.click();

            HighlightElement.highlightElement(labelUsername);
            genericUtil.clickWithPause(labelUsername,1000);

            HighlightElement.highlightElement(textUsername);
            genericUtil.writeTextWithPause(textUsername,username,2000);

            HighlightElement.highlightElement(labelPassword);
            genericUtil.clickWithPause(labelPassword,1000);

            HighlightElement.highlightElement(textPassword);
            genericUtil.writeTextWithPause(textPassword,password,2000);

            HighlightElement.highlightElement(eyeButton);
            genericUtil.click(eyeButton);

            HighlightElement.highlightElement(buttonSubmit);
            buttonSubmit.click();

            wait.until(ExpectedConditions.visibilityOf(adminTitle));
            HighlightElement.highlightElement(adminTitle);
            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "dashboard");
            Reporter.log("SUCCESSFULLY ADMIN page is redirected.", true);

            wait.until(ExpectedConditions.visibilityOf(usernameTitle));
            logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyEmployeeUser(String username, String password) {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
            genericUtil.pause(3000);
            wait.until(ExpectedConditions.visibilityOf(logo_img));
            genericUtil.pause(1000);
            HighlightElement.highlightElement(logo_img);
            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(loginBtn);
            loginBtn.click();

            HighlightElement.highlightElement(textUsername);
            textUsername.clear();
            textUsername.sendKeys(username);
            Thread.sleep(2000);

            HighlightElement.highlightElement(textPassword);
            textPassword.clear();
            textPassword.sendKeys(password);
            Thread.sleep(2000);

            HighlightElement.highlightElement(buttonSubmit);
            buttonSubmit.click();



            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "dashboard");
            Reporter.log("SUCCESSFULLY Register  page is redirected.",true);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }
}
