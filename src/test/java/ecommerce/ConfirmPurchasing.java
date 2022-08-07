package ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfirmPurchasing extends OpenCloseBrowser {

	@Test(priority = 0)
	public void checkout() {
		driver.findElement(By.name("termsofservice")).click();
		driver.findElement(By.name("checkout")).click();
	}
	@Test(priority = 1)
	public void Confirm() {
		Select countries = new Select(driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]")));
		countries.selectByValue("123");
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Cairo");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("AinShams");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("123456");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("012122262323");
		driver.findElement(By.name("save")).click();
		driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")));
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
		
	}
	@Test(priority = 2)
	public void Payments() {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='paymentmethod_1']")));
		driver.findElement(By.xpath("//*[@id='paymentmethod_1']")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@id='payment-method-buttons-container']/button")).click();
		Select paymentType = new Select(driver.findElement(By.name("CreditCardType")));
		paymentType.getFirstSelectedOption();
		driver.findElement(By.id("CardholderName")).sendKeys("Mostafa Mohamed Suliman");
		driver.findElement(By.id("CardNumber")).sendKeys("5078031063516497");
		Select month,year;
		month=new Select(driver.findElement(By.id("ExpireMonth")));
		year= new Select(driver.findElement(By.id("ExpireYear")));
		month.selectByValue("9");
		year.selectByValue("2024");
		driver.findElement(By.name("CardCode")).sendKeys("245");
		driver.findElement(By.xpath("//*[@id='payment-info-buttons-container']/button")).click();
		driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();
		String ExpectedResult ="Your order has been successfully processed!";
		String ActualResult=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")).getText();
		Assert.assertEquals(ActualResult, ExpectedResult);
		//driver.findElement(By.linkText("Click here for order details.")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[3]/button")).click();
		

	}

}
