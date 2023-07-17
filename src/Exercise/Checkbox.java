package Exercise;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		// Navigate to URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//Click the first checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue((driver.findElement(By.id("checkBoxOption1"))).isSelected());
		
		//Untick the first checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse((driver.findElement(By.id("checkBoxOption1"))).isSelected());
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));
		
		System.out.println("No. of checkbox is: "+checkbox.size());
		
		
		
	}
	
}
