package Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class BaseClass {

	static ExtentReports report;
	static ExtentTest test;
	public static WebDriver driver;

	@BeforeMethod
	public void startTest() {
		

		driver = new ChromeDriver();
		report = new ExtentReports("C:\\Users\\srika\\eclipse-workspace\\SwagLabs_TestNG\\Screenshot\\index.html", false);
	//	test = report.startTest("Extent report Demo");
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/index.html");
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		report.flush();
		report.endTest(test);

	}
	public static String CaptureScreen(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File("screenshot/" + ".png");

		String absolutepath = target.getAbsolutePath();

		FileUtils.copyFile(src, target);
		return absolutepath;

	}
	
}
