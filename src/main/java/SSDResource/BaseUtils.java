package SSDResource;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class BaseUtils implements ConfigPath
{
	public static Workbook wb;
	public static String getProperty(String CONFIG_PATH,String key)
	{
		String Property = "";
		Properties Prop = new Properties();
		try
		{
			Prop.load(new FileInputStream(CONFIG_PATH));
			Property = Prop.getProperty(key);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return Property;
	}
	
	public static int getRowCount(String EXCEL_PATH,String Sheet)
	{
		int RowCount = 0;
		try
		{
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			RowCount = wb.getSheet(Sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return RowCount;
	}
	
	public static String getCellValue(String EXCEL_PATH,String Sheet, int row,int column)
	{
		String Value = "";
		try
		{
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			Value = wb.getSheet(Sheet).getRow(row).getCell(column).toString();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return Value;
	}
	/*public static void captureScreenshot(WebDriver driver,String testcaseName)
	{
			Date dt = new Date();
			String CurrentDate = dt.toString().replaceAll(":", "_");
			TakesScreenshot ts2 = (TakesScreenshot) driver;
			File SrcFile2 = ts2.getScreenshotAs(OutputType.FILE);
		    File DstFile2 = new File(".\\ScreenShots\\"+CurrentDate+"\\"+testcaseName+"_screenshot.png");
		    try
		    {
		    	
		    FileHandler.copy(SrcFile2,DstFile2);
		    }
		catch(Exception e)
		{
			System.out.println(e);
		}
	} */
}
