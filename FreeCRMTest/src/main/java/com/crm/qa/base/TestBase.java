package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions options1;
	static FirefoxOptions options2;


	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\FreeCRMTest\\src\\"
					+ "main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void inilization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ankit\\Downloads\\chromedriver_win32_extract\\chromedriver.exe");
			options1 = new ChromeOptions();
			options1.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options1);
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ankit\\Downloads\\geckodriver-v0.31.0-win64_extract\\geckodriver.exe");
			options2 = new FirefoxOptions();
			driver = new FirefoxDriver(options2);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		options1.setPageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		driver.get(prop.getProperty("url"));

	}

}
