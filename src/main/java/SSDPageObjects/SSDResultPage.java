package SSDPageObjects;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import SSDResource.BaseClass;
//import ssdPages.SSDServermodelPage;

public class SSDResultPage extends BaseClass
{
SSDServermodelPage ssdServermodelpage;
	
	//Declaration
	@FindBy (xpath = "//*[@id=\"panel-ggroup1\"]/div/div[1]/h4/a/span[text()='Refine your results']")
	public
	WebElement ResultText;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup1\"]/div/div[1]/h4/a")
	public WebElement ResultLink;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup2\"]/div/div[1]/h4/a")
	public
	WebElement SSDProtfolioLink;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup2\"]/div/div[1]/h4/a/span[text()='SSD Portfolio Alignment']")
	public
	WebElement SSDProtfolioText;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a")
	public
	WebElement SSDRequriementslink;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a/span[text()='SSDs meet your requirements']")
	public
	WebElement SSDRequrimentsText;
	
	@FindBy (xpath = "//span[@id=\"printToLink\"]")
	WebElement Print;
	
	@FindBy (xpath = "//*[@id=\"downloadAllPDF\"]")
	WebElement DownloadAllPDFFile;
	
	@FindBy (xpath = "//*[@id=\"downloadAllRec\"]")
	WebElement DownloadAllExcelFile;
	
	@FindBy (xpath = "//span[@id=\"share_//\"]")
	WebElement Share;
	
	@FindBy (xpath = "//span[@id=\"feedbackLink\"]")
	WebElement Feedback;
	
	@FindBy (xpath = "//span[@id=\"startOverLink\"]")
	WebElement StartOver;
	
	//SSDName 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div[1]")
	WebElement SSDName;
	
	//SSDSKU ID
	@FindBy (xpath = "//*[@id=\"result_content\"]/div/span")
	WebElement SSDSKUID;
	
	//SSD Mainstream
	@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div[2]")
	WebElement SSDMainstream;
	
	//SSD NonMainstream
	@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[705]/div[2]/div[2]/div[2]/div[2]/span")
	WebElement SSDNonMainstream;
	
	//SSD Download
	@FindBy (xpath = "//*[@id=\"download_\"]")
	public
	WebElement SSDDownload;
	
	//SSDShowMore()
	@FindBy (xpath = "//button[@class='btn_showmore accordionSubtitle']")
	public
	WebElement SSDShowMore;
	
	//SSDShowless()
	@FindBy (xpath = "//button[@class='btn_showmore accordionSubtitle']")
	WebElement SSDShowLess;
	
	//SSDImage()
	@FindBy (xpath = "//*[@id=\"result_content\"]")
	WebElement SSDImage;
	
	//SSDPriceLabel
	@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[6]/div[2]/div[2]/div[3]/span[1]")
	WebElement SSDPriceLabel;
	
	//Server Compactability List
	@FindBy (xpath = "//span[@class=\"serverModelNamesInitial\"]")
	WebElement SSDServerCompat;
	
	//SSD Search Tab
	@FindBy (xpath = "//*[@id=\"searchfield\"]")
	WebElement SSDSearch;
	
	//SSD Search Icon
	@FindBy (xpath = "//*[@id=\"icon-search\"]")
	WebElement SSDSearchIcon;
	
	//SSD Server Type
	@FindBy (xpath = "//*[@id=\"sel_server_type\"]")
	public
	WebElement SSDResultServertype;
	
	//SSD Server Model Type
	@FindBy (xpath = "//*[@id=\"sel_server_model\"]")
	public
	WebElement SSDResultServerModeltype;
	
	//SSD Max Capacity Slider
	@FindBy (xpath = "//*[@id=\"max_capacity\"]")
	WebElement SSDMaxCapSlider;
	
	//SSD Min Capacity Slider
	@FindBy (xpath = "//*[@id=\"min_capacity\"]")
	WebElement SSDMinCapSlider;
	
	//SSD Max Price Slider
	@FindBy (xpath = "//*[@id=\"max_price\"]")
	WebElement SSDMaxPrice;
	
	//SSD Min Price Slider
	@FindBy (xpath = "//*[@id=\"min_price\"]")
	WebElement SSDMinPrice;
	
	//SSD Min Endurance Slider
	@FindBy (xpath = "//*[@id=\"min_endurance\"]")
	WebElement SSDMinEndu;
	
	//SSD Max Endurnace Slider
	@FindBy (xpath = "//*[@id=\"max_endurance\"]")
	WebElement SSDMaxEndu;
	
	//SSD Min Power Slider
	@FindBy (xpath = "//*[@id=\"min_power\"]")
	WebElement SSDMinPower;
	
	//SSD Max Power Slider
	@FindBy (xpath = "//*[@id=\"max_power\"]")
	WebElement SSDMaxPower;
	
	//SSD Min RandomRead Latency Slider
	@FindBy (xpath = "//*[@id=\"min_rlatency\"]")
	WebElement SSDMinRR;
	
	//SSD Max RandomReas Latency Slider
	@FindBy (xpath = "//*[@id=\"max_rlatency\"]")
	WebElement SSDMaxRR;
	
	//SSD Min RandomWrite Latency Slider
	@FindBy (xpath = "//*[@id=\"min_wlatency\"]")
	WebElement SSDMinRW;
	
	//SSD Max RandomRead Latency Slider
	@FindBy (xpath = "//*[@id=\"max_wlatency\"]")
	WebElement SSDMaxRW;
	
	//SSD All Slider 
	@FindBy (xpath = "//*[@id=\"slider-range\"]/span[2]")
	WebElement SSDAllSliders;
	
	// SSD Read Performance 
	@FindBy (xpath = "//*[@id=\"collapse1\"]/div/div[4]/div/div[2]/div[2]/div/div[4]/div[1]/div[3]/div/div[1]")
	WebElement SSDReadPerf;
	
	//SSD Write Performance
	@FindBy (xpath = "//*[@id=\"collapse1\"]/div/div[4]/div/div[2]/div[2]/div/div[4]/div[1]/div[4]/div/div[1]")
	WebElement SSDWritePerf;
	
	//SSD Selected Configurations
	@FindBy (xpath = "//*[@id=\"id-ssdtype_RI\"]")
	WebElement SSDReadResultSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_MU\"]")
	WebElement SSDMixedResultSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_WI\"]")
	WebElement SSDWriteResultSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_VRO\"]")
	WebElement SSDVROResultSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_SAS\"]")
	WebElement SSDInterfaceSelectedSAS;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_SATA\"]")
	WebElement SSDInterfaceSelectedSATA;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_NVMe\"]")
	WebElement SSDInterfaceSelectedNVMe;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_VALUESAS\"]")
	public
	WebElement SSDInterfaceSelectedValueSAS;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_SATAVRO\"]")
	public
	WebElement SSDInterfaceSelectedSATAVRO;
	
	@FindBy (xpath = "//*[@id=\"id-ssdFormFactor_AIC\"]")
	WebElement SSDFormFactorAddInCard;
	
	@FindBy (xpath = "//*[@id=\"id-ssdFormFactor_LFF\"]")
	WebElement SSDFormFactorLFF;
	
	@FindBy (xpath = "//*[@id=\"id-ssdFormFactor_SFF\"]")
	WebElement SSDFormFactorSFF;
	
	@FindBy (xpath = "//*[@id=\"id-ssdFormFactor_M2\"]")
	WebElement SSDFormFactorM2;
	
	@FindBy(xpath = "//*[@id=\"id-ssdFormFactor_M2e\"]")
	WebElement SSDFormFactorM2EKit;
	
	@FindBy (xpath = "//*[@id=\"stream_main\"]")
	WebElement Mainstream;
	
	@FindBy (xpath = "//*[@id=\"stream_Yes\"]")
	public WebElement MainstreamChk;
	
	@FindBy (xpath = "//*[@id=\"stream_No\"]")
	public WebElement NonMainstreamChk;
	
	@FindBy (xpath = "//*[@id=\"id-refineYourResults\"]")
	public WebElement SelectAllChBxes;
	
	@FindBy (xpath = "/*[@id=\"check-box-label\"]/span")
	WebElement SelectAllCheckBxText;
	
	//Minimum Capacity Slider
	@FindBy (xpath = "//*[@id=\"slider-range\"]/span[1]")
	WebElement SSDMinCapMove;
	
	//Minimum Capacity Slider
	@FindBy (xpath = "//*[@id=\"slider-range\"]/span[1]")
	WebElement SSDMinCapMoveTarget;
	
	//Number of SSD Requriments
	@FindBy (xpath = "//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a/span/span")
	WebElement SSDNumber;
	

	
	// Result Page Labels for the Checkboxes
	@FindBy (xpath = "//div[text()='SSD type']")
	WebElement SSDTypelabel;
	@FindBy (xpath = "//div[text()='Interface type']")
	WebElement Interfacelabel;
	@FindBy (xpath = "//div[text()='Form factor']")
	WebElement Formfactorlabel;
	@FindBy (xpath = "//div[text()='Certifications']")
	WebElement Certificationslabel;
	@FindBy (xpath = "//div[text()='Best Availability']")
	WebElement BestAvailabilitylabel;
	
	// SSD Image
	@FindBy (xpath = "//*[@id=\"result_content\"]/img")
	public
	WebElement SSDImages;
	
	//Server Compatibility 
		@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[4]/div/div[2]/span")
		public WebElement ServerCompact;
	
		//SSD Mainstream
		@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div[2]")
		public WebElement SSDMainstreamResults;
	
	// Select All Option AlertBox 
	//For Selecting Yes Option
	@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button[1]")
	public WebElement SelectAllYes;
	
	//For Selecting No Option
	@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button[2]")
	public WebElement SelectAllNo;
	
	//For Mainstream/Non-Mainstream
	@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button")
	public WebElement AlertOK;
	
	//Alert Message 
	@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button")
	public
	WebElement AlertMessageOk;
	
	@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div")
	public
	WebElement AlertMessage;

	@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[3]")
	public
	WebElement AlertMessageText;
	
	
	//Intialization
	public SSDResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickRefineYourResults()
	{
		JavascriptExecutor SSDScrollUp = (JavascriptExecutor)driver;
		SSDScrollUp.executeScript("arguments[0].click();",ResultLink);
		
	}
	
	public boolean ResultRefineYourResultsLabel()
	{
		return ResultText.isDisplayed();
	}
	
	public void ClickSSDPort()
	{
		SSDProtfolioLink.click();
	}
	
	public boolean SSDPortImage()
	{
		return SSDProtfolioText.isDisplayed();
	}
	
	public void ClickSSDRequirment()
	{
		SSDRequriementslink.click();
	}
	
	public boolean SSDRequirmentText()
	{
	
		return SSDRequrimentsText.isDisplayed();
	}
	
	public void ClickPrint()
	{
		Print.click();
	}
	
	public void ClickShare()
	{
		Share.click();
	}
	
	public void ClickFeedBack()
	{
		Feedback.click();
	}
	
	public void StartOver()
	{
		StartOver.click();
	}
	
	public boolean ResultpageSSDName()
	{
		return SSDName.isDisplayed();
	}
	
	public boolean ResultSSDSKU()
	{
		return SSDSKUID.isDisplayed();
	}
	
	public boolean ResultDownload()
	{
		return SSDDownload.isDisplayed();
	}
	
	public void  SSDResultDownload()
	{
		SSDDownload.click();
	}
	public void SSDResultClickShowMore()
	{
		SSDShowMore.click();
	}
	public boolean ResultShowMore()
	{
		SSDShowMore.click();
		return SSDShowMore.isDisplayed();
	}
	
	public boolean ResultShowLess()
	{
		SSDServerCompat.isDisplayed();
		return SSDShowLess.isDisplayed();
	}
	
	public boolean ResultPriceLabel()
	{
		return SSDPriceLabel.isDisplayed();
	}
	
	public boolean ResultSearchLabel()
	{
		return SSDSearch.isDisplayed();
	}
	
	public void ResultSearch()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		SSDSearch.sendKeys("P22276-B21");
		SSDSearchIcon.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		JavascriptExecutor SearchResultScroll = (JavascriptExecutor)driver;
		SearchResultScroll.executeScript("arguments[0].scrollIntoView();", SSDSKUID );
	}
	
	public boolean ResultServerType()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualServerTypeSelected = "HPE Apollo Systems                ";
		String ExpectedServerTypeDisplays = driver.findElement(By.xpath("//*[@id=\"sel_server_type\"]/option[4]")).getText();
		//String ExpectedServerTypeDisplayed = SSDResultServertype.getText();
		Assert.assertEquals(ActualServerTypeSelected,ExpectedServerTypeDisplays);
		return SSDResultServertype.isDisplayed();
	}
	
	public boolean ResultServerModel()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualServerModelSelected = "Apollo 10 - sx40 Gen10";
		String ExpectedServerModelDisplays = driver.findElement(By.xpath("//*[@id=\"Apollo 10 - sx40 Gen10\"]")).getText();
		//String ExpectedSeverModelSelected = SSDResultServerModeltype.getText();
		Assert.assertEquals(ActualServerModelSelected, ExpectedServerModelDisplays);
		return SSDResultServerModeltype.isDisplayed();
	}
	
	public void ResultCapacitySlider()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualMinCapacity = "3178";
		String ExpectedMinCapacity = SSDMinCapSlider.getText();
		Assert.assertEquals(ActualMinCapacity, ExpectedMinCapacity);
		String ActualMaxCapacity = "15360";
		String ExpectedMaxCapacity = SSDMaxCapSlider.getText();
		Assert.assertEquals(ActualMaxCapacity, ExpectedMaxCapacity);
		
	}
	
	public void ResultPriceSlider()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualMinPrice = "0";
		String ExpectedMinPrice = SSDMinPrice.getText();
		Assert.assertEquals(ActualMinPrice, ExpectedMinPrice);
		String ActualMaxPrice = "18625";
		String ExpectedMaxPrice = SSDMaxPrice.getText();
		Assert.assertEquals(ActualMaxPrice,ExpectedMaxPrice);
	}
	
	public boolean ResultReadPerformanceLabel()
	{
		String ActualReadPerfLabel = "ReadPerformance";
		String ExpectedReadPerfLabel = SSDReadPerf.getText();
		Assert.assertEquals(ActualReadPerfLabel, ExpectedReadPerfLabel);
		return SSDReadPerf.isDisplayed();
	}
	
	public boolean ResultWritePerformanceLabel()
	{
		String ActualWritePerfLabel = "WritePerformance";
		String ExpectedWritePerfLabel = SSDWritePerf.getText();
		Assert.assertEquals(ActualWritePerfLabel, ExpectedWritePerfLabel);
		return SSDWritePerf.isDisplayed();
	}
	public void ResultEduranceSlider()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualMinEndurance = "0";
		String ExpectedMinEndurance = SSDMinEndu.getText();
		Assert.assertEquals(ActualMinEndurance, ExpectedMinEndurance);
		String ActualMaxEndurance = "7.4";
		String ExpectedMaxEndurance = SSDMaxEndu.getText();
		Assert.assertEquals(ActualMaxEndurance, ExpectedMaxEndurance);
	}
	
	public void ResultMaxPower()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualMinPower = "0.00";
		String ExpectedMinPower = SSDMinPower.getText();
		Assert.assertEquals(ActualMinPower,ExpectedMinPower);
		String ActualMaxPower = "25.00";
		String ExpectedMaxPower = SSDMaxPower.getText();
		Assert.assertEquals(ActualMaxPower,ExpectedMaxPower);
	}
	
	public void ResultRandomRead()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualMinRR = "(Î¼) 0";
		String ExpectedMinRR = SSDMinRR.getText();
		Assert.assertEquals(ActualMinRR, ExpectedMinRR);
		String ActualMaxRR = "(Î¼) 235";
		String ExpectedMaxRR = SSDMaxRR.getText();
		Assert.assertEquals(ActualMaxRR, ExpectedMaxRR);
	}
	
	public void ResultRandonWrite()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualMinRW = "(Î¼) 0";
		String ExpectedMinRW = SSDMinRW.getText();
		Assert.assertEquals(ActualMinRW, ExpectedMinRW);
		String ActualMaxRW = "(Î¼) 5400";
		String ExpectedMaxRW = SSDMaxRW.getText();
		Assert.assertEquals(ActualMaxRW, ExpectedMaxRW);
	}
	
	public void ResultSelectedCheckboxes()
	{
		
	}
	
	public boolean ResultReadSSDSelected()
	{
		return SSDReadResultSelected.isSelected();
	}
	
	public boolean ResultMixedSSDSelected()
	{
		return SSDMixedResultSelected.isSelected();
	}
	
	public boolean ResultWriteSSDSelected()
	{
		return SSDWriteResultSelected.isSelected();
	}
	
	public boolean ResultVROSSDSelected()
	{
		return SSDVROResultSelected.isSelected();
	}
	
	public boolean ResultSASSelected()
	{
		return SSDInterfaceSelectedSAS.isSelected();
	}
	
	public boolean ResltSATSSelected()
	{
		return SSDInterfaceSelectedSATA.isSelected();
	}
	
	public boolean ResultNVmeSelected()
	{
		return SSDInterfaceSelectedNVMe.isSelected();
	}
	
	public boolean ResultValueSASSelected()
	{
		return SSDInterfaceSelectedValueSAS.isSelected();
	}
	public boolean ResultAddInCardSelected()
	{
		return SSDFormFactorAddInCard.isSelected();
	}
	
	public boolean ResultLFFSelected()
	{
		return SSDFormFactorLFF.isSelected();
	}
	
	public boolean ResultM2Selected()
	{
		return SSDFormFactorM2.isSelected();
	}
	
	public boolean ResultM2eSelected()
	{
		return SSDFormFactorM2EKit.isSelected();
	}
	
	public boolean ResultSFFSelected()
	{
		return SSDFormFactorSFF.isSelected();
	}
	
	public boolean ResultMainstream()
	{
		return MainstreamChk.isSelected();
	}
	
	public boolean ResultNonMainstreamDisplay()
	{
		return SSDNonMainstream.isDisplayed();
	}
	public boolean ResultSelectAll()
	{
		
		return SelectAllCheckBxText.isDisplayed();
	}
	
	public boolean ResultSSDSearchIcon()
	{
		return SSDSearchIcon.isDisplayed();
	}
	
	public boolean ResultSSDImage()
	{
		return SSDImage.isDisplayed();
	}
	
	public void ResultCapaSlider()
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Actions ResCapaSlider = new Actions(driver);
		try
		{
			ResCapaSlider.clickAndHold(SSDMinCapMove)
			.moveToElement(SSDMinCapMoveTarget)
			.moveToElement(SSDMinCapMoveTarget, 100, -20)
			.release().build().perform();
			//.moveByOffset(0, -20).release().perform();
			//ResCapaSlider.dragAndDropBy(SSDMinCapMove, 30, 100).build().perform();
			//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			//ResCapaSlider.clickAndHold(SSDMinCapMove).moveByOffset(100,10).build().perform();
			//ResCapaSlider.release().build().perform();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		JavascriptExecutor CapaSearchResultScroll = (JavascriptExecutor)driver;
		CapaSearchResultScroll.executeScript("arguments[0].scrollIntoView();", SSDSKUID );
	}
	
	public void ResultDisplayCapa()
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		JavascriptExecutor CapaSearchResultScroll = (JavascriptExecutor)driver;
		CapaSearchResultScroll.executeScript("arguments[0].scrollIntoView();", SSDRequriementslink );
		String ActualSSDRequirmentLabel = "1";
		String ExpectedSSDRequirmentLabel = SSDNumber.getText();
		System.out.println(ExpectedSSDRequirmentLabel);
		Assert.assertEquals(ActualSSDRequirmentLabel,ExpectedSSDRequirmentLabel);
		SSDRequriementslink.click();
	}
	
	public void ResultSelectAllBtn()
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		JavascriptExecutor SelectAllSearchScrollUP = (JavascriptExecutor)driver;
		SelectAllSearchScrollUP.executeScript("arguments[0].scrollIntoView();", SelectAllChBxes );
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"collapse1\"]/div/div[4]/div/div[2]/div[3]/label")).click();
		//SelectAllChBxes.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		SSDProtfolioLink.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		JavascriptExecutor SelectAllSearchResultScroll = (JavascriptExecutor)driver;
		SelectAllSearchResultScroll.executeScript("arguments[0].scrollIntoView();", SSDRequriementslink );
		String ActualSSDRequirmentLabel = "125";
		String ExpectedSSDRequirmentLabel = SSDNumber.getText();
		System.out.println(ExpectedSSDRequirmentLabel);
		Assert.assertEquals(ActualSSDRequirmentLabel,ExpectedSSDRequirmentLabel);	
	}
	
	public void ResultDeselectAllBtn()
	{
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		JavascriptExecutor SelectAllSearchScrollUP = (JavascriptExecutor)driver;
		SelectAllSearchScrollUP.executeScript("arguments[0].scrollIntoView();", SSDRequriementslink );
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"collapse1\"]/div/div[4]/div/div[2]/div[3]/label")).click();
		//SelectAllChBxes.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		JavascriptExecutor SelectAllSearchResultScroll = (JavascriptExecutor)driver;
		SelectAllSearchResultScroll.executeScript("arguments[0].scrollIntoView();", SSDProtfolioLink );
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		String ActualSSDRequirmentLabel = "38";
		String ExpectedSSDRequirmentLabel = SSDNumber.getText();
		System.out.println(ExpectedSSDRequirmentLabel);
		Assert.assertEquals(ActualSSDRequirmentLabel,ExpectedSSDRequirmentLabel);	
	}
	public void ResultPageMainstream() throws InterruptedException
	{
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		JavascriptExecutor MixedSearchResultScrollDown = (JavascriptExecutor)driver;
		//MixedSearchResultScrollDown.executeScript("window.scrollBy(0,300)", "");
		MixedSearchResultScrollDown.executeScript("arguments[0].scrollIntoView();",BestAvailabilitylabel);
		MixedSearchResultScrollDown.executeScript("arguments[0].click();",MainstreamChk);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		MixedSearchResultScrollDown.executeScript("arguments[0].scrollIntoView();",SSDRequriementslink);
		Thread.sleep(1000);
		AlertMessageOk.click();
		
	}
	public boolean ResultWriteSeverType()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//String ActualServerTypeSelected = "HPE ProLiant BL C-Class                ";
		String ActualServerTypeSelected = "HPE ProLiant BL C-Class			";	
		String ExpectedServerTypeDisplays = driver.findElement(By.xpath("//*[@id=\"sel_server_type\"]/option[6]")).getText();
		//String ExpectedServerTypeDisplayed = SSDResultServertype.getText();
		Assert.assertEquals(ActualServerTypeSelected,ExpectedServerTypeDisplays);
		return SSDResultServertype.isDisplayed();
	}
	public boolean ResultWriteServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualServerModelSelected = "BL460c Gen10";
		String ExpectedServerModelDisplays = driver.findElement(By.xpath("//*[@id=\"BL460c Gen10\"]")).getText();
		//String ExpectedSeverModelSelected = SSDResultServerModeltype.getText();
		Assert.assertEquals(ActualServerModelSelected, ExpectedServerModelDisplays);
		return SSDResultServerModeltype.isDisplayed();
	}
	public void ResultDisplayServerModel()
	{
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		JavascriptExecutor SearchResultServerModelScrollDown = (JavascriptExecutor)driver;
		//MixedSearchResultScrollDown.executeScript("window.scrollBy(0,300)", "");
		SearchResultServerModelScrollDown.executeScript("arguments[0].scrollIntoView();",SSDRequriementslink);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	public void ResultInvalidSearch()
	{
		SSDSearch.sendKeys("ABCDEF");
		SSDSearchIcon.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		JavascriptExecutor SearchResultScroll = (JavascriptExecutor)driver;
		SearchResultScroll.executeScript("arguments[0].scrollIntoView();", SSDRequriementslink );
	}
	public void ResultScrollUP()
	{
		JavascriptExecutor ScrollUpRefineResult = (JavascriptExecutor)driver;
		ScrollUpRefineResult.executeScript("arguments[0].scrollIntoView();", ResultLink );
	}
	// Server Compactability 
	public boolean ReadMixedResultServerType()
	{
		String ActualServerTypeSelected = "HPE ProLiant 100 Series                ";
		String ExpectedServerTypeDisplays = driver.findElement(By.xpath("//*[@id=\"sel_server_type\"]/option[3]")).getText();
		//String ExpectedServerTypeDisplayed = SSDResultServertype.getText();
		Assert.assertEquals(ActualServerTypeSelected,ExpectedServerTypeDisplays);
		return SSDResultServertype.isDisplayed();
	}
	
	public boolean ReadMixedResultServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualServerModelSelected = "ML110 Gen10";
		String ExpectedServerModelDisplays = driver.findElement(By.xpath("//*[@id=\"ML110 Gen10\"]")).getText();
		//String ExpectedSeverModelSelected = SSDResultServerModeltype.getText();
		Assert.assertEquals(ActualServerModelSelected, ExpectedServerModelDisplays);
		return SSDResultServerModeltype.isDisplayed();
	}
	public void ResultPageSKUs()
	{
		List<WebElement> SSDSKU = driver.findElements(By.xpath("//*[@id=\"result_content\"]/div/span"));
		int i = SSDSKU.size();
		System.out.println(i);
		for (WebElement OptionSKU : SSDSKU)
		{
			System.out.println(OptionSKU.getText());
		}
	}
	public boolean SelectAllSelectedYes()
	{
		SelectAllYes.click();
		return true;
	}
	public boolean SelectAllSelectedNo()
	{
		SelectAllNo.click();
		return true;
	}
	public boolean MainstreamChkBxSelected()
	{
		return MainstreamChk.isSelected();
	}
	public boolean NonMainstreamChkBxSelected()
	{
		return NonMainstreamChk.isSelected();
	}
	public boolean MainstreamNonMainstream()
	{
		if(MainstreamChk.isSelected())
		{
			JavascriptExecutor SelectAll = (JavascriptExecutor)driver;
			SelectAll.executeScript("arguments[0].scrollIntoview();", SSDRequriementslink);
			String ActualString = "Mainstream";
			String ExpectedString = SSDMainstream.getText();
			Assert.assertEquals(ActualString, ExpectedString);
		}
		else
		{
			JavascriptExecutor SelectAll = (JavascriptExecutor)driver;
			SelectAll.executeScript("arguments[0].scrollIntoView();", SSDRequriementslink);
			String ActualString = "Non Mainstream";
			String ExpectedString = SSDNonMainstream.getText();
			Assert.assertEquals(ActualString, ExpectedString);
		}
		return true;
	}
	public boolean AllDownloadPDF() throws InterruptedException
	{
		String FileDownloadPath = System.getProperty("user.dir");
		DownloadAllPDFFile.click();
		Thread.sleep(5000);
		File DownloadFile = new File(FileDownloadPath+"/SSDResults.pdf");
		if(DownloadFile.exists())
		{
			System.out.println("PDF File Downloaded SucessFully");
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean ResultReadSeverType()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//String ActualServerTypeSelected = "HPE ProLiant BL C-Class                ";
		String ActualServerTypeSelected = "﻿﻿HPE ProLiant 300 Series																";	
		String ExpectedServerTypeDisplays = driver.findElement(By.xpath("//*[@id=\"sel_server_type\"]/option[4]")).getText();
		//String ExpectedServerTypeDisplayed = SSDResultServertype.getText();
		Assert.assertEquals(ActualServerTypeSelected,ExpectedServerTypeDisplays);
		return SSDResultServertype.isDisplayed();
	}
	public boolean ResultReadServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualServerModelSelected = "DL325 Gen10 Plus";
		String ExpectedServerModelDisplays = driver.findElement(By.xpath("//*[@id=\"sel_server_model\"]/option[4]")).getText();
		//String ExpectedSeverModelSelected = SSDResultServerModeltype.getText();
		Assert.assertEquals(ActualServerModelSelected, ExpectedServerModelDisplays);
		return SSDResultServerModeltype.isDisplayed();
	}
}
