package Test;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;

@Listeners(Listener.class)
public class LoginPageTest extends BaseClass {
	@Test
	public void LoginSucessTest() throws IOException {
		try {
			test = report.startTest("Tc_001").assignAuthor("Srikanth").assignCategory("Windows");

			LoginPage lp = new LoginPage();
			lp.LoginToApp("standard_user", "secret_sauce1");
			lp.validateSuccessMessage("Products");
			test.log(LogStatus.PASS, "User sucessfully loged in to the application", "User landed on Homepage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(CaptureScreen(driver)) + "User unable to land on Homepage");
		}
	}

	@Test
	public void LoginFailureTest() throws IOException {
		try {
			test = report.startTest("Tc_002").assignAuthor("Srikanth").assignCategory("Windows");

			LoginPage lp = new LoginPage();
			lp.LoginToApp("Standard1234", "Stand123");
			lp.validateErrorMessage("Epic sadface: Username and password do not match any user in this service");
			test.log(LogStatus.PASS, "User unable to logged in to the application");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(CaptureScreen(driver)) + "User unable to land on Hompeage");
		}
	}

	@Test
	public void Locked_UserTest() throws IOException {
		try {
			test = report.startTest("Tc_003").assignAuthor("Srikanth").assignCategory("Windows");

			LoginPage lp = new LoginPage();
			lp.LoginToApp("locked_out_user", "secret_sauce");
			lp.validateLockedOutMessage("Epic sadface: Sorry, this user has been locked out");
			test.log(LogStatus.PASS, "User unable to landed on Homepage because Loged user");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(CaptureScreen(driver))
					+ "User unable to land on Homepage due to logged user");
		}
	}
}
