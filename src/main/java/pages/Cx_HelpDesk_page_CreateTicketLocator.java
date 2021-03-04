package pages;

import TestUtil.Constants;
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
import org.testng.Assert;

public class Cx_HelpDesk_page_CreateTicketLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;

    public Cx_HelpDesk_page_CreateTicketLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//img[@class=\"logo-default\"]")
    public WebElement logo_img;

//    @FindBy(xpath = "//span[contains(text(),'Customer')]")
    @FindBy(xpath = "//span[contains(text(),'Customer') and @class='title']") //Changes in v2.0 on 04-Feb-2021
    public WebElement sidebar_textCustomer;

    @FindBy(xpath = "//span[contains(text(),'Create a New Ticket')]")
    public WebElement sidebar_textCreateTicket;

    @FindBy(xpath = "//a[contains(text(),'Outbound Call')]")
    public WebElement channel_OutboundCall;

    @FindBy(xpath = "//a[contains(text(),'Email')]")
    public WebElement channel_Email;

    @FindBy(xpath = "//a[contains(text(),'Received Call')]")
    public WebElement channel_ReceivedCall;

    @FindBy(xpath = "//select[@id='selectBox']")
    public WebElement customer; //EmpCust

    @FindBy(xpath = "//span[contains(text(),'Create New Ticket')]")
    public WebElement titleCreateTicket;

    @FindBy(xpath = "//select[@id='createTicketTitle']")
    public WebElement ticketType; //Returns

    @FindBy(xpath = "//input[@formcontrolname='Description']")
    public WebElement description;

    @FindBy(xpath = "//label[contains(text(),'Owner')]/..//input[@class='form-control']")
    public WebElement labelOwner;

    @FindBy(xpath = "//select[@formcontrolname='Status']")
    public WebElement state;

    @FindBy(xpath = "//select[@formcontrolname='Priority']")
    public WebElement priority;

    @FindBy(xpath = "//input[@formcontrolname='Tags']")
    public WebElement tag;

    @FindBy(xpath = "//span[contains(text(),'Select file')]") //div[@class='form-control uneditable-input input-fixed input-small fileUPload']
    public WebElement file;

    @FindBy(xpath = "(//input[@class='btn btn-success'])[1]")
    public WebElement buttonSubmit;

    @FindBy(xpath = "//h4[contains(text(),'Confirm Ticket Creation!')]")
    public WebElement confirmTicket;

    @FindBy(xpath = "//input[@value='Yes']")
    public WebElement optionConfirmYesTicket;

    @FindBy(xpath = "//input[@value='No']")
    public WebElement optionConfirmNoTicket;

    @FindBy(xpath = "//input[@value='No']")
    public WebElement optionConfirmCloseTicket;

    @FindBy(xpath = "//h4[text()='Confirm Ticket Creation!']/../button")
    public WebElement closeConfirmCreateTicket;

    /*-----------------Return Pop-Up window----------------*/
    @FindBy(xpath = "(//div[@class=\"modal-content\"])[4]")
    public WebElement popupReturn;

    @FindBy(xpath = "//select[@id='returninvoiceno']")
    public WebElement Invoice;

    @FindBy(xpath = "//span[contains(text(),'Paracetamol SF 250/5ml Sus 1Lt')]")
    public WebElement ProductName;

    @FindBy(xpath = "//input[@id='returnqty0']")
    public WebElement ReturnQty;

    @FindBy(xpath = "//input[@id='returnBoxes0']")
    public WebElement ReturnBoxesQty;

    @FindBy(xpath = "(//input[@value=\"Submit\"])[2]")
    public WebElement ReturnSubmitButton;

    @FindBy(xpath = "//select[@id='returnProductReason']")
    public WebElement ReturnSelectReason;

    @FindBy(xpath = "//span[contains(text(),'PIP Code Error.')]")
    public WebElement ReturnSelectPIPCodeError;

    @FindBy(xpath = "(//input[@value='Submit'])[3]")
    public WebElement ReturnReasonSubmitButton;

    @FindBy(xpath = "//span[@xpath=\"1\"]")
    public WebElement ReturnDeclarationCheckedButton;

    @FindBy(xpath = "//input[@id='radio14']")
    public WebElement ReturnNoteDeclarationRadio1Yes;

    @FindBy(xpath = "//input[@id='radio16']")
    public WebElement ReturnNoteDeclarationRadio2Yes;

    @FindBy(xpath = "//input[@id='radio18']")
    public WebElement ReturnNoteDeclarationRadio3Yes;

    @FindBy(xpath = "(//input[@value=\"Submit\"])[4]")
    public WebElement ReturnNoteDeclarationSubmitButton;

    @FindBy(xpath = "//span[@xpath='1']")
    public WebElement ReturnSelectPIPCodeErrorCheckedButton;


    /*-----------------End of-Return Pop-Up window---------------*/


    /**
     * TESTCASE: Create Ticket
     */
    public void createTicket() {
        genericUtil = new GenericUtil();
        try {
            wait.until(ExpectedConditions.visibilityOf(sidebar_textCustomer));
            HighlightElement.highlightElement(sidebar_textCustomer);
            sidebar_textCustomer.click();
            genericUtil.pause(2000);

            HighlightElement.highlightElement(sidebar_textCreateTicket);
            sidebar_textCreateTicket.click();
            genericUtil.pause(2000);
            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "createnewticket");

            HighlightElement.highlightElement(titleCreateTicket);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(channel_Email);
            genericUtil.clickWithPause(channel_Email,1000);

            HighlightElement.highlightElement(customer);
            genericUtil.click(customer);
            Select selectCustomer = new Select(customer);
            selectCustomer.selectByVisibleText("TEST CUSTOMER");
            genericUtil.pause(1000);
            genericUtil.click(customer);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(ticketType);
            genericUtil.click(ticketType);
            Select selectTicketType = new Select(ticketType);
            selectTicketType.selectByVisibleText("Returns");
            genericUtil.pause(1000);
            genericUtil.click(ticketType);
            genericUtil.pause(1000);

        /*---BEGIN-------------Return popup-----------------*/
            HighlightElement.highlightElement(popupReturn);
            Select selectInvoice = new Select(Invoice);
            selectInvoice.selectByVisibleText("983586540"); //983586540
            genericUtil.pause(1000);

            HighlightElement.highlightElement(ReturnQty);
            genericUtil.writeTextWithPause(ReturnQty,"01",1000);

            HighlightElement.highlightElement(ReturnBoxesQty);
            genericUtil.writeTextWithPause(ReturnBoxesQty,"01",1000);

            HighlightElement.highlightElement(ProductName);
            genericUtil.clickWithPause(ProductName,1000);

            HighlightElement.highlightElement(popupReturn);
            Select selectReturnReason = new Select(ReturnSelectReason);
            selectReturnReason.selectByVisibleText("Other");
            genericUtil.pause(1000);

            HighlightElement.highlightElement(ReturnSelectPIPCodeError);
            genericUtil.clickWithPause(ReturnSelectPIPCodeError,1000);

            HighlightElement.highlightElement(ReturnDeclarationCheckedButton);
            genericUtil.clickWithPause(ReturnDeclarationCheckedButton,2000);

            HighlightElement.highlightElement(ReturnSelectPIPCodeErrorCheckedButton);
            genericUtil.clickWithPause(ReturnSelectPIPCodeErrorCheckedButton,2000);

            HighlightElement.highlightElement(ReturnReasonSubmitButton);
            genericUtil.clickWithPause(ReturnReasonSubmitButton,2000);

            HighlightElement.highlightElement(ReturnSubmitButton);
            genericUtil.clickWithPause(ReturnSubmitButton,1000);

            HighlightElement.highlightElement(ReturnDeclarationCheckedButton);
            genericUtil.clickWithPause(ReturnDeclarationCheckedButton,1000);

            HighlightElement.highlightElement(ReturnNoteDeclarationRadio1Yes);
            genericUtil.clickWithPause(ReturnNoteDeclarationRadio1Yes,1000);

            HighlightElement.highlightElement(ReturnNoteDeclarationRadio3Yes);
            genericUtil.clickWithPause(ReturnNoteDeclarationRadio3Yes,1000);

            HighlightElement.highlightElement(ReturnNoteDeclarationSubmitButton);
            genericUtil.clickWithPause(ReturnNoteDeclarationSubmitButton,1000);

        /*---END-------------Return popup-----------------*/

            HighlightElement.highlightElement(description);
            genericUtil.writeTextWithPause(description, "Test Description", 1000);
            genericUtil.pause(2000);

            HighlightElement.highlightElement(labelOwner);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(state);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(priority);
            genericUtil.click(priority);
            genericUtil.pause(1000);
            Select selectPriority = new Select(priority);
            selectPriority.selectByVisibleText("Low");
            genericUtil.pause(2000);

            HighlightElement.highlightElement(tag);
            genericUtil.writeTextWithPause(tag, "#New#Created#Open#", 2000);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(buttonSubmit);
            genericUtil.clickWithPause(buttonSubmit, 2000);

            HighlightElement.highlightElement(optionConfirmYesTicket);
            genericUtil.clickWithPause(optionConfirmYesTicket, 3000);

        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
