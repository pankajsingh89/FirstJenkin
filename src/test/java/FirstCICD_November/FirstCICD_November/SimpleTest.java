package FirstCICD_November.FirstCICD_November;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest {

	@Test
	public void openExampleDomain() {
		// Set up Chrome driver (auto-download)
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		// Recommended for CI: run headless
		options.addArguments("--headless=new"); // use --headless or --headless=new (new headless in recent Chrome)
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");

		WebDriver driver = new ChromeDriver(options);
		try {
			driver.get("https://example.com");
			String title = driver.getTitle();

		} finally {
			driver.quit();
		}
	}
}
