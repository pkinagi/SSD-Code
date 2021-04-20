package SSDResource;

import org.apache.poi.ss.usermodel.charts.ChartData;
import org.apache.poi.xwpf.usermodel.examples.ChartFromScratch;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewConfigurer;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SSDExtentReportNG 
{
	static ExtentReports ResultsReport;
	public static ExtentReports getResultObject()
	{
		String ResultReportPath = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter testresults = new ExtentSparkReporter(ResultReportPath);
		testresults.config().setTimeStampFormat("EEEE,MMMM,dd,yyyy,hh:mm a '('zzz')'");
		testresults.config().setReportName("SSD Selector Tool Automation");
		testresults.config().setDocumentTitle("SSD Test Results");
		testresults.config().setTheme(Theme.STANDARD);
		ResultsReport = new ExtentReports();
		ResultsReport.attachReporter(testresults);
		ResultsReport.setSystemInfo("Tester", "Prashant Kinagi");
		return ResultsReport;
	}
}