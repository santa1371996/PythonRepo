package PageMethods;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import utilities.DateUtils;
import utilities.StringUtils;
import utilities.PersonDetails;

import utilities.cucumberLogs;
import utilities.globalvariables;

public class InterestsPage extends commonMethods {


	@FindBy(xpath = "//*[@class='btn OSFillParent'][@type = 'button']")
	WebElement btn_EditDetails;
	@FindBy(xpath = "//*[@class='btn OSFillParent'][@type = 'button'][contains(text(),'Add interest')]")
	WebElement btn_addInterest;

	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Cancel')]")
  WebElement btn_Cancel;

	@FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_InterestDetails;

	@FindBy(xpath = "//input[@id='Input_CurrentInterest2']")
	WebElement	txt_Interest;

	@FindBy(xpath = "//*[@id='popupDiscardChanges']//a[contains(text(),'Discard')]")
  WebElement lnk_discard;

  @FindBy(xpath = "//*[@id='popupDiscardChanges']//a[contains(text(),'Continue editing')]")
  WebElement lnk_ContinueEditing;

	@FindBy(xpath = "//div[@id='popupDeleteItem']//a[contains(text(),'Delete')]")
	public WebElement lnk_Delete;

	SoftAssert softAssert = new SoftAssert();

	@FindBy(xpath = "//div[@class='popup-dialog popup-dialog']")
	public WebElement dlg_DiscardChanges;

	@FindBy(xpath = "//div[@class='popup-dialog popup-dialog'][@id='popupDeleteItem']")
	public WebElement dlg_Delete;

  @FindBy(xpath = "//div[@class='drop-overlay-bottom']//button[@class='btn btn-primary']")
	WebElement btn_SaveChanges;

	@FindBy(xpath = "//div[@id='b1-popupReviewChanges']//button[@class='btn OSFillParent']")
	public WebElement btn_cancelReviewChanges;

	@FindBy(xpath ="//div[@class='list-item']")
	public List<WebElement> interestsList;

	@FindBy(xpath ="//div[@class='public-profile-content']//div[@class='list list-group OSFillParent']")
	public List<WebElement> finalInterestsList;

	String interest;

	public InterestsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void edit_details() {

		explicitWait(btn_EditDetails, "elementToBeClickable", 20);
		clickElement(btn_EditDetails, "Edit Details button");
	}

	public boolean is_InterestDetails_Landing_Displayed() {
		if (explicitWait(btn_EditDetails,"elementToBeClickable", 30)) {
			cucumberLogs.info("Interests landing details page displayed");
			return true;
		}
		return false;
	}

	public boolean is_InterestDetails_Displayed() {

		if (frm_InterestDetails.isDisplayed()) {
			cucumberLogs.info("Edit Interests page displayed");
			return true;
		}
		return false;
	}

	public void enterInterests(String interest ) {
		clearText(txt_Interest);
		enterText(txt_Interest, interest);
	}

	public void addInterests() {
		this.interest = new String(StringUtils.generateRandomChars("abcdefghijklmnopqrstuvxyz", 5));

		enterInterests(this.interest);
		clickElement(btn_addInterest, "Add interest");
		cucumberLogs.info(this.interest + " interest is added ");
		System.out.println(this.interest + " interest is added ");
	}

	public void cancelAddingInterest() {
		explicitWait(btn_Cancel, "elementToBeClickable", 20);
		clickElement(btn_Cancel, "Cancel button");
		moveToElement(btn_Cancel);
	}

	public void discardInterests() {

		explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
		explicitWait(lnk_discard, "elementToBeClickable", 20);
		clickElement(lnk_discard, "Discard link");
	}

	public WebElement searchInterest() {
		int nosOfInterests = interestsList.size();
		WebElement newInterest = null ;
		for( int i = 0 ; i < nosOfInterests ; i++) {
			try {
					 cucumberLogs.info("Searching for recently added interest...");

					 if (explicitWaitForTextInElement(interestsList.get(i),this.interest,3) ){
					 	newInterest=interestsList.get(i);
					 	break;
					}
			}
			catch(Exception e){
				//do nothing but interate completely
			}
		}
		return newInterest;
	}

	public WebElement searchInFinalInterestList() {
		int nosOfInterests = finalInterestsList.size();
		for( int i = 0 ; i < nosOfInterests ; i++) {
			try {

				if (explicitWaitForTextInElement(finalInterestsList.get(i),this.interest,3) ){
					 cucumberLogs.info("found interest added");
					 return interestsList.get(i);
				}
			}
			catch(Exception e){
				//do nothing but interate completely
			}
		}

		return null;
	}

 public boolean deleteLatestInterest() {
	 WebElement interest = searchInterest();
	 if( interest != null ){
		 WebElement	deleteIcon = interest.findElement(By.xpath(".//child::i"));
		 scrolldownbrowser(interest);
		 deleteIcon.click();
		 return true;
	 }
   return false;
 }

 public boolean isDeletedInterestDisplayed() {
	 WebElement interest = searchInterest();
	 if( interest == null ){
		 return true;
	 }
	 return false;
 }

 public boolean isAddedInterestDisplayed() {
	 WebElement interest = searchInFinalInterestList();
	 if( interest != null ){
		 return true;
	 }
	 return false;
 }

 public void confirmDeleteInterest() {
	 explicitWait(dlg_Delete, "visibilityOf", 120);
	 explicitWait(lnk_Delete, "elementToBeClickable", 20);
	 clickElement(lnk_Delete, "Delete link");
 }

	public void continueEditingContactDetails() {

		explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
		explicitWait(lnk_ContinueEditing, "elementToBeClickable", 20);
		clickElement(lnk_ContinueEditing, "Continue editing link");
	}

  public void SaveChanges()  {
		explicitWait(btn_SaveChanges, "elementToBeClickable", 10);
		clickElement(btn_SaveChanges, "Save Changes button");
	}




}
