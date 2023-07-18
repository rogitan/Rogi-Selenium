package Exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExercise {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		List<WebElement> column = driver.findElements(By.xpath("//table[@class='table-display']//th"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table-display']//tr"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,350)");
		
		System.out.println("Number of columns is: "+ column.size());
		System.out.println("Number of rows is: "+ rows.size());
		
		int rowNumber = 3;
		WebElement getRow = driver.findElement(By.xpath("(//table[@class='table-display']//tr)["+rowNumber+"]"));
		List<WebElement> getColumn = getRow.findElements(By.tagName("td"));
		
		for(int i =0; i<getColumn.size();i++) {
			String columnValue = getColumn.get(i).getText();
			System.out.println("Value for column number "+ i +" in row "+rowNumber+" is "+columnValue);
		}
		
		
		
		
	}
	
}
