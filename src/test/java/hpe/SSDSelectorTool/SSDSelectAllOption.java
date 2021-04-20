package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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

public class SSDSelectAllOption extends BaseClass
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
	
	public SSDSelectAllOption()
	{
		super();
	}
	
	//@BeforeTest()
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
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdLetsstartpage.ClickHelpMeChoose();
	}
	
	@Test(priority = 1)
	public void ToVerifyURL()
	{
		ssdWorkloadpage = new SSDWorkloadPage();
		String ActualWorkloadURL = prop.getProperty("WorkLoadPage");//"https://ssdhpestage.azurewebsites.net/workload";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	
	@Test(priority = 2)
	public void ToVerifyNextBtn()
	{
		ssdWorkloadpage = new SSDWorkloadPage();
		Assert.assertFalse(ssdWorkloadpage.UnClickNextBtn(), "Next Button is Disabled State");
	}
	@Test(priority = 3)
	public void ToVerifySelectAll()
	{
		ssdWorkloadpage = new SSDWorkloadPage();
		ssdWorkloadpage.WorkPageSelectAll();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	//Assert.assertFalse(ssdWorkloadpage.NextButtonEnabled(), "Next Button is Enabled State");
		System.out.println(ssdWorkloadpage.NextButtonEnabled());
	}
	@Test(enabled = false)
	public void ToVerifyNxtBtn()
	{
		ssdWorkloadpage = new SSDWorkloadPage();
		Assert.assertFalse(ssdWorkloadpage.NextButtonEnabled(), "Next Button is Enabled State");
	}
	@Test(priority = 5)
	public void ToVerifyDeSelectAll()
	{
		ssdWorkloadpage = new SSDWorkloadPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		ssdWorkloadpage.WorkPageSelectAll();
	}
	@Test(priority = 6)
	public void ToVerifySelectedAll()
	{
		ssdWorkloadpage = new SSDWorkloadPage();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		ssdWorkloadpage.WorkPageSelectAll();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		ssdWorkloadpage.ClickNextBtn();
	}
	@Test(priority = 7)
	public void ToVerifySSDURL()
	{
		ssdServertypepage = new SSDServertypePage();
		String ActualWorkloadURL = prop.getProperty("SSDPage");//"https://ssdhpestage.azurewebsites.net/ssd-type";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);	
	}
	@Test(priority = 8)
	public void ToVerifySSDSelected()
	{
		ssdServertypepage = new SSDServertypePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdServertypepage.NextBtnEnabled(), "Next Button is Enabled");
		Assert.assertTrue(ssdServertypepage.SelectedReadIntensive(),"READ Intensive is Selected");
		Assert.assertTrue(ssdServertypepage.SelectedMixedIntensive(),"MIXED Intensive is Selected");
		Assert.assertTrue(ssdServertypepage.SelectedWriteIntensive(),"WRITE Intensive is Selected");
		Assert.assertTrue(ssdServertypepage.SelectedVROIntensive(),"VRO Intensive is Selected");
		ssdServertypepage.NextClick();
		
	}
	@Test(priority = 9)
	public void ToVerifySeverTypeURL()
	{
		ssdServermodelpage = new SSDServermodelPage();
		String ActualWorkloadURL = prop.getProperty("ServerTypePage");//"https://ssdhpestage.azurewebsites.net/server-type";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
		
	}
	@Test(priority = 10)
	public void ToVerifySeverTypeNxtBtn()
	{
		ssdServermodelpage = new SSDServermodelPage();
		Assert.assertFalse(ssdServermodelpage.ServerTypeNxtBtn(), "Next Button is Disabled State");
	}
	@Test(priority = 11)
	public void ToVerifyServerTypeSelectAll()
	{
		ssdServermodelpage = new SSDServermodelPage();
		ssdServermodelpage.SMSelectAll();
		Assert.assertTrue(ssdServermodelpage.ServerTypeNxtBtn(), "Next Button is Enabled State");
	}
	@Test(priority = 12)
	public void ToVerifySeverTypeDeselectAll()
	{
		ssdServermodelpage = new SSDServermodelPage();
		ssdServermodelpage.SMSelectAll();
		Assert.assertFalse(ssdServermodelpage.ServerTypeNxtBtn(), "Next Button is Disabled State");
	}
	@Test(priority = 13)
	public void ToVerifyServerTypeSelectedAll()
	{
		ssdServermodelpage = new SSDServermodelPage();
		ssdServermodelpage.SMSelectAll();
		ssdServermodelpage.ServerTypeNextBtn();
	}
	@Test(priority = 14)
	public void ToVerifyCapacityURL()
	{
		ssdCapacitypage = new SSDCapacityPage();
		String ActualWorkloadURL = prop.getProperty("DriveCapacityPage");//"https://ssdhpestage.azurewebsites.net/drive-capacity";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 15)
	public void ToVerifyCapacityNxtBtn()
	{
		ssdCapacitypage = new SSDCapacityPage();
		Assert.assertTrue(ssdCapacitypage.CapacityMaxvalue(),"Max Value is Displayed");
		Assert.assertTrue(ssdCapacitypage.CapacityMinValue(),"Min Value is Displayed");
		Assert.assertTrue(ssdCapacitypage.CapaNxtBtn(),"Next Btn is Enabled");
		
	}
	@Test(priority = 16)
	public void ToVerifyCapacityMinSlider()
	{
		ssdCapacitypage = new SSDCapacityPage();
		Actions ResCapaSlider = new Actions(driver);
		WebElement SSDMinCapMove = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[2]/div/div"));
		//int IntSlider = SSDMinCapMove.getSize().getWidth();
		//System.out.println(IntSlider);
		WebElement SSDMinCapMoveTarget = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[2]/div/div"));
		//System.out.println(SSDMinCapMoveTarget);
		try
		{
			ResCapaSlider.clickAndHold(SSDMinCapMove)
			.moveToElement(SSDMinCapMoveTarget)
			.moveToElement(SSDMinCapMoveTarget,700, 0)
			.release().build().perform();
		}
		catch( Exception e)
		{
			System.out.println(e);
		}
	}
	@Test(priority = 17)
	public void ToVerifyNxtBtnDisabled()
	{
		ssdCapacitypage = new SSDCapacityPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		try 
			{
				Assert.assertFalse(ssdCapacitypage.CapacityNxtBtn(), "Next Btn is Disabled State");
				System.out.println("Minimum and Maximum are at Same Place, So Next Button is disabled State");
		    }
		catch( Exception e)
		{
			System.out.println(e);
		}
	}
	@Test(priority = 18)
	public void ToVerifyCapacityMaxSlider()
	{
		ssdCapacitypage = new SSDCapacityPage();
		Actions ResCapaSlider = new Actions(driver);
		WebElement SSDMinCapMove = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[2]/div/div"));
		//int IntSlider = SSDMinCapMove.getSize().getWidth();
		//System.out.println(IntSlider);
		WebElement SSDMinCapMoveTarget = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[2]/div/div"));
		//System.out.println(SSDMinCapMoveTarget);
		try
		{
			ResCapaSlider.clickAndHold(SSDMinCapMove)
			.moveToElement(SSDMinCapMoveTarget)
			.moveToElement(SSDMinCapMoveTarget,-600, 0)
			.release().build().perform();
		}
		catch( Exception e)
		{
			System.out.println(e);
		}
	}
	@Test(priority = 19)
	public void ToVerifyNxtBtnEnabled()
	{
		ssdCapacitypage = new SSDCapacityPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Assert.assertTrue(ssdCapacitypage.CapaNxtBtn(), "Next Btn is Enabled State");
		ssdCapacitypage.CapaNextBtn();
	}
	@Test(priority = 20)
	public void ToVerifyInterfaceURL()
	{
		ssdInterfacepage = new SSDInterfacePage();
		String ActualWorkloadURL = prop.getProperty("InterfacePage");//"https://ssdhpestage.azurewebsites.net/interface-type";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 21)
	public void ToVerifyInterfaceSelected()
	{
		ssdInterfacepage = new SSDInterfacePage();
		Assert.assertTrue(ssdInterfacepage.InterfaceNxtBtnEn(), "Next Button is Enabled");
		System.out.println("----!!InterfaceType Page Options Status!!---------");
		Assert.assertTrue(ssdInterfacepage.InterfaceSAS(), "SAS Option is AutoSelected");
		System.out.println(ssdInterfacepage.InterfaceSAS() + "SAS Option is AutoSelected");
		Assert.assertTrue(ssdInterfacepage.InterfaceSATA(), "SATA Option is AutoSelected");
		System.out.println(ssdInterfacepage.InterfaceSATA() + "SATA Option is AutoSelected");
		Assert.assertTrue(ssdInterfacepage.InterfaceNVMe(), "NVMe Option is AutoSelected");
		System.out.println(ssdInterfacepage.InterfaceNVMe() + "NVMe Option is AutoSelected");
		//Assert.assertTrue(ssdInterfacepage.InterfaceNVMeMainstream(), "NVMe Mainstream Option is AutoSelected");
		//System.out.println(ssdInterfacepage.InterfaceNVMeMainstream() + "NVMe Mainstream Option is AutoSelected");
		//Assert.assertTrue(ssdInterfacepage.InterfaceNVMeHigh(), "NVMe High Performance Option is AutoSelected");
		//System.out.println(ssdInterfacepage.InterfaceNVMeHigh() + "NVMe High Performance Option is AutoSelected");
		Assert.assertTrue(ssdInterfacepage.InterfaceValueSAS(), "Value SAS is Selected");
		System.out.println(ssdInterfacepage.InterfaceValueSAS() + "Value SAS is Selected");
		//Assert.assertTrue(ssdInterfacepage.InterfaceSataVRO(), "SATA VRO is selected");
		//System.out.println(ssdInterfacepage.InterfaceValueSAS() + "Value SAS is Selected");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		ssdInterfacepage.InterfaceNxtBtn();
	}
	@Test(priority = 22)
	public void ToVerifyFormFactorURL()
	{
		ssdFormfactorpage = new SSDFormfactorPage();
		String ActualWorkloadURL = prop.getProperty("FormFactorPage");//"https://ssdhpestage.azurewebsites.net/form-factor";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 23)
	public void ToVerifyFormFactoeSelected()
	{
		ssdFormfactorpage = new SSDFormfactorPage();
		System.out.println("------------!!Form Factor Page Options Status!!------------------");
		Assert.assertTrue(ssdFormfactorpage.FFNxtBtn(), "Next Btn is Enabled");
		Assert.assertTrue(ssdFormfactorpage.AddInCardImage(), "Add-In-Card Image is Displayed");
		System.out.println(ssdFormfactorpage.AddInCardImage() + "Add-In-Card Image is Displayed");
		Assert.assertTrue(ssdFormfactorpage.AddInCardSelected(),"Add-In-Card is Selected");
		System.out.println(ssdFormfactorpage.AddInCardSelected() + "Add-In-Card is Selected");
		Assert.assertTrue(ssdFormfactorpage.LFFDisplayed()," 3.5 LFF Image is displayed");
		System.out.println(ssdFormfactorpage.LFFDisplayed() + " 3.5 LFF Image is displayed");
		Assert.assertTrue(ssdFormfactorpage.LFFSelected(),"3.5 LFF Image is Selected");
		System.out.println(ssdFormfactorpage.LFFSelected() + "3.5 LFF Image is Selected");
		Assert.assertTrue(ssdFormfactorpage.M2ImageDisplayed(),"M2 Image is displayed");
		System.out.println(ssdFormfactorpage.M2ImageDisplayed() + "M2 Image is displayed");
		Assert.assertTrue(ssdFormfactorpage.M2CardSelected(),"M2 Card  is Selected");
		System.out.println(ssdFormfactorpage.M2CardSelected() + "M2 Card  is Selected");
		Assert.assertTrue(ssdFormfactorpage.M2EDisplayed(),"M.2 E Kit Image is displayed");
		System.out.println(ssdFormfactorpage.M2EDisplayed() + "M.2 E Kit Image is displayed");
		Assert.assertTrue(ssdFormfactorpage.M2eSelected(),"M2.E Kit is Selected");
		System.out.println(ssdFormfactorpage.M2eSelected() + "M2.E Kit is Selected");
		Assert.assertTrue(ssdFormfactorpage.SFFDisplayed(),"2.5 SFF Image is displayed");
		System.out.println(ssdFormfactorpage.SFFDisplayed() + "2.5 SFF Image is displayed");
		Assert.assertTrue(ssdFormfactorpage.SFFSelected(),"2.5 SFF is Selected");
		System.out.println(ssdFormfactorpage.SFFSelected() + "2.5 SFF is Selected");
		ssdFormfactorpage.FormNxtBtn();
	}
	@Test(priority = 24)
	public void ToVerifyBestAvailURL()
	{
		ssdBestAvailability= new SSDBestAvailability();
		String ActualWorkloadURL = prop.getProperty("MainstreamPage");//"https://ssdhpestage.azurewebsites.net/mainstream";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 25)
	public void ToVerifyBestAvailSelectAll()
	{
		ssdBestAvailability = new SSDBestAvailability();
		ssdBestAvailability.MainNonMainstreamSelectAll();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Assert.assertTrue(ssdBestAvailability.Mainstream(), "Mainstream Option is Selected");
		Assert.assertTrue(ssdBestAvailability.NonMainstream(),"NonMainstream Option is Selected");
		ssdBestAvailability.BestAvailNxtBtn();
	}
	@Test(priority = 26)
	public void ToVerifyResultURL()
	{
		ssdResultpage = new SSDResultPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String ActualWorkloadURL = prop.getProperty("ResultPage");//"https://ssdhpestage.azurewebsites.net/#forward";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 27)
	public void ToVerifyResultsDisplays()
	{
		ssdResultpage = new SSDResultPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Assert.assertTrue(ssdResultpage.ResultRefineYourResultsLabel(),"Refine  your results");
		Assert.assertTrue(ssdResultpage.SSDPortImage(),"SSD Portfolio Alignment");
		String SSDResultDisplays = ssdResultpage.SSDRequriementslink.getText();
		System.out.println(SSDResultDisplays);
		String ActualSSDRequirmentLabel = "135 -  SSDs meet your requirements";
		String ExpectedSSDRequirmentLabel = driver.findElement(By.xpath("//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a")).getText();
		Assert.assertEquals(ActualSSDRequirmentLabel, ExpectedSSDRequirmentLabel);
		//Assert.assertTrue(ssdResultpage.SSDRequirmentText(),"214 - SSDs meet your requirements");	
	}
	@Test(priority = 28)
	public void ToVerifyRefineYourResults()
	{
		ssdResultpage = new SSDResultPage();
		ssdResultpage.ClickRefineYourResults();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		System.out.println("--------------------!!Result Page Options Status!!---------------------------");
		Assert.assertTrue(ssdResultpage.ResultReadSSDSelected(), "Read Intensive is Selected");
		System.out.println(ssdResultpage.ResultReadSSDSelected() + "Read Intensive is Selected");
		Assert.assertTrue(ssdResultpage.ResultMixedSSDSelected(), "Mixed Use is Selected");
		System.out.println(ssdResultpage.ResultMixedSSDSelected() + "Mixed Use is Selected");
		Assert.assertTrue(ssdResultpage.ResultWriteSSDSelected(), "Write Intensive is Selected");
		System.out.println(ssdResultpage.ResultWriteSSDSelected() + "Write Intensive is Selected");
		Assert.assertTrue(ssdResultpage.ResultVROSSDSelected(), "Very Read Optimization is Selected");
		System.out.println(ssdResultpage.ResultVROSSDSelected() + "Very Read Optimization is Selected");
		Assert.assertTrue(ssdResultpage.ResultSASSelected(), "SAS is Selected");
		System.out.println(ssdResultpage.ResultSASSelected() +  "SAS is Selected");
		Assert.assertTrue(ssdResultpage.ResltSATSSelected(), "SATA is Selected");
		System.out.println(ssdResultpage.ResltSATSSelected() + "SATA is Selected");
		Assert.assertTrue(ssdResultpage.ResultNVmeSelected(), "NVMe is Selected");
		System.out.println(ssdResultpage.ResultNVmeSelected() + "NVMe is Selected");
		Assert.assertTrue(ssdResultpage.ResultAddInCardSelected(), "Add-In Card is Selected");
		System.out.println(ssdResultpage.ResultAddInCardSelected() + "Add-In Card is Selected");
		Assert.assertTrue(ssdResultpage.ResultLFFSelected(), "3.5 LFF is Selected");
		System.out.println(ssdResultpage.ResultLFFSelected() + "3.5 LFF is Selected");
		Assert.assertTrue(ssdResultpage.ResultM2Selected(), "M2. is Selected");
		System.out.println(ssdResultpage.ResultM2Selected() + "M2. is Selected");
		Assert.assertTrue(ssdResultpage.ResultM2eSelected(), "M.2 Enablement is Selected");
		System.out.println(ssdResultpage.ResultM2eSelected() + "M.2 Enablement is Selected");
		Assert.assertTrue(ssdResultpage.ResultSFFSelected(), "2.5 SFF is Selected");
		System.out.println(ssdResultpage.ResultSFFSelected() + "2.5 SFF is Selected");
		Assert.assertTrue(ssdResultpage.ResultMainstream(), "Mainstream is Selected");
		System.out.println(ssdResultpage.ResultMainstream() + "Mainstream is Selected");
	}
	/*@Test(priority = 26)
	public void ToVerifyResultNonMainstream()
	{
		
	}
	@Test(priority = 27)
	public void ToVerifyResutSelectServer()
	{
		
	} */
	
	@AfterTest()
	public void TearDown()
	{
		driver.close();
	}
}
