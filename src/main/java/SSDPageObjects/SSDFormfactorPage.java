package SSDPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SSDResource.BaseClass;

public class SSDFormfactorPage extends BaseClass
{
	//Declaration
		// Add in Card Image 
		@FindBy (xpath = "//*[@id=\"AIC\"]/img")
		WebElement AddInImage;
		// Add-In-Card ID
		//@FindBy (xpath = "//*[@id=\"id-ssdInterface_3\"]")
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_AIC\"]")
		WebElement AddInCheckBx;
		
		// M2. Image
		@FindBy (xpath = "//*[@id=\"M.2\"]/img")
		WebElement M2Image;
		//M2 ID
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_mez\"]")
		WebElement M2CheckBx;
		
		// 3.5" LFF Image
		@FindBy (xpath = "//*[@id=\"LFF\"]/img")
		WebElement Image35;
		// 3.5 Id
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_LFF\"]")
		WebElement SSD35CheckBx;
		
		//2.5" SFF Image 
		@FindBy (xpath = "//*[@id=\"SFF\"]/img")
		WebElement Image25;
		//2.5 Form Factor ID
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_SFF\"]")
		WebElement SSD25checkBx;
		
		//M.2 Enablement Image 
		@FindBy (xpath = "//*[@id=\"M.2e\"]/img")
		WebElement M2EImage;
		// M.2 E ID
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_mezE\"]")
		WebElement SSDM2ECheckBx;
		
		//Next Button in Drive Capacity  Page
		@FindBy (xpath = "//button[@id=\"nextQuestion_btn\"]")
		WebElement FormFactorNextBtn;
		
		//Search Icon
		@FindBy (xpath = "//*[@id=\"search1\"]/i")
		WebElement AllPageSearchIcon;
		
		@FindBy (xpath = "//span[@id=\"check-box-label\"][text()='Add-In Card']")
		WebElement SelectFormFactor;
		
		public JavascriptExecutor FormFactorClick = (JavascriptExecutor)driver;
		
		
		
		
		
		//Intialization
		public SSDFormfactorPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public void ClickFromFactor()
		{
			SelectFormFactor.click();
		}
		public boolean AddInCardImage()
		{
			return AddInImage.isDisplayed();
		}
		public boolean AddInCardSelected()
		{
			return AddInCheckBx.isSelected();
		}
		public boolean M2ImageDisplayed()
		{
			return M2Image.isDisplayed();
		}
		public boolean M2CardSelected()
		{
			return M2CheckBx.isSelected();
		}
		public boolean LFFDisplayed()
		{
			return Image35.isDisplayed();
		}
		public boolean LFFSelected()
		{
			return SSD35CheckBx.isSelected();
		}
		public boolean SFFDisplayed()
		{
			return Image25.isDisplayed();
		}
		public boolean SFFSelected()
		{
			return SSD25checkBx.isSelected();
		}
		public boolean M2EDisplayed()
		{
			return M2EImage.isDisplayed();
		}
		public boolean M2eSelected()
		{
			return SSDM2ECheckBx.isSelected();
		}
		public void FormNxtBtn()
		{
			FormFactorNextBtn.click();
		}
		public boolean FFSearchIcon()
		{
			return AllPageSearchIcon.isDisplayed();
		}
		public boolean FFNxtBtn()
		{
			return FormFactorNextBtn.isEnabled();
		}

		public boolean EditFormFactorOptions() throws InterruptedException
		{
			Thread.sleep(20000);
			if(SSDM2ECheckBx.isSelected() || M2CheckBx.isSelected() || SSD35CheckBx.isSelected()||SSD25checkBx.isSelected())
			{
				FormFactorNextBtn.isEnabled();
				FormFactorClick.executeScript("arguments[0].click()", SSD35CheckBx);
				FormFactorClick.executeScript("arguments[0].click()",SSD25checkBx);
				FormFactorClick.executeScript("arguments[0].click()", SSDM2ECheckBx);
				FormFactorClick.executeScript("arguments[0].click()", M2CheckBx);
				return FormFactorNextBtn.isEnabled();
			}
			else
			{
				FormFactorNextBtn.click();
				return false;
			}
		}
		
		public void EnableFormFactorOptions()
		{
			FormFactorClick.executeScript("arguments[0].click()", SSD35CheckBx);
			FormFactorClick.executeScript("arguments[0].click()", SSD25checkBx);
			FormFactorClick.executeScript("arguments[0].click()", SSDM2ECheckBx);
			FormFactorClick.executeScript("arguments[0].click()", M2CheckBx);
		}
}
