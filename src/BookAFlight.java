import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookAFlight {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/User/Desktop/rogi/webDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		// Go to URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		// Book one way ticket
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1"));
		
		Thread.sleep(2000);
		String name = "Bengaluru (BLR)";
		WebElement departureDropdown = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
		departureDropdown.click();
		
		WebElement departureLoc = driver.findElement(By.xpath("//div[@id='dropdownGroup1']//a[@text='"+name+"']"));
		departureLoc.click();
		
	}

}
