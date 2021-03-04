package pages;

import TestUtil.CheckBox;
import TestUtil.GenericUtil;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cx_HelpDesk_page_RegisterLocator  extends TestBase {
    public static WebDriverWait wait;
    public static GenericUtil genericUtil;
    public static CheckBox objCheckBox;

    public Cx_HelpDesk_page_RegisterLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 40);

    }
    @FindBy(xpath = "//img[@class=\"logo-default\"]")
    public WebElement logo_img;

    @FindBy(xpath = "//a[@class='switch login switch_btn']")
    public WebElement RegisterBtn;

    @FindBy(xpath = "//input[@id='comapnyname']")
    WebElement RegCustomerName;

    @FindBy(xpath = "//input[@id='address']")
    WebElement RegCustomerAddress;

    @FindBy(xpath = "//input[@id='county']")
    WebElement RegCustomerCounty;

    @FindBy(xpath ="//input[@id='Accountno']")
    WebElement RegCustomerAccNo;

    @FindBy(xpath ="//input[@id='city']")
    WebElement RegCustomerCity;

    @FindBy(xpath ="//input[@id='postalCode']")
    WebElement RegCustomerPostcode;

    @FindBy(xpath ="//input[@id='contactPerson']")
    WebElement RegCustomerContactName;

    @FindBy(xpath ="//input[@id='contactPersonno']")
    WebElement RegCustomerContactNo;

    @FindBy(xpath ="//input[@id='fax']")
    WebElement RegCustomerFaxNumber;

    @FindBy(xpath = "//input[@id='email']")
    WebElement RegCustomerEmail;

    @FindBy(xpath ="//input[@id='isActive']")
   public WebElement RegCustomerStatus;

    @FindBy(xpath = "//input[@id='submit']")
    WebElement RegSubmit;

    @FindBy(xpath = "//input[@class='reset']")
    WebElement RegClear;

    @FindBy(xpath = "//a[@class='cancel']")
    WebElement RegCancel;


    /**
     * TESTCASE: Add Customer
     * @param CustomerName = customerName
     * @param CustomerAddress
     * @param County
     * @param CustomerAccountNumber
     * @param City
     * @param PostCode
     * @param ContactPersonName
     * @param ContactPersonNumber
     * @param FaxNumber
     * @param Email
     */

    public void addCustomer(String CustomerName,String CustomerAddress,String County,String CustomerAccountNumber,String City,
                            String PostCode,String ContactPersonName, String ContactPersonNumber,String FaxNumber,String Email){
        try {
            genericUtil = new GenericUtil();

            wait.until(ExpectedConditions.visibilityOf(logo_img));
            HighlightElement.highlightElement(logo_img);
            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(RegisterBtn);
            genericUtil.clickWithPause(RegisterBtn,500);

            HighlightElement.highlightElement(RegCustomerName);
            genericUtil.writeTextWithPause(RegCustomerName,CustomerName,1000);

            HighlightElement.highlightElement(RegCustomerAddress);
            genericUtil.writeTextWithPause(RegCustomerAddress,CustomerAddress,1000);

            HighlightElement.highlightElement(RegCustomerCounty);
            genericUtil.writeTextWithPause(RegCustomerCounty,County,1000);

            HighlightElement.highlightElement(RegCustomerAccNo);
            genericUtil.writeTextWithPause(RegCustomerAccNo,CustomerAccountNumber,1000);

            HighlightElement.highlightElement(RegCustomerCity);
            genericUtil.writeTextWithPause(RegCustomerCity,City,1000);

            HighlightElement.highlightElement(RegCustomerPostcode);
            genericUtil.writeTextWithPause(RegCustomerPostcode,PostCode,1000);

            HighlightElement.highlightElement(RegCustomerContactName);
            genericUtil.writeTextWithPause(RegCustomerContactName,ContactPersonName,1000);

            HighlightElement.highlightElement(RegCustomerContactNo);
            genericUtil.writeTextWithPause(RegCustomerContactNo,ContactPersonNumber,1000);

            HighlightElement.highlightElement(RegCustomerFaxNumber);
            genericUtil.writeTextWithPause(RegCustomerFaxNumber,FaxNumber,1000);

            HighlightElement.highlightElement(RegCustomerEmail);
            genericUtil.writeTextWithPause(RegCustomerEmail,Email,1000);

            try {
                objCheckBox = new CheckBox();
                HighlightElement.highlightElement(RegCustomerStatus);
                objCheckBox.Select_The_Checkbox(RegCustomerStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(RegCustomerStatus);
                objCheckBox.DeSelect_The_Checkbox(RegCustomerStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(RegCustomerStatus);
                objCheckBox.Select_The_Checkbox(RegCustomerStatus);
                genericUtil.pause(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            HighlightElement.highlightElement(RegSubmit);
            genericUtil.clickWithPause(RegSubmit,3000);

            HighlightElement.highlightElement(RegClear);
            genericUtil.clickWithPause(RegClear,3000);

            HighlightElement.highlightElement(RegCancel);
            genericUtil.clickWithPause(RegCancel,3000);


        }catch (Exception ex){
            ex.getStackTrace();
        }
    }

}