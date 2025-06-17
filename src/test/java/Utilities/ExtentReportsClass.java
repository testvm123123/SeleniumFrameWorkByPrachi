package Utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsClass implements ITestListener {

	public static ExtentSparkReporter spark;
	public static ExtentReports reports;
	public static ExtentTest etest;

	public void onStart(ITestContext Context) {

		spark = new ExtentSparkReporter(
				"C:\\Users\\ThirupathiAnnarapu\\Desktop\\RestAssured\\SeleniumFrameWorkByPrachi\\EReport\\EReportsv.html");
		spark.config().setDocumentTitle("ex reports Doc");
		spark.config().setReportName("ex reports");
		spark.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();

		reports.attachReporter(spark);

		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("system", "windows");

	}

	public void onTestSuccess(ITestResult result) {
		etest = reports.createTest(result.getName());
		etest.log(Status.PASS, "Test Passed" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		etest = reports.createTest(result.getName());
		etest.log(Status.FAIL, "Test failed:" + result.getName());
		// C:\Users\ThirupathiAnnarapu\Desktop\RestAssured\SeleniumFrameWorkByPrachi\screenshots
		String path = System.getProperty("user.dir") + "//screenshots//" + result.getName() + ".png";
		File fis = new File(path);
		if (fis.exists()) {
			etest.fail("testcasefailed:").addScreenCaptureFromPath(path);
		}

	}

	public void onTestSkipped(ITestResult result) {
		etest = reports.createTest(result.getName());
		etest.log(Status.SKIP, "Test skipped" + result.getName());
	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
