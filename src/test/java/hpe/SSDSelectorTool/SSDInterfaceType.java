package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SSDResource.BaseClass;
import SSDPageObjects.SSDCapacityPage;
import SSDPageObjects.SSDHomePage;
import SSDPageObjects.SSDInterfacePage;
import SSDPageObjects.SSDLetsStartpage;
import SSDPageObjects.SSDServermodelPage;
import SSDPageObjects.SSDServertypePage;
import SSDPageObjects.SSDWorkloadPage;

public class SSDInterfaceType extends BaseClass
{
	SSDHomePage 		ssdHomePage;
	SSDLetsStartpage 	ssdletsstartpage;
	SSDWorkloadPage 	ssdWorkloadPage;
	SSDServertypePage 	ssdServertypePage;
	SSDServermodelPage 	ssdServermodelPage;
	SSDCapacityPage 	ssdCapacitypage;
	SSDInterfacePage 	ssdInterfacetypepage;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	public SSDInterfaceType()
	{
		super();
	}
	
	@Test (priority = 0)
	public void ToVerifyInterfaceTypePageURL()
	{
		String ActualSSDURL = prop.getProperty("InterfacePage");//"https://ssdhpestage.azurewebsites.net/interface-type";
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		log.info("Successfully moved to Interface Page");
	}
	
	@Test (priority = 1)
	public void ToVerifyInterfaceTypeNxtBtn()
	{
		ssdInterfacetypepage = new SSDInterfacePage();
		//Assert.assertFalse(ssdcapacitypage.CapacityNxtBtn(), "NextBtn is in Disabled State");
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdInterfacetypepage.InterfaceNxtBtnEn(), "NextBtn is in Enabled State");
	}

	@Test (priority = 2)
	public void ToVerifySASAutoSelected()
	{
		ssdInterfacetypepage = new SSDInterfacePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdInterfacetypepage.InterfaceSAS(), "NextBtn is in Enabled State");
	}
	
	@Test (priority = 3)
	public void ToVerifySATAAutoSelected()
	{
		ssdInterfacetypepage = new SSDInterfacePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdInterfacetypepage.InterfaceSATA(), "NextBtn is in Enabled State");
	}
	
	@Test (priority = 4)
	public void ToVerifyNVMeAutoSelected()
	{
		ssdInterfacetypepage = new SSDInterfacePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdInterfacetypepage.InterfaceNVMe(), "NextBtn is in Enabled State");
	}
	
	/* @Test (priority = 5)
	public void ToVerifyNVMeSubAutoSelected1()
	{
		ssdInterfacetypepage = new SSDInterfacePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdInterfacetypepage.InterfaceNVMeHigh(), "NextBtn is in Enabled State");
	}
	
	@Test (priority = 6)
	public void ToVerifyNVMeSubAutoSelected2()
	{
		ssdInterfacetypepage = new SSDInterfacePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdInterfacetypepage.InterfaceNVMeMainstream(), "NextBtn is in Enabled State");
	} */
	
	@Test (priority = 7)
	public void ToVerifySearchIcon()
	{
		ssdInterfacetypepage = new SSDInterfacePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdInterfacetypepage.InterfaceSearchIcon(), "NextBtn is in Enabled State");
	}
	
	@Test (priority = 8)
	public void ToVerifyNextBtn()
	{
		ssdInterfacetypepage = new SSDInterfacePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdInterfacetypepage.InterfaceNxtBtn();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		String ActualURL = prop.getProperty("FormFactorPage");//"https://ssdhpestage.azurewebsites.net/form-factor";
		String ExpectedURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);
	}
}
