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

import  SSDResource.BaseClass;


public class SSDWorkloadPage extends BaseClass
{
	//Declarations
		//@FindBy (css = "span#check-box-label")
		//To Learn More Workload
		@FindBy(xpath = "//*[@id=\"ssdSelector\"]/section/section[1]/div/div[1]/div/div/a")
		WebElement LearnMoreWorkloadPDF;
		
		//@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Active Archiving']")
		//WebElement SelectReadWorkload;
		
		//To find Read Intensive 
		@FindBy (xpath = "//div[@id=\"disp_col_0\"]//span[@id=\"check-box-label\"]")
		//@FindBy (id = "ssd-workload_ri")
		WebElement ReadCheck;
		
		//To find Read Intensive Label
		@FindBy (xpath = "//*[@id=\"disp_col_0\"]/div[2]")
		public WebElement ReadIntensiveLabel;
		
		//To find Mixed Intensive
		@FindBy (xpath = "//div[@id=\"disp_col_1\"]//span[@id=\"check-box-label\"]")
		WebElement MixedCheck;
		
		//To find Mixed Intensive Label
		@FindBy (xpath = "//*[@id=\"disp_col_1\"]/div[2]")
		public WebElement MixedIntensiveLabel;
		
		//To find Write Intensive
		@FindBy (xpath = "//div[@id=\"disp_col_2\"]//span[@id=\"check-box-label\"]")
		WebElement WriteCheck;
		
		//To find Write Intensive Label
		@FindBy (xpath = "//*[@id=\"disp_col_2\"]/div[2]")
		public WebElement WriteIntensiveLabel;
		
		//To find VRO Intensive
		@FindBy (xpath = "//div[@id=\"disp_col_0\"]//span[@id=\"check-box-label\"]")
		WebElement VROCheck;
		
		//To find VRO Intensive Label
		@FindBy (xpath = "//*[@id=\"disp_col_3\"]/div[2]")
		public WebElement VROIntensiveLabel;
		
		//Single Workload Selecting  for Read Intensive
		@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Active Archiving']")
		public WebElement SelectReadWorkload;
		
		// Single Workload Selecting  for Mixed Use
		@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Business Processing']")
		public WebElement SelectMixedWorkload;
		
		// Single Workload Selecting  for Write Intensive
		@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Big Data Analytics']")
		public WebElement SelectWriteWorkLoad;
		
		// Single Workload Selecting  for VRO
		@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='AI']")
		public WebElement SelectVROWorkLoad;
				
		@FindBy (xpath = "//button[@id=\"nextQuestion_btn\"]")
		WebElement NextBtn;
		
		// Select All 
		@FindBy (xpath = "//*[@id=\"ssd-iDontKnow\"]")
		public WebElement WorkloadSelectAll;
		
		
		
		//Intialization
		public SSDWorkloadPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public void ClickWorkload()
		{
			SelectReadWorkload.click();
		}
		
		public void ClickMixedWorkload()
		{
			SelectMixedWorkload.click();
		}
		
		public void ClickWriteWorkload()
		{
			SelectWriteWorkLoad.click();
		}
		// Clicking Next Button in the Workload Page
		public void ClickNextBtn()
		{
			NextBtn.click();
		}
		
		public boolean UnClickNextBtn()
		{
				if (NextBtn.isEnabled())
				{
					System.out.println("Next is  Selected");
				}
				else
				{
					System.out.println("Next is not Selected");
				}
				return false;
			
		}
		public boolean IsClicked()
		{
			return ReadCheck.isSelected();
		}
		public void SelectReadALL()
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//*[@id=\"ssd-workload_ri\"]"));
			int TotalCheckbox = AllCheckboxes.size();
			Actions Mousemove = new Actions(driver);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 250)");
			System.out.println("Total Number of Read Intensive Workload are " + TotalCheckbox);
			int i=0;
			/*for(i = 0; i <= TotalCheckbox; i++)
			{
				AllCheckboxes.get(i).click();
			}*/
			//String ReadWorkloadValue = AllCheckboxes.get(i).getAttribute("Value");
			i = TotalCheckbox;
				for(WebElement Checkbox : AllCheckboxes)
					{		
							jse.executeScript("arguments[0].click()", Checkbox);
						  // Checkbox.click();
						   i++;
						   
					}
		}
		public boolean NextButtonEnabled()
		{
			return NextBtn.isEnabled();
			
		}
		public void WorkloadPDF()
		{
			LearnMoreWorkloadPDF.click();
			String WorkloadMainWindow = driver.getWindowHandle();
			Set<String> PDFFileOpened = driver.getWindowHandles();
			Iterator<String> PDFI1 = PDFFileOpened.iterator();
			while(PDFI1.hasNext())
			{
				String PDFFileChild = PDFI1.next();
				if(!WorkloadMainWindow.equalsIgnoreCase(PDFFileChild))
				{
					driver.switchTo().window(PDFFileChild);
					driver.getCurrentUrl();
					String ActualString = prop.getProperty("PDFPage"); //"https://ssdhpestage.azurewebsites.net//content/resource/The%20Pan-HPE%20Workloads%20Taxonomy.pdf";
					String ExpectedString = driver.getCurrentUrl();
					Assert.assertEquals(ActualString,ExpectedString);
					driver.close();	
				}
			}
			driver.switchTo().window(WorkloadMainWindow);
			//String ActualString = "https://ssdhpestage.azurewebsites.net//content/resource/The%20Pan-HPE%20Workloads%20Taxonomy.pdf";
			//String ExpectedString = driver.getCurrentUrl();
			//Assert.assertEquals(ActualString,ExpectedString);
			
		}
		public void DeslectReadAll()
		{
			SelectReadALL();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div[@id=\"disp_col_0\"]//span[@id=\"check-box-label\"]"));
			int TotalCheckbox = AllCheckboxes.size();
			System.out.println("Total Number of Read Intensive Workload are " + TotalCheckbox);
			int j ;
			j = TotalCheckbox;
				for(WebElement Checkbox : AllCheckboxes)
					{ 
						Checkbox.click();
						j++;
					}
			
		}
		// For Selecting "Select All/I Don't Yet" Option in Workload Page
		public void WorkPageSelectAll()
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", WorkloadSelectAll);
		}
		
		public void SelectMixedALL()
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div[@id=\"disp_col_1\"]//span[@id=\"check-box-label\"]"));
			int TotalCheckbox = AllCheckboxes.size();
			Actions Mousemove = new Actions(driver);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 250)");
			System.out.println("Total Number of Mixed USe Intensive Workload are " + TotalCheckbox);
			//int i = TotalCheckbox;
			/*for(i = 0; i <= TotalCheckbox; i++)
			{
				AllCheckboxes.get(i).click();
			}*/
			//String MixedWorkloadValue = AllCheckboxes.get(i).getAttribute("Value");
			int i = TotalCheckbox;
				for(WebElement Checkbox : AllCheckboxes)
					{		
						   Checkbox.click();
						   i++;
						   
					}
		}
		
		public void SelectWriteALL()
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div[@id=\"disp_col_2\"]//span[@id=\"check-box-label\"]"));
			int TotalCheckbox = AllCheckboxes.size();
			//Actions Mousemove = new Actions(driver);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 250)");
			System.out.println("Total Number of WRITE Intensive Workload are " + TotalCheckbox);
			//int i = TotalCheckbox;
			/*for(i = 0; i <= TotalCheckbox; i++)
			{
				AllCheckboxes.get(i).click();
			}*/
			//String MixedWorkloadValue = AllCheckboxes.get(i).getAttribute("Value");
			int i = TotalCheckbox;
				for(WebElement Checkbox : AllCheckboxes)
					{		
							jse.executeScript("arguments[0].click()", Checkbox);
						   //Checkbox.click();
						   i++;
						   
					}
		}
		public void SelectVROALL()
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div[@id=\"disp_col_3\"]//span[@id=\"check-box-label\"]"));
			int TotalCheckbox = AllCheckboxes.size();
			//Actions Mousemove = new Actions(driver);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 250)");
			System.out.println("Total Number of WRITE Intensive Workload are " + TotalCheckbox);
			//int i = TotalCheckbox;
			/*for(i = 0; i <= TotalCheckbox; i++)
			{
				AllCheckboxes.get(i).click();
			}*/
			//String MixedWorkloadValue = AllCheckboxes.get(i).getAttribute("Value");
			int i = TotalCheckbox;
				for(WebElement Checkbox : AllCheckboxes)
					{		
							jse.executeScript("arguments[0].click()", Checkbox);
						   //Checkbox.click();
						   i++;
						   
					}
		}
		
		public void AllWorkloadSelect()
		{
			SelectReadWorkload.click();
			SelectMixedWorkload.click();
			SelectWriteWorkLoad.click();
			SelectVROWorkLoad.click();
		}
}
