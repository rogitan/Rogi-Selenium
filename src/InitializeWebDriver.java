import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InitializeWebDriver {

	
	public WebDriver initializeDriver() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/User/Desktop/rogi/webDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
}
