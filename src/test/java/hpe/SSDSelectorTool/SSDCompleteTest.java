package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SSDResource.BaseClass;
import SSDPageObjects.SSDBestAvailability;
import SSDPageObjects.SSDCapacityPage;
import SSDPageObjects.SSDFormfactorPage;
import SSDPageObjects.SSDHomePage;
import SSDPageObjects.SSDInterfacePage;
import SSDPageObjects.SSDLetsStartpage;
import SSDPageObjects.SSDResultPage;
import SSDPageObjects.SSDSelectAllType;
import SSDPageObjects.SSDServermodelPage;
import SSDPageObjects.SSDServertypePage;
import SSDPageObjects.SSDWorkloadPage;

public class SSDCompleteTest extends BaseClass
{
	SSDHomePage 		ssdHomepage;
	SSDLetsStartpage  	ssdLetsstartpage;
	SSDWorkloadPage	 	ssdWorkloadpage;
	SSDServertypePage	ssdServertypepage;
	SSDServermodelPage 	ssdServermodelpage;
	SSDCapacityPage		ssdCapacitypage;
	SSDInterfacePage 	ssdInterfacepage;
	SSDFormfactorPage	ssdFormfactorpage;
	SSDBestAvailability	ssdBestAvailability;
	SSDResultPage 		ssdResultpage;
	SSDSelectAllType	ssdSelectalltype;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	
 
	
	public SSDCompleteTest()
	{
		super();
	}
	@Test (priority = 0)
	public void LetStart()
	{
		Intialization();
		ssdHomepage = new SSDHomePage();
		ssdLetsstartpage = new SSDLetsStartpage();
		ssdWorkloadpage = new SSDWorkloadPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdHomepage.ClickIAgreeBtn();
		System.out.println("Stage URL :- " + driver.getCurrentUrl());
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		ssdLetsstartpage.ClickHelpMeChoose();
	}
	
	@Test(priority = 1)
	public void ToVerifyWorkloadURL()
	{
		ssdWorkloadpage = new SSDWorkloadPage();
		String ActualWorkloadURL = prop.getProperty("WorkLoadPage");//"https://ssdhpestage.azurewebsites.net/workload";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 2)
	public void ToVerifyNextBtn()
	{
		Assert.assertFalse(ssdWorkloadpage.UnClickNextBtn(), "Next Button is Disabled State");
	}
	
	@Test(priority = 3)
	public void ToVerifySelectALLWorkload()
	{
		ssdWorkloadpage.WorkPageSelectAll();
		Assert.assertTrue(ssdWorkloadpage.NextButtonEnabled(), "Next Button is Enabled");
		ssdWorkloadpage.ClickNextBtn();
	}
	
	@Test(priority = 4)
	public void ToVerifySSDTypeURL()
	{
		ssdServertypepage = new SSDServertypePage();
		String ActualSSDURL = prop.getProperty("SSDPage");
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		
	}
	
	@Test(priority = 5)
	public void ToVerifySSDTypeSelected()
	{
		if (ssdServertypepage.AllSSDTypeSelected() == true)
		{
			Assert.assertTrue(true, "All Options are selected the Select All Option is Selected");
		}
		else if (ssdServertypepage.AllSSDTypeSelected() == false)
		{
			Assert.assertFalse(false, "Options are not Selected and Select All Option is not Selected");
		}
		else
		{
			System.out.println("Next Button is enabled");
		}
		ssdServertypepage.NextClick();
		
	}
	
	@Test(priority=6)
	public void ToVerifyServerTypeURL()
	{
		ssdServermodelpage = new SSDServermodelPage();
		String ActualSSDURL = prop.getProperty("ServerTypePage");
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
	}
	
	@Test(priority=7)
	public void ToVerifyServerTypeList()
	{
		if(ssdServermodelpage.ClickServerType() == true)
		{
			Assert.assertTrue(true, "Server Type list Matching");
		}
		else 
		{
			Assert.assertFalse(false, "Server Type list is not matching");
		}	
	 }
	
	@Test(priority = 8)
	public void ToVerifySeverModelList() throws InterruptedException
	{
		if(ssdServermodelpage.CompareServerTypeServerModelList() == true)
		{
			Assert.assertTrue(true, "Server Type and Server Model List Is Mapping");
		}
		else
		{
			Assert.assertFalse(false, "Server Type and Server Model List is not Mapping");
		}
	}
	
	@Test(priority = 9)
	public void ToVerifySelectServerTypeAndServerModel() throws InterruptedException
	{
		ssdServermodelpage.SelectSeverTypeAndServerModel();
		Thread.sleep(1000);
		ssdServermodelpage.ServerTypeNextBtn();
	}
	
	@Test(priority = 10)
	public void ToVerfiyCapacityURL()
	{
		ssdCapacitypage = new SSDCapacityPage();
		String ActualSSDURL = prop.getProperty("DriveCapacityPage");
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		ssdCapacitypage.CapaNextBtn();
	}
	
	@Test(priority = 11)
	public void ToVerifyEditSelectedInterfaceOptions() throws InterruptedException
	{
		ssdInterfacepage = new SSDInterfacePage();
		if (ssdInterfacepage.EditInterfaceOptions() == true)
		{
			Assert.assertTrue(true, "All Options are editable and It is in Disabled State");
		}
		else 
		{
			Assert.assertFalse(false, "Next Button is disabled State, All options are in disable State");
			System.out.println("Next Button is Disabled State");
		}
		ssdInterfacepage.EnableInterfaceOptions();
		ssdInterfacepage.InterfaceNxtBtn();
	}
	
	@Test(priority = 12)
	public void ToVerifyEditSelectedFormFactorOptions() throws InterruptedException
	{
		ssdFormfactorpage = new SSDFormfactorPage();
		Thread.sleep(1000);
		if(ssdFormfactorpage.EditFormFactorOptions() == true )
		{
			Assert.assertTrue(true,"All Options are editable and It is in Disbled State");
		}
		else
		{
			Assert.assertFalse(false, "Next Button is disabled State, All options are in disable State");
			System.out.println("Next Button is Disabled State");
		}
		ssdFormfactorpage.EnableFormFactorOptions();
		ssdFormfactorpage.FormNxtBtn();
	}
	
	@Test(priority = 13)
	public void ToVerifyEditMainstreamOptions()
	{
		ssdBestAvailability = new SSDBestAvailability();
		if (ssdBestAvailability.EditMainstreamOptions() == true)
		{
			Assert.assertFalse(false, "Mainstream and Non-Mainstream is in disabled State");
		}
		else
		{
			Assert.assertFalse(false, "Next Button is in Disabled State");
			System.out.println("Next Button is Disabled State");
		}
		ssdBestAvailability.EnableMainstreamOptions();
	}
	
	@Test(priority = 14)
	public void ToVerifyMainstreamSelectAll() throws InterruptedException
	{
		Thread.sleep(2000);
		Assert.assertTrue(ssdBestAvailability.MainstreamSelectAll(), "Mainstream and Non-Mainstream Is Selected");
		ssdBestAvailability.BestAvailNxtBtn();
	}
	
	@Test(priority = 15)
	public void ToVerifySSDResultPage() throws InterruptedException
	{
		ssdResultpage = new SSDResultPage();
		Thread.sleep(1000);
		JavascriptExecutor CompleteTestClick = (JavascriptExecutor)driver;
		CompleteTestClick.executeScript("arguments[0].scrollIntoView();",ssdResultpage.SSDRequriementslink);
		String ActualSSDResults = "112 -  SSDs meet your requirements";
		String ExpectedSSDResults = ssdResultpage.SSDRequriementslink.getText();
		Assert.assertEquals(ActualSSDResults, ExpectedSSDResults);	
	}
	@Test(priority = 16)
	public void ToVerifySSDMainstreamResults()
	{
		String ActualSSDMainstream = "Non Mainstream";
		String ExpectedSSDMainstream = ssdResultpage.SSDMainstreamResults.getText();
		Assert.assertEquals(ActualSSDMainstream, ExpectedSSDMainstream);
	} 
	
	/*@Test(priority = 17)
	public void ToVerifyMainstreamNonMainstreamCheckBox()
	{
		JavascriptExecutor CompleteTestClick = (JavascriptExecutor)driver;
		CompleteTestClick.executeScript("arguments[0].click()",ssdResultpage.MainstreamChk);	
		CompleteTestClick.executeScript("arguments[0].click()",ssdResultpage.NonMainstreamChk);
		WebElement confirmAlert = driver.switchTo().activeElement().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button"));
		confirmAlert.click();
	}
	
	@Test(priority = 18)
	public void ToVerifyMainstreamChkbox()
	{
		Assert.assertTrue(ssdResultpage.MainstreamNonMainstream(), "Either Mainstream or Non Mainstream Is Selected");
	}
	
	@Test(priority = 19)
	public void ToVerifySelectAllOption() throws InterruptedException
	{
		JavascriptExecutor CompleteTestClick = (JavascriptExecutor)driver;
		CompleteTestClick.executeScript("arguments[0].click()",ssdResultpage.SelectAllChBxes);
		System.out.println(driver.switchTo().activeElement().getText());
		ssdResultpage.SelectAllYes.click();
		Thread.sleep(1000);
		String ActualSSDResults = "250 -  SSDs meet your requirements";
		String ExpectedSSDResults = ssdResultpage.SSDRequriementslink.getText();
		Assert.assertEquals(ActualSSDResults, ExpectedSSDResults);
		
	}
	@Test(priority = 20)
	public void ToVerifyDownloadFile() throws InterruptedException
	{
		JavascriptExecutor RefineResult = (JavascriptExecutor)driver;
		RefineResult.executeScript("arguments[0].scrollIntoView()", ssdResultpage.ResultLink);
		if(ssdResultpage.AllDownloadPDF() == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("File not Found");
		}
	}*/
	
}
