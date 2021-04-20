package SSDPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SSDResource.BaseClass;

public class SSDBestAvailability extends BaseClass
{
	//Declarations
		//Mainstream Checkbox
		@FindBy (xpath = "//*[@id=\"ssdCategory_Main\"]")
		WebElement MainstreamCheckBx;
		
		// Mainstream
		//@FindBy (xpath = "//*[@id=\"stream_Yes\"]")
		//WebElement MainstreamCheckBx;
		
		//Non Mainstream Checkbox
		@FindBy (xpath = "//*[@id=\"ssdCategory_Nonmain\"]")
		WebElement NonMainstreamCheckBx;
		
		//Mainstream Click
		@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Mainstream']")
		WebElement MainstreamCBx;
		
		//Non-Mainstream Click
		@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Non Mainstream']")
		WebElement NonMainstreamCBx;
		
		//Select All Checkbox
		@FindBy (xpath = "//*[@id=\"ssd-iDontKnow\"]")
		WebElement SelectAllCheckBx;
		
		//Next button
		@FindBy (xpath = "//button[@id=\"nextQuestion_btn\"]")
		WebElement BestAvailabilityNextBtn;
		
		//Back Button
		@FindBy (xpath = "//button[@id=\"backQuestion_btn\"]/span[text()='Back']")
		WebElement BestAvailabilitybackBtn;
		
		//Search Icon
		@FindBy (xpath = "//*[@id=\"search1\"]/i")
		WebElement AllPageSearchIcon;
		
		public JavascriptExecutor bestAvailclick = (JavascriptExecutor)driver;
		
		//Intialization
	public SSDBestAvailability()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean Mainstream()
	{
		return MainstreamCheckBx.isSelected();
	}

	public boolean NonMainstream()
	{
		return NonMainstreamCheckBx.isSelected();
	}

	public boolean MainstreamClick()
	{
		MainstreamCBx.click();
		return BestAvailabilityNextBtn.isEnabled();
	}

	public void MainNonstreamClick()
	{
		MainstreamCBx.click();
		NonMainstreamCBx.click();
	}

	public boolean NextSelectAll()
	{ 
		BestAvailabilityNextBtn.isEnabled();
		return SelectAllCheckBx.isEnabled();
	}

	public void BestAvailNextBtn()
	{
		NonMainstreamCBx.click();
		BestAvailabilityNextBtn.click();
	}

	public boolean NextBtnEnabled()
	{
		return BestAvailabilityNextBtn.isEnabled();
	}

	public boolean BASearchIcon()
	{
		return AllPageSearchIcon.isDisplayed();
	}
	public void MainNonMainstreamSelectAll()
	{
		//SelectAllCheckBx.click();
		
		bestAvailclick.executeScript("arguments[0].click()", SelectAllCheckBx);
	}
	public void BestAvailNxtBtn()
	{
		BestAvailabilityNextBtn.click();
		
	}

	public boolean EditMainstreamOptions()
	{
		if(MainstreamCheckBx.isSelected() || NonMainstreamCheckBx.isSelected())
		{
			BestAvailabilityNextBtn.isEnabled();
			bestAvailclick.executeScript("arguments[0].click()", MainstreamCheckBx);
			return BestAvailabilityNextBtn.isEnabled();
		}
		else
		{
			//BestAvailabilityNextBtn.click();
			return false;
		}
	}

	public void EnableMainstreamOptions()
	{
		bestAvailclick.executeScript("arguments[0].click()", MainstreamCheckBx);
		bestAvailclick.executeScript("arguments[0].click()", NonMainstreamCheckBx);
	}

	public boolean MainstreamSelectAll()
	{
		return SelectAllCheckBx.isSelected();
	}
}
