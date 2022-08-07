package ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Shopping extends OpenCloseBrowser{
	@Test(priority = 0)
	public void selectShopping() {
		WebElement computerElement = driver.findElement(By.linkText("Computers"));
		Actions action = new Actions(driver);
		action.moveToElement(computerElement).build().perform();
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Lenovo IdeaCentre 600 All-in-One PC")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-3\"]")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("shopping cart")));
		driver.findElement(By.linkText("shopping cart")).click();
	} 
	@Test(priority = 1)
	public void selectShopping2() {
		WebElement electronicsElement = driver.findElement(By.linkText("Electronics"));
		Actions action = new Actions(driver);
		action.moveToElement(electronicsElement).build().perform();
		driver.findElement(By.linkText("Cell phones")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]")).click();
		driver.findElement(By.linkText("Nokia Lumia 1020")).click();
		driver.findElement(By.xpath("//*[@id=\"product_enteredQuantity_20\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"product_enteredQuantity_20\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-20\"]")).click();
		

		 
	}
	@Test(priority = 2)
	public void shoppingCart() {
		driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a")).click();
		
	}
	@Test(priority = 3)
	public void removeFromShoppingCart() {
		driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[7]")).click();
	}

}
