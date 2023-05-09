package variousConcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle_ActualCode {

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

		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("xpath");
		driver.findElement(By.xpath("//button[@id='ybar-search']")).click();
//Window Handles		
		driver.findElement(By.xpath("//div[@id='web']/ol/li[1]/div/div[1]/h3/a")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String i : handles) {
			 System.out.println(i);
			driver.switchTo().window(i);
		}		
	}
//	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
