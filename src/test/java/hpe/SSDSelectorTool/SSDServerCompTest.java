package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class SSDServerCompTest extends BaseClass
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
	
	public SSDServerCompTest()
	{
		super();
	}
	@Test (priority = 0)
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
	
	@Test(priority = 1)
	public void ToVerifyWorkloadURL()
	{
		ssdWorkloadpage = new SSDWorkloadPage();
		String ActualWorkloadURL = prop.getProperty("WorkLoadPage");//"https://ssdhpestage.azurewebsites.net/workload";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	
	@Test(priority=2)
	public void ToVerifyReadWorkloadLabel()
	{
		String ActualReadWorkloadColumn = prop.getProperty("ReadWorkloadColumn");
		String ExpectedReadWorkloadColumn = ssdWorkloadpage.ReadIntensiveLabel.getText();
		System.out.println(ExpectedReadWorkloadColumn);
		Assert.assertEquals(ActualReadWorkloadColumn, ExpectedReadWorkloadColumn);
	}
	
	@Test(priority=3)
	public void ToVerifyMixedWorkloadLabel()
	{
		String ActualMixedWorkloadColumn = prop.getProperty("MixedWorkloadColumn");
		String ExcpectedMixedWorkloadColumn = ssdWorkloadpage.MixedIntensiveLabel.getText();
		Assert.assertEquals(ActualMixedWorkloadColumn,ExcpectedMixedWorkloadColumn);
	}
	
	@Test(priority=4)
	public void ToVerifySelectReadAnDMixedWorkloads()
	{
		ssdWorkloadpage.SelectReadWorkload.click();
		ssdWorkloadpage.SelectMixedWorkload.click();
	}
	
	@Test(priority=5)
	public void ToVerifySSDTypesAutoSelected()
	{
		ssdServertypepage = new SSDServertypePage();
		ssdWorkloadpage.ClickNextBtn();
		String ActualWorkloadURL = prop.getProperty("SSDPage");//"https://ssdhpestage.azurewebsites.net/ssdtype";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
		Assert.assertTrue(ssdServertypepage.SelectedReadIntensive(),"Read-Intensive ");
		Assert.assertTrue(ssdServertypepage.SelectedMixedIntensive(),"Mixed-Intensive");
		//ssdServertypepage.NextBtnEnabled();
	}
	@Test(priority=6)
	public void ToVerifyServerTypeAndServerModel()
	{
		ssdServertypepage.NextClick();
		ssdServermodelpage = new SSDServermodelPage();
		String ActualWorkloadURL = prop.getProperty("ServerTypePage");//"https://stg-app-hpessd.azurewebsites.net/server-type";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
		Assert.assertTrue(ssdServermodelpage.ReadMixedServerType(),"Server Type List is Displayed");
		ssdServermodelpage.SelectReadMixedServerModel();
		ssdServermodelpage.ServerTypeNextBtn();
	}
	@Test(priority=7)
	public void ToVerifyDriveCapacityChange() throws InterruptedException
	{
		ssdCapacitypage = new SSDCapacityPage();
		String ActualWorkloadURL = prop.getProperty("DriveCapacityPage");//"https://stg-app-hpessd.azurewebsites.net/drive-capacity";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
		Actions ResCapaSlider = new Actions(driver);
		WebElement SSDMinCapMove = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[2]/div/div"));
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
		Thread.sleep(3000);
	}
	@Test(priority = 8)
	public void ToVerifyNxtBtnDisabled()
	{
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
	@Test(priority = 9)
	public void ToVerifyCapacityMaxSlider()
	{
		Actions ResCapaSlider = new Actions(driver);
		WebElement SSDMinCapMove = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[2]/div/div"));
		WebElement SSDMinCapMoveTarget = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[2]/div/div"));
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
		ssdCapacitypage.CapaNextBtn();
	}
	
	@Test(priority=10)
	public void ToVerifyInterfaceTypeAutoSelected()
	{
		ssdInterfacepage = new SSDInterfacePage();
		String ActualWorkloadURL = prop.getProperty("InterfacePage");//"https://stg-app-hpessd.azurewebsites.net/interface-type";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
		Assert.assertTrue(ssdInterfacepage.InterfaceSAS(), "NextBtn is in Enabled State");
		Assert.assertTrue(ssdInterfacepage.InterfaceSATA(), "NextBtn is in Enabled State");
		Assert.assertTrue(ssdInterfacepage.InterfaceNVMe(), "NextBtn is in Enabled State");
		//Assert.assertTrue(ssdInterfacepage.InterfaceNVMeMainstream(), "NextBtn is in Enabled State");
		//Assert.assertTrue(ssdInterfacepage.InterfaceNVMeHigh(), "NextBtn is in Enabled State");
		Assert.assertFalse(ssdInterfacepage.SelectAllInterface(),"Select All option is not Selected");
		ssdInterfacepage.InterfaceNxtBtn();
	}
	@Test(priority =11)
	public void ToVerifyFormFactorAutoSelected()
	{
		ssdFormfactorpage = new SSDFormfactorPage();
		WebDriverWait PageloadWait = new WebDriverWait(driver, 10);
		PageloadWait.until(ExpectedConditions.urlToBe("https://uat-app-hpessd.azurewebsites.net/form-factor"));
		String ActualWorkloadURL = prop.getProperty("FormFactorPage");//"https://stg-app-hpessd.azurewebsites.net/form-factor";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
		Assert.assertTrue(ssdFormfactorpage.AddInCardImage(), "Add-In-Card Image is displayed");
		Assert.assertTrue(ssdFormfactorpage.AddInCardSelected(), "NextBtn is in Enabled State");
		Assert.assertTrue(ssdFormfactorpage.M2ImageDisplayed(), "M-2 Image is displayed");
		Assert.assertTrue(ssdFormfactorpage.M2CardSelected(), "NextBtn is in Enabled State");
		Assert.assertTrue(ssdFormfactorpage.M2EDisplayed(), "M2e-Image is displayed");
		Assert.assertTrue(ssdFormfactorpage.M2eSelected(), "NextBtn is in Enabled State");
		Assert.assertTrue(ssdFormfactorpage.LFFDisplayed(), "3.5LFF Image is displayed");
		Assert.assertTrue(ssdFormfactorpage.LFFSelected(), "NextBtn is in Enabled State");
		Assert.assertTrue(ssdFormfactorpage.SFFDisplayed(), "2.5SFF Image is displayed");
		Assert.assertTrue(ssdFormfactorpage.SFFSelected(), "NextBtn is in Enabled State");
		//Assert.assertTrue(ssdFormfactorpage.SelectAllFormFactor(), "Select All Option is Selected");
		ssdFormfactorpage.FormNxtBtn();
	}
	@Test(priority=12)
	public void ToVerifySKUMainstream()
	{
		ssdBestAvailability = new SSDBestAvailability();
		String ActualWorkloadURL = prop.getProperty("MainstreamPage");//"https://stg-app-hpessd.azurewebsites.net/mainstream";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
		Assert.assertTrue(ssdBestAvailability.Mainstream(),"Mainstream Option is Selected");
		ssdBestAvailability.MainNonstreamClick();
		ssdBestAvailability.BestAvailNxtBtn();
	}
	@Test(priority=13)
	public void ToVerifySelectedConfigurationDisplayed() throws InterruptedException
	{
		ssdResultpage = new SSDResultPage();
		String ActualWorkloadURL = prop.getProperty("ResultPage");//"https://stg-app-hpessd.azurewebsites.net/recommendation";
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
		//WebElement ResultRefine = ssdResultpage.ResultText;
		JavascriptExecutor ToSeeRefineYourResults = (JavascriptExecutor)driver;
		ToSeeRefineYourResults.executeScript("arguments[0].scrollIntoView();", ssdResultpage.ResultText); 
		Thread.sleep(2000);
		//ssdResultpage.ClickRefineYourResults();
		Assert.assertTrue(ssdResultpage.ResultReadSSDSelected(), "SSD_Type Read Intensive Selected");
		Assert.assertTrue(ssdResultpage.ResultMixedSSDSelected(),"SSD_Type Mixed Intensive Selected");
		Assert.assertTrue(ssdResultpage.ResultSASSelected(),"Interface_Type SAS Selected");
		Assert.assertTrue(ssdResultpage.ResltSATSSelected(),"Interface_Type SATA Selected");
		Assert.assertTrue(ssdResultpage.ResultNVmeSelected(),"Interface_Type NVMe Selected");
		Assert.assertTrue(ssdResultpage.ResultAddInCardSelected(),"Form-Factor Add-In-Card Selected");
		Assert.assertTrue(ssdResultpage.ResultLFFSelected(),"Form-Factor 3.5LFF Selected");
		Assert.assertTrue(ssdResultpage.ResultM2eSelected(),"Form-Factor M2e Selected");
		Assert.assertTrue(ssdResultpage.ResultM2Selected(),"Form-Factor M2 Selected");
		Assert.assertTrue(ssdResultpage.ResultSFFSelected(),"Form-Factor 2.5SFF Selected");
		Assert.assertFalse(ssdResultpage.ResultMainstream(), "Mainstream is not Selected");
	}
	@Test(priority=14)
	public void ToVerifySSDResults() throws InterruptedException
	{
		
		Assert.assertTrue(ssdResultpage.ReadMixedResultServerType(),"Selected Server-Type is displayed");
		//Assert.assertTrue(ssdResultpage.ReadMixedResultServerModelType(),"Selected Server-Model is displayed");
		Thread.sleep(2000);
		JavascriptExecutor ToSeeSSDResults = (JavascriptExecutor)driver;
		ToSeeSSDResults.executeScript("arguments[0].scrollIntoView();", ssdResultpage.SSDRequriementslink); 
		Thread.sleep(2000);
		String SSDResultDisplays = ssdResultpage.SSDRequriementslink.getText();
		System.out.println(SSDResultDisplays);
		String ActualSSDRequirmentLabel = "35 -  SSDs meet your requirements";
		String ExpectedSSDRequirmentLabel = driver.findElement(By.xpath("//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a")).getText();
		Assert.assertEquals(ActualSSDRequirmentLabel, ExpectedSSDRequirmentLabel);
	} 
	/*@Test(priority=15)
	public void ToVerifySSDServerCompatability() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor ToSeeRefineYourResult = (JavascriptExecutor)driver;
		ToSeeRefineYourResult.executeScript("arguments[0].scrollIntoView();", ssdResultpage.ResultText);
		ssdServermodelpage.ChangeServerModelType();
		ssdServermodelpage.ChangeServerTypeServerModel();
		Thread.sleep(4000);
		String SSDResultDisplays = ssdResultpage.SSDRequriementslink.getText();
		System.out.println(SSDResultDisplays);
		String ActualSSDRequirmentLabel = "64 -  SSDs meet your requirements";
		String ExpectedSSDRequirmentLabel = driver.findElement(By.xpath("//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a")).getText();
		Assert.assertEquals(ActualSSDRequirmentLabel, ExpectedSSDRequirmentLabel);
		Thread.sleep(1000);
		ssdResultpage.SSDResultClickShowMore();
		//String FindServerCompat = "";
		String ExpectedServerCompat = ssdResultpage.ServerCompact.getText();
		if (ExpectedServerCompat.contains("Apollo 2000 - XL170r Gen10,Apollo 2000 - XL190r Gen10,Apollo 2000 - XL225n Gen10 Plus,Apollo 4200 Gen10,Apollo 4500 - XL450 Gen10,Apollo 6000 XL230k Gen10,Apollo 6500 XL270d Gen10,"));
		{
			System.out.println("Server Compactaiablity List is showing");
		}
	}
	
	@Test(priority=16)
	public void ToVerifyServerTypeAndServerModelResults() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor ToSeeRefineYourResult = (JavascriptExecutor)driver;
		ToSeeRefineYourResult.executeScript("arguments[0].scrollIntoView();", ssdResultpage.ResultText);
		ssdServermodelpage.ChangeSeverType();
	} */
	
}
