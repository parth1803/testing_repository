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

public class Cx_HelpDesk_page_Master_CustomerLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;
    public static CheckBox objCheckBox;

    public Cx_HelpDesk_page_Master_CustomerLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement TitleMasters;

    @FindBy(xpath = "//li[@id='master']") //i[@class='fa fa-database']
    public WebElement sidebar_textMaster;

    @FindBy(xpath = "//span[text()=' Customer Master ']")
    WebElement TitleCustomerMaster;

    @FindBy(xpath = "//h4[contains(text(),'Edit Customer')]")
    WebElement EditTitleCustomerMaster;

    @FindBy(xpath = "(//a[@class='collapse btn btn-circle btn-icon-only btn-default'])[3]")
    WebElement Collapse;

    @FindBy(xpath = "(//a[@class='btn btn-circle btn-icon-only btn-default fullscreen'])[3]")
    WebElement FullScreen;

    @FindBy(xpath ="(//select[@class='fontColor'])[3]")
    WebElement List;

    @FindBy(xpath = "(//input[@class='fontColor'])[3]")
    WebElement Search;

    @FindBy(xpath = "(//div/table/tbody/tr[1])[21]")
    WebElement Data;

    @FindBy(xpath = "(//i[@title='Delete Customer'])[1]")
    WebElement DeleteBtn;

    @FindBy(xpath = "(//i[@title='Edit Customer'])[1]")
    WebElement EditBtn;

    /*--------------Edit---------------*/
    @FindBy(xpath = "(//input[@class='form-control ng-pristine ng-valid ng-touched'])[1]")
    WebElement EditCustomerName;

    @FindBy(xpath = "(//input[@class='form-control ng-pristine ng-valid ng-touched'])[2]")
    WebElement EditCustomerAddress;

    @FindBy(xpath = "(//input[@class='form-control ng-pristine ng-valid ng-touched'])[3]")
    WebElement EditCustomerCountry;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[4]")
    WebElement EditCustomerAccNo;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[5]")
    WebElement EditCustomerCity;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[6]")
    WebElement EditCustomerPostcode;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[7]")
    WebElement EditCustomerContactName;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[8]")
    WebElement EditCustomerContactNo;

    @FindBy(xpath ="(//input[@class='form-control ng-pristine ng-valid ng-touched'])[9]")
    WebElement EditCustomerFaxNumber;

    @FindBy(xpath = "(//input[@class='form-control ng-pristine ng-valid ng-touched'])[10]")
    WebElement EditCustomerEmail;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[11]")
    WebElement EditSubmit;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[12]")
    WebElement EditClear;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[13]")
    WebElement EditCancel;

    @FindBy(xpath = "(//a[@class='btn btn-success language_btn'])[5]")
    WebElement AddCustomer;

    @FindBy(xpath = "(//a[@class='btn btn-success language_btn'])[6]")
    WebElement ImportCustomer;

    /*--------------Add New Customer ---------------*/
    @FindBy(xpath = "(//h4[@class=\"modal-title\"])[7]")
    WebElement AddCustomerTitle;

    @FindBy(xpath = "//input[@id=\"name\"]")
    WebElement AddCustomerName;

    @FindBy(xpath = "//input[@formcontrolname=\"address\"]")
    WebElement AddCustomerAddress;

    @FindBy(xpath = "//input[@formcontrolname=\"county\"]")
    WebElement AddCustomerCounty;

    @FindBy(xpath ="//input[@formcontrolname=\"account_No\"]")
    WebElement AddCustomerAccNo;

    @FindBy(xpath ="//input[@formcontrolname=\"city\"]")
    WebElement AddCustomerCity;

    @FindBy(xpath ="//input[@formcontrolname=\"postCode\"]")
    WebElement AddCustomerPostcode;

    @FindBy(xpath ="//input[@formcontrolname=\"contact_Name\"]")
    WebElement AddCustomerContactName;

    @FindBy(xpath ="//input[@formcontrolname=\"contact_No\"]")
    WebElement AddCustomerContactNo;

    @FindBy(xpath ="//input[@formcontrolname=\"fax\"]")
    WebElement AddCustomerFaxNumber;

    @FindBy(xpath = "(//input[@formcontrolname=\"email\"])[2]")
    WebElement AddCustomerEmail;

    @FindBy(xpath ="(//label[@class='mt-checkbox mt-checkbox-single mt-checkbox-outline']/span)[3]")
    public WebElement AddCustomerStatus;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[11]")
    WebElement AddSubmit;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[12]")
    WebElement AddClear;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[13]")
    WebElement AddCancel;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[1]")
    WebElement EmpCustomerPaginationPrevious;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[8]")
    WebElement EmpCustomerPaginationNext;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[5]")
    WebElement EmpCustomerPaginationNo ;

    @FindBy(xpath = "//h3[contains(text(),'Are you sure! You want to Delete this Customer?')]")
    public WebElement DeleteCustomerMessage;

    @FindBy(xpath = "(//button[@class='btn btn-lg btn-success'])[3]")
    public WebElement YesOptionDeleteCustomerMessage;

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

            wait.until(ExpectedConditions.visibilityOf(sidebar_textMaster));
            HighlightElement.highlightElement(sidebar_textMaster);
            sidebar_textMaster.click();
            genericUtil.pause(3000);

            HighlightElement.highlightElement(TitleMasters);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(TitleCustomerMaster);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(Collapse);
            Collapse.click();
            genericUtil.pause(1000);

            HighlightElement.highlightElement(AddCustomer);
            genericUtil.clickWithPause(AddCustomer,2000);

            HighlightElement.highlightElement(AddCustomerTitle);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(AddCustomerName);
            genericUtil.writeTextWithPause(AddCustomerName,CustomerName,1000);

            HighlightElement.highlightElement(AddCustomerAddress);
            genericUtil.writeTextWithPause(AddCustomerAddress,CustomerAddress,1000);

            HighlightElement.highlightElement(AddCustomerCounty);
            genericUtil.writeTextWithPause(AddCustomerCounty,County,1000);

            HighlightElement.highlightElement(AddCustomerAccNo);
            genericUtil.writeTextWithPause(AddCustomerAccNo,CustomerAccountNumber,1000);

            HighlightElement.highlightElement(AddCustomerCity);
            genericUtil.writeTextWithPause(AddCustomerCity,City,1000);

            HighlightElement.highlightElement(AddCustomerPostcode);
            genericUtil.writeTextWithPause(AddCustomerPostcode,PostCode,1000);

            HighlightElement.highlightElement(AddCustomerContactName);
            genericUtil.writeTextWithPause(AddCustomerContactName,ContactPersonName,1000);

            HighlightElement.highlightElement(AddCustomerContactNo);
            genericUtil.writeTextWithPause(AddCustomerContactNo,ContactPersonNumber,1000);

            HighlightElement.highlightElement(AddCustomerFaxNumber);
            genericUtil.writeTextWithPause(AddCustomerFaxNumber,FaxNumber,1000);

            HighlightElement.highlightElement(AddCustomerEmail);
            genericUtil.writeTextWithPause(AddCustomerEmail,Email,1000);

            try {
                objCheckBox = new CheckBox();
                HighlightElement.highlightElement(AddCustomerStatus);
                objCheckBox.Select_The_Checkbox(AddCustomerStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(AddCustomerStatus);
                objCheckBox.DeSelect_The_Checkbox(AddCustomerStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(AddCustomerStatus);
                objCheckBox.Select_The_Checkbox(AddCustomerStatus);
                genericUtil.pause(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            HighlightElement.highlightElement(AddSubmit);
            genericUtil.clickWithPause(AddSubmit,3000);

            HighlightElement.highlightElement(Search);
            genericUtil.writeTextWithPause(Search,CustomerName,3000);
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }

    /**
     * TESTCASE METHOD-2 : EDIT OR MODIFY CUSTOMER
     * @param UpdatedCustomerName
     * @param UpdatedCustomerAddress
     * @param UpdatedCounty
     * @param UpdatedCustomerAccountNumber
     * @param UpdatedCity
     * @param UpdatedPostCode
     * @param UpdatedContactPersonName
     * @param UpdatedContactPersonNumber
     * @param UpdatedFaxNumber
     * @param UpdatedEmail
     */
    public void editCustomer(String UpdatedCustomerName,String UpdatedCustomerAddress,String UpdatedCounty,String UpdatedCustomerAccountNumber,String UpdatedCity,
                             String UpdatedPostCode,String UpdatedContactPersonName, String UpdatedContactPersonNumber,String UpdatedFaxNumber,String UpdatedEmail){
        try {
            genericUtil = new GenericUtil();

            HighlightElement.highlightElement(TitleMasters);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(TitleCustomerMaster);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(EditBtn);
            genericUtil.clickWithPause(EditBtn, 2000);

            HighlightElement.highlightElement(EditTitleCustomerMaster);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(EditCustomerName);
            genericUtil.writeTextWithPause(EditCustomerName, UpdatedCustomerName, 1000);

            HighlightElement.highlightElement(EditCustomerAddress);
            genericUtil.writeTextWithPause(EditCustomerAddress, UpdatedCustomerAddress, 1000);

            HighlightElement.highlightElement(EditCustomerCountry);
            genericUtil.writeTextWithPause(EditCustomerCountry, UpdatedCounty, 1000);

            HighlightElement.highlightElement(EditCustomerAccNo);
            genericUtil.writeTextWithPause(EditCustomerAccNo, UpdatedCustomerAccountNumber, 1000);

            HighlightElement.highlightElement(EditCustomerCity);
            genericUtil.writeTextWithPause(EditCustomerCity, UpdatedCity, 1000);

            HighlightElement.highlightElement(EditCustomerPostcode);
            genericUtil.writeTextWithPause(EditCustomerPostcode, UpdatedPostCode, 1000);

            HighlightElement.highlightElement(EditCustomerContactName);
            genericUtil.writeTextWithPause(EditCustomerContactName, UpdatedContactPersonName, 1000);

            HighlightElement.highlightElement(EditCustomerContactNo);
            genericUtil.writeTextWithPause(EditCustomerContactNo, UpdatedContactPersonNumber, 1000);

            HighlightElement.highlightElement(EditCustomerFaxNumber);
            genericUtil.writeTextWithPause(EditCustomerFaxNumber, UpdatedFaxNumber, 1000);

            HighlightElement.highlightElement(EditCustomerEmail);
            genericUtil.writeTextWithPause(EditCustomerEmail, UpdatedEmail, 1000);

            try {
                objCheckBox = new CheckBox();
                HighlightElement.highlightElement(AddCustomerStatus);
                objCheckBox.Select_The_Checkbox(AddCustomerStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(AddCustomerStatus);
                objCheckBox.DeSelect_The_Checkbox(AddCustomerStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(AddCustomerStatus);
                objCheckBox.Select_The_Checkbox(AddCustomerStatus);
                genericUtil.pause(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            HighlightElement.highlightElement(AddSubmit);
            genericUtil.clickWithPause(AddSubmit, 3000);

            HighlightElement.highlightElement(Search);
            genericUtil.writeTextWithPause(Search, UpdatedCustomerName, 3000);
        }catch(Exception ex){
        ex.getStackTrace();
    }
    }

    public void deleteCustomer(String searchText){
        try {
            genericUtil = new GenericUtil();
            HighlightElement.highlightElement(DeleteBtn);
            genericUtil.clickWithPause(DeleteBtn, 3000);

            HighlightElement.highlightElement(DeleteCustomerMessage);

            HighlightElement.highlightElement(YesOptionDeleteCustomerMessage);
            genericUtil.clickWithPause(YesOptionDeleteCustomerMessage, 3000);

            HighlightElement.highlightElement(Search);
            Search.clear();
            genericUtil.writeTextWithPause(Search, searchText, 3000); //"Group Test"
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }

}
