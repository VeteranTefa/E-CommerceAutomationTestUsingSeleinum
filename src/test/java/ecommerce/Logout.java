package ecommerce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Logout extends OpenCloseBrowser{

	@Test
	public void logoutFromWebSite() {
		driver.findElement(By.linkText("Log out")).click();
	}
}
