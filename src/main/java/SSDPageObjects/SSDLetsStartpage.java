package SSDPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SSDResource.BaseClass;

public class SSDLetsStartpage extends BaseClass
{
	//Declarations
		@FindBy (id = "helpMeChoose_btn")
		WebElement HelpMEChoose;
		
		@FindBy (id = "iKnow_btn")
		WebElement IKnowBtn;
		
		//Intialization
		public SSDLetsStartpage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public void ClickHelpMeChoose()
		{
			HelpMEChoose.click();
		}
		
		public void ClickIKnow()
		{
			IKnowBtn.click();
		}
}
