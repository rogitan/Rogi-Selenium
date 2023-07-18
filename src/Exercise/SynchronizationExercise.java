package Exercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationExercise {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// Navigate to URL and maximize window
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(null);

		signIn(driver);
		addToCart(driver);
	}

	public static void signIn(WebDriver driver) {
		// Set user credential
		String username = "rahulshettyacademy";
		String password = "learning";
		String pageRole = "User";
		String schoolRoleName = "Consultant";

		// Create webelement displayed in the login page
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement roleRadioButton = driver
				.findElement(By.xpath("//span[contains(text(),'User')]//following-sibling::span[@class='checkmark']"));
		WebElement schoolRoleDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		WebElement termsCheckbox = driver.findElement(By.id("terms"));
		WebElement signInButton = driver.findElement(By.id("signInBtn"));

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		roleRadioButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement okayButton = driver.findElement(By.id("okayBtn"));
		wait.until(ExpectedConditions.visibilityOf(okayButton));
		okayButton.click();

		Select dropdown = new Select(schoolRoleDropdown);
		dropdown.selectByVisibleText(schoolRoleName);

		termsCheckbox.click();
		signInButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Shop Name']")));
		System.out.println("User sign in successfully!");
	}

	public static void addToCart(WebDriver driver) {
		
		int count;
		List<WebElement> itemSize = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		
		for(count=0; count < itemSize.size(); count++) {
			itemSize.get(count).click();
		}
		
		WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary' and contains(text(),'Checkout')]"));
		
		checkoutButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-success']")));
		
		System.out.println("Successfully Added to Cart");

	}

}
