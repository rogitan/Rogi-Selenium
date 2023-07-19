package Exercise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinkAndSoftAssert {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		SoftAssert a = new SoftAssert();

		// Navigate to URL
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Get all the web element for every url in footer
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		// Get the href attribute in every link using enhanced for loop
		for (WebElement link : links) {
			String url = link.getAttribute("href");

			// Create object and invoke method to access the class
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();

			// soft assert if respCode has code greater than 400
			int respCode = conn.getResponseCode();
			a.assertTrue(respCode < 400, "Link is broken for URL: " + link.getText());

		}

		// Step will fail if a contains falls
		a.assertAll();

	}

}
