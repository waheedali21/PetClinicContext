package roughwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddEditOwner {

	
	WebDriver driver;
	
	@Test(priority = 1)
	public void addOwner() {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		
		driver.get("http://localhost:8080");
		
		driver.findElement(By.xpath("//span[normalize-space()='Find owners']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add Owner')]")).click();
		
		driver.findElement(By.id("firstName")).sendKeys("Ali");
		driver.findElement(By.id("lastName")).sendKeys("Asad");
		driver.findElement(By.id("address")).sendKeys("123");
		driver.findElement(By.id("city")).sendKeys("Naushahro Feroze");
		driver.findElement(By.id("telephone")).sendKeys("0543333");
		driver.findElement(By.xpath("//button[contains(text(),'Add Owner')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		
		
		//clear the added owner detaials
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("SHAHID");
		
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("Aziz");
		
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("4455Tt");
		
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("Naushahro");
		
		driver.findElement(By.id("telephone")).clear();
		driver.findElement(By.id("telephone")).sendKeys("05431100");
		
		
		driver.findElement(By.xpath("//button[normalize-space()='Update Owner']")).click();
		
	}
	
	
	
}
