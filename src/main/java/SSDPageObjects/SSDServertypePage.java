package SSDPageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SSDResource.BaseClass;

public class SSDServertypePage extends BaseClass
{
	//Declarations
		// READ SSD Selected
		//@FindBy (xpath = "//span[contains(text(),'Read Intensive')]")
		@FindBy (xpath = "//*[@id=\"id-ssdtype_RI\"]")
		WebElement SelectReadInt;
		
		// MIXED SSD Selected
		@FindBy (xpath ="//input[@id=\"id-ssdtype_MU\"]")
		WebElement SelectedMixedInt;
		
		// WRITE SSD Selected
		@FindBy (xpath = "//input[@id=\"id-ssdtype_WI\"]")
		WebElement SelectedWriteInt;
		
		//VRO SSD Selected
		@FindBy (xpath = "//input[@id=\"id-ssdtype_VRO\"]")
		WebElement SelectedVROInt;
		
		//Next Button in SSD Type Page
		@FindBy (xpath = "//button[@id=\"nextQuestion_btn\"]")
		WebElement NextBtn;
		
		// Back Button in SSD Type Page
		@FindBy (xpath = "//button[@id=\"backQuestion_btn\"]/span[text()='Back']")
		WebElement BackBtn;
		
		//Select All Option
		@FindBy (xpath = "//span[@class = \"sel_all\"]")
		WebElement SelectBtn;
		
		
		
		
		//Intailization
		
		public SSDServertypePage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public boolean SelectedReadIntensive()
		{
			return SelectReadInt.isSelected();
		}
		
		public boolean SelectedMixedIntensive()
		{
			return SelectedMixedInt.isSelected();
		}
		
		public boolean SelectedWriteIntensive()
		{
			return SelectedWriteInt.isSelected();
		}
		
		public boolean SelectedVROIntensive()
		{
			return SelectedVROInt.isSelected();
		}
		
		public void NextClick()
		{
			NextBtn.click();
		}
		
		public boolean NextBtnEnabled()
		{
			return NextBtn.isEnabled();
		}
		
		public void BackClick()
		{
			BackBtn.click();
		}
		
		public boolean SelectAll()
		{
			if (SelectBtn.isEnabled())
			{
				System.out.println("Next is  Selected");
			}
			else
			{
				System.out.println("Next is not Selected");
			}
			return false;
		}
		
		public boolean AllSSDsSelected()
		{
			return SelectReadInt.isSelected() & SelectedWriteInt.isSelected() & SelectedMixedInt.isSelected() ;
		}
		
		public boolean AllSSDTypeSelected()
		{
			if(SelectReadInt.isSelected() & SelectedWriteInt.isSelected() & SelectedMixedInt.isSelected() & NextBtn.isEnabled())
			{
				SelectBtn.isSelected();
				return true;
			}
			else if(SelectReadInt.isSelected() || SelectedWriteInt.isSelected() || SelectedMixedInt.isSelected() & NextBtn.isEnabled())
			{
				SelectBtn.isSelected();
				return false;
			}
			else
			{
				System.out.println("Select All Option is not Selected in SSD Type");
				return false;
			}
		}
}	
