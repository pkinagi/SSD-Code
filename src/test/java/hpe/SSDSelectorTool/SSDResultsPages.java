package hpe.SSDSelectorTool;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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

public class SSDResultsPages extends BaseClass
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
	SSDResultPage 		ssdResulttypepage;
	String Timeout = prop.getProperty("ImplicitTimeOut");
	int timeoutperiod = Integer.parseInt(Timeout);
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	public SSDResultsPages()
	{
		super();
	}
	
	@Test (priority = 0)
	public void ToVerifyResultPageURL()
	{
		ssdResulttypepage = new SSDResultPage();
		String ActualSSDURL = prop.getProperty("ResultPage");//"https://ssdhpestage.azurewebsites.net/#forward";
		String ExpectedSSDURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
		log.info("Successfully moved to Result Page");
	}
	
	@Test (priority = 1)
	public void ToVerifyRefineYourResultsLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		String ActualRefineLabel = "Refine your results";
		String ExpectedRefineLabel = driver.findElement(By.xpath("//*[@id=\"panel-ggroup1\"]/div/div[1]/h4/a")).getText();
		Assert.assertEquals(ActualRefineLabel,ExpectedRefineLabel);
	}
	
	@Test (priority = 2)
	public void ToVerifySSDPortfolioAlignmentlabel()
	{
		ssdResulttypepage = new SSDResultPage();
		String ActualSSDPortfolioLabel = "SSD Portfolio Alignment";
		String ExpectedSSDPortfolioLabel = driver.findElement(By.xpath("//*[@id=\"panel-ggroup2\"]/div/div[1]/h4/a")).getText();
		Assert.assertEquals(ActualSSDPortfolioLabel,ExpectedSSDPortfolioLabel);
	}
	
	/* @Test (priority =3)
	public void ToVerifySSDRequirmentsLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		String ActualSSDRequirmentLabel = "38 -  SSDs meet your requirements";
		String ExpectedSSDRequirmentLabel = driver.findElement(By.xpath("//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a")).getText();
		Assert.assertEquals(ActualSSDRequirmentLabel,ExpectedSSDRequirmentLabel);
	} */
	
	@Test (priority = 4)
	public void ToVerifyFeedBackLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		String ActualFeedbackLabel = "Feedback   ";
		String ExpectedFeedbackLabel = driver.findElement(By.xpath("//span[@id=\"feedbackLink\"]")).getText();
		Assert.assertEquals(ActualFeedbackLabel, ExpectedFeedbackLabel);
	}
	
	/*@Test (priority = 5)
	public void ToVerifyShareLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		String ActualShareLabel = "Share   ";
		String ExpectedShareLabel = driver.findElement(By.xpath("//*[@id=\"share_\"]")).getText();
		Assert.assertEquals(ActualShareLabel,ExpectedShareLabel);
	} */
	
	@Test (priority = 6)
	public void ToVerifyPrintLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		String ActualPrintlabel = "Print   ";
		String ExpectedPrintlabel = driver.findElement(By.xpath("//*[@id=\"printToLink\"]")).getText();
		Assert.assertEquals(ActualPrintlabel, ExpectedPrintlabel);
	}
	
	@Test (priority = 7)
	public void ToVerifyStartOverLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		String ActualStartOverlabel = "Start over   ";
		String ExpectedStartOverlabel = driver.findElement(By.xpath("//*[@id=\"startOverLink\"]")).getText();
		Assert.assertEquals(ActualStartOverlabel,ExpectedStartOverlabel);
	}
	
	@Test(priority = 8)
	public void ToVerifyRefineResultsLink()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ClickRefineYourResults();
		driver.manage().timeouts().pageLoadTimeout(timeoutperiod, TimeUnit.SECONDS);
	}
	@Test(priority = 9)
	public void ToVerityResultsDisplay()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultReadSSDSelected(), "Read Intensive Selected");
	}
	
	@Test(priority = 10)
	public void ToVerifySearchIcon()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultSSDSearchIcon(), "Search Icon Displayed");
	}
	
	/*@Test(priority = 11)
	public void ToVerifyRefineYourElements()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultReadSSDSelected(), "Read Intensive Selected");
		System.out.println("Read Intensive Selected");
		Assert.assertTrue(ssdResulttypepage.ResultSASSelected(),"Interface - SAS is Selected");
		System.out.println("Interface - SAS is Selected");
		Assert.assertTrue(ssdResulttypepage.ResltSATSSelected(), "Interface - SATA is Selected");
		System.out.println("Interface - SATA is Selected");
		Assert.assertTrue(ssdResulttypepage.ResultNVmeSelected(),"Interface - NVMe is Selected");
		System.out.println("Interface - NVMe is Selected");
		Assert.assertTrue(ssdResulttypepage.ResultAddInCardSelected(),"Form-Fator - Add-In-Card");
		System.out.println("Form-Fator - Add-In-Card");
		Assert.assertTrue(ssdResulttypepage.ResultLFFSelected(),"Form-Fator - 3.5 LFF ");
		System.out.println("Form-Fator - 3.5 LFF");
		Assert.assertTrue(ssdResulttypepage.ResultSFFSelected(),"Form-Fator - 2.5 SFF ");
		System.out.println("Form-Fator - 2.5 SFF");
		Assert.assertTrue(ssdResulttypepage.ResultM2Selected(),"Form-Fator - M2 ");
		System.out.println("Form-Fator - M2 ");
		Assert.assertTrue(ssdResulttypepage.ResultM2eSelected(),"Form-Fator - M2E ");
		System.out.println("Form-Fator - M2E ");
		Assert.assertTrue(ssdResulttypepage.ResultMainstream(),"Mainstream is Selected");
		System.out.println("Mainstream is Selected");
	}  */
	
	@Test(priority = 12)
	public void ToVerifySeverTypeDisplayed()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultServerType();

	}
	
	/*@Test(priority = 13)
	public void ToverifySeverModelDisplayed()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultServerModel();
	}*/
	
	/* @Test(priority = 14)
	public void ToVerifyCapacitySliderLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultCapacitySlider();
		//Assert.assertTrue(ssdResulttypepage.ResultCapacitySlider(),"Capacity Slider is Displayed");
	} */
	
	/*@Test(priority = 15)
	public void ToVerifyPriceSliderLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultPriceLabel(),"Price Slider is Displayed");
		driver.manage().timeouts().pageLoadTimeout(timeoutperiod, TimeUnit.SECONDS);
	}*/
	
	  @Test(priority = 16)
	public void ToVerifyReadPerformanceLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultReadPerformanceLabel(),"Read Performance label is Displayed");
	}
	
	/*@Test(priority = 17)
	public void ToVerifyWritePerformanceLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultWritePerformanceLabel(),"Write Performance lable is Displayed");
	} */
	
	/*@Test(priority = 18)
	public void ToVerifyEnduranceLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultEduranceSlider();
		//Assert.assertTrue(ssdResulttypepage.ResultEduranceSlider(),"Endurance Slider is Displayed");
	} */
	
	/*@Test(priority = 19)
	public void ToVerifyMaxPowerLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultMaxPower();
		//Assert.assertTrue(ssdResulttypepage.Res,"Capacity Slider is Displayed");
	} */
	
	/*@Test(priority = 20)
	public void ToVerifyRandomReadLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultRandomRead();
	}*/
	
	/*@Test(priority = 21)
	public void ToVerifyRandomWriteLable()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultRandonWrite();
	}  */
	
	/*@Test(priority = 22)
	public void ToVerifySelectAllLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		String ActualSelectAllLabel = "Select all applicable checkboxes above";
		String ExpectedSelectAllLabel = driver.findElement(By.xpath("//*[@id=\"check-box-label\"]/span[text()='Select all applicable checkboxes above']")).getText();
		Assert.assertEquals(ActualSelectAllLabel, ExpectedSelectAllLabel);
		//Assert.assertTrue(ssdResulttypepage.ResultSelectAll(),"Select All Applicable Checkboxes above Message is Displayed");
	} */
	
	@Test(priority = 23)
	public void ToVerifySKUIDDisplayed()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultSSDSKU(),"SKU is Displayed");
	}
	
	/* @Test(priority = 24)
	public void ToVerifySSDDownload()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultDownload(),"Download is Displayed");
	} */
	
	@Test(priority = 25)
	public void ToVerifySSDShowMore()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultShowMore(),"ShowMore is Displayed");
	}
	
	@Test(priority = 26)
	public void ToVerifySSDShowLess()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultShowLess(),"ShowLess is Displayed");
	}
	
	@Test(priority = 27)
	public void ToVerifySSDImage()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultSSDImage(),"Drive Image is Displayed");
	} 
	
	@Test(priority = 28)
	public void ToVerifyServerCompactability()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultpageSSDName(),"SSD Name is Displayed");
	} 
	
	@Test(priority = 29)
	public void ToVerifySSDName()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultpageSSDName(),"SSD Name is Displayed");
	}
	
	/* @Test(priority = 30)
	public void ToVerifySSDPriceLabel()
	{
		ssdResulttypepage = new SSDResultPage();
		Assert.assertTrue(ssdResulttypepage.ResultPriceLabel(),"Price Name is Displayed");
	} */
	
	@Test(priority =31)
	public void ToVerifySSDPortfolioLink()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ClickSSDPort();
	}
	
	/*@Test(priority = 32)
	public void ToVerifySearchTab()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultSearch();
		ToVerifySKUIDDisplayed();
		ToVerifySSDName();
		ToVerifySSDShowMore();	
	} */
	
	 /* @ Test(priority = 33)
	public void ToVerifyCapacitySlider()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultCapaSlider();	
	}
	
	@Test(priority = 34)
	public void ToVerifyCapacitySliderResult()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultDisplayCapa();
	} */
	
	/*@Test(priority = 35)
	public void ToVerifySelectAllResults()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultSelectAllBtn();
	} */
	
	/*@Test(priority = 36)
	public void ToVerifyDeSelectAll()
	{
		ssdResulttypepage = new SSDResultPage();
		ssdResulttypepage.ResultDeselectAllBtn();
	} */
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}
}
