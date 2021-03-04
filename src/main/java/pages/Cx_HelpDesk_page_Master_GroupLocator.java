package pages;

import TestUtil.CheckBox;
import TestUtil.GenericUtil;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cx_HelpDesk_page_Master_GroupLocator extends TestBase{

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;
    public static CheckBox objCheckBox;

    /*--------------Group ---------------*/
    @FindBy(xpath = "//h1[@class='page-title']")
    public WebElement TitleMasters;

    @FindBy(xpath = "(//span[@class='caption-subject font-dark bold uppercase'])[2]")
    public WebElement TitleGroup;

    @FindBy(xpath = "//li[@id='master']") //i[@class='fa fa-database']
    public WebElement sidebar_textMaster;

    @FindBy(xpath = "(//a[@class='collapse btn btn-circle btn-icon-only btn-default'])[2]")
    public WebElement GroupCollapse;

    @FindBy(xpath = "(//a[@class='btn btn-circle btn-icon-only btn-default fullscreen'])[2]")
    public WebElement GroupFullScreen;

    @FindBy(xpath ="(//select[@class='fontColor'])[2]")
    public WebElement GroupList;

    @FindBy(xpath = "(//input[@class='fontColor'])[2]")
    public WebElement GroupSearch;

    @FindBy(xpath = "(//tr[@class='odd shown'])[1]")
    public WebElement GroupData;

    @FindBy(xpath = "(//tr/td[@class='text-center btnPlus'])[1]")
    public WebElement GroupBtnPlus;

    @FindBy(xpath = "(//tr/td[@class='text-center btnMinus'])[1]")
    public WebElement GroupBtnMinus;

    @FindBy(xpath = "(//tr[@class='ng-star-inserted'])[3]")
    public WebElement GroupDataListFirstRow;

    @FindBy(xpath = "(//input[@class='fontColor'])[3]")
    public WebElement GroupDataSearch;

    @FindBy(xpath = "(//tr[@class='ng-star-inserted'])[3]")
    public WebElement GroupEmpDataFirstRow;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[3]")
    public WebElement GroupEmpPaginationPrevious;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[5]")
    public WebElement GroupEmpPaginationNext;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[4]")
    public WebElement GroupEmpPaginationNo ;

    /*--------------Edit Group ---------------*/

    @FindBy(xpath = "//i[@title=\"Edit Group\"]")
    public WebElement GroupEditBtn;

    @FindBy(xpath = "//i[@title='Delete Group']")
    public WebElement GroupDeleteBtn;

    @FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid ng-touched']")
    public WebElement GroupEditName;

    /*

    //don't no which xpath use

    @FindBy(xpath = "")
    WebElement GroupEditAttachedUser;

    */

    @FindBy(xpath ="(//label[@class='mt-checkbox mt-checkbox-single mt-checkbox-outline']/span)[2]")
    public WebElement GroupEditStatus;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[7]")
    public WebElement GroupEditSubmit;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[8]")
    public WebElement GroupEditClear;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[9]")
    public WebElement GroupEditCancel;

    @FindBy(xpath = "(//a[@class='btn btn-success language_btn'])[3]")
    public WebElement GroupAdd;

    @FindBy(xpath = "(//a[@class='btn btn-success language_btn'])[4]")
    public WebElement GroupImport;

    @FindBy(xpath = "//h3[contains(text(),'Are you sure! You want to Delete this Group?')]")
    public WebElement DeleteGroupMessage;

    @FindBy(xpath = "(//button[@class='btn btn-lg btn-success'])[2]")
    public WebElement YesOptionDeleteGroupMessage;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement GroupAddName;

    @FindBy(xpath = "(//div[@class='cuppa-dropdown'])[1]")
    public WebElement GroupAddAttachedUser;

    @FindBy(xpath = "//label[@for='selectAll']")
    public WebElement SelectedAllAttachedUser;

    @FindBy(xpath = "//span[contains(text(),'Deselect All')]")
    public WebElement DeSelectedAllAttachedUser;

    @FindBy(xpath = "(//span[@class='c-angle-down ng-star-inserted'])[1]")
    public WebElement downArrowAttachedUser;

    @FindBy(xpath = "(//label[@class='mt-checkbox mt-checkbox-single mt-checkbox-outline']/span)[2]")
    public WebElement GroupAddStatus;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[7]")
    public WebElement GroupAddSubmit;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[8]")
    public WebElement GroupAddClear;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[9]")
    public WebElement GroupAddCancel;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[8]")
    public WebElement GroupPaginationPrevious;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[11]")
    public WebElement GroupPaginationNext;

    @FindBy(xpath = "(//a[@class='ng-star-inserted'])[10]")
    public WebElement GroupPaginationNo ;

    public Cx_HelpDesk_page_Master_GroupLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public void createGroup(String GroupName,String searchText){
        try {
            genericUtil = new GenericUtil();

            wait.until(ExpectedConditions.visibilityOf(sidebar_textMaster));
            HighlightElement.highlightElement(sidebar_textMaster);
            sidebar_textMaster.click();
            genericUtil.pause(2000);

            HighlightElement.highlightElement(TitleMasters);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(GroupCollapse);
            genericUtil.clickWithPause(GroupCollapse,1000);

            HighlightElement.highlightElement(TitleGroup);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(GroupAdd);
            genericUtil.clickWithPause(GroupAdd,3000);

            HighlightElement.highlightElement(GroupAddName);
            genericUtil.writeTextWithPause(GroupAddName,GroupName,2000); //"Group Test"

            HighlightElement.highlightElement(GroupAddAttachedUser);
            genericUtil.clickWithPause(GroupAddAttachedUser,1000);

            HighlightElement.highlightElement(SelectedAllAttachedUser);
            genericUtil.clickWithPause(SelectedAllAttachedUser,1000);

            HighlightElement.highlightElement(downArrowAttachedUser);
            genericUtil.clickWithPause(downArrowAttachedUser,1000);

            try {
                objCheckBox = new CheckBox();
                HighlightElement.highlightElement(GroupAddStatus);
                objCheckBox.Select_The_Checkbox(GroupAddStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(GroupAddStatus);
                objCheckBox.DeSelect_The_Checkbox(GroupAddStatus);
                genericUtil.pause(1000);
                HighlightElement.highlightElement(GroupAddStatus);
                objCheckBox.Select_The_Checkbox(GroupAddStatus);
                genericUtil.pause(1000);
            }catch (Exception e) {
                e.printStackTrace();
            }

            HighlightElement.highlightElement(GroupAddSubmit);
            genericUtil.clickWithPause(GroupAddSubmit,3000);

            HighlightElement.highlightElement(GroupSearch);
            genericUtil.writeTextWithPause(GroupSearch,searchText,3000); //"Group Test"

            HighlightElement.highlightElement(GroupBtnPlus);
            genericUtil.clickWithPause(GroupBtnPlus,2000); //"Group Test"

            HighlightElement.highlightElement(GroupBtnMinus);
            genericUtil.clickWithPause(GroupBtnMinus,2000); //"Group Test"
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }

    public void editGroup(String UpdatedGroupName,String searchText){
        try {
            genericUtil = new GenericUtil();

            HighlightElement.highlightElement(GroupEditBtn);
            genericUtil.clickWithPause(GroupEditBtn,3000);

            HighlightElement.highlightElement(GroupAddName);
            genericUtil.writeTextWithPause(GroupAddName,UpdatedGroupName,2000); //"Group Test"

            HighlightElement.highlightElement(GroupAddAttachedUser);
            genericUtil.clickWithPause(GroupAddAttachedUser,1000);

            HighlightElement.highlightElement(DeSelectedAllAttachedUser);
            genericUtil.clickWithPause(DeSelectedAllAttachedUser,2000);

            HighlightElement.highlightElement(SelectedAllAttachedUser);
            genericUtil.clickWithPause(SelectedAllAttachedUser,2000);

            HighlightElement.highlightElement(downArrowAttachedUser);
            genericUtil.clickWithPause(downArrowAttachedUser,1000);

            HighlightElement.highlightElement(GroupAddSubmit);
            genericUtil.clickWithPause(GroupAddSubmit,3000);

            HighlightElement.highlightElement(GroupSearch);
            GroupSearch.clear();
            genericUtil.writeTextWithPause(GroupSearch,searchText,3000); //"Group Test"
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }

    public void deleteGroup(String searchText){
        try {
            genericUtil = new GenericUtil();
            HighlightElement.highlightElement(GroupDeleteBtn);
            genericUtil.clickWithPause(GroupDeleteBtn, 3000);

            HighlightElement.highlightElement(DeleteGroupMessage);

            HighlightElement.highlightElement(YesOptionDeleteGroupMessage);
            genericUtil.clickWithPause(YesOptionDeleteGroupMessage, 3000);

            HighlightElement.highlightElement(GroupSearch);
            GroupSearch.clear();
            genericUtil.writeTextWithPause(GroupSearch, searchText, 3000); //"Group Test"
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }
}
