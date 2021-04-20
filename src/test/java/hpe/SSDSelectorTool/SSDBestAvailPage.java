package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SSDResource.BaseClass;
import SSDPageObjects.SSDBestAvailability;
import SSDPageObjects.SSDCapacityPage;
import SSDPageObjects.SSDFormfactorPage;
import SSDPageObjects.SSDHomePage;
import SSDPageObjects.SSDInterfacePage;
import SSDPageObjects.SSDLetsStartpage;
import SSDPageObjects.SSDServermodelPage;
import SSDPageObjects.SSDServertypePage;
import SSDPageObjects.SSDWorkloadPage;

public class SSDBestAvailPage extends BaseClass
{

	SSDHomePage 		ssdHomePage;
	SSDLetsStartpage 	ssdletsstartpage;
	SSDWorkloadPage 	ssdWorkloadPage;
	SSDServertypePage 	ssdServertypePage;
	SSDServermodelPage 	ssdServermodelPage;
	SSDCapacityPage 	ssdCapacitypage;
	SSDInterfacePage 	ssdInterfacetypepage;
	SSDFormfactorPage 	ssdFormfactortypepage;
	SSDBestAvailability ssdBestavailabilitypage;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	public SSDBestAvailPage()
	{
		super();
	}
	
	
	@Test (priority = 0)
	public void ToVerifyMainstreamPageURL()
	{
		String ActualSSDURL = prop.getProperty("MainstreamPage");//"https://ssdhpestage.azurewebsites.net/mainstream";
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		log.info("Successfully moved to next page");
	}
	
	@Test (priority = 1)
	public void ToVerifyMainNxtBtn()
	{
		ssdBestavailabilitypage = new SSDBestAvailability();
		Assert.assertTrue(ssdBestavailabilitypage.NextBtnEnabled(), "Next is Enabled");
	}
	
	@Test (priority = 2)
	public void ToVerifyMainstream()
	{
		ssdBestavailabilitypage = new SSDBestAvailability();
		Assert.assertTrue(ssdBestavailabilitypage.Mainstream(), "Mainstream is Enabled");
	}
	
	@Test (priority = 3)
	public void ToVerifyNonMainstream()
	{
		ssdBestavailabilitypage = new SSDBestAvailability();
		Assert.assertFalse(ssdBestavailabilitypage.NonMainstream(), "Non-Mainstream is not selected");
	}
	
	@Test (priority = 4)
	public void ToVerifyClickMainstreamNext()
	{
		ssdBestavailabilitypage = new SSDBestAvailability();
		Assert.assertFalse(ssdBestavailabilitypage.MainstreamClick(), "Next Button is in Disabled State");
	}
	
	@Test (priority = 5)
	public void ToVerifyClickMainstreamNon()
	{
		ssdBestavailabilitypage = new SSDBestAvailability();
		ssdBestavailabilitypage.MainNonstreamClick();
	}
	
	@Test (priority = 6)
	public void ToVerifyNextSelectAll()
	{
		ssdBestavailabilitypage = new SSDBestAvailability();
		Assert.assertTrue(ssdBestavailabilitypage.NextBtnEnabled(), "Next Btn is Enabled");
		Assert.assertTrue(ssdBestavailabilitypage.NextSelectAll(), "Select All option is Selected");
	}
	@Test (priority = 7)
	public void ToVerifyBestAvailabilityNextBtn()
	{
		ssdBestavailabilitypage = new SSDBestAvailability();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdBestavailabilitypage.BestAvailNextBtn();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		String ActualURL = prop.getProperty("ResultPage");//"https://ssdhpestage.azurewebsites.net/#forward";
		String ExpectedURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);
	}
	
	@Test (priority = 8)
	public void ToVerifySearchIcon()
	{
		ssdBestavailabilitypage = new SSDBestAvailability();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdBestavailabilitypage.BASearchIcon(),"Search Icon Is Visible");
	}
	
}
