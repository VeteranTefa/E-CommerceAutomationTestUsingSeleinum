package ecommerce;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterandLogin extends OpenCloseBrowser{


	@Test
	public void login_Test() {
		driver.findElement(By.linkText("Log in")).click();
		WebElement em,pass;
		em=driver.findElement(By.name("Email"));
		pass=driver.findElement(By.name("Password"));
		em.sendKeys("moonsasa83@gmail.com");
		pass.sendKeys("tefa@123");
		WebElement clickLogin= driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body > div.customer-blocks > div.returning-wrapper.fieldset > form > div.buttons > button"));
		clickLogin.click();
		
	}

}
