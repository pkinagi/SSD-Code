package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SSDResource.BaseClass;
import SSDPageObjects.SSDCapacityPage;
import SSDPageObjects.SSDHomePage;
import SSDPageObjects.SSDLetsStartpage;
import SSDPageObjects.SSDServermodelPage;
import SSDPageObjects.SSDServertypePage;
import SSDPageObjects.SSDWorkloadPage;

public class SSDDrvCapacity extends BaseClass
{
	SSDHomePage 		ssdhomepage;
	SSDLetsStartpage 	ssdletsstartpage;
	SSDWorkloadPage 	ssdWorkloadPage;
	SSDServertypePage 	ssdServertypePage;
	SSDServermodelPage 	ssdServermodelPage;
	SSDCapacityPage 	ssdcapacitypage;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	public SSDDrvCapacity()
	{
		super();
	}
	
	@Test (priority = 0)
	public void ToVerifyCapacityPageURL()
	{
		String ActualSSDURL = prop.getProperty("DriveCapacityPage");//"https://ssdhpestage.azurewebsites.net/drive-capacity";
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		log.info("Successfully moved to Capacity Page");
	}
	
	@Test (priority = 6)
	public void ToVerifyDrivCapacityNxtBtn()
	{
		ssdcapacitypage = new SSDCapacityPage();
		//Assert.assertFalse(ssdcapacitypage.CapacityNxtBtn(), "NextBtn is in Disabled State");
		Assert.assertTrue(ssdcapacitypage.CapacityPreviousPosition(), "NextBtn is in Enabled State");
	}
	/*@Test (priority = 5)
	public void ToVerifyDrivCapacityNxtBtn1()
	{
		ssdcapacitypage = new SSDCapacityPage();
		Assert.assertFalse(ssdcapacitypage.CapacityNxtBtn2(), "NextBtn is in Disabled State");
	} */
	@Test (priority = 3)
	public void ToVerifyMoveMaxSlider()
	{
		ssdcapacitypage = new SSDCapacityPage();
		ssdcapacitypage.MaxSlider();
	}
	@Test (priority = 4)
	public void ToVerifyMoveMinSlider()
	{
		ssdcapacitypage = new SSDCapacityPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdcapacitypage.MinSlider();
	}
	@Test (priority = 8)
	public void ToCapacityNextBtn()
	{
		ssdcapacitypage = new SSDCapacityPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdcapacitypage.CapaNextBtn();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		String ActualURL = prop.getProperty("InterfacePage");//"https://ssdhpestage.azurewebsites.net/interface-type";
		String ExpectedURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);
	}
	@Test (priority = 7)
	public void ToVerifySearchIcon()
	{
		ssdcapacitypage = new SSDCapacityPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdcapacitypage.SearchIconVisible(),"Search Icon Is Visible");
		
	}
}
