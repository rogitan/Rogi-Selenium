package javastream;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaStreamExercise {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		
		//Web Element for Sort button
		WebElement vegColumnSort = driver.findElement(By.xpath("//span[text()='Veg/fruit name']//parent::th"));
		
		vegColumnSort.click();
		
		List<WebElement> vegName = driver.findElements(By.xpath("//tr//td[1]"));
		
		// Get the actual vegetables in tables without sort and collect as List
		List<String> originalList = vegName.stream().map(s->s.getText()).collect(Collectors.toList());
		
		// Get the actual vegetables in tables with sort applied and collect as List
		List<String> newList = vegName.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(newList));
		
		//Scan the name "beans" and print the price
//		do{
		List<String> price = vegName.stream().filter(s->s.getText().contains("Beans")).
				map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(g->System.out.println(g));
		
		driver.findElement(By.cssSelector("a[aria-label='Next']"));
//		}while(!(price.size()>0));
	}
 
	private static String getPriceVeggie(WebElement s) {

		String newPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return newPrice;
	}

}
