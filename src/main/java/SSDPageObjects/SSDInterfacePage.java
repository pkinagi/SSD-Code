package SSDPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SSDResource.BaseClass;

public class SSDInterfacePage extends BaseClass
{
	//Declaration
		//Search Icon In The Header
		@FindBy (xpath = "//*[@id=\"search1\"]/i")
		WebElement AllPageSearchIcon;
		
		//Auto Selected Interface SAS
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_SAS\"]")
		WebElement AutoInterfaceSAS;
		
		//Auto Selected Interface SATA
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_SATA\"]")
		WebElement AutoInterfaceSATA;
		
		//Auto Selected Interface NVMe
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_NVMe\"]") 
		WebElement AutoInterfaceNVMe;
		
		//Auto Selected Interface NVMe NVMe Mainstream
		@FindBy (xpath = "//*[@id=\"nvmMain\"]")
		WebElement AutoInterfaceNVMeMainstream;
		
		//Auto Selected Interface NVMe NVMe High Performance
		@FindBy (xpath = "//*[@id=\"nvmHigh\"]")
		WebElement AutoInterfaceNVMeHighPerformance;
		
		//Not Selected Value SAS
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_VALUESAS\"]")
		WebElement NotSelectedSAS;
		
		//Not Selected Sata VRO
		@FindBy (xpath = "//*[@id=\"id-ssdInterface_SATA_VRO\"]")
		WebElement NotSelectedVRO;
		
		//Next Button in Interface Type  Page
		@FindBy (xpath = "//button[@id=\"nextQuestion_btn\"]")
		WebElement InterfaceNxtBtn;
		
		// Back Button in Interface Type Page
		@FindBy (xpath = "//button[@id=\"backQuestion_btn\"]/span[text()='Back']")
		WebElement InterfaceBackBtn;
		
		@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='SAS']")
		WebElement SelectInterface;
		
		@FindBy (xpath = "//span[id=\"check-box-label\"]/span[text()='Mainstream']")
		WebElement SelectMainstream;
		
		// Select All Options
		@FindBy (xpath = "//*[@id=\"check-box-label\"]/span[text()=\"Select All / I Don't Know Yet\"]")
		WebElement SelectAllInterface;
		
		
		
		public JavascriptExecutor InterfaceClick = (JavascriptExecutor)driver;
		
		//Intialization
		public SSDInterfacePage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public void ClickInterface()
		{
			SelectInterface.click();
		}
		
		public void ClickMainstream()
		{
			SelectMainstream.click();
		}
		
		public boolean InterfaceSAS()
		{
			return AutoInterfaceSAS.isSelected();
		}
		public boolean InterfaceSATA()
		{
			return AutoInterfaceSATA.isSelected();
		}
		public boolean InterfaceNVMe()
		{
			return AutoInterfaceNVMe.isSelected();
		}
		public boolean InterfaceNVMeMainstream()
		{
			return AutoInterfaceNVMeMainstream.isSelected();
		}
		public boolean InterfaceNVMeHigh()
		{
			return AutoInterfaceNVMeHighPerformance.isSelected();
		}
		public void InterfaceNxtBtn()
		{
			InterfaceNxtBtn.click();
		}
		public void InterfaceBackBtn()
		{
			InterfaceBackBtn.click();
		}
		public boolean InterfaceNxtBtnEn()
		{
			return InterfaceNxtBtn.isEnabled();
		}
		public boolean InterfaceSearchIcon()
		{
			return AllPageSearchIcon.isDisplayed();
		}
		public boolean InterfaceValueSAS()
		{
			return NotSelectedSAS.isSelected();
		}
		public boolean InterfaceSataVRO()
		{
			return NotSelectedVRO.isSelected();
		}
		public boolean SelectAllInterface()
		{
			return SelectAllInterface.isSelected();
		}
		
		public boolean EditInterfaceOptions() throws InterruptedException
		{
			Thread.sleep(20000);
			if(AutoInterfaceSAS.isSelected() || AutoInterfaceSATA.isSelected() || AutoInterfaceNVMe.isSelected() & InterfaceNxtBtn.isEnabled())
			{
				InterfaceClick.executeScript("arguments[0].click()", AutoInterfaceSAS);
				InterfaceClick.executeScript("arguments[0].click()", AutoInterfaceSATA);
				InterfaceClick.executeScript("arguments[0].click()",AutoInterfaceNVMe);
				return InterfaceNxtBtnEn();
			}
			else
			{
				InterfaceNxtBtn.click();
				return false;
			}
		}
		public void EnableInterfaceOptions()
		{
			InterfaceClick.executeScript("arguments[0].click()", AutoInterfaceSAS);
			InterfaceClick.executeScript("arguments[0].click()", AutoInterfaceSATA);
			InterfaceClick.executeScript("arguments[0].click()",AutoInterfaceNVMe);
		}
		
		public void CheckNextButton()
		{
			if(AutoInterfaceSAS.isSelected() & InterfaceNxtBtn.isEnabled())
			{
				InterfaceNxtBtn.click();
			}
			else if (AutoInterfaceSATA.isSelected() & InterfaceNxtBtn.isEnabled())
			{
				
			}
		}
}
