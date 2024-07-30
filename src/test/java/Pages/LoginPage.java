package Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.BaseClass;
import junit.framework.Assert;

public class LoginPage extends BaseClass {

	@FindBy(id = "user-name")
	WebElement Username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement btnLogin;

	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement logo;

	@FindBy(xpath = "//div[@class='product_label']")
	WebElement SuccessMEssage;

	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement ErrorMessage, Locked_out;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void LoginToApp(String un, String pwd) {
		Username.sendKeys(un);
		password.sendKeys(pwd);
		btnLogin.click();

	}

	public void validateSuccessMessage(String ExpMess) {
		String actualMess = SuccessMEssage.getText();
		Assert.assertEquals(actualMess, ExpMess);
	}

	public void validateErrorMessage(String ExpErrorMess) {
		String actualMessage = ErrorMessage.getText();
		Assert.assertEquals(actualMessage, ExpErrorMess);
	}

	public void validateLockedOutMessage(String locked_outMessage) {
		String actualLockedMess = Locked_out.getText();
		Assert.assertEquals(actualLockedMess, locked_outMessage);

	}

}
