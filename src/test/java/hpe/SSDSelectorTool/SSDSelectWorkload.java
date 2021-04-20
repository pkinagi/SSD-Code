package hpe.SSDSelectorTool;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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

public class SSDSelectWorkload extends BaseClass
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
	ExtentReports ResultsReports;
	
	public SSDSelectWorkload()
	{
		super();
	}
	
	/*@BeforeMethod
	public void LaunchTest()
	{
		Intialization();
		homepage = new SSDHomePage();
		letstartpage = new SSDLetsStartpage();
		workloadpage = new SSDWorkloadPage();
		
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
	} */
	@BeforeTest
	public void TestReport()
	{
		String ResultReportPath = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter testresults = new ExtentSparkReporter(ResultReportPath);
		testresults.config().setReportName("SSD Selector Tool Automation");
		testresults.config().setDocumentTitle("SSD Test Results");
		
		ResultsReports = new ExtentReports();
		ResultsReports.attachReporter(testresults);
		ResultsReports.setSystemInfo("Tester", "Prashant Kinagi");
		
	}
	@Test (priority = 0)
	public void LetsStart()
	{
		ResultsReports.createTest("SmokeTest");
		Intialization();
		ssdHomepage = new SSDHomePage();
		ssdLetsstartpage = new SSDLetsStartpage();
		ssdWorkloadpage = new SSDWorkloadPage();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdHomepage.ClickIAgreeBtn();
		System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdLetsstartpage.ClickHelpMeChoose();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		ssdWorkloadpage.ClickWorkload();
		ssdWorkloadpage.ClickMixedWorkload();
		ssdWorkloadpage.ClickWriteWorkload();
		System.out.println("!!!----Selected the WorkLoad ----!!!");
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		//Assert.assertEquals(servertypepage.SelectedReadIntensive(), true, "Sever Type Selected as ReadIntensive");
	}
	@Test (priority = 2)
	public void VerifyReadIntens()
	{
		ResultsReports.createTest("Select Read-Intensive WorkLoad");
		ssdWorkloadpage.ClickNextBtn();
		ssdServertypepage = new SSDServertypePage();
		Assert.assertTrue(ssdServertypepage.SelectedReadIntensive());
		System.out.println("!!!----Selected the SSD Type ----!!!");
		Assert.assertTrue(ssdServertypepage.SelectedMixedIntensive());
		Assert.assertTrue(ssdServertypepage.SelectedWriteIntensive());
		System.out.println(driver.getCurrentUrl());
		ssdWorkloadpage.ClickNextBtn();
	 }
	@Test (priority =3)
	public void VerifyServerType()
	{
		ssdServermodelpage = new SSDServermodelPage();
		ssdServermodelpage.ClickServerType();	
		System.out.println("!!!----Selected the SSD Server Type ----!!!");
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		ssdServermodelpage.ClickSeverModel();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		System.out.println("!!!----Selected the SSD Model Type ----!!!");
		System.out.println(driver.getCurrentUrl());
		ssdWorkloadpage.ClickNextBtn();
	}
	@Test (priority = 4)
	public void VerifyCapacity()
	{
		System.out.println(driver.getCurrentUrl());
		/*driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions MoveMaxSlider = new Actions(driver);
		//WebElement CapaMaxValue1 = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[1]/div"));
		WebElement CapaMaxValue1 = driver.findElement(By.xpath("//*[@id=\"steps-slider\"]/div/div[3]/div"));
		MoveMaxSlider.dragAndDropBy(CapaMaxValue1,-20,100).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		MoveMaxSlider.clickAndHold(CapaMaxValue1).moveByOffset(-20,100).release().perform();
		//*[@id="steps-slider"]/div/div[1]/div
		//WebElement CapMinValue1 = driver.
		//MoveMaxSlider.moveToElement(CapaMaxValue1).clickAndHold().dragAndDropBy(CapaMaxValue1, -1000, -300).build().perform(); */
		ssdWorkloadpage.ClickNextBtn();
	}
	@Test (priority = 5)
	public void VerifyInterface()
	{
		ssdInterfacepage = new SSDInterfacePage();
		//serverinterfacepage.ClickInterface();
		System.out.println("!!!----Selected the SSD Interface Type ----!!!");
		System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		WebElement Autoselect = driver.findElement(By.xpath("//*[@id=\"id-ssdInterface_SAS\"]"));
		System.out.println(Autoselect.isSelected());
		Assert.assertTrue(Autoselect.isSelected(),"Checkbox Selected");
		ssdWorkloadpage.ClickNextBtn();
	}
	@Test(priority = 6)
	public void VerifyFormFactor()
	{
		ssdFormfactorpage = new SSDFormfactorPage();
		//serverformfactorpage.ClickFromFactor();
		System.out.println("!!!----Selected the SSD Form Factor Type ----!!!");
		System.out.println(driver.getCurrentUrl());
		WebElement FormFactorImage = driver.findElement(By.xpath("//*[@id=\"AIC\"]/img"));
		System.out.println(FormFactorImage.isDisplayed());
		Assert.assertTrue(FormFactorImage.isDisplayed(), "ADD-In-Card Image Displayed");
	//	WebElement FormFactorElement = driver.findElement(By.xpath(""));
		
		ssdWorkloadpage.ClickNextBtn();
		//driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id=\"check-box-label\"]/span[text()='Mainstream']")).click();
		ssdWorkloadpage.ClickNextBtn();
		
		
	}
	@Test (priority = 7)
	public void VerifyResults() throws FileNotFoundException, InterruptedException
	{
		ssdResultpage = new SSDResultPage();
		System.out.println("!!!---- SSD Selector Tool Result Page ----!!!");
		System.out.println(driver.getCurrentUrl());
		ssdResultpage.ClickRefineYourResults();
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		/*List <WebElement> TotalSlidersResults = driver.findElements(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
		int ResultpageSlider = TotalSlidersResults.size();
		System.out.println(ResultpageSlider);
		Actions ResCapaSlider = new Actions(driver);
		WebElement SSDMinCapMoveTarget = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
		int i = ResultpageSlider;
		//int i;
			for (WebElement ResSlider : TotalSlidersResults)
			{
				try
				{
					ResCapaSlider.clickAndHold(ResSlider)
					.moveToElement(SSDMinCapMoveTarget)
					.moveToElement(SSDMinCapMoveTarget, -200, 0)
					.release().build().perform();
					i++;
				}
			catch(Exception e)
				{
					System.out.println(e);
				}
				Thread.sleep(1000);
			} */
		   WebElement SSDMinCapMove = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
			WebElement SSDMinCapMoveTarget = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
			Actions ResCapaSlider = new Actions(driver);
			try
			{
				ResCapaSlider.clickAndHold(SSDMinCapMove)
				.moveToElement(SSDMinCapMoveTarget)
				.moveToElement(SSDMinCapMoveTarget, -200, 0)
				.release().build().perform();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		Thread.sleep(1000);
	/*	WebElement SSDMinCapMove1 = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
		WebElement SSDMinCapMoveTarget1 = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
		Actions ResCapaSlider1 = new Actions(driver);
		try
		{
			ResCapaSlider1.clickAndHold(SSDMinCapMove1)
			.moveToElement(SSDMinCapMoveTarget1)
			.moveToElement(SSDMinCapMoveTarget1, 100, 0)
			.release().build().perform();
		}
		catch(Exception e)
		{
			System.out.println(e);
		} */
		//ssdResultpage = new SSDResultPage();
		//ssdResultpage.SSDResultDownload();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		JavascriptExecutor SelectAllSearchScrollUP = (JavascriptExecutor)driver;
		WebElement SelectAllChBxes = driver.findElement(By.xpath("//*[@id=\"id-refineYourResults\"]"));
		SelectAllSearchScrollUP.executeScript("arguments[0].scrollIntoView();", SelectAllChBxes );
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"collapse1\"]/div/div[4]/div/div[2]/div[3]/label")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		WebElement ResultLink = driver.findElement(By.xpath("//*[@id=\"panel-ggroup1\"]/div/div[1]/h4/a"));
		JavascriptExecutor SelectAllSearchResultScroll = (JavascriptExecutor)driver;
		SelectAllSearchResultScroll.executeScript("arguments[0].scrollIntoView();", ResultLink );
		
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		TakeScreenshot("ResultPage");
		Assert.assertTrue(ssdresultpage.ResultText(), "Result is Correct");*/
	} 
	/*@Test (priority = 8)
	public void VerifyResults1()
	{
		ssdresultpage.ClickSSDPort();
		Assert.assertTrue(ssdresultpage.SSDPortText(), "SSD Port Text is Correct");
	}
	
	@Test (priority = 9)
	public void VerifyResults2()
	{
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		ssdresultpage.ClickSSDRequirment();
		Assert.assertTrue(ssdresultpage.SSDRequirmentText(), "SSD Requirement Text is Correct");
	}
	

	@Test (enabled = false)
	public void VerifyResults3() throws AWTException
	{
		ssdresultpage.ClickPrint();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB); 
		rb.keyPress(KeyEvent.VK_TAB);
	} */
	@AfterMethod
	public void CloseBrowser()
	{
		ResultsReports.flush();
	} 
	@Test(priority=8)
	public void ToVerifyCopyPasteURl() throws AWTException
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_T);
		//driver.get(prop.getProperty("ResultPage"));
		driver.get(prop.getProperty("URL"));
		
	}
}
