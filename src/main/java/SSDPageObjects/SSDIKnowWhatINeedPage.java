package SSDPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SSDResource.BaseClass;

public class SSDIKnowWhatINeedPage extends BaseClass
{
	@FindBy (xpath = "//*[@id=\"panel-ggroup1\"]/div/div[1]/h4/a/span[text()='Refine your results']")
	public
	WebElement IKnowResultText;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup1\"]/div/div[1]/h4/a")
	public
	WebElement IKnowResultLink;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup2\"]/div/div[1]/h4/a")
	public
	WebElement IKnowSSDProtfolioLink;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup2\"]/div/div[1]/h4/a/span[text()='SSD Portfolio Alignment']")
	public
	WebElement IKnowSSDProtfolioText;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a")
	public
	WebElement IKnowSSDRequriementslink;
	
	@FindBy (xpath = "//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a/span[text()='SSDs meet your requirements']")
	public
	WebElement IKnowSSDRequrimentsText;
	
	@FindBy (xpath = "//span[@id=\"printToLink\"]")
	WebElement IKnowPrint;
	
	@FindBy (xpath = "//span[@id=\"share_//\"]")
	WebElement IKnowhare;
	
	@FindBy (xpath = "//span[@id=\"feedbackLink\"]")
	WebElement IKnowFeedback;
	
	@FindBy (xpath = "//span[@id=\"startOverLink\"]")
	WebElement IKnowStartOver;
	
	//SSDName 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div[1]")
	WebElement IKnowSSDName;
	
	//SSDSKU ID
	@FindBy (xpath = "//*[@id=\"result_content\"]/div/span")
	WebElement IKnowSSDSKUID;
	
	//SSD Mainstream
	@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div[2]")
	WebElement IKnowSSDMainstream;
	
	//SSD NonMainstream
	//@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[705]/div[2]/div[2]/div[2]/div[2]/span")
	@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div[2]/span")
	public
	WebElement IKnowSSDNonMainstream;
	
	//SSD Download
	@FindBy (xpath = "//*[@id=\"download_\"]")
	public
	WebElement IKnowSSDDownload;
	
	//SSDShowMore()
	@FindBy (xpath = "//button[@class='btn_showmore accordionSubtitle']")
	public
	WebElement IKnowSSDShowMore;
	
	//SSDShowless()
	@FindBy (xpath = "//button[@class='btn_showmore accordionSubtitle']")
	WebElement IKnowSSDShowLess;
	
	//SSDImage()
	@FindBy (xpath = "//*[@id=\"result_content\"]")
	WebElement IKnowSSDImage;
	
	// Options Selected XPath For SSD Types, Interface Type, FormFactor Types, Certificates and Mainstream
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_RI\"]")
	WebElement SSDReadResultSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_MU\"]")
	WebElement SSDMixedResultSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_WI\"]")
	WebElement SSDWriteResultSelectSSD;
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_VRO\"]")
	WebElement SSDVROResultSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_SAS\"]")
	public
	WebElement SSDInterfaceSelectedSAS;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_SATA\"]")
	public
	WebElement SSDInterfaceSelectedSATA;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_NVMe\"]")
	public
	WebElement SSDInterfaceSelectedNVMe;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_VALUESAS\"]")
	public
	WebElement SSDInterfaceSelectedValueSAS;
	
	@FindBy (xpath = "//*[@id=\"id-ssdInterfaceType_SATAVRO\"]")
	public
	WebElement SSDInterfaceSelectedSATAVRO;
	
	@FindBy (xpath = "//*[@id=\"id-ssdFormFactor_AIC\"]")
	public
	WebElement SSDFormFactorAddInCard;
	
	@FindBy (xpath = "//*[@id=\"id-ssdFormFactor_LFF\"]")
	public
	WebElement SSDFormFactorLFF;
	
	@FindBy (xpath = "//*[@id=\"id-ssdFormFactor_SFF\"]")
	public
	WebElement SSDFormFactorSFF;
	
	@FindBy (xpath = "//*[@id=\"id-ssdFormFactor_M2\"]")
	public
	WebElement SSDFormFactorM2;
	
	@FindBy(xpath = "//*[@id=\"id-ssdFormFactor_M2e\"]")
	public
	WebElement SSDFormFactorM2EKit;
	
	@FindBy(xpath = "//*[@id=\"id-certifications_0\"]")
	WebElement vSANCertification;
	
	@FindBy(xpath = "//*[@id=\"id-certifications_1\"]")
	WebElement MSServer2016Certification;
	
	@FindBy(xpath = "//*[@id=\"id-certifications_2\"]")
	WebElement SDDCCertification;
	
	@FindBy (xpath = "//*[@id=\"stream_Yes\"]")
	public
	WebElement MainstreamClick;
	
	@FindBy (xpath = "//*[@id=\"stream_No\"]")
	public
	WebElement NonMainstreamClick;
	
	@FindBy (xpath = "//*[@id=\"id-refineYourResults\"]")
	WebElement IKnowSelectAll;
	
	// SSD-Read Intensive 
	@FindBy (xpath = "//div[contains(text(),'Read Intensive')]")
	WebElement SSDReadIntensiveResults;
	
	@FindBy (xpath = "//div[contains(text(),'Mixed Use')]")
	WebElement SSDMixedUseResults;
	
	@FindBy (xpath = "//div[contains(text(),'Write Intensive')]")
	WebElement SSDWriteIntensiveResults;
	
	@FindBy (xpath = "//div[contains(text(),'Very Read Optimized')]")
	WebElement SSDVRO;
	
	// Interface Types
	@FindBy (xpath = "//div[contains(text(),'SAS')]")
	WebElement SSDInterSASResults;
	
	@FindBy (xpath = "//div[contains(text(),'SATA')]")
	WebElement SSDInterSATAResults;
	
	@FindBy (xpath = "//div[contains(text(),'NVMe')]")
	WebElement SSDInterNVMeResults;
	
	@FindBy (xpath = "//div[contains(text(),'Value SAS')]")
	WebElement SSDInterValueSASResults;
	
	@FindBy (xpath = "//div[contains(text(),'SFF')]")
	WebElement SSDFormFSFFResults;

	@FindBy (xpath = "//div[contains(text(),'LFF')]")
	WebElement SSDFormFLFFResults;
	
	@FindBy (xpath = "//div[contains(text(),'M.2')]")
	WebElement SSDFormFM2Results;
	
	@FindBy (xpath = "//div[contains(text(),'M.2 SSD')]")
	WebElement SSDFormFM2EResults;
	
	// Results not found
	@FindBy (xpath = "//div[@id=\"collapse3\"]/div[text()]")
	public
	WebElement SSDNoResults;
	
	// SSD Mainstream Results
	@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div[2]/span")
	public
	WebElement SSDMainstream;
	
	// Certifications xpath
	@FindBy (xpath = "//*[@id=\"id-certifications_0\"]")
	WebElement SSDCertificationVSAN;
	
	@FindBy (xpath = "//*[@id=\"id-certifications_1\"]")
	WebElement SSDCertificationMS2016;
	
	@FindBy (xpath = "//*[@id=\"id-certifications_2\"]")
	WebElement SSDCertificationSDDC;
	
	@FindBy (xpath = "//*[@id=\"stream_Yes\"]")
	WebElement SSDIKnowMainstream;
	
	@FindBy (xpath = "//*[@id=\"stream_No\"]")
	WebElement SSDIKnowNonMainstream;
	
	@FindBy (xpath = "//*[@id=\"id-refineYourResults\"]")
	public
	WebElement SSDIKnowSelectAll;
	
	//@FindBy (xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/p[1]")
	@FindBy (css = "#collapse3 > div > div > div > div > div > p:nth-child(1)")
	public
	WebElement	SSDNoResultsAvailable;
	
	//Alert Message
	@FindBy (xpath = "//*[@id=\"jconfirm-box68243\"]/div/text()")
	public
	WebElement BestAvailAlertMessage;
	
	@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button")
	public
	WebElement AlertMessageOk;
	
	@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div")
	public
	WebElement AlertMessage;

	@FindBy (xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[3]")
	public
	WebElement AlertMessageText;
	
	//Search Tab
	@FindBy (xpath = "//*[@id=\"searchfield\"]")
	public
	WebElement SSDSearch;
	
	//SSD Search Icon
	@FindBy (xpath = "//*[@id=\"icon-search\"]")
	public
	WebElement SSDSearchIcon;
	
	//Loader Icon
	@FindBy (xpath = "//*[@id=\"mainContent\"]/div[5]/div[3]")
	public
	WebElement SSDLoader;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 //Initialization
	public SSDIKnowWhatINeedPage()
	{

		PageFactory.initElements(driver, this);
	}
	
	public void ClickRefineYourResults()
	{
		IKnowResultLink.click();
	}
	public boolean ReadIntensiveSelected()
	{
		return SSDReadResultSelected.isSelected();
	}
	
	public boolean MixedUseSelected()
	{
		return SSDMixedResultSelected.isSelected();
	}
	
	public boolean WriteSSDSelected()
	{
		return SSDWriteResultSelectSSD.isSelected();
	}
	
	public boolean VROSelected()
	{
		return false;
	}
	
	public boolean InterfaceSASSelected()
	{
		return SSDInterfaceSelectedSAS.isSelected();
	}
	
	public boolean InterfaceSATASelected()
	{
		return SSDInterfaceSelectedSATA.isSelected();
	}
	
	public boolean IntefaceNVMeSelected()
	{
		return SSDInterfaceSelectedNVMe.isSelected();
	}
	
	public boolean FormFactorLFFSelected()
	{
		return SSDFormFactorLFF.isSelected();
	}
	
	public boolean FormFactorSFFSelected()
	{
		return SSDFormFactorSFF.isSelected();
	}
	public boolean FormFactorM2Selected()
	{
		return SSDFormFactorM2.isSelected();
	}
	public boolean FormFactorM2EnablementKitSelected()
	{
		return SSDFormFactorM2EKit.isSelected();
	}
	public boolean FormFactorAddInCardSelected()
	{
		return SSDFormFactorAddInCard.isSelected();
	}
	public boolean CertificationsVSanSelected()
	{
		SSDCertificationVSAN.isSelected();
		return false;
	}
	public boolean CertificationsMS2016Selected()
	{
		return SSDCertificationMS2016.isSelected();
	}
	public boolean CertificationsSDDCSelected()
	{
		return SSDCertificationSDDC.isSelected();
	}
	public boolean BestAvailabilityMainstreamSelected()
	{
		return SSDIKnowMainstream.isSelected();
	}
	public boolean BestAvailabilityNonMainstreamSelected()
	{
		return SSDIKnowNonMainstream.isSelected();
	}
	public boolean SelectAllOption()
	{
		return SSDIKnowSelectAll.isSelected();
	}
	
	public void ClickSelectAllOption()
	{
		SSDIKnowSelectAll.click();
	}
	
	
	public boolean OnlyReadIntensiveSelected() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor MixedClick = (JavascriptExecutor)driver;
		MixedClick.executeScript("arguments[0].click()",SSDMixedResultSelected);
		Thread.sleep(1000);
		MixedClick.executeScript("arguments[0].click()",SSDWriteResultSelectSSD);
		Thread.sleep(1000);
		MixedClick.executeScript("arguments[0].click()",SSDVROResultSelected);
		if (SSDReadResultSelected.isSelected())
		{
			System.out.println(SSDReadIntensiveResults.isDisplayed());
			System.out.println("SSD Read Intensive  " + SSDReadIntensiveResults.getText());
		}
		else 
		{
			System.out.println(SSDWriteResultSelectSSD.isDisplayed());
		}
		return SSDReadIntensiveResults.isDisplayed();
	}
	
	public boolean OnlySASIsSelected() throws InterruptedException
	{
		JavascriptExecutor InterfaceTypeClick = (JavascriptExecutor)driver;
		//InterfaceTypeClick.executeScript("arguments[0].click()",SSDInterfaceSelectedSATA);
		Thread.sleep(1000);
		//InterfaceTypeClick.executeScript("arguments[0].click()",SSDInterfaceSelectedNVMe);
		Thread.sleep(1000);
		InterfaceTypeClick.executeScript("arguments[0].click()",SSDInterfaceSelectedSAS);
		if(SSDInterfaceSelectedSAS.isSelected())
		{
			if(SSDFormFactorSFF.isDisplayed())
			{
				System.out.println(SSDInterSASResults.isDisplayed());
				System.out.println("2.5 SFF SAS Results " + SSDFormFSFFResults.getText());
			}
			else if(SSDFormFactorLFF.isDisplayed())
			{
				System.out.println("3.5 LFf SAS Results " + SSDFormFLFFResults.getText());
			}
			
		}
		else 
		{
			System.out.println(SSDInterSATAResults.isDisplayed());
			System.out.println(SSDInterSATAResults.getText());
			
		}
		return SSDInterSASResults.isDisplayed();
	}
	
	public boolean OnlySATIsSelected() throws InterruptedException
	{
		JavascriptExecutor InterfaceTypeClick = (JavascriptExecutor)driver;
		InterfaceTypeClick.executeScript("arguments[0].click()", SSDInterfaceSelectedSAS);
		Thread.sleep(1000);
		InterfaceTypeClick.executeScript("arguments[0].click()", SSDInterfaceSelectedSATA);
		//InterfaceTypeClick.executeScript("arguments[0].click()", SSDInterfaceSelectedNVMe);
		if(SSDInterfaceSelectedSATA.isSelected())
		{
			if(SSDFormFactorSFF.isDisplayed())
			{
				System.out.println(SSDInterSATAResults.isDisplayed());
				System.out.println("2.5 SFF with SATA Results " + SSDFormFSFFResults.getText());
			}
			else if(SSDFormFactorLFF.isDisplayed())
			{
				System.out.println("3.5 LFF With SATA Results "+ SSDFormFLFFResults.getText());
			}
			else if(SSDFormFactorSFF.isDisplayed() && SSDFormFactorLFF.isDisplayed())
			{
				System.out.println("2.5 SFF with SATA Results " + SSDFormFSFFResults.getText());
				System.out.println("3.5 LFF With SATA Results "+ SSDFormFLFFResults.getText());
			}
		}
		else
		{
			System.out.println(SSDInterSASResults.isDisplayed());
			System.out.println(SSDInterSASResults.getText());
		}
		return SSDInterSATAResults.isDisplayed();
	}
	public boolean OnlyNVMeIsSelected() throws InterruptedException
	{
		JavascriptExecutor InterfaceTypeClick = (JavascriptExecutor)driver;
		InterfaceTypeClick.executeScript("arguments[0].click()", SSDInterfaceSelectedSATA);
		Thread.sleep(2000);
		InterfaceTypeClick.executeScript("arguments[0].click()", SSDInterfaceSelectedNVMe);
		if(SSDInterfaceSelectedNVMe.isSelected())
		{
			if (SSDInterSATAResults.isDisplayed() || SSDInterSASResults.isDisplayed())
			{
				System.out.println("NVMe result are not there in the Read Intensive ");
				return true;
			}
			else if(SSDInterfaceSelectedNVMe.isSelected())
			{
				SSDInterNVMeResults.isDisplayed();
			}
		}
		return SSDInterNVMeResults.isDisplayed();
	}
	public boolean OnlyValueSASSelected() throws InterruptedException 
	{
		JavascriptExecutor InterfaceTypeClick = (JavascriptExecutor)driver;
		InterfaceTypeClick.executeScript("arguments[0].click()", SSDInterfaceSelectedNVMe);
		Thread.sleep(1000);
		InterfaceTypeClick.executeScript("arguments[0].click()", SSDInterfaceSelectedValueSAS);
		if(SSDInterfaceSelectedValueSAS.isSelected())
		{
			if(SSDFormFactorSFF.isDisplayed())
			{
				System.out.println(SSDInterValueSASResults.isDisplayed());
				System.out.println("2.5 SFF with ValueSAS Results " + SSDFormFSFFResults.getText());
			}
			else if(SSDFormFactorLFF.isDisplayed())
			{
				System.out.println("3.5 LFF With ValueSAS Results "+ SSDFormFLFFResults.getText());
			}
			else if(SSDFormFactorSFF.isDisplayed() && SSDFormFactorLFF.isDisplayed())
			{
				System.out.println("2.5 SFF with ValueSAS Results " + SSDFormFSFFResults.getText());
				System.out.println("3.5 LFF With ValueSAS Results "+ SSDFormFLFFResults.getText());
			}
		}
		else
		{
			System.out.println(SSDInterValueSASResults.isDisplayed());
			System.out.println(SSDInterValueSASResults.getText());
		}
		return SSDInterValueSASResults.isDisplayed();
	}
	public boolean OnlyAddInCardIsSelected()
	{
		JavascriptExecutor FormFactorTypeAddInClick = (JavascriptExecutor)driver;
		FormFactorTypeAddInClick.executeScript("arguments[0].click()", SSDFormFactorAddInCard);
		return true;
	}
	
	public boolean OnlyM2IsSelected()
	{
		JavascriptExecutor FormFactorTypeM2Click = (JavascriptExecutor)driver;
		FormFactorTypeM2Click.executeScript("arguments[0].click()", SSDFormFactorAddInCard);
		FormFactorTypeM2Click.executeScript("arguments[0].click()", SSDFormFactorM2);
		if(SSDFormFactorM2.isSelected())
		{
			if(SSDFormFactorSFF.isDisplayed())
			{
				System.out.println(SSDInterValueSASResults.isDisplayed());
				System.out.println("2.5 SFF with ValueSAS Results " + SSDFormFSFFResults.getText());
				return false;
			}
			else
			{
				return SSDFormFM2Results.isDisplayed();
			}
		}
		else
		{
			System.out.println(SSDFormFM2Results.isDisplayed());
			System.out.println(SSDFormFM2Results.getText());
		}
		return SSDFormFM2Results.isDisplayed();
	}
	
	public boolean OnlyM2EIsSelected()
	{
		JavascriptExecutor FormFactorTypeM2eClick = (JavascriptExecutor)driver;
		FormFactorTypeM2eClick.executeScript("arguments[0].click()", SSDFormFactorM2);
		FormFactorTypeM2eClick.executeScript("arguments[0].click()", SSDFormFactorM2EKit);
		if(SSDFormFactorM2EKit.isSelected())
		{
			if( SSDFormFactorLFF.isDisplayed() || SSDFormFactorSFF.isDisplayed() )
			{
				System.out.println("SFF and LFF Result should be seen");
				return false;
			}
			else
			{
				return SSDFormFM2EResults.isDisplayed();
			}
		}
		return SSDFormFM2EResults.isDisplayed();
	}
	public boolean OnlyLFFIsSelected() throws InterruptedException
	{
		JavascriptExecutor FormFactorTypeClick = (JavascriptExecutor)driver;
		FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorM2EKit);
		//FormFactorTypeClick.executeScript("arguments[0].click()", SSDInterfaceSelectedValueSAS);
		Thread.sleep(1000);
		//FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorAddInCard);
		//Thread.sleep(1000);
		FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorLFF);
		Thread.sleep(1000);
		//FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorSFF);
		//Thread.sleep(1000);
		//FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorM2);
		//Thread.sleep(2000);
		
		if(SSDFormFactorLFF.isSelected())
		{
			if(SSDFormFLFFResults.isDisplayed() == true)
			{
				SSDFormFLFFResults.isDisplayed();
				
			}
			else
			{
				System.out.println(SSDNoResults.getText());
			}
		}
		else
		{
			System.out.println(SSDNoResults.getText());
		}
		return SSDFormFLFFResults.isDisplayed();
	}
	public boolean OnlySSFIsSelected() throws InterruptedException
	{
		JavascriptExecutor FormFactorTypeClick = (JavascriptExecutor)driver;
		FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorLFF);
		Thread.sleep(2000);
		FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorSFF);
		if(SSDFormFactorSFF.isSelected())
		{
			System.out.println(SSDFormFSFFResults.isDisplayed());
			
		}
		else
		{
			System.out.println(SSDNoResults.getText());
		}
		return SSDFormFSFFResults.isDisplayed();
	}
	public boolean OnlyFFIsUnSelected() throws InterruptedException
	{
		JavascriptExecutor FormFactorTypeClick = (JavascriptExecutor)driver;
		FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorSFF);
		Thread.sleep(1000);
		//FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorLFF);
		Thread.sleep(2000);
		FormFactorTypeClick.executeScript("arguments[0].click()", SSDFormFactorAddInCard);
		if(SSDInterfaceSelectedNVMe.isSelected() || SSDInterfaceSelectedSATA.isDisplayed() || SSDInterfaceSelectedSAS.isDisplayed())
		{
			if(SSDFormFLFFResults.isDisplayed())
			{
				System.out.println(SSDFormFLFFResults.isDisplayed());
			}
			else if(SSDFormFSFFResults.isDisplayed())
			{
				System.out.println(SSDFormFSFFResults.isDisplayed());
			}
			else
			{
				System.out.println(SSDNoResults.getText());
			}	
		}
		else
		{
			System.out.println(SSDNoResults.getText());
		}
		FormFactorTypeClick.executeScript("arguments[0].click()",SSDInterfaceSelectedSAS);
		return SSDFormFLFFResults.isDisplayed() && SSDFormFSFFResults.isDisplayed();
	}
	public void NonMainstreamSSDResults()
	{
		JavascriptExecutor ScrollDown = (JavascriptExecutor)driver;
		ScrollDown.executeScript("arguments[0].click()", MainstreamClick);
	}
	public void MainstreamSSDResults()
	{
		JavascriptExecutor MStreamClick = (JavascriptExecutor)driver;
		MStreamClick.executeScript("arguments[0].click()", NonMainstreamClick);
	}
	
	public boolean SearchSSDResult()
	{
		JavascriptExecutor IKnowResult = (JavascriptExecutor)driver;
		WebDriverWait SSDWait = new WebDriverWait(driver, 20);
		IKnowResult.executeScript("arguments[0].scrollIntoView();",IKnowResultLink);
		SSDSearch.sendKeys("Powo");
		SSDSearchIcon.click();
		IKnowResult.executeScript("arguments[0].scrollIntoView()",IKnowSSDRequriementslink);
		SSDWait.until(ExpectedConditions.textToBePresentInElement(IKnowSSDRequriementslink, "0 -  SSDs meet your requirements"));
		return SSDNoResults.isDisplayed();
	}
	
	public void ClearSearchTab()
	{
		JavascriptExecutor IKnowSSDsResults = (JavascriptExecutor)driver;
		WebDriverWait SSDWait = new WebDriverWait(driver, 20);
		IKnowSSDsResults.executeScript("arguments[0].scrollIntoView();",IKnowResultLink);
		SSDSearch.clear();
		SSDSearch.sendKeys(Keys.ENTER);
		IKnowSSDsResults.executeScript("arguments[0].scrollIntoView();",IKnowSSDRequriementslink);
		SSDWait.until(ExpectedConditions.textToBePresentInElement(IKnowSSDRequriementslink, "77 -  SSDs meet your requirements"));
	}
	
	public void LoaderImage()
	{
		if(SSDLoader.isDisplayed())
		{
			
		}
	}
}
