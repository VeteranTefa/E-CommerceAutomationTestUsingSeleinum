package ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Search extends OpenCloseBrowser{
	@Test(priority = 0)
	public void SearchBox() {
		driver.findElement(By.id("small-searchterms")).sendKeys("Apple"+Keys.ENTER);
		
	}
	@Test(priority = 1)
	public void addToWithList() {
		driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button-4\"]")).click();
	}
	@Test(priority = 2)
	public void goToWishlistMenu() {
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a")).click();
	}
	@Test(priority = 3)
	public void wishListToCart() {
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[1]")).click();
		driver.findElement(By.name("addtocartbutton")).click();
	}
	

}
