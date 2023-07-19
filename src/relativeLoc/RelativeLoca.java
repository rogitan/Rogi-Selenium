package relativeLoc;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLoca {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameInputField = driver.findElement(By.name("name"));

		String labelName = driver.findElement(with(By.tagName("label")).above(nameInputField)).getText();
		System.out.println(labelName);

		WebElement DOBLabel = driver.findElement(By.xpath("//label[@for='dateofBirth']"));

		driver.findElement(with(By.tagName("input")).below(DOBLabel)).click();

		WebElement checkboxLabel = driver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxLabel)).click();
				
	}

}
