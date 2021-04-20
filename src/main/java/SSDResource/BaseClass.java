package SSDResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.commons.io.FileUtils;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseClass implements ConfigPath
{
	public static  WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static Properties prop;
	public String ConfigFilePath = ".\\src\\main\\java\\Config\\config.Properties";
	public String TestDataPath = ".\\TestData\\TestDataFile.xlsx";
	
	public static Map <String, Object[]> testresultdata;
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	
	static 
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	public BaseClass()
	{
		;
		try
		{
			prop = new Properties();
			FileInputStream input = new FileInputStream(ConfigFilePath);
			prop.load(input);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void Intialization()
	{
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Test Results");
		testresultdata = new LinkedHashMap<String, Object[]>();
		testresultdata.put("1", new Object[] {"Test ID", "Action", "Excepted Results", "Actual Results"});
		//String Browsername = prop.getProperty("browser");
		// To Integration with Jenkins for Selecting the Browser 
		//mvn test -DBrowsername=chrome
		
		String Browsername = System.getProperty("browser");
		String FileDownloadPath = System.getProperty("user.dir");
		HashMap<String,Object> chromPerfs = new HashMap<String, Object>();
		chromPerfs.put("profile.default_content_settings.popups",0);
		chromPerfs.put("download.default_directory",FileDownloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs",chromPerfs);
		
		
		if(Browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			driver = new ChromeDriver(options);
			
		}
		else if (Browsername.equals("MicrosoftEdge"))
		{
			System.setProperty("webdriver.edge.driver", ".\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if (Browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		driver = e_driver;
		driver.manage().window().maximize();  // Maximize the Window
		driver.manage().deleteAllCookies();   // Delete the Cookies in the Browser
		System.out.println("------!!Specified URL is Launched in the Browser!!-------------");
		driver.get(prop.getProperty("URL"));   // For Launching the URL
		
	}
	
	// Takes a Screenshot for Failed TestCases
	public String TakeScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		Date dt = new Date();
		String CurrentDate = dt.toString().replace(":", "_");
		//TakesScreenshot TakeScreen = (TakesScreenshot) driver;
		//File SrcFile = TakeScreen.getScreenshotAs(OutputType.FILE);
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir")+"\\Reports\\"+testCaseName+".png";
		FileUtils.copyFile(SrcFile, new File(DestinationFile));
		//File DstFile = new File(".\\ScreenShots\\"+CurrentDate+testCaseName+"_ScreenShot.png");
		/*try
		{
			FileHandler.copy(SrcFile, DstFile);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}*/
		return DestinationFile;
	}
	// Get Screen Shot 
	
	public void ReadExcelFile(String FilePath, String FileName, String SheetName) throws IOException
	{
		File file = new File(FilePath+"\\"+FileName);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook Readworkbook = null;
		
		String fileExtensionName = FileName.substring(FileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx"))
		{
			Readworkbook = new XSSFWorkbook(inputStream);
			
		}
		else if(fileExtensionName.equals(".xls"))
		{
			Readworkbook = new HSSFWorkbook(inputStream);
		}
		// Read Sheet Name in the Excel File
		Sheet ReadSheet = Readworkbook.getSheet(SheetName);
		//Find the Total Number of Rows
		int rowcount = ReadSheet.getLastRowNum()-ReadSheet.getFirstRowNum();
		//Create
		for(int i = 0; i < rowcount ; i++)
		{
			Row row = ReadSheet.getRow(i);
			for(int j = 0; j < row.getLastCellNum(); j++)
			{
				System.out.println(row.getCell(j).getStringCellValue()+"||");
			}
		}
		System.out.println();
	}
	
	public void WriteExcelFile(String WriteFilePath,String WriteFileName, String WriteSheetName,String[] dataToWrite) throws IOException
	{
		File fileWrite = new File(WriteFilePath+"\\"+WriteFileName);
		
		FileInputStream inputStream = new FileInputStream(fileWrite);
		Workbook Writeworkbook = null;
		String fileExtensionName = WriteFilePath.substring(WriteFileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx"))
		{
			Writeworkbook = new XSSFWorkbook(inputStream);
			
		}
		else if(fileExtensionName.equals(".xls"))
		{
			Writeworkbook = new HSSFWorkbook(inputStream);
		}
		Sheet Writesheet = Writeworkbook.getSheet(WriteSheetName);
		
		int rowcount = Writesheet.getLastRowNum()-Writesheet.getFirstRowNum();
		// To Get 1st Row from the Sheet
		Row row = Writesheet.getRow(0);
		// To Create New Row and Append it at last of Sheet
		Row NewRow = Writesheet.createRow(rowcount+1);
		//loop for Writing to a file
		for(int j = 0; j < row.getLastCellNum(); j++)
		{
			Cell cell = NewRow.createCell(j);
			cell.setCellValue(dataToWrite[j]);
		}
		//Close input Stream
		inputStream.close();
		//Create an Object  of FileOutputStream class to Create Write Data in Excel file
		FileOutputStream Writeoutputstream = new FileOutputStream(fileWrite);
		// To Write Data to Excel File
		Writeworkbook.write(Writeoutputstream);
		Writeoutputstream.close();
	}
	
	public void setupAfterSuite()
	{
		Set<String> keyset = testresultdata.keySet();
		int rownum = 0;
		for(String key : keyset)
		{
			Row row = sheet.createRow(rownum++);
			Object [] objArr = testresultdata.get(key);
			int cellnum = 0;
			for(Object obj : objArr)
			{
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof Date)
					cell.setCellValue((Date)obj);
				else if(obj instanceof Boolean)
					cell.setCellValue((Boolean)obj);
				else if(obj instanceof String)
					cell.setCellFormula((String)obj);
				else if(obj instanceof Double)
					cell.setCellValue((Double)obj);	
			}
		}
		try
		{
			FileOutputStream fileout = new FileOutputStream(new File ("TestResult.xls"));
			workbook.write(fileout);
			fileout.close();
			System.out.println("!!!............Excel Written Successfully........!!!");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
