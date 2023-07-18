package Exercise;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoCompleteDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		WebElement autoCompleteSearchField = driver.findElement(By.id("autocomplete"));
		autoCompleteSearchField.sendKeys("phi");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ui-menu-item']//div[text()='Philippines']")));
		WebElement dropdownSelection = driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Philippines']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(dropdownSelection).click().build().perform();
		
		String newValue = autoCompleteSearchField.getAttribute("value");
		
		Assert.assertEquals("Expected and actual is equal", "Philippines", newValue);
		
		
	}

}
