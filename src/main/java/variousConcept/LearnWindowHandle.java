package variousConcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {
	
	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void windowHandleTest() {

//Window Handle
		String handle = driver.getWindowHandle();
//		System.out.println(driver.getWindowHandle()); //We can use this directly too
		System.out.println(handle); //Here we put in variable 'handle'
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("xpath");
		driver.findElement(By.xpath("//button[@id='ybar-search']")).click();
	
		String handle1 = driver.getWindowHandle();
		System.out.println(handle1);
		System.out.println(driver.getTitle());
		
//Window Handles		
		driver.findElement(By.xpath("//div[@id='web']/ol/li[1]/div/div[1]/h3/a")).click();
		Set <String> handles = driver.getWindowHandles();
	//	System.out.println(handles); //It will print the UNIQUE identifier
		
		System.out.println(driver.getTitle()); //This is no need but for my understanding to see the title
//Here we are using ForEachLooop to print each page
		for(String i : handles) {
			System.out.println(i);
//Here we are Switching the			
		driver.switchTo().window(i);
		}
		System.out.println(driver.getTitle());//This is no need but for my understanding to see the title
		driver.switchTo().window(handle); //Here we are going back to the previous page
		System.out.println(driver.getTitle());//This is no need but for my understanding to see the title
	}
//	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
