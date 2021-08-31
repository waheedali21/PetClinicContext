package roughwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class VeterianList {

WebDriver driver;
	
	@Test(priority = 1)
	public void addOwner() {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		
		driver.get("http://localhost:8080");
		
		driver.findElement(By.xpath("//span[normalize-space()='Veterinarians']")).click();
		
		
		String petName = driver.findElement(By.xpath("//div[@class='container-fluid']")).getText();
		System.out.println(petName);
		
		if(petName.contains("James Carter")) {
			System.out.println("pet listing is verified");
		}
		
		
		String name = driver.findElement(By.xpath("//td[normalize-space()='James Carter']")).getText();
		System.out.println("Name is: " + name);
		
		
		
		
		
	}
	

}
