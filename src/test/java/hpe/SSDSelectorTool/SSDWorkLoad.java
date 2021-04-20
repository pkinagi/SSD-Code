package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import SSDResource.BaseClass;
import SSDPageObjects.SSDHomePage;
import SSDPageObjects.SSDLetsStartpage;
import SSDPageObjects.SSDWorkloadPage;

public class SSDWorkLoad extends BaseClass
{
	SSDHomePage 		homepage ;
	SSDLetsStartpage 	letstartpage;
	SSDWorkloadPage 	workloadpage;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	
	
	public SSDWorkLoad()
	{
		super();
	}
	
	@Test (priority = 1)
	public void LetStart()
	{
		Intialization();
		homepage = new SSDHomePage();
		letstartpage = new SSDLetsStartpage();
		workloadpage = new SSDWorkloadPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		homepage.ClickIAgreeBtn();
		System.out.println("Stage URL :- " + driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		letstartpage.ClickHelpMeChoose();
	}
	@Test (priority = 3)
	public void ToVerifyNextButton()
	{
		Assert.assertFalse(workloadpage.UnClickNextBtn(), "Next Button is Disabled State");
		
	}
	@Test (priority = 2)
	public void ToVerifyReadIntensiveNotSelected()
	{
		Assert.assertFalse(workloadpage.IsClicked(), "To Check Read Intensive workload is selected");
	}
	@Test (priority = 4)
	public void ToVerifyAllReadIntensiveSelected()
	{
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		workloadpage.SelectReadALL();
	}
	@Test (priority = 5)
	public void ToVerifyNextButtonEnabled()
	{
		Assert.assertTrue(workloadpage.NextButtonEnabled(), "Next Button is Enabled");
		System.out.println("Next is enabled");
	}
	/*@Test (priority = 5)
	public void ToVerifyMixedIntensiveNotSelected()
	{
		
	}
	@Test (priority = 6)
	public void ToVerifyAllMixedIntensiveSelected()
	{
		
	}
	@Test (priority = 7)
	public void ToVerifyWriteIntensiveNotSelected()
	{
		
	}
	@Test (priority = 8)
	public void ToVerifyAllWriteIntensiveSelected()
	{
		
	}
	@Test (priority = 9)
	public void ToVerifyVROIntensiveNotSelected()
	{
		
	}
	@Test (priority = 10)
	public void ToVerifyAllVROIntensiveSelected()
	{
		
	} */
	@Test(priority = 11)
	public void ToVerifyLearnAboutWorkload()
	{
		workloadpage.WorkloadPDF();
	} 
	/*@Test(priority = 12)
	public void ToVerifyReadDeselect()
	{
		workloadpage.DeslectReadAll();
		Assert.assertFalse(workloadpage.UnClickNextBtn(), "Next Button is Disabled State");
		
	} */
	@Test(priority = 13)
	public void NextBtn()
	{
		workloadpage.ClickNextBtn();
	} 
}
