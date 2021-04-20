package SSDResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseFile implements ConfigPath
{
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
}
