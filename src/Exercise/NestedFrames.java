package Exercise;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFrames {

	public static void main(String[] args) {
		
		//Invoke WebDriver
		System.setProperty("webdriver.chrome.driver", "/Users/User/Desktop/rogi/webDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Navigate to URL and maximize window
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		// Click Nested Frames link
		driver.findElement(By.linkText("Nested Frames")).click();
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		
	}

}
