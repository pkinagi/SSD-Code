package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SSDResource.BaseClass;
import SSDPageObjects.SSDHomePage;
import SSDPageObjects.SSDLetsStartpage;
import SSDPageObjects.SSDServermodelPage;
import SSDPageObjects.SSDServertypePage;
import SSDPageObjects.SSDWorkloadPage;

public class SSDServerType extends BaseClass
{
	SSDHomePage 		ssdhomepage;
	SSDLetsStartpage 	ssdletsstartpage;
	SSDWorkloadPage 	ssdworkloadpage;
	SSDServertypePage 	ssdtypepage;
	SSDServermodelPage 	ssdservermodelpage;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	public SSDServerType()
	{
		super();
	}
	
	@Test (priority = 0)
	public void ToVerifyServerTypeURL()
	{
		
		String ActualSSDURL = prop.getProperty("ServerTypePage");//"https://ssdhpestage.azurewebsites.net/server-type";
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		log.info("Successfully Moved to Next Page");
	}
	
	@Test (priority = 1)
	public void ToVerifyServerModelNxtBtn()
	{
		ssdservermodelpage = new SSDServermodelPage();
		Assert.assertFalse(ssdservermodelpage.ServerTypeModelSelected(), "NextBtn is in Disabled State");
	}
	
	@Test (priority = 2)
	public void ToVerifyServerTypeDropDown()
	{
		ssdservermodelpage = new SSDServermodelPage();
		Assert.assertTrue(ssdservermodelpage.ClickServerType(), "Server Type List is displayed");
	}
	
	@Test (priority = 3)
	public void ToVerfiyServerModelDropDown()
	{
		ssdservermodelpage = new SSDServermodelPage();
		ssdservermodelpage.ClickSeverModel();
	}

	@Test (priority = 4)
	public void ToVerifyWorkledSelected()
	{
		ssdservermodelpage = new SSDServermodelPage();
		ssdservermodelpage.ShowsTargetWorkload();
	}
	
	@Test (priority = 5)
	public void ToVerifyTargetTable()
	{
		ssdservermodelpage = new SSDServermodelPage();
		Assert.assertTrue(ssdservermodelpage.TargetDisplayed(), "Selected Workloads are displayed");
	}
	
	@Test (priority = 6)
	public void ToVerifyBackButton()
	{
		ssdservermodelpage = new SSDServermodelPage();
		ssdtypepage = new SSDServertypePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdservermodelpage.ServerModelTypeBackBtn();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		String ActualString = prop.getProperty("SSDPage"); //"https://ssdhpestage.azurewebsites.net/ssd-type";
		String ExpectedString = driver.getCurrentUrl();
		Assert.assertEquals(ActualString, ExpectedString);
		Assert.assertTrue(ssdtypepage.NextBtnEnabled(), "Next Button is Enabled");
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdtypepage.SelectedReadIntensive(), "Read Intensive Selected");
		ssdtypepage.NextClick();
	}
	
	@Test(priority = 7)
	public void ToVerifySelectAll()
	{
		ssdservermodelpage = new SSDServermodelPage();
		Assert.assertTrue(ssdservermodelpage.SeverTypeModelSelectAll(), "Select All/I don't Yet");
	}
	
	@Test(priority = 8)
	public void ToVerifyServerNextBtn()
	{
		ssdservermodelpage = new SSDServermodelPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdservermodelpage.ServerTypeNextBtn();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		String ActualURL = prop.getProperty("DriveCapacityPage");//"https://ssdhpestage.azurewebsites.net/drive-capacity";
		String ExpectedURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);
	}
}
