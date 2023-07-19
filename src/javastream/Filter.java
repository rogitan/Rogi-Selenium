package javastream;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filter {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String vegName = "Rice";
		WebElement searchField = driver.findElement(By.id("search-field"));
		searchField.sendKeys(vegName);
		
		List<WebElement> searchResultRows = driver.findElements(By.xpath("//tr//td[1]"));
		
		List<WebElement> searchResults = searchResultRows.stream().filter(veg->veg.getText().contains(vegName)).
		collect(Collectors.toList());
		
		Assert.assertEquals(searchResultRows.size(), searchResults.size());
		
		
	}
	
	

}
