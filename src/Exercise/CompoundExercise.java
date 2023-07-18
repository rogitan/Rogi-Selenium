package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CompoundExercise {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//Creating web element locator for checkbox
		String checkboxID = "checkBoxOption3";
		WebElement checkboxOption = driver.findElement(By.id(checkboxID));
		WebElement checkboxLabel = driver.findElement(By.xpath("//input[@id='"+checkboxID+"']//parent::label"));
		
		
		//Click option and get text label
		checkboxOption.click();
		String checkboxLabelName = checkboxLabel.getText();
		
		//Parent WebElement for Dropdown
		WebElement dropdownExample = driver.findElement(By.id("dropdown-class-example"));
		
		//Creating object for dropdown and select by visibile text
		Select dropdownSelect = new Select(dropdownExample);
		dropdownSelect.selectByVisibleText(checkboxLabelName);
		
		//Creating web elements for alert section
		WebElement alertInputField = driver.findElement(By.id("name"));
		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		
		//Enter value to alert input field
		alertInputField.sendKeys(checkboxLabelName);
		alertButton.click();
		
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		
	}
	
}
