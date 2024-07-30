package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(linkText="Sauce Labs Backpack")
	WebElement product;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	WebElement AddToCard;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void validateHomePage() {
		product.click();
		AddToCard.click();
	}
}
