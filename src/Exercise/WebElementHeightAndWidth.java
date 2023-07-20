package Exercise;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementHeightAndWidth {

	
	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		// Navigate to URL
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		WebElement firstNameField = driver.findElement(By.name("name"));
		firstNameField.sendKeys("String");
		File file = firstNameField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\User\\automationScreenshot\\screenshot.png"));
		
		System.out.println(firstNameField.getRect().getDimension().getHeight());
		System.out.println(firstNameField.getRect().getDimension().getWidth());
		
	}
}
