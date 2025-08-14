package Test;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNG3 {
	
	WebDriver driver;

	@BeforeClass
	public void setEnv() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\Data\\javaWorkspace\\chromedriver.exe");
		driver = new ChromeDriver(); // Launching Browser Instance
		driver.manage().window().maximize(); // Maximize the Window
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/"); // Open URL
	}

	// Get current date and Time
	public String getDateAndTime() {
		DateTimeFormatter currentDateAndTime = DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return currentDateAndTime.format(now);
	}

	@DataProvider
	public Object[][] dataSet() throws Exception {

		// Specify the property file location
		File src = new File("D:\\TestData\\TestGit\\Repository\\Object_Repo.properties");
		// Create FileInputStream class object to load the file
		FileInputStream fis = new FileInputStream(src);
		// Create Properties class object to read properties file
		Properties pro = new Properties();
		pro.load(fis);
		Object arr[][] = new Object[3][2];
		TestNG3 t8 = new TestNG3();

		arr[0][0] = pro.getProperty("EmailTestData") + " " + t8.getDateAndTime();
		arr[0][1] = pro.getProperty("PasswordTestData");

		arr[1][0] = "Email_2";
		arr[1][1] = "Password_2";
		
		arr[2][0] = "Email_3";
		arr[2][1] = "Password_3";

		return arr;
	}

	@Test(dataProvider = "dataSet")
	public void enterData(String userName, String password) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(userName);
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		driver.navigate().back();
	}
}
