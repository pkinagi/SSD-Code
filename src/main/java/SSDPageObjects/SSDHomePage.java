package SSDPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SSDResource.BaseClass;

public class SSDHomePage extends BaseClass
{
	//Declaration
		@FindBy (id = "licenseAgree_btn" )
		WebElement AgreeButton;
		
				
		//Intialization
		
		public SSDHomePage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public void ClickIAgreeBtn()
		{
			AgreeButton.click();
		}
}
