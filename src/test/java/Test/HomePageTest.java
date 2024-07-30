package Test;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;

	@Test
	public void HomePageTest() {
		lp = new LoginPage();
		hp = new HomePage();
		lp.LoginToApp("standard_user", "secret_sauce");
		hp.validateHomePage();
	}
}
