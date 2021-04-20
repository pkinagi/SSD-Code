package SSDPageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SSDResource.BaseClass;

public class SSDCapacityPage extends BaseClass
{
	//Declarations
		//Next Button in Drive Capacity  Page
		@FindBy (xpath = "//button[@id=\"nextQuestion_btn\"]")
		WebElement DrvCapacityNextBtn;
		
		//Max Value in Capacity Page
		@FindBy (xpath = "//*[@id=\"input-with-keypress-1\"]")
		WebElement CapaMaxValue;
		
		//Min Value in Capacity Page
		@FindBy (xpath = "//*[@id=\"input-with-keypress-0\"]")
		WebElement CapaMinValue;
		
		//Slider Minimum Point Value in Capacity Page
		@FindBy (xpath = "//*[@id=\"steps-slider\"]/div/div[1]/div")
		WebElement MinPointSlider;
		
		//Slider Maximum Point Value in Capacity Page
		@FindBy (css = "//div[@class='noUi-handle noUi-handle-upper']//div[@class='noUi-touch-area']")
		WebElement MaxPointSlider;
		
		//Capacity Page Back Button
		@FindBy (xpath = "//button[@id=\"backQuestion_btn\"]/span[text()='Back']")
		WebElement CapacityBackBtn;
		
		
		//Search Icon
		@FindBy (xpath = "//*[@id=\"search1\"]/i")
		WebElement AllPageSearchIcon;
		
		
		
		
		//Intilization
		public SSDCapacityPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		
		public boolean CapacityMaxvalue()
		{
			return CapaMaxValue.isDisplayed();
		}
		
		public boolean CapacityMinValue()
		{
			return CapaMinValue.isDisplayed();
		}
		
		public void MaxSlider()
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions MoveMaxSlider = new Actions(driver);
			try
			{
				MoveMaxSlider.dragAndDropBy(MaxPointSlider, -30, 100).build().perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				MoveMaxSlider.clickAndHold(MaxPointSlider).moveByOffset(-30, 100).release().perform();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		public void MinSlider()
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions MoveMinSlider = new Actions(driver);
			try
			{
				MoveMinSlider.dragAndDropBy(MinPointSlider, 100, 40).build().perform();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				MoveMinSlider.clickAndHold(MinPointSlider).moveByOffset(100, 40).release().perform();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			//MoveMinSlider.clickAndHold(MoveMinSlider).moveByOffset(100, 40).release().perform();
			//MoveMinSlider.moveToElement(MinPointSlider).click().dragAndDropBy(MinPointSlider, -1000, -200).build().perform();
		}
		public boolean CapacityNxtBtn()
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions MoveMaxMinSlider = new Actions(driver);
			MoveMaxMinSlider.moveToElement(MinPointSlider).click().dragAndDropBy(MinPointSlider, 1000, 0).build().perform();
			return DrvCapacityNextBtn.isEnabled();
		}
		public boolean CapacityNxtBtn2()
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions MoveMinSlider = new Actions(driver);
			//MoveMinMaxSlider.moveToElement(MaxPointSlider).click().dragAndDropBy(MaxPointSlider, 0, 1000).build().perform();
			try 
			{
				WebElement MinPointSlider1 = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[2]/div"));
				MoveMinSlider.dragAndDropBy(MinPointSlider1,100,20).build().perform();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				MoveMinSlider.clickAndHold(MinPointSlider1).moveByOffset(100,20).release().perform();
			  }
			catch (Exception e)
			{
				System.out.println(e);
			}
			return DrvCapacityNextBtn.isEnabled();
		}
		public boolean CapacityPreviousPosition()
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Actions MoveBackSlider = new Actions(driver);
			try
			{
				WebElement MovMinBackSlider = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[2]/div"));
				MoveBackSlider.dragAndDropBy(MovMinBackSlider, -100,0).build().perform();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				MoveBackSlider.clickAndHold(MovMinBackSlider).moveByOffset(-100,0).release().perform();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			return DrvCapacityNextBtn.isEnabled();
		}
		public void CapaNextBtn()
		{
			DrvCapacityNextBtn.click();
		}
		public boolean SearchIconVisible()
		{
			return AllPageSearchIcon.isDisplayed();
		}
		public boolean CapaNxtBtn()
		{
			return DrvCapacityNextBtn.isEnabled();
		}
}
