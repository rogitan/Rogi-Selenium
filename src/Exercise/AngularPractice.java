package Exercise;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AngularPractice {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		WebElement firstNameField = driver.findElement(By.name("name"));
		WebElement emailField = driver.findElement(By.name("email"));
		WebElement passwordField = driver.findElement(By.id("exampleInputPassword1"));
		WebElement checkbox = driver.findElement(By.id("exampleCheck1"));
		WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		WebElement radioButtonStudent = driver.findElement(By.id("inlineRadio1"));
		WebElement birthdayField = driver.findElement(By.name("bday"));
		WebElement submitButton = driver.findElement(By.cssSelector("input[type*='submit']"));
		
		firstNameField.sendKeys("Rogi");
		emailField.sendKeys("rogi.test@google.com");
		passwordField.sendKeys("P@ssword1");
		checkbox.click();
		
		Select gender = new Select(genderDropdown);
		gender.selectByVisibleText("Female");
		
		radioButtonStudent.click();
		birthdayField.sendKeys("01/01/1990");
		
		submitButton.click();
		
		WebElement alertMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		
		assertTrue(alertMessage.getText().contains("Success! The Form has been submitted successfully!."));
//		driver.close();
		System.out.println("Sign up successful");
		
		
	}

}
