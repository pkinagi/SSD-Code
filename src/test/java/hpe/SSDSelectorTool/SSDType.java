package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SSDResource.BaseClass;
import SSDPageObjects.SSDHomePage;
import SSDPageObjects.SSDLetsStartpage;
import SSDPageObjects.SSDServertypePage;
import SSDPageObjects.SSDWorkloadPage;

public class SSDType extends BaseClass
{
	SSDHomePage 		homepage;
	SSDLetsStartpage 	letstartpage ;
	SSDWorkloadPage 	workloadpage ;
	SSDServertypePage 	ssdtypepage ;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	public SSDType()
	{
		super();
	}

	/*public void letsstart()
	{
		Intialization();
		homepage = new SSDHomePage();
		letstartpage = new SSDLetsStartpage();
		homepage.ClickIAgreeBtn();
		letstartpage.ClickHelpMeChoose();
		ssdtypepage = new SSDServertypePage();
	}*/
	
	@Test (priority = 0)
	public void ToVerifySSDTypePage()
	{
		//String ActualSSDURL = "https://ssdhpestage.azurewebsites.net/ssd-type";
		String ActualSSDURL = prop.getProperty("SSDPage");
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		log.info("Successfully Moved to Next Page");
		
	}
	@Test (priority = 1)
	public void ToVerifyReadSSDSelected()
	{
		
		ssdtypepage = new SSDServertypePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdtypepage.SelectedReadIntensive(),"READ Intensive is Selected");
	}
	@Test (priority = 2)
	public void ToVerifyMixedSSDSelected()
	{
		
	}
	@Test (priority = 3)
	public void ToVerifyWriteSSDSelected()
	{
		
	}
	@Test (priority = 4 )
	public void ToVerifyVROSSDSelected()
	{
		
	}
	/*@Test (priority = 5)
	public void ToVerifyAllSSDsSelected()
	{
		Assert.assertTrue(ssdtypepage.AllSSDsSelected(), "All SSD Types are Selected");
	}*/
	@Test (priority = 6)
	public void ToVerfiyNextBtn()
	{
		ssdtypepage = new SSDServertypePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertTrue(ssdtypepage.NextBtnEnabled(), "Next Button is Enabled");
	}
	@Test (priority = 7)
	public void ToVerifySelectAll()
	{
		ssdtypepage = new SSDServertypePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		Assert.assertFalse(ssdtypepage.SelectAll(), "Select All/I Don't Know Yet Option is not Selected");
	}
	@Test (priority = 8)
	public void ToVerfiyBackBtn()
	{
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdtypepage.BackClick();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		String ActualString = prop.getProperty("WorkLoadPage"); //"https://ssdhpestage.azurewebsites.net/workload";
		String ExpectedString = driver.getCurrentUrl();
		Assert.assertEquals(ActualString, ExpectedString);
		Assert.assertTrue(ssdtypepage.NextBtnEnabled(), "Next Button is Enabled");
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		workloadpage = new SSDWorkloadPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		workloadpage.ClickNextBtn();
	}
	@Test (priority = 9)
	public void ToVerfiySSDNextBtn()
	{
		ssdtypepage = new SSDServertypePage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdtypepage.NextClick();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		String ActualURL = prop.getProperty("ServerTypePage");//"https://ssdhpestage.azurewebsites.net/server-type";
		String ExpectedURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);
	}
}
