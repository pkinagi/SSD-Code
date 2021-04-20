package SSDPageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import SSDResource.BaseClass;

public class SSDServermodelPage extends BaseClass
{
	SSDResultPage ssdResultpage;
	//Declarations
	@FindBy (xpath = "//select[@id=\"sel_server_type\"]")
	WebElement SelectServer;
	
	@FindBy (xpath = "//select[@id=\"sel_server_model\"]")
	WebElement SelectServerModel;
	
	//Target Workload Tables
	@FindBy (xpath = "//*[@id=\"workload_comparision_table\"]/tbody/tr[1]")
	WebElement TargetWorkloads;
	
	//Target Workload Whole table
	@FindBy (xpath = "//*[@id=\"workload_comparision_table\"]/tbody")
	WebElement WholeTable;
	
	//Server Type Back Button
	@FindBy (xpath = "//button[@id=\"backQuestion_btn\"]/span[text()='Back']")
	WebElement ServerTypeBackBtn;
	
	//Select All
	@FindBy (xpath = "//span[@class = \"sel_all\"]")
	WebElement ServerModelSelectBtn;
	
	//Next Button in Server Type Page
	@FindBy (xpath = "//button[@id=\"nextQuestion_btn\"]")
	WebElement ServerTypeNextBtn;
	
	
	
	//Intialization
	
	public SSDServermodelPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean ClickServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		//Get All Server Types
		List<WebElement> AllServerTypes = serverType.getOptions();
		String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
			//return true;
		}
		else
		{
			System.out.println("Server Types are not matching");
			//return false;
		}	
		serverType.selectByVisibleText("HPE Apollo Systems");	
		return SelectServer.isDisplayed();
	}
	
	public void ClickSeverModel()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor ClickModel = (JavascriptExecutor)driver;
		ClickModel.executeScript("arguments[0].click()", SelectServerModel);
		//SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ModelType.selectByVisibleText("Apollo 2000 - XL170r Gen10");		
	}
	
	public void ShowReadTargetWorkload()
	{
		// Storing the Workload selected from the Workload Page
		int  SelectWorkloads = 12;
		for (int i = 1; i <=SelectWorkloads; i++)
		{
			String WorkloadValue = driver.findElement(By.xpath("//*[@id=\"workload_comparision_table\"]/tbody/tr[" + i + "]")).getText();
			System.out.println("!--------------Read Selected Workloads are ----------------! " + WorkloadValue);	
		}
	}
	
	public void ShowsTargetWorkload()
	{
		// Storing the Workload selected from the Workload Page
		int  SelectWorkloads = 12;
		for (int i = 1; i <=SelectWorkloads; i++)
		{
			String WorkloadValue = driver.findElement(By.xpath("//*[@id=\"workload_comparision_table\"]/tbody/tr[" + i + "]")).getText();
			System.out.println("!-------------Selected Read Workloads are ----------------! " + WorkloadValue);	
		}
	}
	public boolean TargetDisplayed()
	{
		return WholeTable.isDisplayed();
	}
	
	public void ServerModelTypeBackBtn()
	{
		ServerTypeBackBtn.click();
	}
	
	public boolean SeverTypeModelSelectAll()
	{
		return ServerModelSelectBtn.isDisplayed();
	}
	
	public boolean ServerTypeModelSelected()
	{
		ServerModelSelectBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ServerModelSelectBtn.click();
		return ServerTypeNextBtn.isEnabled();
	}
	
	public void ServerTypeNextBtn()
	{
		ServerTypeNextBtn.click();
	}
	
	public boolean ServerTypeNxtBtn()
	{
		return ServerTypeNextBtn.isEnabled();
	}
	
	public void SMSelectAll()
	{
		ServerModelSelectBtn.click();
	}
	public void MixedTargetLoadDisplays()
	{
		int  SelectWorkloads = 9;
		for (int i = 1; i <=SelectWorkloads; i++)
		{
			String WorkloadValue = driver.findElement(By.xpath("//*[@id=\"workload_comparision_table\"]/tbody/tr[" + i + "]")).getText();
			System.out.println("Selected MixedUse Workloads are " + WorkloadValue);	
		}
	}
	public boolean MixedServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		//Get All Server Types
		List<WebElement> AllServerTypes = serverType.getOptions();
		String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
			System.out.println("Server Types are not matching");
		}
		serverType.selectByVisibleText("HPE Apollo Systems");	
		return SelectServer.isDisplayed();
	}
	public void MixedServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ModelType.selectByVisibleText("Apollo 2000 - XL170r Gen10");		
	}
	public void WriteTargetLoadDisplays()
	{
		int  SelectWorkloads = 14;
		for (int i = 1; i <=SelectWorkloads; i++)
		{
			String WorkloadValue = driver.findElement(By.xpath("//*[@id=\"workload_comparision_table\"]/tbody/tr[" + i + "]")).getText();
			System.out.println("Selected WRITE-Intensive Workloads are " + WorkloadValue);	
		}
	}
	public boolean WriteServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		//Get All Server Types
		List<WebElement> AllServerTypes = serverType.getOptions();
		String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
			System.out.println("Server Types are not matching");
		}
		serverType.selectByVisibleText("HPE ProLiant BL C-Class");	
		return SelectServer.isDisplayed();
	}
	public void WriteServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ModelType.selectByVisibleText("BL460c Gen10");		
	}

	public void VROTargetLoadDisplays()
	{
		int  SelectWorkloads = 8;
		for (int i = 1; i <=SelectWorkloads; i++)
		{
			String WorkloadValue = driver.findElement(By.xpath("//*[@id=\"workload_comparision_table\"]/tbody/tr[" + i + "]")).getText();
			System.out.println("Selected WRITE-Intensive Workloads are " + WorkloadValue);	
		}
	}
	public boolean VROServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		//Get All Server Types
		List<WebElement> AllServerTypes = serverType.getOptions();
		String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
			System.out.println("Server Types are not matching");
		}
		serverType.selectByVisibleText("HPE ProLiant BL C-Class");	
		return SelectServer.isDisplayed();
	}
	public void VROServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ModelType.selectByVisibleText("BL460c Gen10");		
	}
	public boolean ResultServerServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		//Get All Server Types
		List<WebElement> AllServerTypes = serverType.getOptions();
		//String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		String [] ServerTypeValues = {"Cloud Servers","Edgeline","HPE Apollo Systems","HPE Moonshot System","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant BL C-Class","HPE Synergy","Proliant Misc Servers"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
			System.out.println("Server Types are not matching");
		}
		serverType.selectByVisibleText("HPE ProLiant BL C-Class");	
		return SelectServer.isDisplayed();
	}
	public void ResultServerServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ModelType.selectByVisibleText("BL460c Gen10");		
	}
	public void SelectedWorkloadDisplay()
	{
		int  SelectWorkloads = 3;
		for (int i = 1; i <=SelectWorkloads; i++)
		{
			String WorkloadValue = driver.findElement(By.xpath("//*[@id=\"workload_comparision_table\"]/tbody/tr[" + i + "]")).getText();
			System.out.println("Selected WRITE-Intensive Workloads are " + WorkloadValue);	
		}
	}
	public boolean SelectedWorkloadServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		//Get All Server Types
		List<WebElement> AllServerTypes = serverType.getOptions();
	//String [] ServerTypeValues = {"Cloud Servers","Edgeline","HPE Apollo Systems","HPE Moonshot System","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant BL C-Class","HPE Synergy","Proliant Misc Servers"};
		String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
			System.out.println("Server Types are not matching");
		}
		serverType.selectByVisibleText("HPE ProLiant 300 Series");	
		return SelectServer.isDisplayed();
	}
	public void SelectedWorkedServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ModelType.selectByVisibleText("DL385 Gen10");		
	}
	public boolean ResultAllOptionServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		//Get All Server Types
		List<WebElement> AllServerTypes = serverType.getOptions();
		//String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		String [] ServerTypeValues = {"Cloud Servers","Edgeline","HPE Apollo Systems","HPE Moonshot System","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant BL C-Class","HPE Synergy","Proliant Misc Servers"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
			System.out.println("Server Types are not matching");
		}
		serverType.selectByVisibleText("HPE Synergy");	
		return SelectServer.isDisplayed();
	}
	public boolean ResultAllOptionServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ModelType.selectByVisibleText("Synergy 660 Gen10");		
		return SelectServerModel.isDisplayed();
	}
	public boolean ResultAllOptionSelectedDifferentServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		//Get All Server Types
		List<WebElement> AllServerTypes = serverType.getOptions();
		//String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		String [] ServerTypeValues = {"Cloud Servers","Edgeline","HPE Apollo Systems","HPE Moonshot System","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant BL C-Class","HPE Synergy","Proliant Misc Servers"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
			System.out.println("Server Types are not matching");
		}
		serverType.selectByVisibleText("HPE Apollo Systems");	
		return SelectServer.isDisplayed();
	}
	public void ResultAllOptionSelectedDifferentServerModelType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ModelType.selectByVisibleText("Apollo 4200 Gen10");		
	}
	// Combination of Read and Mixed Intensive
	public boolean ReadMixedServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		//Get All Server Types
		List<WebElement> AllServerTypes = serverType.getOptions();
		//String [] ServerTypeValues = {"Cloud Servers","Edgeline","HPE Apollo Systems","HPE Moonshot System","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant BL C-Class","HPE Synergy","Proliant Misc Servers"};
		String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
			System.out.println("Server Types are not matching");
		}
		serverType.selectByVisibleText("HPE ProLiant 100 Series");	
		return SelectServer.isDisplayed();
	}
	public void SelectReadMixedServerModel()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ModelType.selectByVisibleText("ML110 Gen10");		
	}
	//Select the Sever type in the Result Page
	public void ChangeServerModelType()
	{
		SelectServer.click();
		Select ServerType = new Select(SelectServer);
		List<WebElement> AllServerTypes = ServerType.getOptions();
		ServerType.selectByVisibleText("HPE ProLiant 500 Series");
	}
	public void ChangeServerTypeServerModel()
	{
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		ModelType.selectByVisibleText("DL560 Gen10");
	}
	public void ChangeSeverType() throws InterruptedException
	{
		SelectServer.click();
		Select ServerType = new Select(SelectServer);
		List<WebElement> AllServerTypes = ServerType.getOptions();
		int j,i = AllServerTypes.size();
		System.out.println("Server Types" + i);
		for(WebElement ServerTypesList : AllServerTypes)
			{
			System.out.println(ServerTypesList.getText());
			}
		for (j = 2; j <= i; j++)
		{
			//System.out.println(j + ServerTypesOptions1.getText());
			ServerType.selectByIndex(j);
			JavascriptExecutor ClickModel = (JavascriptExecutor)driver;
			ClickModel.executeScript("arguments[0].click()", SelectServerModel);
		//	SelectServerModel.click();
			Thread.sleep(2000);
		    ChangeServerModel();
		    if(j==11)
			{
				System.out.println(j+"Completed the Server Types");
				break;
			}
		}
		
		
		 //selectByVisibleText("HPE ProLiant 500 Series");
		//String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","HPE Moonshot System","Proliant Misc Servers","Cloud Servers","Edgeline"};
		/*String [] ServerTypeValues = {"Cloud Servers","Edgeline","HPE Apollo Systems","HPE Moonshot System","HPE ProLiant 10 Series","HPE ProLiant 100 Series","HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant BL C-Class","HPE Synergy","Proliant Misc Servers"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					System.out.println(ServerTypesOptions.getText());
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
		
			System.out.println("Server Types are not matching");
		}
		ServerType.selectByVisibleText("HPE ProLiant 500 Series");	*/
	}
	public void ChangeServerModel() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor ClickModel = (JavascriptExecutor)driver;
		ClickModel.executeScript("arguments[0].click()", SelectServerModel);
		//SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ModelType.getOptions();
		int k, l = AllServerModels.size();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		for (k = 1; k < l; k++)
		{
			//AllServerModels.get(k).click();
			ModelType.selectByIndex(k); //selectByVisibleText("DL560 Gen10");
			Thread.sleep(3000);	
			ServerModelResultDisplay();
		}
		Thread.sleep(1000);	
	}
	
	public void ServerModelResultDisplay() throws InterruptedException
	{
		ssdResultpage = new SSDResultPage();
		JavascriptExecutor ScrollUpRefineResult = (JavascriptExecutor)driver;
		ScrollUpRefineResult.executeScript("arguments[0].scrollIntoView();", ssdResultpage.SSDRequriementslink );
		System.out.println(ssdResultpage.SSDRequriementslink.getText());
		String ActualServerModelResults = "0 -  SSDs meet your requirements";
		String ExpectedServerModelResults = ssdResultpage.SSDRequriementslink.getText();
		if(ActualServerModelResults.equalsIgnoreCase(ExpectedServerModelResults))
		{
			System.out.println("For the Selected Server Type and Server Model Results are not there");
		}
		else
		{
			JavascriptExecutor ScrollUpRefineResults = (JavascriptExecutor)driver;
			ScrollUpRefineResults.executeScript("arguments[0].scrollIntoView();", ssdResultpage.SSDRequriementslink );
			ssdResultpage.ResultPageSKUs();
			ssdResultpage.SSDResultClickShowMore();
			Thread.sleep(2000);
			String ExpectedServerCompat = ssdResultpage.ServerCompact.getText();
			System.out.println(ExpectedServerCompat);
			if (ExpectedServerCompat.contains("Apollo 2000 - XL170r Gen10,Apollo 2000 - XL190r Gen10,Apollo 2000 - XL225n Gen10 Plus,Apollo 4200 Gen10,Apollo 4500 - XL450 Gen10,Apollo 6000 XL230k Gen10,Apollo 6500 XL270d Gen10,"));
			{
				System.out.println("Server Compatibility List is showing");
			}
		}
	 }
	
	// I Know What I Need
	
	public void SSDIKnowServerType() throws InterruptedException
	{
		Thread.sleep(2000);
		SelectServer.click();
		Select ServerType = new Select(SelectServer);
		List<WebElement> AllServerTypes = ServerType.getOptions();
		int j,i = AllServerTypes.size();
		System.out.println("Server Types" + i);
		for(WebElement ServerTypesList : AllServerTypes)
			{
				System.out.println(ServerTypesList.getText());
			}
		ServerType.selectByIndex(2);
	}
	
	public void SSDIKnowServerModel() 
	{
		SelectServerModel.click();
	}
	
	// Compare the Server Type and Server Model
	
	public boolean CompareServerTypeServerModelList() throws InterruptedException
	{
		SelectServer.click();
		Select ServerTypelist = new Select(SelectServer);
		List<WebElement> Serverlist = ServerTypelist.getOptions();
		String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems","Cloud Servers"};
		int i,j, Count = 0;
		j = Serverlist.size();
		for (i = 1; i <= ServerTypeValues.length; i++)
			{
				ServerTypelist.selectByIndex(i);
				Thread.sleep(1000);
				ClickCompareServerModellist();
				Count++;
				if(i == 7)
				{
					break;
				}
			}
		if(Count == ServerTypeValues.length)
		{
			System.out.println("Server Type and Server Model List is Showing Correct");
			return true;
		}
		else
		{
			System.out.println("Server Type and Server Model is MisMatch");
			return false;
		}
	}
	public void ClickCompareServerModellist()
	{
		SelectServerModel.click();
		Select ServerModelist = new Select(SelectServerModel);
		List<WebElement> ServerModel = ServerModelist.getOptions();
		List<String> ServerModelActualList =  new ArrayList();
		for( WebElement ServerM : ServerModel)
		{
			ServerModelActualList.add(ServerM.getText());
			System.out.println(ServerModelActualList);
	    }
	}
	public void SelectSeverTypeAndServerModel() throws InterruptedException
	{
		SelectServer.click();
		Select ServerType = new Select(SelectServer);
		ServerType.selectByIndex(2);
		Thread.sleep(1000);
		SelectServerModel.click();
		Select ModelType = new Select(SelectServerModel);
		ModelType.selectByIndex(2);
	}
	public boolean ReadSelectServerType()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectServer.click();
		Select serverType = new Select(SelectServer);
		List<WebElement> AllServerTypes = serverType.getOptions();
		String [] ServerTypeValues = {"HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant 100 Series","HPE ProLiant BL C-Class","HPE Synergy","HPE Apollo Systems"};
		int i = 0, count = 0;
		for (WebElement ServerTypesOptions : AllServerTypes)
		{
			for (i = 0; i < ServerTypeValues.length; i++)
			{
				if(ServerTypesOptions.getText().equals(ServerTypeValues[i]))
				{
					count++;
				}
			}
		}
		if (count == ServerTypeValues.length)
		{
			System.out.println("In Server type Drop Down Values are correct");
		}
		else
		{
			System.out.println("Server Types are not matching");
		}
		serverType.selectByVisibleText("HPE ProLiant 300 Series");
		return SelectServer.isDisplayed();
	}
	public void ReadSelectServerModel()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor ClickServerModel = (JavascriptExecutor)driver;
		ClickServerModel.executeScript("arguments[0].click()", SelectServerModel);
		//SelectServerModel.click();
		Select ServerModelType = new Select(SelectServerModel);
		List<WebElement> AllServerModels = ServerModelType.getOptions();
		for (WebElement ServerModelList : AllServerModels)
		{
			System.out.println(ServerModelList.getText());
		}
		ServerModelType.selectByVisibleText("DL325 Gen10 Plus");		
	}
}
