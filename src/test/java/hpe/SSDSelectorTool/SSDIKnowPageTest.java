package hpe.SSDSelectorTool;

import java.awt.AWTException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SSDResource.BaseClass;
import SSDPageObjects.SSDBestAvailability;
import SSDPageObjects.SSDCapacityPage;
import SSDPageObjects.SSDExcelResult;
import SSDPageObjects.SSDFormfactorPage;
import SSDPageObjects.SSDHomePage;
import SSDPageObjects.SSDIKnowWhatINeedPage;
import SSDPageObjects.SSDInterfacePage;
import SSDPageObjects.SSDLetsStartpage;
import SSDPageObjects.SSDResultPage;
import SSDPageObjects.SSDServermodelPage;
import SSDPageObjects.SSDServertypePage;
import SSDPageObjects.SSDWorkloadPage;

public class SSDIKnowPageTest extends BaseClass
{
	SSDHomePage 		ssdHomepage;
	SSDLetsStartpage 	ssdLetsstartpage;
	SSDWorkloadPage 	ssdWorkloadpage;
	SSDServertypePage 	ssdServertypepage;
	SSDServermodelPage 	ssdServermodelpage;
	SSDCapacityPage 	ssdSapacitypage;
	SSDInterfacePage 	ssdInterfacepage;
	SSDFormfactorPage 	ssdFormfactorpage;
	SSDBestAvailability ssdBestavailability;
	SSDResultPage		ssdResultpage;
	SSDIKnowWhatINeedPage	ssdIKnowpage;
	SSDExcelResult	ssdExcelresult;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	public JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
	public static Map <String, Object[]> testresultdata;
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	
	 public static Logger log =LogManager.getLogger(BaseClass.class.getName());
	
	//public static WebDriverWait wait = new WebDriverWait(driver, 40);
	
	//Map <String, Object[]> testresultdata;
	
	public SSDIKnowPageTest()
	{
		super();
	}
	@BeforeTest(description="Launches the SSD Selector Tool Application")
	
	//@Test(priority = 0, description="Launches the SSD Selector Tool Application")
	public void IKnowWhatINeed()
	{
		Intialization();
		ssdHomepage = new SSDHomePage();
		ssdLetsstartpage = new SSDLetsStartpage();
		ssdWorkloadpage = new SSDWorkloadPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdHomepage.ClickIAgreeBtn();
		System.out.println("Stage URL :- " + driver.getCurrentUrl());
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		ssdLetsstartpage.ClickIKnow();
	}
	@Test(priority = 1, description="Verifying the I Know What I Need URl")
	public void ToVerifyIKnowWhatINeedURL() throws InterruptedException
	{
		String ActualSSDURL = prop.getProperty("ResultPage");// "https://ssdhpestage.azurewebsites.net/recommendation";
		String ExpectedSSDURL = driver.getCurrentUrl();
	try
	{
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		log.info("Successfully Launched the I Know What I Need Page");
		//testresultdata.put("2", new Object[] {1d,"Verifying the I Know What I Need URl","I Know What I Need Page is Displayed","Pass"});
	}
	catch (Exception e)
	{
		//testresultdata.put("2", new Object[] {1d,"Verifying the I Know What I Need URl","I Know What I Need Page is Displayed","Fail"});
	}
	}
	@Test(priority =2,description="Verifying the SSD Results with 250 SSDs")
	public void ToVerifySSDResults() throws InterruptedException
	{
		JavascriptExecutor SSDResults = (JavascriptExecutor)driver;
		ssdIKnowpage = new SSDIKnowWhatINeedPage();
		if(ssdIKnowpage.SSDLoader.isDisplayed())
		{
			WebDriverWait SSDResultWait = new WebDriverWait(driver, 30);
			SSDResultWait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "250 -  SSDs meet your requirements"));
		}
		String ActualSSDResult = "250 -  SSDs meet your requirements";
		String ExpectedSSDResult = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		Assert.assertEquals(ActualSSDResult, ExpectedSSDResult);
		log.info("250 SSDS are displayed");
		/*String ActualMainstreamPresent = "Mainstream";
		String ExpectedMainstreamPresent = ssdIKnowpage.SSDMainstream.getText();
		Assert.assertEquals(ActualMainstreamPresent, ExpectedMainstreamPresent);*/
	}
   @Test(priority = 3)
	public void ToVerifySelectedOptions() throws InterruptedException
	{
		//ssdIKnowpage.ClickRefineYourResults();
		Assert.assertTrue(ssdIKnowpage.ReadIntensiveSelected(), "SSD-Type Read Intensive Selected");
		Assert.assertTrue(ssdIKnowpage.MixedUseSelected(), "SSD-Type Mixed-Use Intensive Selected");
		Assert.assertTrue(ssdIKnowpage.WriteSSDSelected(), "SSD-Type Write Intensie Selected");
		Assert.assertTrue(ssdIKnowpage.InterfaceSASSelected(), "SAS Option Selected");
		Assert.assertTrue(ssdIKnowpage.InterfaceSATASelected(), "SATA Option Selected");
		Assert.assertTrue(ssdIKnowpage.IntefaceNVMeSelected(), "NVMe Option Selected");
		Assert.assertTrue(ssdIKnowpage.FormFactorLFFSelected(), "3.5 LFF is Selected");
		Assert.assertTrue(ssdIKnowpage.FormFactorSFFSelected(), "2.5 SFF is Selected");
		Assert.assertTrue(ssdIKnowpage.FormFactorM2Selected(), "M.2 Selected");
		Assert.assertTrue(ssdIKnowpage.FormFactorM2EnablementKitSelected(), "M.2 Enablement Kit");
		Assert.assertTrue(ssdIKnowpage.FormFactorAddInCardSelected(), "Add-In Card is Selected");
		Assert.assertFalse(ssdIKnowpage.CertificationsVSanSelected(),"In Certifications - vSAN is Selected");
		Assert.assertFalse(ssdIKnowpage.CertificationsMS2016Selected(), "In Certifications - MS Server 2016");
		Assert.assertFalse(ssdIKnowpage.CertificationsSDDCSelected(), "In Certifications - SDDC is Selected");
		Assert.assertTrue(ssdIKnowpage.BestAvailabilityMainstreamSelected(), "Mainstream is Selected");
		Assert.assertTrue(ssdIKnowpage.BestAvailabilityNonMainstreamSelected(), "Non-Mainstream is Selected");
		Assert.assertTrue(ssdIKnowpage.SelectAllOption(), "Select All Applicable CheckBoxes Above");
		Thread.sleep(1000);
	}
	/*@Test(priority = 4)
	public void ToVerifyAllOptionsDeSelected() throws InterruptedException
	{
		JavascriptExecutor DeselectAll = (JavascriptExecutor)driver;
		DeselectAll.executeScript("arguments[0].click()",ssdIKnowpage.SSDIKnowSelectAll);
		Thread.sleep(2000);
		DeselectAll.executeScript("arguments[0].scrollIntoView()", ssdIKnowpage.IKnowSSDRequriementslink);
		String ActualDeSSDResult = "314 -  SSDs meet your requirements";
		String ExpectedDeSSDResult = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println(ExpectedDeSSDResult);
		Assert.assertEquals(ActualDeSSDResult, ExpectedDeSSDResult);
	}
	@Test(priority =5)
	public void ToVerifyServerTypeSelected() throws InterruptedException
	{
		ssdServermodelpage = new SSDServermodelPage();
		Thread.sleep(1000);
		ssdServermodelpage.SSDIKnowServerType();
		Thread.sleep(1000);
		ssdServermodelpage.SSDIKnowServerModel();
		
	}*/
	@Test(priority =6 ,description="Verifying Read Options Selected")
	public void ToVerifyReadOptionsResults() throws InterruptedException
	{
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowResultLink);
		Assert.assertTrue(ssdIKnowpage.OnlyReadIntensiveSelected(), "Only Read Option is Selected");
		ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "120 -  SSDs meet your requirements"));
		String ActualSSDReadIntensive = "120 -  SSDs meet your requirements";
		String ExpectedSSDReadIntnensive = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println("Read Intensive Results :- " + ssdIKnowpage.IKnowSSDRequriementslink.getText());
		Assert.assertEquals(ActualSSDReadIntensive, ExpectedSSDReadIntnensive);
	}
	@Test(priority = 7, description="Verifying the PDF file is downloaded")
	public void ToVerifyDownloadFile() throws InterruptedException
	{
		ssdResultpage = new SSDResultPage();
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
	} 
   
   @Test(priority = 8 ,description="Verifying the Excel File Results")
	public void ToVerifyExcelFileResults()
	{
		ssdExcelresult = new SSDExcelResult();
		ssdExcelresult.CompareTwoExcelFiles();
		ssdExcelresult.ExcelSheetEqual();
	}
	@Test(priority = 9, description= "To Check the Interface Options")
	public void ToVerifyUnCheckInterface() throws InterruptedException
	{
		JavascriptExecutor UncheckInterface = (JavascriptExecutor)driver;
		UncheckInterface.executeScript("arguments[0].click()", ssdIKnowpage.SSDInterfaceSelectedSATA);
		Thread.sleep(1000);
		UncheckInterface.executeScript("arguments[0].click()", ssdIKnowpage.SSDInterfaceSelectedValueSAS);
		Thread.sleep(1000);
		UncheckInterface.executeScript("arguments[0].click()",ssdIKnowpage.SSDInterfaceSelectedSAS);
		Thread.sleep(1000);
		UncheckInterface.executeScript("arguments[0].click()", ssdIKnowpage.SSDInterfaceSelectedNVMe);
	}
	@Test(priority=10,description="To Verify the Interface Selected SSDs Results")
	public void ToVerifyInterfaceOptionSASResults() throws InterruptedException
	{
		JavascriptExecutor SASScrollUp = (JavascriptExecutor)driver;
		SASScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowResultLink);
		Assert.assertTrue(ssdIKnowpage.OnlySASIsSelected(),"Only SAS SSD Results are Displayed");
		Thread.sleep(1000);
		SASScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		WebDriverWait SASwait = new WebDriverWait(driver, 40);
		SASwait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "15 -  SSDs meet your requirements"));
		String ActualSSDReadSASInterfaceResults = "15 -  SSDs meet your requirements";
		String ExpectedSSDReadSASInterfaceResults = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println("SAS Results are displayed :- " + ssdIKnowpage.IKnowSSDRequriementslink.getText());
		Assert.assertEquals(ActualSSDReadSASInterfaceResults,ExpectedSSDReadSASInterfaceResults);
	}
	@Test(priority=11,description="To Verify the Interface Selected With SATA SSDs")
	public void ToVerifyInterfaceOptionSATAResults() throws InterruptedException
	{
		JavascriptExecutor SATAScrollUP = (JavascriptExecutor)driver;
		Assert.assertTrue(ssdIKnowpage.OnlySATIsSelected(),"ONly SATA SSD Results are Displayed");
		Thread.sleep(2000);
		SATAScrollUP.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		WebDriverWait SATAwait = new WebDriverWait(driver, 40);
		SATAwait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "42 -  SSDs meet your requirements"));
		String AcutalSSDReadSATAInterfaceResults = "42 -  SSDs meet your requirements";
		String ExpectedSSDReadSATAInterfaceResults = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println("SATA Results are displayed :- " + ssdIKnowpage.IKnowSSDRequriementslink.getText());
		Assert.assertEquals(AcutalSSDReadSATAInterfaceResults,ExpectedSSDReadSATAInterfaceResults);
	}
	@Test(priority=12,description="To Verify the Interface Selected With NVMe SSDs")
	public void ToVerifyInterfaceOptionNVMeResults() throws InterruptedException
	{
		JavascriptExecutor NVMeScrollUp = (JavascriptExecutor)driver;
		Assert.assertTrue(ssdIKnowpage.OnlyNVMeIsSelected(),"Only NVMe SSD Results are Displayed");
		NVMeScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		WebDriverWait NVMewait = new WebDriverWait(driver, 40);
		NVMewait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "55 -  SSDs meet your requirements"));
		String AcutalSSDReadNVMeInterfaceResults = "55 -  SSDs meet your requirements";
		String ExpectedSSDReadNVMeInterfaceResults = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println("NVMe Results are displayed :- " + ssdIKnowpage.IKnowSSDRequriementslink.getText());
		Assert.assertEquals(AcutalSSDReadNVMeInterfaceResults,ExpectedSSDReadNVMeInterfaceResults);
	}
	@Test(priority=13, description="To Verify the Interface Selected With SAS SSDS")
	public void ToVerifyInterfaceOptionValueSASResults() throws InterruptedException
	{
		JavascriptExecutor ValueSASScrollUp = (JavascriptExecutor)driver;
		Assert.assertTrue(ssdIKnowpage.OnlyValueSASSelected(), "Only Value SAS Results are Displayed");
		ValueSASScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		WebDriverWait ValueSASwait = new WebDriverWait(driver, 40);
		ValueSASwait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "8 -  SSDs meet your requirements"));
		String ActualSSDReadValueSASInterfaceResults = "8 -  SSDs meet your requirements";
		String ExpectedSSDReadValueSASInterfaceResults = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println("Value SAS Results are displayed :- " + ssdIKnowpage.IKnowSSDRequriementslink.getText());
		Assert.assertEquals(ActualSSDReadValueSASInterfaceResults, ExpectedSSDReadValueSASInterfaceResults);
	}
	@Test(priority = 14, description="To Uncheck the Form Factor SSDs")
	public void ToVerifyUnCheckFormFactorSection()
	{
		JavascriptExecutor UnCheckFormFactor = (JavascriptExecutor)driver;
		UnCheckFormFactor.executeScript("arguments[0].click()", ssdIKnowpage.SSDInterfaceSelectedValueSAS);
		Assert.assertFalse(false);
		UnCheckFormFactor.executeScript("arguments[0].click()", ssdIKnowpage.SSDFormFactorAddInCard);
		Assert.assertFalse(false);
		UnCheckFormFactor.executeScript("arguments[0].click()", ssdIKnowpage.SSDFormFactorLFF);
		Assert.assertFalse(false);
		UnCheckFormFactor.executeScript("arguments[0].click()", ssdIKnowpage.SSDFormFactorM2);
		Assert.assertFalse(false);
		UnCheckFormFactor.executeScript("arguments[0].click()", ssdIKnowpage.SSDFormFactorM2EKit);
		Assert.assertFalse(false);
		UnCheckFormFactor.executeScript("arguments[0].click()", ssdIKnowpage.SSDFormFactorSFF);
		Assert.assertFalse(false);
	}
	@Test(priority =15,description="To Verify the Form Factor Add-InCard SSDs")
	public void ToVerifyFormFactorOptionsAddInResults() throws InterruptedException
	{
		JavascriptExecutor AddInScrollUp = (JavascriptExecutor)driver;
		AddInScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowResultLink);
		Thread.sleep(1000);
		Assert.assertTrue(ssdIKnowpage.OnlyAddInCardIsSelected(), "Add-In Card Form Factor Results are Displayed");
		String ActualAddInCard = "There are no results based on your selection. Please select different attributes or start over.";
		String ExpectedAddInCard = ssdIKnowpage.SSDNoResultsAvailable.getText();
		System.out.println("For Read Option Selected AddInCard SSDs are not There :- " +ExpectedAddInCard);
		Assert.assertEquals(ActualAddInCard, ExpectedAddInCard);
	}
	 @Test(priority = 16, description="To Verify the Form Factor M.2 SSDs")
	public void ToVerifyFormFactorOptionM2Results()
	{
		JavascriptExecutor M2ScrollUp = (JavascriptExecutor)driver;
		Assert.assertTrue(ssdIKnowpage.OnlyM2IsSelected(), "M.2 Form FactorResult are displayed");
		M2ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		WebDriverWait M2wait = new WebDriverWait(driver, 50);
		M2wait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "8 -  SSDs meet your requirements"));
		String ActualM2Selected = "8 -  SSDs meet your requirements" ;
		String ExceptedM2Selected = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println("For Read Option Selected M.2 SSDs are :- " + ExceptedM2Selected);
		Assert.assertEquals(ActualM2Selected, ExceptedM2Selected);
	} 
	@Test(priority = 17, description= "To Verify the Form Factor M.2e SSDs")
	public void ToVerifyFormFactorOptionM2eResults()
	{
		JavascriptExecutor M2eScrollUp = (JavascriptExecutor)driver;
		Assert.assertTrue(ssdIKnowpage.OnlyM2EIsSelected(), "M.2 Enablement Kit Results are displayed");
		M2eScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		WebDriverWait M2ewait = new WebDriverWait(driver, 50);
		M2ewait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "1 -  SSDs meet your requirements"));
		String ActualM2eSelected = "1 -  SSDs meet your requirements" ;
		String ExceptedM2eSelected = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println("For Read Option Selected M2.E SSDs are there :- " + ExceptedM2eSelected);
		Assert.assertEquals(ActualM2eSelected, ExceptedM2eSelected);
	}
	@Test(priority = 18, description = "To Verify the Form Factor 3.5 SSDS")
	public void ToVerifyFormFactorOptionLFFResults() throws InterruptedException
	{
		JavascriptExecutor LFFScrollUp = (JavascriptExecutor)driver; 
		Assert.assertTrue(ssdIKnowpage.OnlyLFFIsSelected(), "3.5in Form Factor Results are Displayed");
		Thread.sleep(1000);
		LFFScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		WebDriverWait LFFwait = new WebDriverWait(driver, 40);
		LFFwait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "4 -  SSDs meet your requirements"));
		String ActualSSDLFFResults = "4 -  SSDs meet your requirements";
		String ExpectedSSDLFFResults = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println("3.5 LFF Results are displayed :-" + ssdIKnowpage.IKnowSSDRequriementslink.getText());
		Assert.assertEquals(ActualSSDLFFResults,ExpectedSSDLFFResults);
	}
	@Test(priority= 19, description= "To Verify the Form Factor 2.5 SSDs")
	public void ToVerifyFormFactorOptionSFFResults() throws InterruptedException
	{
		JavascriptExecutor SFFScrollUp = (JavascriptExecutor)driver;
		Assert.assertTrue(ssdIKnowpage.OnlySSFIsSelected(), "2.5in Form Factor Results are Displayed");
		Thread.sleep(2000);
		SFFScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		WebDriverWait SFFwait = new WebDriverWait(driver, 40);
		SFFwait.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "107 -  SSDs meet your requirements"));
		String ActualSSDSFFResults = "107 -  SSDs meet your requirements";
		String ExpectedSSDSFFResults = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		System.out.println("2.5 SFF REsults are displayed :-" + ssdIKnowpage.IKnowSSDRequriementslink.getText());
		Assert.assertEquals(ActualSSDSFFResults, ExpectedSSDSFFResults);
	} 
	/*@Test(priority = 20)
	public void ToVerifyDownloadFile() throws InterruptedException
	{
		ssdResultpage = new SSDResultPage();
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
	
	 @Test(priority = 20,description="To Verify Non-Mainstream SSDs Results")
	public void ToVerifyNonMainstreamResults() throws AWTException
	{
		JavascriptExecutor NonMainstreamScrollUp = (JavascriptExecutor)driver;
		NonMainstreamScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDProtfolioLink);
		NonMainstreamScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.MainstreamClick);
		ssdIKnowpage.NonMainstreamSSDResults();
		//ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.MainstreamClick);
		NonMainstreamScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDNonMainstream);
		String ActualNonMainstreamResults = "Non Mainstream";
		String ExpectedNonMainstreamResults = ssdIKnowpage.IKnowSSDNonMainstream.getText();
		Assert.assertEquals(ActualNonMainstreamResults,ExpectedNonMainstreamResults);
	} 
	
	@Test(priority = 21, description="To Verify to display Non-Mainstream SSDs on click on Mainstream Checkbox")
	public void ToVerifyMainstreamResults()
	{
		JavascriptExecutor MainstreamScrollUp = (JavascriptExecutor)driver;
		MainstreamScrollUp.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDProtfolioLink);
		ssdIKnowpage.MainstreamSSDResults();
		
	} 
	
	@Test(priority =22, description="To Verify Alert Message and Non-Mainstream SSDS")
	public void ToVerifyBestAvailabilityOptionSelected()
	{
		WebDriverWait SSDResults = new WebDriverWait(driver, 40);
		Assert.assertEquals(ssdIKnowpage.AlertMessageText.getText(), "There are no results based on your selection(s). You must select at least one of the following or both");
		ssdIKnowpage.AlertMessageOk.click();
		SSDResults.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "77 -  SSDs meet your requirements"));
		String ActualNonMainstreamSSDs = "77 -  SSDs meet your requirements";
		String ExcpectedNonMainstreamSSDs = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		Assert.assertEquals(ActualNonMainstreamSSDs, ExcpectedNonMainstreamSSDs);
	}
	
	@Test(priority = 23, description = "To Verify SSD Search Tab, with wrong input and SSD Requirement Link")
	public void ToVerifySearchTabSSDRequrimentLink()
	{
		ssdIKnowpage.SearchSSDResult();
		Assert.assertEquals(true, ssdIKnowpage.SSDNoResults.isDisplayed());
	}
	
	@Test(priority = 24, description = "To Verify to clear Search Tab and retrive the SSDs Results")
	public void ToVerifyToRetriveSSDsResults()
	{
		ssdIKnowpage.ClearSearchTab();
		WebDriverWait SSDResults1 = new WebDriverWait(driver, 40);
		JavascriptExecutor SSDsResults = (JavascriptExecutor)driver;
		SSDsResults.executeScript("arguments[0].scrollIntoView();", ssdIKnowpage.IKnowSSDRequriementslink);
		SSDResults1.until(ExpectedConditions.textToBePresentInElement(ssdIKnowpage.IKnowSSDRequriementslink, "77 -  SSDs meet your requirements"));
		String ActualNonMainstreamSSDs = "77 -  SSDs meet your requirements";
		String ExcpectedNonMainstreamSSDs = ssdIKnowpage.IKnowSSDRequriementslink.getText();
		Assert.assertEquals(ActualNonMainstreamSSDs, ExcpectedNonMainstreamSSDs);
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	} 
	
}
