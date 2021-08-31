package roughwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddPetExample {

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
		driver.findElement(By.id("lastName")).sendKeys("Mehdi");
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		
		driver.findElement(By.xpath("//table[@id='owners']//tbody//tr[9]//td[1]//a")).click(); //click existing owner
		driver.findElement(By.xpath("//a[contains(text(),'Add')]")).click(); //click Add new pet
		
		String ownerName = driver.findElement(By.xpath("//span[normalize-space()='Arhaan Mehdi']")).getText();
		System.out.println("Owner name: " + ownerName);
		
		Select dd = new Select(driver.findElement(By.id("type")));
		dd.selectByVisibleText("dog");
		
		
		
		
		
}
	
}
