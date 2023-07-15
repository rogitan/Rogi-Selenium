package socium.stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetrievePurchaseInformation {

	static WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Robot robot;
	

	@Given("I landed in Demo Aspnet Awesome Page")
	public static void I_landed_in_Demo_Aspnet_Awesome_Page() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://demo.aspnetawesome.com/");

	}

	@Given("^I navigated to menu (.+)$")
	public void I_navigate_to_menuName(String menuName) {

		WebElement filteringMenuButton = driver
				.findElement(By.xpath("//*[text()='Filtering']//parent::div[@data-g='Menu']"));
		filteringMenuButton.click();

		WebElement serverDataMenu = driver.findElement(By.linkText(menuName));
		serverDataMenu.click();

	}

	@When("^I search for name (.+)$")
	public void I_search_for_transactionID(String firstName) throws AWTException, InterruptedException{
		robot = new Robot();

		WebElement personSearchField = driver.findElement(By.id("GridFrow2fltPerson-awed"));
		
		personSearchField.sendKeys(firstName);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}

	@Then("I should print out all the columns")
	public void printAllColumns() {
		
		
		List<WebElement> allColumn = driver.findElements(By.xpath("//tr[@data-k='929']/td"));
		wait.until(ExpectedConditions.visibilityOfAllElements(allColumn));
		
		allColumn.size();
		System.out.println("Input ID Number: " + allColumn.get(0).getText());
		System.out.println("Person: " + allColumn.get(1).getText());
		System.out.println("Food: " + allColumn.get(2).getText());
//		System.out.println("Price: " + allColumn.get(3).getText());
		System.out.println("Date: " + allColumn.get(4).getText());
		System.out.println("Country: " + allColumn.get(5).getText());
		System.out.println("Meals: " + allColumn.get(6).getText());
	}

}
