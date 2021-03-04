package pages;

import TestUtil.CheckBox;
import TestUtil.GenericUtil;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.util.Password;

public class Cx_HelpDesk_page_Master_CustomerUserLocator extends TestBase {

    public Cx_HelpDesk_page_Master_CustomerUserLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;
    public static CheckBox objCheckBox;

    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement TitleMasters;

    @FindBy(xpath = "//li[@id='master']") //i[@class='fa fa-database']
    public WebElement sidebar_textMaster;

    @FindBy(xpath = "//span[text()=' Customer User Master ']")
    WebElement TitleCustomerUser;

    @FindBy(xpath = "(//a[@class='collapse btn btn-circle btn-icon-only btn-default'])[4]")
    WebElement CustomerUserCollapse;

    @FindBy(xpath = "(//a[@class='btn btn-circle btn-icon-only btn-default fullscreen'])[4]")
    WebElement FullScreen;

    @FindBy(xpath ="(//select[@class='fontColor'])[4]")
    WebElement List;

    @FindBy(xpath = "(//input[@class='fontColor'])[4]")
    WebElement Search;

    @FindBy(xpath = "(//div/table/tbody/tr[1])[31]")
    WebElement Data;

    @FindBy(xpath = "(//i[@title='Delete Customer User'])[1]")
    WebElement DeleteBtn;

    @FindBy(xpath = "(//i[@title='Edit Customer User'])[1]")
    WebElement EditBtn;

    /*--------------Edit---------------*/

    @FindBy(xpath = "//input[@class='c-input ng-pristine ng-valid ng-star-inserted ng-touched']")
    WebElement EditCustomerName;

    @FindBy(xpath = "(//input[@class='form-control ng-pristine ng-invalid ng-touched'])[1]")
    WebElement EditUserName;

    @FindBy(xpath = "(//input[@class='form-control ng-pristine ng-invalid ng-touched'])[2]")
    WebElement EditUserID;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[3]")
    WebElement EditPassword;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[4]")
    WebElement EditConfirmPassword;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[5]")
    WebElement EditDesignation;

    @FindBy(xpath = "//select[@class='form-control ng-pristine ng-invalid ng-touched']")
    WebElement EditRole;

    @FindBy(xpath = "(//label[@class='mt-checkbox mt-checkbox-single mt-checkbox-outline']/span)[4]")
    WebElement EditStatus;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[13]")
    WebElement EditSubmit;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[14]")
    WebElement EditClear;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[15]")
    WebElement EditCancel;

    @FindBy(xpath = "(//a[@class='btn btn-success language_btn'])[7]")
    WebElement AddNewCustomerUser;

    @FindBy(xpath = "(//a[@class='btn btn-success language_btn'])[8]")
    WebElement ImportCustomer;

    /*--------------Add New CustomerUser ---------------*/

    @FindBy(xpath = "(//div[@class='selected-list'])[2]")
    WebElement AddCustomerName;

 //   @FindBy(xpath = "//input[@class=\"c-input ng-pristine ng-valid ng-star-inserted ng-touched\"]")
   // WebElement SearchCustomerName;

    //    @FindBy(xpath = "//label[contains(text(),'TEST CUSTOMER')]")
    @FindBy(xpath = "(//div/ul/li[@class='pure-checkbox ng-star-inserted'])[3]")
    WebElement SelectCustomerName;

    @FindBy(xpath = "(//input[@id='login_Id'])")
    WebElement AddUserName;

    @FindBy(xpath = "(//input[@class='form-control ng-pristine ng-valid ng-touched'])[4]")
    WebElement AddUserID;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[5]")
    WebElement AddDepartment;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[6]")
    WebElement AddDesignation;

    //Added in v2.0
    @FindBy(xpath ="(//input[@type=\"password\"])[1]")
    WebElement Password;

    //Added in v2.0
    @FindBy(xpath ="(//input[@type=\"password\"])[2]")
    WebElement ConfirmPassword;

    @FindBy(xpath ="//select[@class='form-control ng-pristine ng-invalid ng-touched']")
    WebElement CustomerUserRole;

    @FindBy(xpath = "(//label[@class='mt-checkbox mt-checkbox-single mt-checkbox-outline']/span)[4]")
    WebElement CustomerUserStatus;

//    @FindBy(xpath = "(//input[@class='btn btn-success'])[13]")
    @FindBy(xpath = "//input[@class='btn btn-success' and @type='button' and @tabindex ='109']")
    WebElement AddSubmit;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[14]")
    WebElement AddClear;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[15]")
    WebElement AddCancel;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[15]")
    WebElement CustomerUserPaginationPrevious;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[18]")
    WebElement CustomerUserPaginationNext;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[16]")
    WebElement CustomerUserPaginationNo ;

    @FindBy(xpath = "(//input[@class='fontColor'])[1]")
    public WebElement search;

    /** TESTCASE METHOD: CREATE CUSTOMER USER
     *
     * @param Username
     * @param UserID
     * @param strPassword
     * @param strConfirmPassword
     * @param Department
     * @param Designation
     */
    public void createCustomerUser(String strCustomerName,String Username,String UserID,String strPassword,String strConfirmPassword,String Department,String Designation,String searchText){
        try {
            genericUtil = new GenericUtil();

            wait.until(ExpectedConditions.visibilityOf(sidebar_textMaster));
            HighlightElement.highlightElement(sidebar_textMaster);
            sidebar_textMaster.click();
            genericUtil.pause(2000);

            HighlightElement.highlightElement(TitleCustomerUser);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(CustomerUserCollapse);
            genericUtil.clickWithPause(CustomerUserCollapse,1000);

            HighlightElement.highlightElement(AddNewCustomerUser);
            genericUtil.clickWithPause(AddNewCustomerUser,3000);

            HighlightElement.highlightElement(AddCustomerName);
            genericUtil.writeTextWithPause(AddCustomerName,strCustomerName,2000); //"Employee Test"
            genericUtil.click(AddCustomerName);
            genericUtil.pause(2000);

          //   HighlightElement.highlightElement(SearchCustomerName);
          //  genericUtil.click(SearchCustomerName);
            // Actions builder = new Actions(driver);
            //Action seriesOfActions = builder.moveToElement(SearchCustomerName).click().build();
           // seriesOfActions.perform();
            //genericUtil.writeTextWithPause(SearchCustomerName,searchText,2000);

            HighlightElement.highlightElement(SelectCustomerName);
            genericUtil.writeTextWithPause(SelectCustomerName,strCustomerName,2000); //"Employee Test"
            genericUtil.click(SelectCustomerName);
            genericUtil.pause(2000);

            genericUtil.click(AddUserName);
            HighlightElement.highlightElement(AddUserName);
            genericUtil.writeTextWithPause(AddUserName,Username,2000);

            HighlightElement.highlightElement(AddUserID);
            genericUtil.writeTextWithPause(AddUserID,UserID,2000);

            HighlightElement.highlightElement(AddDepartment);
            genericUtil.writeTextWithPause(AddDepartment,Department,2000);

            HighlightElement.highlightElement(AddDesignation);
            genericUtil.writeTextWithPause(AddDesignation,Designation,2000);

            HighlightElement.highlightElement(Password);
            genericUtil.writeTextWithPause(Password,strPassword,2000);

            HighlightElement.highlightElement(ConfirmPassword);
            genericUtil.writeTextWithPause(ConfirmPassword,strConfirmPassword,2000);

            try {
                objCheckBox = new CheckBox();
                HighlightElement.highlightElement(CustomerUserStatus);
                objCheckBox.Select_The_Checkbox(CustomerUserStatus);
                genericUtil.pause(1200);
                HighlightElement.highlightElement(CustomerUserStatus);
                objCheckBox.DeSelect_The_Checkbox(CustomerUserStatus);
                genericUtil.pause(1200);
                HighlightElement.highlightElement(CustomerUserStatus);
                objCheckBox.Select_The_Checkbox(CustomerUserStatus);
                genericUtil.pause(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            HighlightElement.highlightElement(AddSubmit);
            genericUtil.clickWithPause(AddSubmit,3000);

        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }


}
