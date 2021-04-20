package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class SSDReadSelect extends BaseClass
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

	public SSDReadSelect()
	{
		super();
	}
	
	@Test (priority = 0,description = "To Start the test with Read Intensive Select in Workload Page")
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
	
	@Test(priority = 1, description = "To Verify the Workload Page URL")
	public void ToVerifyWorkloadURL()
	{
		ssdWorkloadpage = new SSDWorkloadPage();
		String ActualWorkloadURL = prop.getProperty("WorkLoadPage");//"https://ssdhpestage.azurewebsites.net/workload";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 2 , description = "To Verify the Next Button is in disabled state when no workload is selected")
	public void ToVerifyNextBtn()
	{
		Assert.assertFalse(ssdWorkloadpage.UnClickNextBtn(), "Next Button is Disabled State");
	}
	@Test(priority = 3, description = "To Verify the Next Button is in Enabled state when Read workload is selected")
	public void ToVerifySelectWriteIntensive()
	{
		
		ssdWorkloadpage.SelectReadALL();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Assert.assertTrue(ssdWorkloadpage.NextButtonEnabled(), "Next Button is Enabled State");
		ssdWorkloadpage.ClickNextBtn();
		
	}
	@Test(priority = 4, description = "To Verify the SSD Page URL")
	public void ToVerifySSDURL()
	{
		ssdServertypepage = new SSDServertypePage();
		String ActualWorkloadURL = prop.getProperty("SSDPage");//"https://ssdhpestage.azurewebsites.net/ssd-type";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);	
	}
	@Test(priority = 5, description = "To Verify the Read Intensive is selected in the SSD Page")
	public void ToVerifyReadUse()
	{
		ssdServertypepage = new SSDServertypePage();
		Assert.assertTrue(ssdServertypepage.SelectedReadIntensive(),"Read-Intensive is Selected");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		ssdServertypepage.NextClick();
	}
	@Test(priority = 6, description = "To Verify the Server-Type Page URL")
	public void ToVerifyServerTypeURL()
	{
		ssdServermodelpage = new SSDServermodelPage();
		String ActualWorkloadURL = prop.getProperty("ServerTypePage");//"https://ssdhpestage.azurewebsites.net/server-type";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
		
	}
	@Test(priority = 7, description = "To Verify the Selected Workloads are displayed in the Server-Type Page")
	public void ToVerifySelectedWorkloadDisplays()
	{
		ssdServermodelpage = new SSDServermodelPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		ssdServermodelpage.ShowReadTargetWorkload();
		Assert.assertFalse(ssdServermodelpage.ServerTypeNxtBtn(), "Next Button is in Disabled State");
		System.out.println(ssdServermodelpage.ServerTypeNxtBtn());
	}
	@Test(priority = 8, description = "To Verify the Server-Type list and Select the Server Type from the drop down")
	public void VerifyToSelectReadServerType()
	{
		ssdServermodelpage = new SSDServermodelPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Assert.assertTrue(ssdServermodelpage.ReadSelectServerType(), "Server Type List is displayed and Server Type is selected");
	}
	@Test(priority = 9, description = "To Verify the selected Server Model list and Select the Server Model from the drop down")
	public void ToVerifySelectWriteServerModelType()
	{
		ssdServermodelpage = new SSDServermodelPage();
		ssdServermodelpage.ReadSelectServerModel();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Assert.assertTrue(ssdServermodelpage.ServerTypeNxtBtn(), "Next Button is Enabled");
		ssdServermodelpage.ServerTypeNextBtn();
	}
	@Test(priority = 10, description = "To Verify the Capacity Page URL")
	public void ToVerifyCapacityURL()
	{
		ssdCapacitypage = new SSDCapacityPage();
		String ActualWorkloadURL = prop.getProperty("DriveCapacityPage");//"https://ssdhpestage.azurewebsites.net/drive-capacity";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 11, description = "To Verify Next Button is enabled in Capacity Page and Maximum and Minimum Value is displayed")
	public void ToVerifyCapacity()
	{
		ssdCapacitypage = new SSDCapacityPage();
		Assert.assertTrue(ssdCapacitypage.CapacityMaxvalue(),"Max Value is Displayed");
		Assert.assertTrue(ssdCapacitypage.CapacityMinValue(),"Min Value is Displayed");
		Assert.assertTrue(ssdCapacitypage.CapaNxtBtn(),"Next Btn is Enabled");
	}
	@Test(priority = 12, description = "To Verify when Maximum and Minimum point slider meet at Same and ViceVersa")
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
	@Test(priority = 13, description = "To Verify Next Button is disabled in Capacity Page when Maximum and Minimum meet at Same and ViceVersa")
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
	@Test(priority = 14, description = "To Verify Next Button is disabled in Capacity Page when Maximum and Minimum meet at Same and ViceVersa")
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
	@Test(priority = 15, description = "To Verify Next Button is enabled")
	public void ToVerifyNxtBtnEnabled()
	{
		ssdCapacitypage = new SSDCapacityPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Assert.assertTrue(ssdCapacitypage.CapaNxtBtn(), "Next Btn is Enabled State");
		ssdCapacitypage.CapaNextBtn();
	}
	@Test(priority = 16, description = "To Verify Interface-Page URL")
	public void ToVerifyInterfaceURL()
	{
		ssdInterfacepage = new SSDInterfacePage();
		String ActualWorkloadURL = prop.getProperty("InterfacePage");//"https://ssdhpestage.azurewebsites.net/interface-type";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 17, description = "To Verify the Interface type options are autoselected")
	public void ToVerifyInterfaceSelected()
	{
		ssdInterfacepage = new SSDInterfacePage();
		Assert.assertTrue(ssdInterfacepage.InterfaceNxtBtnEn(), "Next Button is Enabled");
		System.out.println("----!!InterfaceType Page Options Status!!---------");
		Assert.assertTrue(ssdInterfacepage.InterfaceSAS(), "SAS Option is AutoSelected");
		System.out.println(ssdInterfacepage.InterfaceSAS() + " SAS Option is AutoSelected");
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
		//Assert.assertFalse(ssdInterfacepage.InterfaceSataVRO(), "SATA VRO is not selected");
		//System.out.println(ssdInterfacepage.InterfaceValueSAS() + "Value SAS is not Selected");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		ssdInterfacepage.InterfaceNxtBtn();
	}
	@Test(priority = 18, description = "To Verify the Form Factor Page URL")
	public void ToVerifyFormFactorURL()
	{
		ssdFormfactorpage = new SSDFormfactorPage();
		String ActualWorkloadURL = prop.getProperty("FormFactorPage");//"https://ssdhpestage.azurewebsites.net/form-factor";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 19, description = "To Verify the Form Factor Options are autoselected")
	public void ToVerifyFormFactoeSelected()
	{
		ssdFormfactorpage = new SSDFormfactorPage();
		System.out.println("------------!!Form Factor Page Options Status!!------------------");
		Assert.assertTrue(ssdFormfactorpage.FFNxtBtn(), "Next Btn is Enabled");
		//Assert.assertTrue(ssdFormfactorpage.AddInCardImage(), "Add-In-Card Image is Displayed");
		//System.out.println(ssdFormfactorpage.AddInCardImage() + "Add-In-Card Image is Displayed");
		//Assert.assertTrue(ssdFormfactorpage.AddInCardSelected(),"Add-In-Card is Selected");
		//System.out.println(ssdFormfactorpage.AddInCardSelected() + "Add-In-Card is Selected");
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
	@Test(priority = 20, description = "To Verify the Best Availability Page URL")
	public void ToVerifyBestAvailURL()
	{
		ssdBestAvailability= new SSDBestAvailability();
		String ActualWorkloadURL = prop.getProperty("MainstreamPage");//"https://ssdhpestage.azurewebsites.net/mainstream";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test(priority = 21, description = "To Verify the Next Button in the Best Availability or Mainstream Page")
	public void ToVerifyMainstreamSelected()
	{
		ssdBestAvailability= new SSDBestAvailability();
		ssdBestAvailability.BestAvailNxtBtn();
	}
	@Test(priority = 22, description = "To Verify the Result Page URL")
	public void ToVerifyMixedResultPageURL()
	{
		ssdResultpage = new SSDResultPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String ActualWorkloadURL = prop.getProperty("ResultPage");//"https://ssdhpestage.azurewebsites.net/#forward";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL) ;
	}
	@Test(priority = 23, description = "To Verify SSDs Results in the SSD Requirement List")
	public void ToVerifyReadResultsDisplays()
	{
		ssdResultpage = new SSDResultPage();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Assert.assertTrue(ssdResultpage.ResultRefineYourResultsLabel(),"Refine  your results");
		Assert.assertTrue(ssdResultpage.SSDPortImage(),"SSD Portfolio Alignment");
		String SSDResultDisplays = ssdResultpage.SSDRequriementslink.getText();
		System.out.println(SSDResultDisplays);
		String ActualSSDRequirmentLabel = "3 -  SSDs meet your requirements";
		String ExpectedSSDRequirmentLabel = driver.findElement(By.xpath("//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a")).getText();
		Assert.assertEquals(ActualSSDRequirmentLabel, ExpectedSSDRequirmentLabel);
		//Assert.assertTrue(ssdResultpage.SSDRequirmentText(),"214 - SSDs meet your requirements");	
	}
	@Test(priority = 24, description = "To Verify Selected Options in the Refine Your Results link")
	public void ToVerifyRefineYourResults()
	{
		ssdResultpage = new SSDResultPage();
		ssdResultpage.ClickRefineYourResults();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		System.out.println("--------------------!!Result Page Options Status!!---------------------------");
		Assert.assertTrue(ssdResultpage.ResultReadSSDSelected(), "Write Use is Selected");
		System.out.println(ssdResultpage.ResultReadSSDSelected() + "Write Use is Selected");
		//System.out.println(ssdResultpage.ResultReadSSDSelected() + "Read Intensive is Not Selected");
		//System.out.println(ssdResultpage.ResultMixedSSDSelected() + "Mixed Intensive is Not Selected");
		//System.out.println(ssdResultpage.ResultVROSSDSelected() + "Very Read Optimization Not is Selected");
		Assert.assertTrue(ssdResultpage.ResultSASSelected(), "SAS is Selected");
		System.out.println(ssdResultpage.ResultSASSelected() +  "SAS is Selected");
		Assert.assertTrue(ssdResultpage.ResltSATSSelected(), "SATA is Selected");
		System.out.println(ssdResultpage.ResltSATSSelected() + "SATA is Selected");
		Assert.assertTrue(ssdResultpage.ResultNVmeSelected(), "NVMe is Selected");
		System.out.println(ssdResultpage.ResultNVmeSelected() + "NVMe is Selected");
		Assert.assertTrue(ssdResultpage.ResultValueSASSelected(), "ValueSAS is Selected");
		System.out.println(ssdResultpage.ResultValueSASSelected() + "ValueSAS is Selected");
		//Assert.assertTrue(ssdResultpage.ResultAddInCardSelected(), "Add-In Card is Selected");
		//System.out.println(ssdResultpage.ResultAddInCardSelected() + "Add-In Card is Selected");
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
	/*@Test(priority = 25)
	public void ToVerifySeverTypeDisplayed()
	{
		ssdResultpage = new SSDResultPage();
		ssdResultpage.ResultWriteSeverType();

	}
	@Test(priority = 26)
	public void ToverifySeverModelDisplayed()
	{
		ssdResultpage = new SSDResultPage();
		ssdResultpage.ResultWriteServerModelType();
	}*/
	@Test(priority = 27, description = "To Verify Image is displayed")
	public void ToVerifyPortfolioLink()
	{
		ssdResultpage = new SSDResultPage();
		ssdResultpage.ClickSSDPort();
	}
	@Test(priority = 28, description = "To Verify to select the list of Server-Type ")
	public void ToVerifyResultSelectServerType()
	{
		ssdServermodelpage = new SSDServermodelPage();
		ssdResultpage = new SSDResultPage();
		WebElement ResultRefine = driver.findElement(By.xpath("//*[@id=\"panel-ggroup1\"]/div/div[1]/h4/a"));
		JavascriptExecutor ScrollUpRefineResults = (JavascriptExecutor)driver;
		ScrollUpRefineResults.executeScript("arguments[0].scrollIntoView()", ResultRefine );
		ResultRefine.click();
		Assert.assertTrue(ssdResultpage.ResultReadSeverType(), "Selected Server Type is Displayed");
		//Assert.assertTrue(ssdServermodelpage.ResultServerServerType(),"Server Type is selected");
	}
	@Test(priority = 29, description = "To Verify to select the list of Server-Model")
	public void ToVerifyResultSelectServerModelType()
	{
		ssdServermodelpage = new SSDServermodelPage();
		Assert.assertTrue(ssdResultpage.ResultReadServerModelType(), "Selected Server-Model is Displayed");
		//ssdServermodelpage.ResultServerServerModelType();
	}
	@Test(priority = 30, description = "To Verify Selected Server type is displayed in Result Page")
	public void ToVerifyResultSelectedServerModelType()
	{
		ssdResultpage = new SSDResultPage();
		ssdResultpage.ResultDisplayServerModel();
	}
	@Test(priority = 31,description = "To Verify Non-Mainstream Results")
	public void ToVerifyWriteNonMainstreamResults() throws InterruptedException
	{
		ssdResultpage = new SSDResultPage();
		ssdResultpage.ResultPageMainstream();
		String SSDResultDisplays = ssdResultpage.SSDRequriementslink.getText();
		System.out.println(SSDResultDisplays);
		String ActualSSDRequirmentLabel = "3 -  SSDs meet your requirements";
		Assert.assertEquals(ActualSSDRequirmentLabel, SSDResultDisplays); 
	}
}
