package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SSDResource.BaseClass;
import SSDPageObjects.SSDCapacityPage;
import SSDPageObjects.SSDFormfactorPage;
import SSDPageObjects.SSDHomePage;
import SSDPageObjects.SSDInterfacePage;
import SSDPageObjects.SSDLetsStartpage;
import SSDPageObjects.SSDServermodelPage;
import SSDPageObjects.SSDServertypePage;
import SSDPageObjects.SSDWorkloadPage;

public class SSDFormFactorType extends BaseClass
{
	SSDHomePage 		ssdHomePage;
	SSDLetsStartpage 	ssdletsstartpage;
	SSDWorkloadPage 	ssdWorkloadPage;
	SSDServertypePage 	ssdServertypePage;
	SSDServermodelPage 	ssdServermodelPage;
	SSDCapacityPage 	ssdCapacitypage;
	SSDInterfacePage 	ssdInterfacetypepage;
	SSDFormfactorPage 	ssdFormfactortypepage;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	public SSDFormFactorType()
	{
		super();
	}
	@Test (priority = 0)
	public void ToVerifyFormFactorPageURL()
	{
		String ActualSSDURL = prop.getProperty("FormFactorPage");//"https://ssdhpestage.azurewebsites.net/form-factor";
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		log.info("Sucessfully moved to FormFactor Page");
	}
	
	@Test (priority = 1)
	public void ToVerifyFormFactorPageNxtBtn()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		//Assert.assertFalse(ssdcapacitypage.CapacityNxtBtn(), "NextBtn is in Disabled State");
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.FFNxtBtn(), "NextBtn is in Enabled State");
	}
	/*@Test (priority = 2)
	public void ToVerifyFFAddInCard()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.AddInCardImage(), "Add In Card Image is Displayed");
	} */
	/* @Test (priority = 3)
	public void ToVerifyFFAddInCardSel()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.AddInCardSelected(), "Add In Card Checkbox Selected");
	} */
	@Test (priority = 4)
	public void ToVerifyFFM2Image()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.M2ImageDisplayed(), "M2 Image is Displayed");
	}
	@Test (priority = 5)
	public void ToVerifyFFM2Selected()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.M2CardSelected(), "M2 CheckBox is Selected");
	}
	@Test (priority = 6)
	public void ToVerifyFFLFFImage()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.LFFDisplayed(), "3.5 LFF Image is Displayed");
	}
	@Test (priority = 7)
	public void ToVerifyFFLFFSelected()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.LFFSelected(), "3.5 CheckBox is Selected");
	}
	@Test (priority = 8)
	public void ToVerifyFFSFFImage()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.SFFDisplayed(), "2.5 SFF Image is Displayed");
	}
	@Test (priority = 9)
	public void ToVerifyFFSFFSelected()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.LFFSelected(), "2.5 SFF CheckBox is Selected");
	}
	@Test (priority = 10)
	public void ToVerifyFFM2EDisplayed()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.M2EDisplayed(), "M.2E Image is Displayed");
	}
	@Test (priority = 11)
	public void ToVerifyFFM2ESelected()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.M2eSelected(), "M2E CheckBox is Selected");
	}
	@Test (priority =12)
	public void ToVerifyFFSearchIcon()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdFormfactortypepage.FFSearchIcon(), "Search Icon is Displayed");
	}
	@Test (priority = 13)
	public void ToVerifyFFNxtBtn()
	{
		ssdFormfactortypepage = new SSDFormfactorPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdFormfactortypepage.FormNxtBtn();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		String ActualURL = prop.getProperty("MainstreamPage");//"https://ssdhpestage.azurewebsites.net/mainstream";
		String ExpectedURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);
	}
}
