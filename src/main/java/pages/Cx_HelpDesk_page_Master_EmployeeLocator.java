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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cx_HelpDesk_page_Master_EmployeeLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;
    public static CheckBox objCheckBox;

    @FindBy(xpath = "//h1[@class='page-title']")
    public WebElement TitleMasters;

    @FindBy(xpath = "//span[text()=' Employee User Master']")
    public WebElement TitleEmpUser;

    @FindBy(xpath = "//li[@id='master']") //i[@class='fa fa-database']
    public WebElement sidebar_textMaster;

    @FindBy(xpath = "(//a[@class='collapse btn btn-circle btn-icon-only btn-default'])[1]")
    public WebElement EmpCollapse;

    @FindBy(xpath = "(//a[@class='btn btn-circle btn-icon-only btn-default fullscreen'])[1]")
    public WebElement EmpFullScreen;

    @FindBy(xpath ="(//select[@class='fontColor'])[1]")
    public WebElement NumberOfRecordsPerPage;

    @FindBy(xpath = "(//input[@class='fontColor'])[1]")
    public WebElement EmpSearch;

    @FindBy(xpath = "(//div/table/tbody/tr[1])[1]")
    public WebElement EmpFirstRowData;

    /*--------------Edit Employee ---------------*/

    @FindBy(xpath = "//h4[contains(text(),'Edit Employee User')]")
    public WebElement EmpEditHeader;

    @FindBy(xpath = "(//i[@title='Edit Employee'])[1]")
    public WebElement EmpEditBtn;

    @FindBy(xpath = "(//i[@title='Delete Employee'])[1]")
    public WebElement EmpDeleteBtn;

    @FindBy(xpath = "//input[@id='fullName']")
    public WebElement EmpEditName;

    @FindBy(xpath = "(//input[@formcontrolname='email'])[1]")
    public WebElement EmpEditEmail;

    @FindBy(xpath = "(//input[@formcontrolname='emp_No'])[1]")
    public WebElement EmpEditNo;

    @FindBy(xpath = "//select[@id='user_Type']")
    public WebElement EmpEditRole;

    @FindBy(xpath ="(//label[@class='mt-checkbox mt-checkbox-single mt-checkbox-outline']/span)[1]")
    public WebElement EmpEditStatus;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[3]")
    public WebElement EmpEditSubmit;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[4]")
    public WebElement EmpEditClear;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[5]")
    public WebElement EmpEditCancel;

    @FindBy(xpath = "(//a[@class='btn btn-success language_btn'])[1]")
    public WebElement AddNewEmployeeUser;

    @FindBy(xpath = "(//a[@class='btn btn-success language_btn'])[2]")
    public WebElement EmpImport;

    /*--------------Add New Employee ---------------*/
    @FindBy(xpath = "//h4[contains(text(),'Add New Employee User')]")
    WebElement TitleEmpAddName;

    @FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-invalid'])[1]")
    WebElement EmpAddName;

//    @FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched']")
    @FindBy(xpath = "(//input[@formcontrolname='email'])[1]")
    WebElement EmpAddEmail;

//    @FindBy(xpath = "//input[@class='form-control ng-dirty ng-invalid ng-touched']")
    @FindBy(xpath = "(//input[@formcontrolname='emp_No'])[1]")
    WebElement EmpAddEmpNo;

    @FindBy(xpath = "(//select[@id='user_Type'])[1]")
    WebElement EmpAddRole;

    @FindBy(xpath = "(//label[@class='mt-checkbox mt-checkbox-single mt-checkbox-outline']/span)[1]")
    WebElement EmpAddStatus;

//  @FindBy(xpath = "(//input[@class='btn btn-success'])[1]")
    //Change xpath in version-2.0
    @FindBy(xpath = "(//input[@value='Submit'])[1]")
    WebElement EmpAddSubmit;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[2]")
    WebElement EmpAddClear;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[3]")
    WebElement EmpAddCancel;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[1]")
    WebElement EmpPaginationPrevious;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[8]")
    WebElement EmpPaginationNext;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[5]")
    WebElement EmpPaginationNo;

    @FindBy(xpath = "//h3[contains(text(),'Are you sure! You want to Delete this Employee Use')]")
    WebElement TitleEmpDelete;

    @FindBy(xpath = "//h4[contains(text(),'You have Successfully deleted selected Employee User')]")
    WebElement SuccessMsgEmpDelete;

    @FindBy(xpath = "(//button[contains(text(),'Close')])[1]")
    WebElement CloseBtnSuccessMsgEmpDelete;

    @FindBy(xpath = "(//button[@class='btn btn-lg btn-success'])[1]")
    WebElement YesOptionEmpDelete;

    public Cx_HelpDesk_page_Master_EmployeeLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    /**
     * TESTCASE METHOD: CREATE EMPLOYEE
     * @param EmpName
     * @param EmpEmail
     * @param EmpNo
     * @param EmpRole
     * @param searchText
     */
    public void createEmployee(String EmpName,String EmpEmail,String EmpNo,String EmpRole,String searchText){
        try {
            genericUtil = new GenericUtil();

            wait.until(ExpectedConditions.visibilityOf(sidebar_textMaster));
            HighlightElement.highlightElement(sidebar_textMaster);
            sidebar_textMaster.click();
            genericUtil.pause(2000);

            HighlightElement.highlightElement(TitleMasters);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(EmpCollapse);
            genericUtil.clickWithPause(EmpCollapse,1000);

            HighlightElement.highlightElement(TitleEmpUser);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(TitleEmpAddName);
            genericUtil.pause(500);

            HighlightElement.highlightElement(AddNewEmployeeUser);
            genericUtil.clickWithPause(AddNewEmployeeUser,3000);

            HighlightElement.highlightElement(EmpAddName);
            genericUtil.writeTextWithPause(EmpAddName,EmpName,2000); //"Employee Test"

            HighlightElement.highlightElement(EmpAddEmail);
            genericUtil.writeTextWithPause(EmpAddEmail,EmpEmail,2000); //"EmpTest@test.com"

            HighlightElement.highlightElement(EmpAddEmpNo);
            genericUtil.writeTextWithPause(EmpAddEmpNo,EmpNo,2000); //"EmpTest"

            HighlightElement.highlightElement(EmpAddRole);
            Select role = new Select(EmpAddRole);
            role.selectByVisibleText(EmpRole); //"Employee"
            genericUtil.pause(1000);

            try {
                objCheckBox = new CheckBox();
                HighlightElement.highlightElement(EmpAddStatus);
                objCheckBox.Select_The_Checkbox(EmpAddStatus);
                genericUtil.pause(1200);
                HighlightElement.highlightElement(EmpAddStatus);
                objCheckBox.DeSelect_The_Checkbox(EmpAddStatus);
                genericUtil.pause(1200);
                HighlightElement.highlightElement(EmpAddStatus);
                objCheckBox.Select_The_Checkbox(EmpAddStatus);
                genericUtil.pause(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            HighlightElement.highlightElement(EmpAddSubmit);
            genericUtil.clickWithPause(EmpAddSubmit,3000);

            HighlightElement.highlightElement(EmpSearch);
            genericUtil.writeTextWithPause(EmpSearch,searchText,3000); //"EmpTest"
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }

    /**
     * TESTCASE METHOD: EDIT or MODIFY EMPLOYEE
     * @param UpdatedEmpName
     * @param UpdatedEmpEmail
     * @param UpdatedEmpNo
     * @param UpdatedEmpRole
     * @param UpdatedSearchText
     */
    public void editEmployee(String UpdatedEmpName,String UpdatedEmpEmail,String UpdatedEmpNo,String UpdatedEmpRole,String UpdatedSearchText){
        try {
            genericUtil = new GenericUtil();
            genericUtil.pause(3000);

            HighlightElement.highlightElement(EmpEditBtn);
            genericUtil.clickWithPause(EmpEditBtn,3000);

            HighlightElement.highlightElement(EmpEditHeader);
            genericUtil.clickWithPause(EmpEditHeader,1000);

            HighlightElement.highlightElement(EmpEditName);
            genericUtil.writeTextWithPause(EmpEditName,UpdatedEmpName,1000); //"Updated EmpTest"

            HighlightElement.highlightElement(EmpEditEmail);
            genericUtil.writeTextWithPause(EmpEditEmail,UpdatedEmpEmail,2000); //"UpdatedEmpTest@test.com"

            HighlightElement.highlightElement(EmpEditNo);
            genericUtil.writeTextWithPause(EmpEditNo,UpdatedEmpNo,2000); //"UpdatedEmpTest"

            HighlightElement.highlightElement(EmpEditRole);
            Select roleEdit = new Select(EmpEditRole);
            roleEdit.selectByVisibleText(UpdatedEmpRole); //"Admin"
            genericUtil.pause(1000);

            try {
                objCheckBox = new CheckBox();
                HighlightElement.highlightElement(EmpEditStatus);
                objCheckBox.Select_The_Checkbox(EmpEditStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(EmpEditStatus);
                objCheckBox.DeSelect_The_Checkbox(EmpEditStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(EmpEditStatus);
                objCheckBox.Select_The_Checkbox(EmpEditStatus);
                genericUtil.pause(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            HighlightElement.highlightElement(EmpEditSubmit);
            genericUtil.clickWithPause(EmpEditSubmit,3000);

            HighlightElement.highlightElement(EmpSearch);
            genericUtil.writeTextWithPause(EmpSearch,UpdatedSearchText,3000); //"UpdatedEmpTest"
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }

    /** TESTCASE METHOD: DELETE or REMOVE EMPLOYEE
     *
     * @param SearchText
     */
    public void deleteEmployee(String SearchText){
        try {
            genericUtil = new GenericUtil();
            genericUtil.pause(3000);

            HighlightElement.highlightElement(EmpEditNo);
            genericUtil.writeTextWithPause(EmpEditNo,SearchText,3000); //"UpdatedEmpTest"

            HighlightElement.highlightElement(EmpDeleteBtn);
            genericUtil.clickWithPause(EmpDeleteBtn,3000);

            HighlightElement.highlightElement(TitleEmpDelete);

            HighlightElement.highlightElement(YesOptionEmpDelete);
            genericUtil.clickWithPause(YesOptionEmpDelete,3000);

            wait.until(ExpectedConditions.visibilityOf(SuccessMsgEmpDelete));
            HighlightElement.highlightElement(YesOptionEmpDelete);

            HighlightElement.highlightElement(SuccessMsgEmpDelete);
            genericUtil.clickWithPause(CloseBtnSuccessMsgEmpDelete,3000);

            HighlightElement.highlightElement(EmpEditNo);
            genericUtil.writeTextWithPause(EmpEditNo,SearchText,3000); //"UpdatedEmpTest"

            HighlightElement.highlightElement(CloseBtnSuccessMsgEmpDelete);
            genericUtil.clickWithPause(CloseBtnSuccessMsgEmpDelete,3000);

            HighlightElement.highlightElement(EmpSearch);
            EmpSearch.clear();
            genericUtil.writeTextWithPause(EmpSearch,SearchText,3000); //"UpdatedEmpTest"
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }
}
