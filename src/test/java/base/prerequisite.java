package base;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class prerequisite {
   
	public static WebDriver driver;
	 public static Properties prop =new Properties();
	 public static Properties Loc =new Properties();
	 public static FileReader fr;
	 public static FileReader fr1;
	 
	 
	 @BeforeMethod
	 public void Setup() throws IOException {
		 if(driver==null) {
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			 fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			 prop.load(fr);
			 Loc.load(fr1);
			 
		 }
		 if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			 

			
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.get(prop.getProperty("testUrl"));
			 
			 
		 }
		 if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 driver.get(prop.getProperty("testUrl"));
		 }
	 }
	 @AfterMethod
	 public void teatdown() {
		 driver.close();
		 
	 }
	 
	 
	 
	
}
