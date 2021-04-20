package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import SSDPageObjects.SSDServermodelPage;
import SSDPageObjects.SSDServertypePage;
import SSDPageObjects.SSDWorkloadPage;


public class SSDIKnowResultPage extends BaseClass
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
	SSDIKnowResultPage	ssdIknowresultpage;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	//private Object SSDProtfolioLink;
	
	public SSDIKnowResultPage()
	{
		super();
	}
	
	
	@Test(priority = 0)
	public void IKnowWhatINeed()
	{
		Intialization();
		ssdHomepage = new SSDHomePage();
		ssdLetsstartpage = new SSDLetsStartpage();
		ssdWorkloadpage = new SSDWorkloadPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdHomepage.ClickIAgreeBtn();
		System.out.println("Stage URL :- " + driver.getCurrentUrl());
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		ssdLetsstartpage.ClickIKnow();
	}
	@Test(priority = 1)
	public void ToIKnowURL()
	{
		ssdIknowresultpage = new SSDIKnowResultPage();
		String ActualSSDURL = prop.getProperty("ResultPage");// "https://ssdhpestage.azurewebsites.net/recommendation";
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
	}
	
	@Test(priority = 2)
	public void ToVerifyIKnowLabels()
	{
		ssdResultpage = new SSDResultPage();
		Assert.assertEquals(ssdResultpage.ResultText.isDisplayed(),true,"Refine Your Result is displayed");
		Assert.assertEquals(ssdResultpage.SSDProtfolioText.isDisplayed(),true, "SSD Protfolio Image is displayed");
		Assert.assertEquals(ssdResultpage.SSDRequriementslink.isDisplayed(),true, "SSD Requriments are displayed");
		String ActualSSDRequirmentLabel = "134 -  SSDs meet your requirements";
		String ExpectedSSDRequirmentLabel = driver.findElement(By.xpath("//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a")).getText();
		Assert.assertEquals(ActualSSDRequirmentLabel,ExpectedSSDRequirmentLabel);
	}
	
	@Test(priority = 3)
	public void ToVerifyCheckBxes()
	{
		ssdResultpage = new SSDResultPage();
		ssdResultpage.ClickRefineYourResults();
	}
	
	@Test(priority = 4)
	public void ToVerifyEnableReadIntendsive()
	{
		ssdResultpage = new SSDResultPage();
		Assert.assertFalse(ssdResultpage.ResultReadSSDSelected(), "Read Intensive is not Selected");
		System.out.println("Read Intensive is not Selected");
	}
	
	@Test(priority = 5)
	public void ToVerifyEnableMixedUseIntensive()
	{
		ssdResultpage = new SSDResultPage();
		Assert.assertFalse(ssdResultpage.ResultMixedSSDSelected(), "Mixed Intensive is not Selected");
		System.out.println("Mixed Intensive is not Selected");
	}
	
	@Test(priority = 6)
	public void ToVerifyEnableWriteIntensive()
	{
		ssdResultpage = new SSDResultPage();
		Assert.assertFalse(ssdResultpage.ResultWriteSSDSelected(), "Write Intensive is not Selected");
		System.out.println("Write Intensive is not Selected");
	}
	
	@Test(priority = 7)
	public void ToVerifyEnableVeryReadOptimized()
	{
		ssdResultpage = new SSDResultPage();
		Assert.assertFalse(ssdResultpage.ResultVROSSDSelected(), "VRO is not Selected");
		System.out.println("VRO is not Selected");
	}
	
	@Test(priority = 8)
	public void ToVerifyInterfaceTypes()
	{
		Assert.assertFalse(ssdResultpage.ResultSASSelected(),"Interface - SAS is Not Selected");
		System.out.println("Interface - SAS is not Selected");
		Assert.assertFalse(ssdResultpage.ResltSATSSelected(), "Interface - SATA is Not Selected");
		System.out.println("Interface - SATA is not Selected");
		Assert.assertFalse(ssdResultpage.ResultNVmeSelected(),"Interface - NVMe is Not Selected");
		System.out.println("Interface - NVMe is not Selected");
		Assert.assertEquals(ssdResultpage.SSDInterfaceSelectedValueSAS.isSelected(),false,"Interface - ValueSAS is not Selected");
		System.out.println("Interface - ValueSAS is not Selected");
		Assert.assertEquals(ssdResultpage.SSDInterfaceSelectedSATAVRO.isSelected(),false,"Interface - SATAVRO is not Selected");
		System.out.println("Interface - SATAVRO is not Selected");
	}
	
	@Test(priority = 9)
	public void ToVerifyFormFactorTypes()
	{
		Assert.assertFalse(ssdResultpage.ResultAddInCardSelected(),"Form-Fator - Add-In-Card");
		System.out.println("Form-Fator - Add-In-Card");
		Assert.assertFalse(ssdResultpage.ResultLFFSelected(),"Form-Fator - 3.5 LFF ");
		System.out.println("Form-Fator - 3.5 LFF");
		Assert.assertFalse(ssdResultpage.ResultSFFSelected(),"Form-Fator - 2.5 SFF ");
		System.out.println("Form-Fator - 2.5 SFF");
		Assert.assertFalse(ssdResultpage.ResultM2Selected(),"Form-Fator - M2 ");
		System.out.println("Form-Fator - M2 ");
		Assert.assertFalse(ssdResultpage.ResultM2eSelected(),"Form-Fator - M2E ");
		System.out.println("Form-Fator - M2E ");
		Assert.assertTrue(ssdResultpage.ResultMainstream(),"Mainstream is Selected");
		System.out.println("Mainstream is Selected");
	}
	
	@Test(priority = 10)
	public void ToVerifyNonMainstream() throws InterruptedException
	{
		ssdResultpage.ResultPageMainstream();
	}
	
	@Test(priority = 11)
	public void ToVerifyShowMore()
	{
		ssdResultpage.ResultShowMore();
	}
	
	@Test(priority = 12)
	public void ToVerifySSDImages()
	{
		Assert.assertEquals(ssdResultpage.SSDImages.isDisplayed(),true,"SSD Image is displayed,When clicked on Show More");
	}
	
	@Test(priority = 13)
	public void ToVerifyFileDownloaded()
	{
		Assert.assertEquals(ssdResultpage.SSDDownload.isDisplayed(),true,"SSD Image is displayed,When clicked on Show More");
		ssdResultpage.SSDResultDownload();
		JavascriptExecutor SelectAllSearchResultScroll = (JavascriptExecutor)driver;
		SelectAllSearchResultScroll.executeScript("arguments[0].scrollIntoView();", ssdResultpage.SSDProtfolioLink);
		String ActualSSDRequirmentLabel = "397 -  SSDs meet your requirements";
		String ExpectedSSDRequirmentLabel = driver.findElement(By.xpath("//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a")).getText();
		Assert.assertEquals(ActualSSDRequirmentLabel,ExpectedSSDRequirmentLabel);
	}
	/*@Test(priority = 14)
	public void ToVerifyRefreshPage()
	{
		
	}*/
	@Test(priority= 14)
	public void ChangeServerType() throws InterruptedException
	{
		ssdServermodelpage = new SSDServermodelPage();
		ssdServermodelpage.ChangeSeverType();
		//ssdServermodelpage.ChangeServerModel();
		
	}
	/*@Test(priority =15)
	public void ChangeServerModel()
	{
		
	}*/
	/*@Test(priority=8)
	public void ToVerifyCopyPasteURl() throws AWTException
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_T);
		//driver.get(prop.getProperty("ResultPage"));
		//driver.get("https://stg-app-hpessd.azurewebsites.net/recommendation");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
	    driver.get("https://stg-app-hpessd.azurewebsites.net/recommendation");
	    
	   // driver.switchTo().window(tabs.get(0)); // switch back to main screen        
	   // driver.get("https://stg-app-hpessd.azurewebsites.net");
		
	}*/
}
