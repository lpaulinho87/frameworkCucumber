package core;

import static utilidades.Configuracoes.getProperties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (Propriedades.browser) {
			case FIREFOX:
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			case CHROME:
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--headless");
				driver = new ChromeDriver(option);
				driver.manage().window().maximize();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(Long.parseLong(getProperties().getProperty("TimeoutImplicitlyWait")), TimeUnit.SECONDS);
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}